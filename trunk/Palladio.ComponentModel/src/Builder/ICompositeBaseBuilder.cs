using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ICompositeBase. Interface base for composite-like structures like composite component- and root-builder.
	/// This interface does justice to the fact, that composite components (respective their builder) do not have
	/// methods to add non-connected first class entities, those entities only can be added by the RootBuilder.
	/// Anyway the <see cref="ICompositeComponentBuilder"/> and the <see cref="IRootBuilder"/> have lot of methods
	/// in common.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/18 07:17:38  kelsaka
	/// - added comments
	///
	/// Revision 1.1  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ICompositeBaseBuilder
	{

	
		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns		
		IComponentBuilder AddComponent(IComponent component, IComponentIdentifier parentComponentID);

		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.BASIC"/>) to the component model.
		/// </summary>
		/// <param name="name"></param>
		/// <returns></returns>
		IBasicComponentBuilder AddBasicComponent(string name);
				
		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		ICompositeComponentBuilder AddCompositeComponent(string name);
				
		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		void RemoveComponent(IComponentIdentifier componentId);



		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		void AddAssemblyConnector(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID,
			IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID);

	}
}
