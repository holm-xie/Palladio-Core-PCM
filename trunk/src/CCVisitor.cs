/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/07/06 00:30:44  sliver
 * + added Markov Probability for transitions
 * + CCVisitor propagates the reliability now
 * 
 */
 
using System;
using System.Collections;

using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Attributes;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of CompositeComponentVisitor.	
	/// </summary>
	public class CCVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		
		public TreeNode ReliabilityTree
		{
			get { return tree; }
		}
		
		public override void VisitObject(object o)
		{
			Console.WriteLine("Unkown object type: "+o.GetType());	
		}
		
		public void VisitIMapping(IMapping m)
		{
			if (m.IsProvidesMapping)
			{
				Visit(m.InnerRole.Component);
				TreeNode innerNode = tree.Children[m.InnerRole.ComponentID];
				foreach ( ISignature s in m.OuterRole.Role.Interface.SignatureList )
				{
					IExternalSignature innerSig = ComponentFactory.CreateExternalSignatureArray( m.InnerRole.RoleID, s) [0];
					IExternalSignature outerSig = ComponentFactory.CreateExternalSignatureArray( m.OuterRole.RoleID, s) [0];
					
					// forward reliability information
					// calculate influences of the mapping here!!
					tree.ProvidesReliabilities.Add( outerSig, innerNode.ProvidesReliabilities[innerSig] );
				}
			}
			else // m.IsRequiresMapping
			{
				TreeNode innerNode = tree.Children[m.InnerRole.ComponentID];
				foreach ( ISignature s in m.OuterRole.Role.Interface.SignatureList )
				{
					IExternalSignature innerSig = ComponentFactory.CreateExternalSignatureArray( m.InnerRole.RoleID, s) [0];
					IExternalSignature outerSig = ComponentFactory.CreateExternalSignatureArray( m.OuterRole.RoleID, s) [0];
					
					// forward reliability information
					// calculate influences of the mapping here!!
					innerNode.RequiresReliabilities.Add( innerSig, tree.RequiresReliabilities[outerSig] );
				}
			}
		}
		
		public void VisitIBinding(IBinding b)
		{
			Visit(b.ProvidingRole.Component);
			TreeNode reqNode = tree.Children[b.RequiringRole.ComponentID];
			TreeNode provNode = tree.Children[b.ProvidingRole.ComponentID];
			
			foreach ( ISignature s in b.RequiringRole.Role.Interface.SignatureList )
			{
				IExternalSignature reqSig = ComponentFactory.CreateExternalSignatureArray( b.RequiringRole.RoleID, s) [0];
				IExternalSignature provSig = ComponentFactory.CreateExternalSignatureArray( b.ProvidingRole.RoleID, s) [0];
				
				// forward reliability information
				// calculate influences of the mapping here!!
				reqNode.RequiresReliabilities.Add( reqSig, provNode.ProvidesReliabilities[provSig] );
			}
		}
		
		public void VisitICompositeComponent(ICompositeComponent aCC)
		{
			if (!visited.Contains(aCC.ID))
			{
				TreeNode ccNode = new TreeNode(aCC.ID);
				tree.AddChild(ccNode);
				visited.Add(aCC.ID);
				
				foreach( IConnection con in cc.GetRequiresConnections(aCC.ID) )
					Visit(con);
				
				CCVisitor v = new CCVisitor(aCC, ccNode);
			}
		}
		
		public void VisitIBasicComponent(IBasicComponent bc)
		{
			if (!visited.Contains(bc.ID))
			{
				TreeNode bcNode = new TreeNode(bc.ID);
				tree.AddChild( bcNode );
				visited.Add(bc.ID);
				
				foreach( IConnection con in cc.GetRequiresConnections(bc.ID) )
					Visit(con);
				
				foreach( IIdentifier id in bc.ProvidedRoles )
				{
					IInterfaceModel im = bc.GetProvidesInterface(id);
					foreach( ISignature sig in im.SignatureList )
					{
						IExternalSignature provSig = ComponentFactory.CreateExternalSignatureArray( id, sig ) [0];
						bcNode.ProvidesReliabilities[ provSig ] = new ReliabilityValue(1.0);
					}
				}
			}
		}
		
		public CCVisitor(ICompositeComponent cc) : this( cc, new TreeNode(cc.ID) )
		{
		}
		
		public CCVisitor(ICompositeComponent cc, TreeNode ccNode) : base(false)
		{
			this.cc = cc;
			this.visited = new ArrayList();
			this.tree = ccNode;
			foreach( IIdentifier i in cc.ProvidedRoles )
			{
				Visit(cc.GetProvidesMappingByOuter(i));
			}
		}
		
		private ICompositeComponent cc;
		private ArrayList visited;
		private TreeNode tree;
	}
}
