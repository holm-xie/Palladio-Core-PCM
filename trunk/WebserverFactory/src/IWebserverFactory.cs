using System;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// IWebserverFactory.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IWebserverFactory
	{

		/// <summary>
		/// Returns whether a type can be used as a provides-component for the given component
		/// </summary>
		/// <param name="type">The type to check for compatiblity.</param>
		/// <returns>True, if the type can be used as a provides-component.</returns>
		//bool isAttachable (Type type);

	
		/// <summary>
		/// Creates the DefaultDispatcher.
		/// </summary>
		/// <param name="requestParser">A component that fullfills the required-interface.</param>
		/// <returns>IDispatcher, using the services from the reqestParser.</returns>
		IDispatcher CreateDispatcher(IRequestParser requestParser);


		/// <summary>
		/// Creates a WebserverMonitor: a component for logging- and debuggin-features. 
		/// </summary>
		/// <returns></returns>
		IWebserverMonitor CreateWebserverMonitor();


		/// <summary>
		/// Creates a ConfigReader to get settings for the webserver.
		/// </summary>
		/// <returns></returns>
		IConfigReader CreateConfigReader();


		/// <summary>
		/// Creates a HTTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as HTTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>HTTPRequestParser</returns>
		IRequestParser CreateHTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser CorSuccessor);


		/// <summary>
		/// Creates a FTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as FTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>FTPRequestParser</returns>
		IRequestParser CreateFTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor);


		/// <summary>
		/// This parser does not use other components as it catches errors on parsing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be parsed. It should be the last link in the COR.
		/// </summary>
		/// <returns>ErrorRequestParser</returns>
		IRequestParser CreateDefaultRequestParser();


		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateStaticFileProvider(IHTTPRequestProcessor CorSuccessor);


		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateDynamicFileProvider(IHTTPRequestProcessor CorSuccessor);


		/// <summary>
		/// This processor does not use other components as it catches errors on processing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be processed. It should be the last link in the COR.
		/// </summary>
		/// <returns>DefaultRequestProcessor</returns>
		IHTTPRequestProcessor CreateDefaultRequestProcessor();


	}
}
