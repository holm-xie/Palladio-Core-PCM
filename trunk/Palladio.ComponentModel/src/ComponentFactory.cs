using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;
using Palladio.ComponentModel.InterfaceModels;
using Palladio.ComponentModel.ServiceEffects;
using Palladio.ComponentModel.Components;
using Palladio.ComponentModel.Connections;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Factory for creating components and component models.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/21 15:37:44  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentFactory
	{	

		#region CreateType

		/// <summary>
		/// Create an IType instance using System.Type of the .Net Reflection API.
		/// </summary>
		/// <param name="aType">Type instance of the .Net Reflection API.</param>
		/// <returns>A Palladio IType instance equivalent to aType.</returns>
		public static IType CreateType(System.Type aType)
		{
			return new ReflectedType(aType);
		}

		/// <summary>
		/// Create an IType instance by using the .Net Reflection API to
		/// resolve aTypeName.
		/// </summary>
		/// <param name="aTypeName">Name of an existing type.</param>
		/// <returns>A Palladio IType instance representing aTypeName.</returns>
		public static IType CreateType(string aTypeName)
		{
			return new ReflectedType(aTypeName);
		}

		/// <summary>
		/// Create an array of IType instances using System.Type of the .Net Reflection API.
		/// </summary>
		/// <param name="aTypeArray">Array of Type instances of the .Net Reflection API.</param>
		/// <returns>An Array of Palladio IType instances equivalent to aTypeArray.</returns>
		public static IType[] CreateTypeArray(params System.Type[] aTypeArray)
		{
			IType[] result = new IType[aTypeArray.Length];
			int index = 0;
			foreach( System.Type t in aTypeArray)
				result[index++] = CreateType(t);
			return result;
		}

		/// <summary>
		/// Create an array of IType instances by using the .Net Reflection API to
		/// resolve each type name of aTypeNameArray.
		/// </summary>
		/// <param name="aTypeNameArray">Array of Names of an existing types.</param>
		/// <returns>An Array of Palladio IType instances representing the types listed in aTypeNameArray.</returns>
		public static IType[] CreateTypeArray(params string[] aTypeNameArray)
		{
			IType[] result = new IType[aTypeNameArray.Length];
			int index = 0;
			foreach( string s in aTypeNameArray)
				result[index++] = CreateType(s);
			return result;
		}

		#endregion

		#region CreateParameter

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(IType aType, string aName, ParameterModifierEnum modifier)
		{
			return new Parameter(aType,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(System.Type aType, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aTypeName">Name of the type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="modifier">Modifier of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(string aTypeName, string aName, ParameterModifierEnum modifier)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName,modifier);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(IType aType, string aName)
		{
			return CreateParameter(aType,aName,ParameterModifierEnum.NONE);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(System.Type aType, string aName)
		{
			IType itype = CreateType(aType);
			return CreateParameter(itype,aName);
		}

		/// <summary>
		/// Create a new parameter for a signature. 
		/// </summary>
		/// <param name="aTypeName">Name of the type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <returns>A new IParameter instance.</returns>
		public static IParameter CreateParameter(string aTypeName, string aName)
		{
			IType itype = CreateType(aTypeName);
			return CreateParameter(itype,aName);
		}

		#endregion

		#region CreateSignature

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="anAttributeHash">Attributes of the signature.</param>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(AttributeHash anAttributeHash, IType aReturnType, string aName, IParameter[] aParamArray, IType[] anExceptionArray)
		{
			return new DefaultSignature(anAttributeHash, aReturnType, aName, aParamArray, anExceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, IParameter[] aParamArray,params IType[] anExceptionArray)
		{
			AttributeHash attributeHash = CreateAttributeHash();
			return CreateSignature(attributeHash, aReturnType, aName, aParamArray, anExceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, IParameter[] aParamArray,params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(returnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, IParameter[] aParamArray,params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(returnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature with System.Void as return type.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, IParameter[] aParamArray,params string[] anExceptionNameArray)
		{
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature with System.Void as return type, empty parameter and empty
		/// exception list
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName)
		{
			return CreateSignature(aName, new IParameter[0], new IType[0]);
		}

		/// <summary>
		/// Creates a new ISignature with System.Void as return type.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <param name="exceptionArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, IParameter[] aParamArray,params IType[] exceptionArray)
		{
			IType returnType = CreateType("System.Void");
			return CreateSignature(returnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType[] exceptionArray = new IType[0];
			return CreateSignature(aReturnType, aName, aParamArray, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnType);
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without exceptions and the return type 'void'. 
		/// It can only be added to interfaces with the roleID aRoleID.
		/// </summary>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="aParamArray">Orderd array of parameters of the signature.</param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aName, params IParameter[] aParamArray)
		{
			IType returnType = CreateType(typeof(void));
			return CreateSignature(returnType, aName, aParamArray);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(IType aReturnType, string aName, IType[] anExceptionArray)
		{
			IParameter[] param = new IParameter[0];
			return CreateSignature(aReturnType,aName,param,anExceptionArray);
		}
		
		/// <summary>
		/// Create a container containing a signature and an interface. Those containers
		/// are used to describe an external service from another component.
		/// </summary>
		/// <param name="iface">the iface of the required service</param>
		/// <param name="signatureID">The signature of the service in the external interface</param>
		/// <returns>A container object containing a signature and an interface</returns>
		public static IService CreateService(IInterfaceModel iface, IIdentifier signatureID )
		{
			if (!iface.SignatureList.ContainsSignatureID(signatureID))
				throw new Exceptions.SignatureNotFoundException(signatureID);
			return new DefaultService(signatureID, iface);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnType">Type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionArray">Unorderd Array of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(System.Type aReturnType, string aName, params System.Type[] anExceptionArray)
		{
			IType returnType = CreateType(aReturnType);
			IType[] exceptionArray = CreateTypeArray(anExceptionArray);
			return CreateSignature(returnType, aName, exceptionArray);
		}

		/// <summary>
		/// Creates a new ISignature without parameters. It can only be added to interfaces with the
		/// roleID aRoleID.
		/// </summary>
		/// <param name="aReturnTypeName">Name of the type of the return value of the signature.</param>
		/// <param name="aName">Name of the Signature.</param>
		/// <param name="anExceptionNameArray">Unorderd Array of the names of exceptions which can be thrown during the execution of the signature. </param>
		/// <returns>A new ISignature.</returns>
		public static ISignature CreateSignature(string aReturnTypeName, string aName, params string[] anExceptionNameArray)
		{
			IType returnType = CreateType(aReturnTypeName);
			IType[] exceptionArray = CreateTypeArray(anExceptionNameArray);
			return CreateSignature(returnType, aName, exceptionArray);
		}

		/// <summary>
		/// Creates an array of ISignatures. For each name in aNameArray a new ISignature
		/// without parameters and exceptions is created. The return type of each 
		/// new ISignature is 'void' and its roleID is aRoleID.
		/// </summary>
		/// <param name="aNameArray">Names of the new Signatures.</param>
		/// <returns>An Array of new ISignatures.</returns>
		public static ISignature[] CreateSignatureArray(params string[] aNameArray)
		{
			ISignature[] result = new ISignature[aNameArray.Length];
			int index = 0;
			foreach (string name in aNameArray)
				result[index++] = CreateSignature(name);
			return result;
		}

		/// <summary>
		/// Create an array of <see cref="IService"/> containers. All of them belong to the same Interfaces which is
		/// specified by iface.
		/// </summary>
		/// <param name="iface">The interface to be assigned to the signatures</param>
		/// <param name="sigsIDs">The ids of the signatures to be attached to the interface.</param>
		/// <returns>An array of <see cref="IService"/></returns>
		public static IService[] CreateServiceArray(IInterfaceModel iface, params IIdentifier[] sigIDs)
		{
			IService[] result = new IService[sigIDs.Length];
			for (int i=0; i < sigIDs.Length; i++)
			{
				result[i] = CreateService(iface,sigIDs[i]);
			}
			return result;
		}

		/// <summary>
		/// Create an array of <see cref="IService"/> containers. All of them belong to the same Interfaces which is
		/// extracted from role given by role.
		/// </summary>
		/// <param name="role">the role, from which the interface is extracted</param>
		/// <param name="sigsIDs">The ids of the signatures to be attached to the interface.</param>
		/// <returns>An array of <see cref="IService"/></returns>
		public static IService[] CreateServiceArray(IRole role, params IIdentifier[] sigIDs)
		{
			return CreateServiceArray(role.Interface,sigIDs);
		}
		#endregion

		#region CreateSignatureListXXX

		/// <summary>
		/// Create a new ISignatureList with aSignatureArray
		/// aSignatureArray.
		/// </summary>
		/// <param name="aSignatureArray">Signatures contained by the new interface.</param>
		/// <returns>A new ISignatureList.</returns>
		public static ISignatureList CreateSignatureList(params ISignature[] aSignatureArray)
		{
			return new DefaultSignatureList(aSignatureArray);
		}

		/// <summary>
		/// Create a new ISignatureList with the role aRoleID and a new set of signatures
		/// created using the names contained in aSignatureNameArray.
		/// </summary>
		/// <param name="aSignatureNameArray">Names of the Signature of the interface.</param>
		/// <returns>A new ISignature instance.</returns>
		public static ISignatureList CreateSignatureList(params string[] aSignatureNameArray)
		{
			return new DefaultSignatureList(CreateSignatureArray(aSignatureNameArray) );
		}

		/// <summary>
		/// Create an Interface WITHOUT a RoleID! This is required as service effect specifications have no
		/// Role.
		/// Currently implemented by setting RoleID to an empty string and disabling constraint checking in this case.
		/// TODO: Should probably be implemented with a decorater for the RoleID
		/// </summary>
		/// <param name="signatures"></param>
		/// <returns></returns>
		public static IServiceList CreateServiceList(params IService[] signatures)
		{
			return new DefaultServiceList(signatures);
		}

		#endregion

		#region CreateXXXInterfaceModel
		/// <summary>
		/// Construct a new interface model
		/// </summary>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(ISignatureList aSigList, string name)
		{
			IInterfaceModel model = new DefaultInterfaceModel(new AttributeHash(),aSigList, name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(model, ModelPersistencyInfo.ATTACHED);
			return model;
		}
		
		/// <summary>
		/// Construct a new interface model
		/// </summary>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IInterfaceModel model = new DefaultInterfaceModel(new AttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(model, info);
			return model;
		}

		/// <summary>
		/// Construct a new interface model containing the given signatures
		/// </summary>
		/// <param name="aSigList">The signatures to be added to the interface initialy</param>
		/// <returns>The newly created interface model</returns>
		public static IInterfaceModel CreateInterfaceModel(ISignatureList aSigList, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IInterfaceModel model = new DefaultInterfaceModel(new AttributeHash(),aSigList, name, ID);
			ModelPersistencyService.Instance.RegisterEntity(model, info);
			return model;
		}

		public static IInterfaceModel CreateInterfaceModel(string name)
		{
			IInterfaceModel model = new DefaultInterfaceModel(new AttributeHash(), name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(model, ModelPersistencyInfo.ATTACHED);
			return model;
		}
		
		/// <summary>
		/// Construct an empty service effect specification
		/// </summary>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification()
		{
			return new DefaultServiceEffectSpecification(new AttributeHash());
		}

		/// <summary>
		/// Construct an service effect specification containing the given external signatures
		/// </summary>
		/// <param name="aSigList">The external signatures contained in the service effect initialy</param>
		/// <returns>A newly created service effect specification</returns>
		public static IServiceEffectSpecification CreateServiceEffectSpecification(IServiceList aSigList)
		{
			return new DefaultServiceEffectSpecification(new AttributeHash(),aSigList);
		}
		#endregion

		#region CreateRole
		internal static IRole CreateRole(IInterfaceModel anInterface, IComponent aComponent)
		{
			return new DefaultRole(aComponent,anInterface);
		}
		#endregion

		#region CreateFSMProtocol
		/// <summary>
		/// Create a FSM containing ISignatures as input symbols to specify
		/// the allowed order of service calls.
		/// </summary>
		/// <returns>A newly created FSM interface protocol automaton</returns>
		public static IFSMInterface CreateFSMProtocolInterface()
		{
			return new FSMInterface(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}

		/// <summary>
		/// Create a FSM containing IExternalSignatures as input symbols to specify
		/// the allowed order of service calls.
		/// </summary>
		/// <returns>A newly created FSM servive effect specification protocol automaton</returns>
		public static IFSMServiceEffect CreateFSMProtocolServiceEffect()
		{
			return new FSMServiceEffect(CreateAttributeHash(), FSMFactory.CreateEmptyFSM());
		}
		#endregion

		#region CreateBasicComponent

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes specified in anAttrHash.
		/// </summary>
		/// <param name="anAttrHash">AttributeHash associated with the new component.</param>
		/// <param name="name">Name of the component to create.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(AttributeHash anAttrHash, string name)
		{
			IBasicComponent comp = new BasicComponent(anAttrHash, name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent.
		/// </summary>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(string name)
		{
			IBasicComponent comp = new BasicComponent(CreateAttributeHash(), name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes specified in anAttrHash.
		/// </summary>
		/// <param name="anAttrHash">AttributeHash associated with the new component.</param>
		/// <param name="name">Name of the component to create.</param>
		/// <param name="ID">ID of the component to create.</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(AttributeHash anAttrHash, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IBasicComponent comp = new BasicComponent(anAttrHash,name,ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent.
		/// </summary>
		/// <returns>New IBasicComponent instance.</returns>
		public static IBasicComponent CreateBasicComponent(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			IBasicComponent comp = new BasicComponent(CreateAttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}
		#endregion

		#region CompositeComponent
		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes given by anAttributeHash.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Component.</param>
		/// <param name="name">A name for the component</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(AttributeHash anAttrHash, string name)
		{
			ICompositeComponent comp = new CompositeComponent(anAttrHash, name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty instance of ICompositeComponent.
		/// </summary>
		/// <returns>A new ICompositeComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(string name)
		{
			ICompositeComponent comp = new CompositeComponent(CreateAttributeHash(), name, (GloballyUniqueIdentifier)IdentifiableFactory.CreateGUID());
			ModelPersistencyService.Instance.RegisterEntity(comp, ModelPersistencyInfo.ATTACHED);
			return comp;
		}

		/// <summary>
		/// Create a new, empty IBasicComponent with the attributes given by anAttributeHash.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new Component.</param>
		/// <param name="ID">An string identifier for the component</param>
		/// <returns>New IBasicComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(AttributeHash anAttrHash, string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			ICompositeComponent comp = new CompositeComponent(anAttrHash, name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		/// <summary>
		/// Create a new, empty instance of ICompositeComponent.
		/// </summary>
		/// <returns>A new ICompositeComponent instance.</returns>
		public static ICompositeComponent CreateCompositeComponent(string name, GloballyUniqueIdentifier ID, ModelPersistencyInfo info)
		{
			ICompositeComponent comp = new CompositeComponent(CreateAttributeHash(), name, ID);
			ModelPersistencyService.Instance.RegisterEntity(comp, info);
			return comp;
		}

		#endregion

		#region CreateConnections

		#if true

		/// <summary>
		/// Create a new IAssemblyConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new AssemblyConnector.</param>
		/// <param name="provComponent">Providing component of the AssemblyConnector relation.</param>
		/// <param name="provRoleID">Providing role of provComp.</param>
		/// <param name="reqComponent">Requiring component of the AssemblyConnector relation.</param>
		/// <param name="reqRoleID">Requiring role of reqComp.</param>
		/// <returns>New IAssemblyConnector instance</returns>
		public static IAssemblyConnector CreateAssemblyConnector(AttributeHash anAttrHash, IComponent reqComponent,
			IIdentifier reqRoleID, IComponent provComponent, IIdentifier provRoleID)
		{
			return new DefaultAssemblyConnector(
				anAttrHash,
				reqComponent.GetRole(reqRoleID),
				provComponent.GetRole(provRoleID));
		}

		/// <summary>
		/// Create a new IAssemblyConnector instance.
		/// </summary>
		/// <param name="provComponent">Providing component of the AssemblyConnector relation.</param>
		/// <param name="provRoleID">Providing role of provComp.</param>
		/// <param name="reqRoleID">Requiring role of reqComp.</param>
		/// <param name="reqComponent">Requiring component of the AssemblyConnector relation.</param>
		/// <returns>New IAssemblyConnector instance</returns>
		public static IAssemblyConnector CreateAssemblyConnector(IComponent reqComponent, IIdentifier reqRoleID,
			IComponent provComponent, IIdentifier provRoleID)
		{
			return new DefaultAssemblyConnector(
				CreateAttributeHash(),
				reqComponent.GetRole(reqRoleID),
				provComponent.GetRole(provRoleID));
		}

		/// <summary>
		/// Create a new IAssemblyConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new AssemblyConnector.</param>
		/// <param name="provRole">Providing role of the AssemblyConnector relation.</param>
		/// <param name="reqRole">Requiring role of the AssemblyConnector relation.</param>
		/// <returns>New IAssemblyConnector instance</returns>
		public static IAssemblyConnector CreateAssemblyConnector(AttributeHash anAttrHash, IRole reqRole, IRole provRole)
		{
			return new DefaultAssemblyConnector( anAttrHash, reqRole, provRole);
		}
#endif 

#if true
		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new DelegationConnector.</param>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anOuterComponent">The outer component the inner component maps to.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateProvidesDelegationConnector(AttributeHash anAttrHash, IComponent anOuterComponent, 
			IIdentifier anOuterRoleID, IComponent anInnerComponent, IIdentifier anInnerRoleID)
		{
			return new DefaultDelegationConnector(anAttrHash, anOuterComponent.GetRole(anOuterRoleID), anInnerComponent.GetRole(anInnerRoleID), DelegationTypeEnum.PROVIDES_DELEGATION);
		}

		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner component is mapped to</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateProvidesDelegationConnector(IComponent anOuterComponent, IIdentifier anOuterRoleID, 
			IComponent anInnerComponent, IIdentifier anInnerRoleID)
		{
			return CreateProvidesDelegationConnector(CreateAttributeHash(), anOuterComponent, anOuterRoleID, anInnerComponent, anInnerRoleID);
		}

		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new DelegationConnector.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateProvidesDelegationConnector(AttributeHash anAttrHash, IRole anOuterRole, IRole anInnerRole)
		{
			return new DefaultDelegationConnector(anAttrHash, anOuterRole, anInnerRole, DelegationTypeEnum.PROVIDES_DELEGATION);
		}
		
		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateProvidesDelegationConnector(IRole anOuterRole, IRole anInnerRole)
		{
			return new DefaultDelegationConnector(CreateAttributeHash(), anOuterRole, anInnerRole, DelegationTypeEnum.PROVIDES_DELEGATION);
		}
		
		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new DelegationConnector.</param>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner compoent is mapped to.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateRequiresDelegationConnector(AttributeHash anAttrHash, IComponent anInnerComponent, 
			IIdentifier anInnerRoleID, IComponent anOuterComponent, IIdentifier anOuterRoleID)
		{
			return new DefaultDelegationConnector(anAttrHash, anInnerComponent.GetRole(anInnerRoleID), anOuterComponent.GetRole(anOuterRoleID), DelegationTypeEnum.REQUIRES_DELEGATION);
		}

		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anOuterRoleID">RoleID of the outer interface.</param>
		/// <param name="anInnerComponent">The inner component the outer interface is mapped onto.</param>
		/// <param name="anOuterComponent">The outer component to which the inner compoent is mapped to.</param>
		/// <param name="anInnerRoleID">The RoleID of the inner component the outer interface is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateRequiresDelegationConnector(IComponent anInnerComponent, IIdentifier anInnerRoleID, IComponent anOuterComponent, IIdentifier anOuterRoleID)
		{
			return CreateRequiresDelegationConnector(CreateAttributeHash(), anInnerComponent, anInnerRoleID, anOuterComponent, anOuterRoleID);
		}

		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anAttrHash">Attributes of the new DelegationConnector.</param>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner interface anOuterRole is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateRequiresDelegationConnector(AttributeHash anAttrHash, 
			IRole anInnerRole, IRole anOuterRole)
		{
			return new DefaultDelegationConnector(anAttrHash, anInnerRole, anOuterRole, DelegationTypeEnum.REQUIRES_DELEGATION);
		}
		
		/// <summary>
		/// Create a new IDelegationConnector instance.
		/// </summary>
		/// <param name="anOuterRole">RoleID of the outer interface.</param>
		/// <param name="anInnerRole">The inner role anOuterRole is mapped onto.</param>
		/// <returns>A new IDelegationConnector instance.</returns>
		public static IDelegationConnector CreateRequiresDelegationConnector(IRole anInnerRole, IRole anOuterRole)
		{
			return new DefaultDelegationConnector(CreateAttributeHash(), anInnerRole, anOuterRole, DelegationTypeEnum.REQUIRES_DELEGATION);
		}

#endif
		#endregion

		/// <summary>
		/// Creates a new, empty AttributeHash.
		/// </summary>
		/// <returns>New AttributeHash instance.</returns>
		public static AttributeHash CreateAttributeHash()
		{
			return new AttributeHash();
		}
	}
}
