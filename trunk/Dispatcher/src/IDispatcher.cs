using System;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// IDispatcher.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IDispatcher
	{

		void Run();

		void Stop();



	}
}
