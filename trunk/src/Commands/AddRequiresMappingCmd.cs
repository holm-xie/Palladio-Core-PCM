#region Universit�t Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universit�t Oldenburg
//	Department f�r Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors f�r die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;

using Palladio.Identifier;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Exceptions;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.Commands
{
	/// <summary>
	/// Zusammenfassung f�r AddBindingCmd.
	/// </summary>
	public class AddRequiresMappingCmd : AbstractCommand
	{
		private ICompositeComponent _targetComp;
		private IIdentifier _role1ID;
		private IIdentifier _comp2ID;
		private IIdentifier _role2ID;
		private IMapping _createdMapping;

		public AddRequiresMappingCmd(ICompositeComponent component, IIdentifier role1ID, IIdentifier comp2ID, IIdentifier role2ID)
		{
			this._targetComp = component;
			this._role1ID = role1ID;
			this._comp2ID = comp2ID;
			this._role2ID = role2ID;
		}

		#region ICommand Member

		public override bool Execute()
		{
			if (this._createdMapping == null)
			{
				this._createdMapping = ComponentFactory.CreateRequiresMapping(
					this._targetComp.GetComponent(this._comp2ID),
					this._role2ID,
					this._targetComp,
					this._role1ID);
			}
			try
			{
				this._targetComp.AddRequiresMappings(this._createdMapping);
			}
			catch(InvalidRoleException e)
			{
				return false;
			}

			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
				EntityChangeReason.REQUIRESMAPPING_ADDED,
				this._createdMapping.ID.Clone() as IIdentifier);

			return true;
		}

		public override bool CanUndo
		{
			get
			{
				return false;
			}
		}

		public override bool Undo()
		{
			//			this._targetComp.DeleteComponents(this._createdComp.ID);
			//
			//			this._evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
			//				EntityChangeReason.COMPONENT_REMOVED,
			//				this._createdComp.ID.Clone() as IIdentifier);

			return true;
		}

		public override Palladio.Editor.Common.EntityProxies.EventArgs EventArgs
		{
			get
			{
				return this._evtArgs;
			}
		}

		public override object Receiver
		{
			get
			{
				return this._targetComp;
			}
		}

		public override object Clone()
		{
			return new AddRequiresMappingCmd(this._targetComp, this._role1ID, this._comp2ID, this._role2ID);
		}
		#endregion
	}
}
