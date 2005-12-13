#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage f�r 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using System;
using System.IO;
using System.Xml;
using System.Xml.Schema;
using System.Xml.XPath;
using Palladio.QoSAdaptor.Enumerations;

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// This class implements a parser for design pattern 
	/// descriptions in XML. 
	/// Some parts of the parser were taken from XmlSeffParser.
	/// </summary>
	public class PatternDescriptionParser
	{
		#region attributes
		/// <summary>
		/// The pattern that shall be parsed.
		/// </summary>
		private PatternDescription pattern;
		#endregion

		#region constructors
		/// <summary>
		/// Constructs a new PatternDescriptionParser and parses the given 
		/// file.
		/// </summary>
		/// <param name="description">A string containing a pattern
		/// description.</param>
		public PatternDescriptionParser(string description)
		{
			pattern = ParseDescription(description);
		}
		#endregion

		#region properties
		/// <summary>
		/// The parsed PatternDescription. 
		/// </summary>
		public IPatternDescription Pattern
		{
			get
			{
				return this.pattern;
			}
		}
		#endregion

		#region methods copied from XmlSeffParser
		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="it"></param>
		/// <param name="child"></param>
		/// <returns></returns>
		private static string GetValueOfChild(XPathNodeIterator it,string child) 
		{
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren(child,it.Current.NamespaceURI);
			it2.MoveNext();
			return it2.Current.Value;
		}

		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="args"></param>
		private void OnValidateError(Object sender, ValidationEventArgs args ) 
		{
			throw new XmlException("File does not match pattern_description.xsd. "+args.Message,null);
		}

		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="file"></param>
		private void XmlValid(string file) 
		{
			try
			{
				XmlTextReader textReader = new XmlTextReader(file);
				XmlValidatingReader val = new XmlValidatingReader(textReader);
				val.ValidationType = ValidationType.Schema;
				val.ValidationEventHandler +=
					new ValidationEventHandler(OnValidateError);
				while (val.Read());			
			} 
			catch 
			{
				throw;
			}
		}
		#endregion

		#region private parsing methods
		/// <summary>
		/// This is the main parsing method. The XML-file 
		/// containing the pattern description is validated 
		/// against the DTD and other initialisations are made. 
		/// After that the methods for parsing the separate parts
		/// of the XML-file are called. 
		/// </summary>
		/// <param name="file">The XML file containing the pattern
		/// description</param>
		/// <returns>A PatternDescription object containing the 
		/// same information as the given XML file.</returns>
		private PatternDescription ParseDescription (string file)
		{
			PatternDescription pattern = new PatternDescription();
			XmlDocument doc;
			XPathNavigator nav;

			try 
			{
				// TODO: Overwork validation
				//XmlValid(file);
				doc = new XmlDocument();
				doc.Load(file);
				nav = doc.CreateNavigator();

				ReadGeneralDescription(nav, pattern);
				ReadMismatches(nav, pattern); 
				ReadAdapterTemplates(nav, pattern); 
				ReadPredictionModels(nav, pattern); 
			}
			catch (XmlException e) 
			{
				Console.WriteLine(e);
				return null;
			} 
			catch (IOException e) 
			{
				Console.WriteLine("File Was not Found!");
				Console.WriteLine(e);
			}
			return pattern;
		}

		/// <summary>
		/// This method parses the general information of the 
		/// pattern description, including the name, general 
		/// description and the source of the pattern. 
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadGeneralDescription(XPathNavigator nav, 
				PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/pattern");
			it.MoveNext();
			pattern.Name = GetValueOfChild(it, "name");
			string interfaceModel = GetValueOfChild(it, "interfaceModel");
			if (interfaceModel.Equals("Behaviour"))
				pattern.InterfaceModel = InterfaceModel.BEHAVIOUR;
			else if (interfaceModel.Equals("Conceptual"))
				pattern.InterfaceModel = InterfaceModel.CONCEPTUAL;
			else if (interfaceModel.Equals("Interaction"))
				pattern.InterfaceModel = InterfaceModel.INTERACTION;
			else if (interfaceModel.Equals("Quality"))
				pattern.InterfaceModel = InterfaceModel.QUALITY;
			else if (interfaceModel.Equals("Syntax"))
				pattern.InterfaceModel = InterfaceModel.SYNTAX;
			else
			{
				// TODO: Throw exception
			}
			pattern.Description = GetValueOfChild(it, "description");
			pattern.Source = GetValueOfChild(it, "source");
		}

		/// <summary>
		/// This methods parses the mismatches described in the 
		/// XML file.
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadMismatches(XPathNavigator nav, 
			PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/pattern/mismatches");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("attribute", it.Current.NamespaceURI);
			while(it2.MoveNext())
				{
					XPathNavigator nav2 = it2.Current.Clone();
					MismatchAttribute attribute = new MismatchAttribute(
						nav2.GetAttribute("name", it2.Current.NamespaceURI));
					string suitability = nav2.GetAttribute
						("suitability", it2.Current.NamespaceURI);
					attribute.Suitability = ConvertSuitability(suitability);
					AddMismatchSubAttributes(attribute, 
						it2.Current.SelectChildren("subAttribute", 
							it2.Current.NamespaceURI));
					pattern.AddMismatchAttribute(attribute);
				}
		}

		/// <summary>
		/// Converts the string representation of the suitability value into
		/// the SuitabilityValue representation.
		/// </summary>
		/// <param name="suitability">String representation of the suitability.
		/// </param>
		/// <returns>SuitabilityValue representation of the suitability.
		/// </returns>
		private SuitabilityValue ConvertSuitability(string suitability)
		{
			// TODO: Change default value?
			SuitabilityValue convertedSuitability = SuitabilityValue.UNKNOWN;
			if (suitability.Equals("++"))
				convertedSuitability = SuitabilityValue.PLUSPLUS;
			else if (suitability.Equals("+"))
				convertedSuitability = SuitabilityValue.PLUS;
			else if (suitability.Equals("o"))
				convertedSuitability = SuitabilityValue.NEUTRAL;
			else if (suitability.Equals("-"))
				convertedSuitability = SuitabilityValue.MINUS;
			else if (suitability.Equals("--"))
				convertedSuitability = SuitabilityValue.MINUSMINUS;
			// TODO: else throw exception
			return convertedSuitability;
		}

		/// <summary>
		/// Adds the subattributes defined in the given node to the given 
		/// MismatchAttribute.
		/// </summary>
		/// <param name="attribute">A MismatchAttribute to add attributes to.
		/// </param>
		/// <param name="it">A node in the XML tree that contains mismatch 
		/// subattributes.</param>
		private void AddMismatchSubAttributes (MismatchAttribute attribute, 
			XPathNodeIterator it)
		{
			while (it.MoveNext())
			{
				XPathNavigator nav2 = it.Current.Clone();
				MismatchSubAttribute subAttribute = new MismatchSubAttribute(
					nav2.GetAttribute("name", it.Current.NamespaceURI));
				string suitability = nav2.GetAttribute
					("suitability", it.Current.NamespaceURI);
				subAttribute.Suitability = ConvertSuitability(suitability);

				attribute.AddSubAttribute(subAttribute);
			}
		}

		/// <summary>
		/// This methods parses the list of templates needed to 
		/// created the adapter that can be used to adjust the 
		/// QoS mismatches of the pattern. 
		/// </summary>
		/// /// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadAdapterTemplates(XPathNavigator nav, 
				PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/pattern/adaptorTemplates");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("template", it.Current.NamespaceURI);
			while(it2.MoveNext())
			{
				pattern.AddAdaptorTemplate(it2.Current.Value);
			}
		}

		/// <summary>
		/// This method parses the list of prediction models that can be 
		/// used to predict the performance of the generated adapter. 
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadPredictionModels(XPathNavigator nav, 
			PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/pattern/predictionModels");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("predictionModel",
				it.Current.NamespaceURI);
			while(it2.MoveNext())
			{
				pattern.AddPredictionModel(ReadPredictionModel(it2.Clone()));
			}
		}

		/// <summary>
		/// This method parses a single prediction model and returns it as
		/// a PredictionModel object.
		/// </summary>
		/// <param name="it">XPathNodeIterator that points to the node of the 
		/// prediction model that shall be parsed. </param>
		/// <returns>The parsed PredictionModel.</returns>
		private PredictionModel ReadPredictionModel(XPathNodeIterator it)
		{
			XPathNavigator nav = it.Current.Clone();
			nav.MoveToFirstAttribute();
			string name = nav.Value;
			nav.MoveToNextAttribute();
			bool isExecutable;
			if (nav.Value.Equals("true"))
				isExecutable = true;
			else
				isExecutable = false;
			
			PredictionModel predictionModel = new PredictionModel(name, 
				isExecutable);	

			XPathNodeIterator it3 = it.Current.SelectChildren(
				"usageInstructions", it.Current.NamespaceURI);
			it3.MoveNext();
			predictionModel.UsageInstructions = it3.Current.Value;

			XPathNodeIterator it2 = it.Current.SelectChildren("template", 
				it.Current.NamespaceURI);
			while (it2.MoveNext())
				predictionModel.AddTemplate(it2.Current.Value);

			return predictionModel;
		}
		#endregion 
	}
}
