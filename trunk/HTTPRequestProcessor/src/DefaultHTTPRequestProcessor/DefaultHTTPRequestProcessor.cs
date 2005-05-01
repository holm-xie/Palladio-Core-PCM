using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// DefaultHTTPRequestProcessor. Causes a <see cref="NotImplementedException"/> as there
	/// should be a chain link which already has handled processing the request.
	/// Use this processor as the last link of the chain.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.8  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.7  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.6  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.5  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.4  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultHTTPRequestProcessor : IHTTPRequestProcessor
	{
		/// <summary>
		/// default constructor.
		/// </summary>
		/// <param name="webserverMonitor">the monitor to use.</param>
		/// <param name="webserverConfiguration">the configuration to use.</param>
		/// <param name="requestProcessorTools">the tools to use. specify the first </param>
		public DefaultHTTPRequestProcessor(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
		}

		/// <summary>
		/// Proceeds on creating a answer to the httpRequest. This method will always cause
		/// a <see cref="NotImplementedException"/>.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void HandleRequest (IHTTPRequest httpRequest)
		{
			throw new NotImplementedException ();			
		}
	}
}
