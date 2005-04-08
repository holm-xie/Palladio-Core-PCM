using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the basic component builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/08 14:40:54  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.2  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractBasicComponentBuilder : IBasicComponentBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;
		private IComponent component;


		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="component">The component to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IComponent component)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.component = component;
		}

		/// <summary>
		/// Called to add an existing interface as provided interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// Called to add an existing interface as required interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Creates a new interface and adds it to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(interfaceName);
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.PROVIDES);
			return new DefaultInterfaceTypeLevelBuilder(lowLevelBuilder, iInterface);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(interfaceName);
			lowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.REQUIRES);
			return new DefaultInterfaceTypeLevelBuilder(lowLevelBuilder, iInterface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provides interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			lowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveRequiresInterface (IInterfaceIdentifier ifaceID)
		{
			lowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Returns the <see cref="IComponentIdentifier"/> of the actual component.
		/// </summary>
		public IComponentIdentifier ComponentID
		{
			get { return this.component.ComponentID; }
		}

	}
}
