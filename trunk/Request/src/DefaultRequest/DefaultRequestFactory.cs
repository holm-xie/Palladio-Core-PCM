using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// DefaultRequestFactory. Creates the different types of Request: IRequest: general request and IHTTPRequest http-request.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.2  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// Revision 1.1  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultRequestFactory : IRequestFactory
	{
		public DefaultRequestFactory()
		{
		}

		public IRequest CreateRequest(IWebserverMonitor webserverMonitor)
		{
			return new DefaultRequest(webserverMonitor);
		}

		public IHTTPRequest CreateHTTPRequest()
		{
			return new DefaultHTTPRequest();
		}
	}
}