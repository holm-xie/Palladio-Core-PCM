//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by CodeSmith.
//     Version: 2.5.14.0
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------
using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	public interface IFSMInterface : ICloneable, IAttributable, IVisitable, IAuxiliaryInterfaceSpecification
	{
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IFiniteStateMachine FSM
		{
			get;
		}

		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IEditableFiniteStateMachine EditFSM
		{
			get;
		}
		
		/// <summary>
		/// Return the signatures which can be used as input alphabeth for the FSM
		/// </summary>
		ISignature[] Signatures 
		{
			get;
		}
		
	}

	
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	public interface IFSMServiceEffect : ICloneable, IAttributable, IVisitable, IAuxiliaryServiceEffectSpecification
	{
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IFiniteStateMachine FSM
		{
			get;
		}

		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		IEditableFiniteStateMachine EditFSM
		{
			get;
		}
		
		/// <summary>
		/// Return the signatures which can be used as input alphabeth for the FSM
		/// </summary>
		IService[] Signatures 
		{
			get;
		}
		
	}

}
