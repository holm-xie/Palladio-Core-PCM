using System;
using System.Net;
using System.Net.Sockets;
using System.Collections;
using System.Threading;
using SimpleLogging;

namespace Scheduler
{
	/// <summary>
	/// Forwards web requests to multiple equal servers in a cluster
	/// and transfers back the replies from the servers.
	/// </summary>
	class SchedulerComponent
	{
		public TcpListener portListener;
		private TcpClient client;
		private SimpleLogger logger;
		private IPAddress localIP;
		private int localPort;

		private ArrayList serverList;
		private IEnumerator serverEnum;

		private SchedulerThread currentThread;
		
		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			SchedulerComponent sc = new SchedulerComponent();
			sc.InitializeLogger();
			sc.StartServer();
			sc.StartListening();
		}

		public SchedulerComponent()
		{
			ArrayList localIPs = GetLocalIPList();
			this.localIP = (IPAddress) localIPs[0];
			this.localPort = 2048;

			this.serverList = GetServerList();
			this.serverEnum = this.serverList.GetEnumerator();
		}

		protected ArrayList GetServerList() 
		{
			ArrayList sL = new ArrayList();

			sL.Add(new IPEndPoint(IPAddress.Parse("192.168.0.2"), 1233));
			sL.Add(new IPEndPoint(IPAddress.Parse("192.168.0.2"), 1234));
			// ...
			
			return sL;
		}

		protected ArrayList GetLocalIPList()
		{
			ArrayList localIPAdresses=new ArrayList();
			String strHostName = Dns.GetHostName();
			IPHostEntry iphostentry = Dns.GetHostByName(strHostName);
			foreach(IPAddress ipaddress in iphostentry.AddressList)
			{
				localIPAdresses.Add(ipaddress);
			}
			return localIPAdresses;
		}

		protected void InitializeLogger()
		{
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.ErrorOutput=true;
		}	
		
		protected void StartServer()
		{
			this.logger.Debug("Local IP: "+this.localIP.ToString()+":"+this.localPort);
			
			try
			{
				this.portListener = new TcpListener(this.localIP,this.localPort);
				portListener.Start();
				this.logger.Debug("Server started.");
			}
			catch(Exception e)
			{
				this.logger.Error("An Exception Occurred while Listening :" +e.ToString());
				this.logger.Error(e.Message);
				this.logger.Error("Please press enter");
				Console.Read();
			}
		}

		protected void StartListening()
		{
			while (true) 
			{
				this.client = portListener.AcceptTcpClient();
				this.logger.Debug("Client connected.");
		
				// select next web server in list
				if(!this.serverEnum.MoveNext())	
				{
					this.serverEnum.Reset();
					this.serverEnum.MoveNext();
				}
				IPEndPoint serverEndPoint = (IPEndPoint)this.serverEnum.Current;
				this.logger.Debug("Selected Server: "+serverEndPoint.Address.ToString()+":"+serverEndPoint.Port);

				this.currentThread = new SchedulerThread(client, serverEndPoint);
			}
		}

	}
}
