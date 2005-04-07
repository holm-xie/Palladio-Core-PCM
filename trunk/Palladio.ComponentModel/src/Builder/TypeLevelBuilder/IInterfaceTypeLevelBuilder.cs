using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;


namespace Palladio.ComponentModel.Builder.TypeLevelBuilder
{

	/// <summary>
	/// Builder interface for type-level specific methods of interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public interface IInterfaceTypeLevelBuilder : IInterfaceBuilder
	{

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		IInterfaceImplementationLevelBuilder ImplementationLevelBuilder
		{
			get;
		}





	}
}
