namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Builder for creating Basic Components.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a basic
	/// component.</p>
	/// Probably currently no methods exist.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2005/05/27 15:22:51  kelsaka
	/// - added return of entity ids
	///
	/// Revision 1.7  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.4  2005/04/07 17:49:31  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.3  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IBasicComponentBuilder : IComponentBuilder
	{
		#region methods

		//basic methods that are non level specific for bc. probably currently no methods exist.

		#endregion


	}
}
