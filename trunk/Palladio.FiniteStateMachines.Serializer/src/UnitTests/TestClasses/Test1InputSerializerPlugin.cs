using System;
using System.Xml;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// Serializes "test1" inputs of the FSM.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.2  2005/09/08 07:24:23  joemal
	/// to be continued ...
	///
	/// Revision 1.1  2005/08/25 09:41:20  kelsaka
	/// - prepared support for "test1" input serialization test
	///
	/// </code>
	/// </remarks>
	public class Test1InputSerializerPlugin : IInputSerializerPlugin
	{
		//holds the supported types of this plugin
		private static Guid[] SUPPORTED_TYPES=new Guid[]{Test1Input.TYPEID};

		/// <summary>
		/// Serializes the given input and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="input">The input to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing the input.</param>
		/// <remarks>The output is automatically surrounded by the calling class by a
		/// <code>&lt;input inputType="abcde"&gt;&lt;/input&gt;</code> Tag.</remarks>
		public void SerializeInput (IInput input, XmlWriter xmlWriter)
		{
			xmlWriter.WriteAttributeString(this.XmlPrefix, "test", this.XmlNamespace, "value");
		}

		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IInput"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize, that contains the input
		/// xml element.</param>
		/// <returns>The deserialized input information.</returns>
		public IInput DeserializeInput (XmlNode xmlNode)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// The namespace of the IInput elements. (read)
		/// </summary>
		public string XmlNamespace
		{
			get
			{
				return "http://Test1-Namespace.com/input";
			}
		}

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		public string XmlSchemaURI
		{
			get
			{
				return "Test1-input.xsd";
			}
		}

		/// <summary>
		/// The prefix to identify XML elements written by the plugin.
		/// </summary>
		public string XmlPrefix
		{
			get
			{
				return "t1pre-input";
			}
		}

		/// <summary>
		/// called to return a list of supported ids of input types
		/// </summary>
		public Guid[] SupportedInputTypes
		{
			get
			{
				return Test1InputSerializerPlugin.SUPPORTED_TYPES;
			}
		}

	}
}
