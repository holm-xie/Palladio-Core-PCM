using System;
using System.Diagnostics;
using System.IO;
using System.Threading;
using System.Xml;
using Altova.Types;
using WebserverXML;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// XMLConfigReader. Reads a xml-config file. The XML-root-element needs to have the name "config".
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2004/12/08 16:07:11  kelsaka
	/// - added: the webserver halts if the config-file can not be found. To make the webserver
	///  use easier the error-message describes how to set the paths (commandline and VS.NET)
	///
	/// Revision 1.8  2004/11/05 16:17:00  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.7  2004/10/23 14:08:35  kelsaka
	/// first steps on reading xml-config-files
	///
	/// Revision 1.6  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.5  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.4  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	/// Revision 1.3  2004/10/22 08:39:23  kelsaka
	/// added html-test-documents, xml-types generated by xmlspy, and first xml-config-files
	///
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class XMLConfigReader : IConfigReader
	{


		public XMLConfigReader()
		{

		}



		/// <summary>
		/// Read the configuration at the specified path. Afterwards the setting can be accessed by GetValue.
		/// </summary>
		/// <param name="configPathFile">Path to XML-config-file including filename.</param>
		public ConfigType ReadConfiguration (string configPathFile)
		{
			WebserverXMLDoc doc = new WebserverXMLDoc();
			doc.SetRootElementName("", "Config");
			

			ConfigType root = new ConfigType();

			try 
			{
				root = new ConfigType(doc.Load(configPathFile));
			}
			catch (XmlException e)
			{
				// write to Console, as the debug-file is not necessarily known.
				Console.WriteLine(e);
			}
			catch (FileNotFoundException e)
			{
				// write to Console, as the debug-file is not necessarily known.
				Console.WriteLine("ERROR: The config-file (" + configPathFile + ") could not be found. Please set the " +
					"config-files at the commandline like:\nWebserver \"..\\..\\..\\Config\\\" (in VS.NET you can set the command " +
					"line parameter by editing the properties of the starting-project (e. g. Palladio.Webserver) " +
					"and setting configuration-properties \"debugging\" command-line-arguments.)\n" + e);
				Console.WriteLine("Webserver halted. Please exit the webserver.");
				Thread.CurrentThread.Suspend();
			}

			return root;
		}


	}
}
