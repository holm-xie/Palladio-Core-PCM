//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by CodeSmith.
//     Version: 2.6.0.117
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------
using System;
using System.Reflection;

namespace Palladio.WebserverAnalyser.Interceptor
{

#region IConfigReader

public class ConfigReaderInterceptor : Palladio.Webserver.ConfigReader.IConfigReader
{

	private Palladio.Webserver.ConfigReader.IConfigReader _target;
	
	public  ConfigReaderInterceptor(Palladio.Webserver.ConfigReader.IConfigReader target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public WebserverXML.ConfigType ReadConfiguration( System.String configPathFile)
	{
		MethodInfo method = _target.GetType().GetMethod("ReadConfiguration", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		WebserverXML.ConfigType returnValue = _target.ReadConfiguration(configPathFile);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   
	#endregion 

}

#endregion

#region IConfiguration

public class ConfigurationInterceptor : Palladio.Webserver.ConfigReader.IConfiguration
{

	private Palladio.Webserver.ConfigReader.IConfiguration _target;
	
	public  ConfigurationInterceptor(Palladio.Webserver.ConfigReader.IConfiguration target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public System.Object GetValue( System.String key)
	{
		MethodInfo method = _target.GetType().GetMethod("GetValue", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.Object returnValue = _target.GetValue(key);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   
	#endregion 

}

#endregion

#region IWebserverConfiguration

public class WebserverConfigurationInterceptor : Palladio.Webserver.ConfigReader.IWebserverConfiguration
{

	private Palladio.Webserver.ConfigReader.IWebserverConfiguration _target;
	
	public  WebserverConfigurationInterceptor(Palladio.Webserver.ConfigReader.IWebserverConfiguration target)
	{
		_target = target;
	}
	
	#region Properties 
	
	public System.String ConfigFilesPath
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_ConfigFilesPath");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.ConfigFilesPath; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_ConfigFilesPath");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.ConfigFilesPath = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.String DebugFile
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_DebugFile");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.DebugFile; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String DocumentRoot
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_DocumentRoot");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.DocumentRoot; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.Int32[] ListeningPorts
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_ListeningPorts");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Int32[] returnValue = _target.ListeningPorts; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String DefaultMimeType
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_DefaultMimeType");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.DefaultMimeType; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String ListenIP
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_ListenIP");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.ListenIP; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String LogFile
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_LogFile");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.LogFile; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String[] DefaultFileNames
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_DefaultFileNames");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String[] returnValue = _target.DefaultFileNames; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	#endregion 
	
	#region Methods

	public System.String GetMimeTypeFor( System.String fileExtension)
	{
		MethodInfo method = _target.GetType().GetMethod("GetMimeTypeFor", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.String returnValue = _target.GetMimeTypeFor(fileExtension);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   
	#endregion 

}

#endregion
	

#region IDispatcher

public class DispatcherInterceptor : Palladio.Webserver.Dispatcher.IDispatcher
{

	private Palladio.Webserver.Dispatcher.IDispatcher _target;
	
	public  DispatcherInterceptor(Palladio.Webserver.Dispatcher.IDispatcher target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public void Stop( )
	{
		MethodInfo method = _target.GetType().GetMethod("Stop", new Type[] {});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.Stop();
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void Run( )
	{
		MethodInfo method = _target.GetType().GetMethod("Run", new Type[] {});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.Run();
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion
	

#region IFTPRequestProcessor

public class FTPRequestProcessorInterceptor : Palladio.Webserver.FTPRequestProcessor.IFTPRequestProcessor
{

	private Palladio.Webserver.FTPRequestProcessor.IFTPRequestProcessor _target;
	
	public  FTPRequestProcessorInterceptor(Palladio.Webserver.FTPRequestProcessor.IFTPRequestProcessor target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods
	#endregion 

}

#endregion
	

#region IHTTPRequestProcessor

public class HTTPRequestProcessorInterceptor : Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessor
{

	private Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessor _target;
	
	public  HTTPRequestProcessorInterceptor(Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessor target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public void handleRequest( Palladio.Webserver.Request.IHTTPRequest httpRequest)
	{
		MethodInfo method = _target.GetType().GetMethod("handleRequest", new Type[] {typeof(Palladio.Webserver.Request.IHTTPRequest)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.handleRequest(httpRequest);
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion

#region IHTTPRequestProcessorTools

public class HTTPRequestProcessorToolsInterceptor : Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessorTools
{

	private Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessorTools _target;
	
	public  HTTPRequestProcessorToolsInterceptor(Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessorTools target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public System.Byte[] OpenFile( System.String completePath, System.String fileName)
	{
		MethodInfo method = _target.GetType().GetMethod("OpenFile", new Type[] {typeof(System.String), typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.Byte[] returnValue = _target.OpenFile(completePath, fileName);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   

	public System.String GetFileMimeTypeFor( System.String requestedFileType)
	{
		MethodInfo method = _target.GetType().GetMethod("GetFileMimeTypeFor", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.String returnValue = _target.GetFileMimeTypeFor(requestedFileType);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   

	public System.String BuildCompletePath( System.String requestedPath)
	{
		MethodInfo method = _target.GetType().GetMethod("BuildCompletePath", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.String returnValue = _target.BuildCompletePath(requestedPath);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   

	public void SendContentToClient( System.Byte[] contentDataBytes, System.Net.Sockets.Socket socket)
	{
		MethodInfo method = _target.GetType().GetMethod("SendContentToClient", new Type[] {typeof(System.Byte[]), typeof(System.Net.Sockets.Socket)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SendContentToClient(contentDataBytes, socket);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void SendContentToClient( System.String contentData, System.Net.Sockets.Socket socket)
	{
		MethodInfo method = _target.GetType().GetMethod("SendContentToClient", new Type[] {typeof(System.String), typeof(System.Net.Sockets.Socket)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SendContentToClient(contentData, socket);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void SendHTTPError( Palladio.Webserver.Request.IHTTPRequest httpRequest, System.String errorMessage, System.String errorCode)
	{
		MethodInfo method = _target.GetType().GetMethod("SendHTTPError", new Type[] {typeof(Palladio.Webserver.Request.IHTTPRequest), typeof(System.String), typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SendHTTPError(httpRequest, errorMessage, errorCode);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void SendHTTPHeader( System.String httpVersion, System.String mimeType, System.Int32 totalBytes, System.String httpStatusCode, System.Net.Sockets.Socket socket)
	{
		MethodInfo method = _target.GetType().GetMethod("SendHTTPHeader", new Type[] {typeof(System.String), typeof(System.String), typeof(System.Int32), typeof(System.String), typeof(System.Net.Sockets.Socket)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SendHTTPHeader(httpVersion, mimeType, totalBytes, httpStatusCode, socket);
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion
	

#region IRequest

public class RequestInterceptor : Palladio.Webserver.Request.IRequest
{

	private Palladio.Webserver.Request.IRequest _target;
	
	public  RequestInterceptor(Palladio.Webserver.Request.IRequest target)
	{
		_target = target;
	}
	
	#region Properties 
	
	public System.Int32 Port
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_Port");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Int32 returnValue = _target.Port; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_Port");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.Port = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Net.Sockets.Socket Socket
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_Socket");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Net.Sockets.Socket returnValue = _target.Socket; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_Socket");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.Socket = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Net.Sockets.TcpListener TcpListener
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_TcpListener");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Net.Sockets.TcpListener returnValue = _target.TcpListener; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_TcpListener");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.TcpListener = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	#endregion 
	
	#region Methods
	#endregion 

}

#endregion

#region IHTTPRequest

public class HTTPRequestInterceptor : Palladio.Webserver.Request.IHTTPRequest
{

	private Palladio.Webserver.Request.IHTTPRequest _target;
	
	public  HTTPRequestInterceptor(Palladio.Webserver.Request.IHTTPRequest target)
	{
		_target = target;
	}
	
	#region Properties 
	
	public System.String RequestedFileType
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_RequestedFileType");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.RequestedFileType; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_RequestedFileType");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.RequestedFileType = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.String RequestedFileName
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_RequestedFileName");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.RequestedFileName; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_RequestedFileName");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.RequestedFileName = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Net.Sockets.Socket Socket
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_Socket");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Net.Sockets.Socket returnValue = _target.Socket; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_Socket");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.Socket = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Collections.Hashtable GETHashtable
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_GETHashtable");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Collections.Hashtable returnValue = _target.GETHashtable; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	public System.String HttpVersion
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_HttpVersion");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.HttpVersion; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_HttpVersion");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.HttpVersion = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.String RequestedDirectoryName
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_RequestedDirectoryName");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.String returnValue = _target.RequestedDirectoryName; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_RequestedDirectoryName");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.RequestedDirectoryName = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Int32 RequestedMethodType
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_RequestedMethodType");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Int32 returnValue = _target.RequestedMethodType; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
		set 
		{ 
			MethodInfo method = _target.GetType().GetMethod("set_RequestedMethodType");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			_target.RequestedMethodType = value; 
			InterceptorActions.AfterCall(id, method);
		}
	}
	
	public System.Collections.Hashtable POSTHashtable
	{
		get 
		{ 
			MethodInfo method = _target.GetType().GetMethod("get_POSTHashtable");
			long id = InterceptorActions.GetNextCallID();
			InterceptorActions.BeforeCall(id, method);
			System.Collections.Hashtable returnValue = _target.POSTHashtable; 
			InterceptorActions.AfterCall(id, method);
			return returnValue;
		}
	}
	
	#endregion 
	
	#region Methods

	public System.String GetPOSTVariableValue( System.String key)
	{
		MethodInfo method = _target.GetType().GetMethod("GetPOSTVariableValue", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.String returnValue = _target.GetPOSTVariableValue(key);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   

	public System.String GetGETVariableValue( System.String key)
	{
		MethodInfo method = _target.GetType().GetMethod("GetGETVariableValue", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		System.String returnValue = _target.GetGETVariableValue(key);
		InterceptorActions.AfterCall(id, method);
		return returnValue;
	}                                   

	public void SetPOSTVariableValue( System.String key, System.String value)
	{
		MethodInfo method = _target.GetType().GetMethod("SetPOSTVariableValue", new Type[] {typeof(System.String), typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SetPOSTVariableValue(key, value);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void SetGETVariableValue( System.String key, System.String value)
	{
		MethodInfo method = _target.GetType().GetMethod("SetGETVariableValue", new Type[] {typeof(System.String), typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.SetGETVariableValue(key, value);
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion
	

#region IRequestParser

public class RequestParserInterceptor : Palladio.Webserver.RequestParser.IRequestParser
{

	private Palladio.Webserver.RequestParser.IRequestParser _target;
	
	public  RequestParserInterceptor(Palladio.Webserver.RequestParser.IRequestParser target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public void HandleRequest( Palladio.Webserver.Request.IRequest request)
	{
		MethodInfo method = _target.GetType().GetMethod("HandleRequest", new Type[] {typeof(Palladio.Webserver.Request.IRequest)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.HandleRequest(request);
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion
	

#region IRequestProcessor

public class RequestProcessorInterceptor : Palladio.Webserver.RequestProcessor.IRequestProcessor
{

	private Palladio.Webserver.RequestProcessor.IRequestProcessor _target;
	
	public  RequestProcessorInterceptor(Palladio.Webserver.RequestProcessor.IRequestProcessor target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods
	#endregion 

}

#endregion
	

#region IWebserverMonitor

public class WebserverMonitorInterceptor : Palladio.Webserver.WebserverMonitor.IWebserverMonitor
{

	private Palladio.Webserver.WebserverMonitor.IWebserverMonitor _target;
	
	public  WebserverMonitorInterceptor(Palladio.Webserver.WebserverMonitor.IWebserverMonitor target)
	{
		_target = target;
	}
	
	#region Properties 
	
	#endregion 
	
	#region Methods

	public void WriteLogEntry( System.String logMessage)
	{
		MethodInfo method = _target.GetType().GetMethod("WriteLogEntry", new Type[] {typeof(System.String)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.WriteLogEntry(logMessage);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void WriteDebugMessage( System.String debugMessage, System.Int32 debugLevel)
	{
		MethodInfo method = _target.GetType().GetMethod("WriteDebugMessage", new Type[] {typeof(System.String), typeof(System.Int32)});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.WriteDebugMessage(debugMessage, debugLevel);
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void FinishWriteAccess( )
	{
		MethodInfo method = _target.GetType().GetMethod("FinishWriteAccess", new Type[] {});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.FinishWriteAccess();
		InterceptorActions.AfterCall(id, method);
	}                                   

	public void InitializeWriteAccess( )
	{
		MethodInfo method = _target.GetType().GetMethod("InitializeWriteAccess", new Type[] {});
		long id = InterceptorActions.GetNextCallID();
		InterceptorActions.BeforeCall(id, method);
		_target.InitializeWriteAccess();
		InterceptorActions.AfterCall(id, method);
	}                                   
	#endregion 

}

#endregion
}
