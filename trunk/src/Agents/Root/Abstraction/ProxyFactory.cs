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

using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Core.Agents.Root.Abstraction
{
	/// <summary>
	/// The ProxyFactory creates proxy objects for concrete instances of the component model. 
	/// All Proxies are derived from <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy"/>.
	/// </summary>
	internal class ProxyFactory
	{
		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IBasicComponent"/>.
		/// </summary>
		/// <param name="comp">An instance implementing <see cref="Palladio.ComponentModel.IBasicComponent"/></param>
		/// <param name="compCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy or its aggregated components.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// roles within or attached to this proxy.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// interfaces within or attached to this proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to interfaces within or attached to this proxy.</param>
		/// <param name="attrProv"></param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IBasicComponent"/>.</returns>
		public static BasicComponentProxy CreateBasicComponentProxy(
			IBasicComponent comp, 
			CommandHandler compCmdHandler, 
			CommandHandler roleCmdHandler, 
			CommandHandler ifaceCmdHandler, 
			CommandHandler sigCmdHandler,
			AttributeProvider attrProv)
		{

			BasicComponentProxy proxy = new BasicComponentProxy(comp, compCmdHandler, new RoleProxy[comp.ProvidedRoles.Length], new RoleProxy[comp.ProvidedRoles.Length], new ServiceEffectSpecificationProxy[comp.GetServicesWithServiceEffectSpecification().Length], attrProv);

			// create role proxies for the provides interfaces
			RoleProxy[] providedRoles = new RoleProxy[comp.ProvidedRoles.Length];
			for(int i = 0; i < comp.ProvidedRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.ProvidedRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv);
				providedRoles[i] = entity;
			}

			// create role proxies for the requires interfaces
			RoleProxy[] requiredRoles = new RoleProxy[comp.RequiredRoles.Length];
			for(int i = 0; i < comp.RequiredRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.RequiredRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv);
				requiredRoles[i] = entity;
			}

			proxy.ProvidedRoles.Clear();
			proxy.RequiredRoles.Clear();
			proxy.ProvidedRoles.AddRange(providedRoles);
			proxy.RequiredRoles.AddRange(requiredRoles);

			// create sef proxies
			IService[] services = comp.GetServicesWithServiceEffectSpecification();
			ServiceEffectSpecificationProxy[] sefProxies = new ServiceEffectSpecificationProxy[services.Length];
			for(int i = 0; i < services.Length; i++)
			{
				Palladio.ComponentModel.IServiceEffectSpecification sef = comp.GetServiceEffectSpecification(services[i]);
				ServiceEffectSpecificationProxy entity = CreateServiceEffectSpecificationProxy(sef, proxy, services[i], compCmdHandler, attrProv);
				foreach(IService sig in sef.SignatureList)
				{
					entity.ServiceList.Add(CreateSignatureProxy(sig.Signature,proxy.GetRequiresRoleByInterfaceID(sig.Interface.ID).Interface, sigCmdHandler, attrProv));
				}
				sefProxies[i] = entity;
			}

			proxy.ServiceEffects.Clear();
			proxy.ServiceEffects.AddRange(sefProxies);

			return proxy;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.ICompositeComponent"/>.
		/// </summary>
		/// <param name="comp">An instance implementing <see cref="Palladio.ComponentModel.ICompositeComponent"/></param>
		/// <param name="compCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy or its aggregated components.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// roles within or attached to this proxy.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// interfaces within or attached to this proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to interfaces within or attached to this proxy.</param>
		/// <param name="attrProv"></param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.ICompositeComponent"/>.</returns>
		public static CompositeComponentProxy CreateCompositeComponentProxy(
			ICompositeComponent comp, 
			CommandHandler compCmdHandler, 
			CommandHandler roleCmdHandler, 
			CommandHandler ifaceCmdHandler, 
			CommandHandler sigCmdHandler,
			AttributeProvider attrProv)
		{
			ComponentProxy[] subcomps = new ComponentProxy[comp.Components.Length];
			for(int i = 0; i < comp.Components.Length; i++)
			{
				ComponentProxy entity = null;
				Palladio.ComponentModel.IComponent subcomp = comp.Components[i];
				if (subcomp is IBasicComponent)
					entity = CreateBasicComponentProxy(subcomp as IBasicComponent, compCmdHandler, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv );
				if (subcomp is ICompositeComponent)
					entity = CreateCompositeComponentProxy(subcomp as ICompositeComponent, compCmdHandler, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv);
				subcomps[i] = entity;
			}
			
			CompositeComponentProxy proxy = new CompositeComponentProxy(comp, compCmdHandler, new RoleProxy[comp.ProvidedRoles.Length], new RoleProxy[comp.RequiredRoles.Length], subcomps, attrProv);

			// create role proxies for the provides interfaces
			RoleProxy[] providedRoles = new RoleProxy[comp.ProvidedRoles.Length];
			for(int i = 0; i < comp.ProvidedRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.ProvidedRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv);
				providedRoles[i] = entity;
			}

			// create role proxies for the requires interfaces
			RoleProxy[] requiredRoles = new RoleProxy[comp.RequiredRoles.Length];
			for(int i = 0; i < comp.RequiredRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.RequiredRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler, attrProv);
				requiredRoles[i] = entity;
			}

			proxy.ProvidedRoles.Clear();
			proxy.RequiredRoles.Clear();
			proxy.ProvidedRoles.AddRange(providedRoles);
			proxy.RequiredRoles.AddRange(requiredRoles);

			return proxy;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IRole"/>.
		/// </summary>
		/// <param name="role">An instance implementing <see cref="Palladio.ComponentModel.IRole"/></param>
		/// <param name="comp">The Proxy object for the component to which this role is being attached.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this role.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// the interface proxy attached to this role.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to the interface attached to this role.</param>
		/// <param name="attrProv"></param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IRole"/>.</returns>
		public static RoleProxy CreateRoleProxy(IRole role, ComponentProxy comp, CommandHandler roleCmdHandler, CommandHandler ifaceCmdHandler, CommandHandler sigCmdHandler, AttributeProvider attrProv)
		{
			InterfaceProxy interfaceProxy = CreateInterfaceProxy(role.Interface, ifaceCmdHandler, sigCmdHandler, attrProv);
			RoleProxy rp = new RoleProxy(role, comp, interfaceProxy, roleCmdHandler);
			return rp;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IInterfaceModel"/>.
		/// </summary>
		/// <param name="iface">An instance implementing <see cref="Palladio.ComponentModel.IInterfaceModel"/>.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this interface proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to this interface proxy.</param>
		/// <param name="attrProv"></param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IInterfaceModel"/>.</returns>
		public static InterfaceProxy CreateInterfaceProxy(IInterfaceModel iface, CommandHandler ifaceCmdHandler, CommandHandler sigCmdHandler, AttributeProvider attrProv)
		{
			SignatureProxy[] signatures = new SignatureProxy[iface.SignatureList.Count];

			for(int i = 0; i < iface.SignatureList.Count; i++)
			{
				Palladio.ComponentModel.ISignature sig = iface.SignatureList[i];
				SignatureProxy sigProxy = CreateSignatureProxy(sig, null, sigCmdHandler, attrProv);
				signatures[i] = sigProxy;
			}

			InterfaceProxy ip = new InterfaceProxy(iface, ifaceCmdHandler, signatures, attrProv);

			foreach(SignatureProxy sig in ip.Signatures)
				sig.Interface = ip;
			
			return ip;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sig">An instance implementing <see cref="Palladio.ComponentModel.ISignature"/>.</param>
		/// <param name="iface">The interface proxy to which this signature belongs.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy.</param>
		/// <returns></returns>
		public static SignatureProxy CreateSignatureProxy(ISignature sig, InterfaceProxy iface, CommandHandler sigCmdHandler, AttributeProvider attrProv)
		{
			SignatureProxy proxy = new SignatureProxy(sig, iface, sigCmdHandler, new ParameterProxy[sig.Parameters.Length], attrProv);

			ParameterProxy[] parameters = new ParameterProxy[sig.Parameters.Length];
			for(int i = 0; i < sig.Parameters.Length; i++)
			{
				Palladio.ComponentModel.IParameter param = sig.Parameters[i];
				ParameterProxy paramProxy = CreateParameterProxy(param, proxy);
				parameters[i] = paramProxy;
			}

			proxy.Parameters.Clear();
			proxy.Parameters.AddRange(parameters);
			return proxy;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="param"></param>
		/// <param name="sig"></param>
		/// <returns></returns>
		public static ParameterProxy CreateParameterProxy(IParameter param, SignatureProxy sig)
		{
			return new ParameterProxy(param, sig);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="binding"></param>
		/// <param name="connCmdHandler"></param>
		/// <param name="attrProv"></param>
		/// <returns></returns>
		public static BindingProxy CreateBindingProxy(IBinding binding, RoleProxy provRole, RoleProxy reqRole, CommandHandler connCmdHandler, AttributeProvider attrProv)
		{
			return new BindingProxy(binding, provRole, reqRole, connCmdHandler, attrProv);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="mapping"></param>
		/// <param name="innerRole"></param>
		/// <param name="outerRole"></param>
		/// <param name="connCmdHandler"></param>
		/// <param name="attrProv"></param>
		/// <returns></returns>
		public static ProvidesMappingProxy CreateProvidesMappingProxy(IMapping mapping, RoleProxy innerRole, RoleProxy outerRole, CommandHandler connCmdHandler, AttributeProvider attrProv)
		{
			return new ProvidesMappingProxy(mapping, innerRole, outerRole, connCmdHandler, attrProv);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="mapping"></param>
		/// <param name="connCmdHandler"></param>
		/// <param name="attrProv"></param>
		/// <returns></returns>
		public static RequiresMappingProxy CreateRequiresMappingProxy(IMapping mapping, RoleProxy innerRole, RoleProxy outerRole, CommandHandler connCmdHandler, AttributeProvider attrProv)
		{
			return new RequiresMappingProxy(mapping, innerRole, outerRole, connCmdHandler, attrProv);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sef"></param>
		/// <param name="comp"></param>
		/// <param name="service"></param>
		/// <param name="sefCmdHandler"></param>
		/// <param name="attrProv"></param>
		/// <returns></returns>
		public static ServiceEffectSpecificationProxy CreateServiceEffectSpecificationProxy(IServiceEffectSpecification sef, BasicComponentProxy comp, IService service, CommandHandler sefCmdHandler, AttributeProvider attrProv)
		{
			return new ServiceEffectSpecificationProxy(sef, comp, service, sefCmdHandler, attrProv);
		}
	
	}
}
