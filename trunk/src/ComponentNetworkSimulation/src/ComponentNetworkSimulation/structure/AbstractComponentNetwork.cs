using System.Collections;

namespace ComponentNetworkSimulation.structure
{
	public abstract class AbstractComponentNetwork
	{
		protected ArrayList SystemServices = new ArrayList();
		protected ArrayList ConnectorList = new ArrayList();
	
		public abstract System.String getName();

		public TimeConsumer getSystemService(int idx)
		{
			if (idx < SystemServices.Count)
				return (TimeConsumer)SystemServices[idx];
			else
				return null;
		}

		public int getSystemServiceCount() 
		{
			return SystemServices.Count;
		}

		public IEnumerator getSystemServices()
		{
			return SystemServices.GetEnumerator();
		}

		public void reset()
		{
			for (int a=0;a<ConnectorList.Count;a++)
				((AbstractConnector)ConnectorList[a]).reset();
		}
	}
}
