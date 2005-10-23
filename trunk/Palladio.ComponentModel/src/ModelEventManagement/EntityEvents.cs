using Palladio.Attributes;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from any entity in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// Revision 1.3  2005/04/06 20:48:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class EntityEvents : IEntityEvents
	{
		#region constructor

		/// <summary>
		/// called to create a new eventstructure for an entity
		/// </summary>
		internal EntityEvents(IComponentModelEntity entity)
		{
			entity.NameChangedEvent += new StaticAttributeChangedEventHandler(entity_NameChangedEvent);
			entity.Attributes.AttributeChanged +=new Palladio.Attributes.AttributeChangedEventHandler(Attributes_AttributeChanged);
		}

		#endregion

		#region notify methods

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		/// <param name="args">the arguments</param>
		internal void NotifyAttributeChangedEvent(object sender, AttributeChangedEventArgs args)
		{
			if (AttributeChangedEvent != null)
				AttributeChangedEvent(sender, args);
		}

		/// <summary>
		/// called to fire the event
		/// </summary>
		/// <param name="sender">the sender</param>
		internal void NotifyNameChangedEvent(object sender)
		{
			if (NameChangedEvent != null)
				NameChangedEvent(sender);
		}

		#endregion

		#region events
		
		/// <summary>
		/// fired, when an attribute of the attribute hashtable has been changed
		/// </summary>
		public event AttributeChangedEventHandler AttributeChangedEvent;

		/// <summary>
		/// called when the name of the entity has been changed
		/// </summary>
		public event StaticAttributeChangedEventHandler NameChangedEvent;

		#endregion

		#region private methods

		//called by the entity when the name has been changed
		private void entity_NameChangedEvent(object sender)
		{
            NotifyNameChangedEvent(sender);
		}

		//called by the attributehash when an attribute has been changed
		private void Attributes_AttributeChanged(object source, AttributeChangedEventArgs args)
		{	
			NotifyAttributeChangedEvent(source,args);
		}

		#endregion
	}
}
