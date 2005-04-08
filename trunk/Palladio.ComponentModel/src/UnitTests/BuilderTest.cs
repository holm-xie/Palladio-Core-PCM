#if TEST
using NUnit.Framework;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// Testcases for the builder (not the low level builder).
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.3  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.2  2005/04/08 08:23:30  joemal
	/// rename class ComponentModel to ComponentModelEnvironment
	/// due to problems with the namespace
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	[TestFixture]	
	public class BuilderTest
	{
		private ComponentModelEnvironment componentModel;
		private IRootTypeLevelBuilder rootBuilder;

		#region for static use
		/// <summary>
		/// For debugging purposes.
		/// </summary>
		/// <param name="args">Arguments</param>
		public static void Main(string[] args)
		{
			BuilderTest bt = new BuilderTest();
			bt.AddBCToRoot();
		}

		public BuilderTest()
		{
			InitTest();
		}
		#endregion

		#region general tests
		[Test]
		public void InitTest()
		{
			this.componentModel = new ComponentModelEnvironment();	
			this.rootBuilder = componentModel.RootBuilder;
		}
		#endregion

		#region root-Tests
		[Test]
		public void AddBCToRoot()
		{
			rootBuilder.AddBasicComponent("BC1");
		}

		[Test]
		public void AddCCToRoot()
		{
			rootBuilder.AddCompositeComponent("CC1");
		}

		[Test]
		public void RemoveCCandBCFromRoot()
		{
			Identifier.IComponentIdentifier c1 = rootBuilder.AddCompositeComponent("CC2").ComponentID;
			Identifier.IComponentIdentifier c2 = rootBuilder.AddCompositeComponent("BC2").ComponentID;
			rootBuilder.RemoveComponent(c1);
			rootBuilder.RemoveComponent(c2);
		}

		[Test]
		public void AddInterfaceToRoot()
		{
			rootBuilder.AddInterface("Interface-Name1");
		}

		[Test]
		public void AddCC_BCToRoot()
		{
			rootBuilder.AddCompositeComponent("CC3").AddBasicComponent("CC3_BC3");
		}

		[Test]
		public void RemoveInternalCC_BCFromRoot()
		{
			Identifier.IComponentIdentifier c4 = rootBuilder.AddCompositeComponent("CC4").AddBasicComponent("CC4_BC4").ComponentID;
			rootBuilder.RemoveComponent(c4);
		}
		[Test]
		public void JustClearAll()
		{
			rootBuilder.ClearAll();
		}
		[Test]
		public void AddComponentThenClearAll()
		{
			rootBuilder.AddCompositeComponent("Comp");
			rootBuilder.ClearAll();
		}
		#endregion

		#region CC-Builder
		[Test]
		public void CC_AddBCToCCAndRemove()
		{
			Identifier.IComponentIdentifier c5 = rootBuilder.AddCompositeComponent("CC5").AddBasicComponent("CC4_BC4").ComponentID;
			rootBuilder.RemoveComponent(c5);
		}

		[Test]
		public void CC_AddProvidesInterfaceAndRemove()
		{
			Identifier.IInterfaceIdentifier i6 = rootBuilder.AddCompositeComponent("CC6").AddProvidesInterface("IF6").InterfaceID;
			rootBuilder.RemoveInterface(i6);
		}

		[Test]
		public void CC_AddRequiresInterfaceAndRemove()
		{
			Identifier.IInterfaceIdentifier i7 = rootBuilder.AddCompositeComponent("CC7").AddRequiresInterface("IF7").InterfaceID;
			rootBuilder.RemoveInterface(i7);
		}

		[Test]
		public void CC_AddInterfacesAndConnections()
		{
			ICompositeComponentTypeLevelBuilder sccb = rootBuilder.AddCompositeComponent("SuperCC8");
			Identifier.IInterfaceIdentifier i8 = rootBuilder.AddInterface("IF8").InterfaceID;
			
			ICompositeComponentTypeLevelBuilder ccb1 = sccb.AddCompositeComponent("CC8-1");
			ICompositeComponentTypeLevelBuilder ccb2 = sccb.AddCompositeComponent("CC8-2");

			ccb1.AddProvidesInterface(i8);
			ccb2.AddRequiresInterface(i8);

			sccb.AddAssemblyConnector("Connection8", ccb2.ComponentID, i8, ccb1.ComponentID, i8);			
		}

		[Test]
		public void CC_RemoveComponentTwice()
		{
			Identifier.IComponentIdentifier bc9 = rootBuilder.AddBasicComponent("BC9").ComponentID;
			rootBuilder.RemoveComponent(bc9);
			rootBuilder.RemoveComponent(bc9);
		}

		[Test]
		public void CC_AddComponentWithOneNameTwice()
		{
			rootBuilder.AddBasicComponent("BC9");
			rootBuilder.AddBasicComponent("BC9");
		}
		#endregion

		#region BC-Builder
		[Test]
		public void BC_AddInterfacesAndConnections()
		{
			ICompositeComponentTypeLevelBuilder sccb = rootBuilder.AddCompositeComponent("SuperCC10");
			Identifier.IInterfaceIdentifier i10 = rootBuilder.AddInterface("IF10").InterfaceID;
			
			IBasicComponentTypeLevelBuilder bcb1 = sccb.AddBasicComponent("BC10-1");
			IBasicComponentTypeLevelBuilder bcb2 = sccb.AddBasicComponent("BC10-2");

			bcb1.AddProvidesInterface(i10);
			bcb2.AddRequiresInterface(i10);

			sccb.AddAssemblyConnector("Connection8", bcb2.ComponentID, i10, bcb1.ComponentID, i10);			
		}

		[Test]
		public void BC_RemoveInterface()
		{
			Identifier.IInterfaceIdentifier i11 =  rootBuilder.AddInterface("IF11").InterfaceID;
			IBasicComponentTypeLevelBuilder bc11 = rootBuilder.AddBasicComponent("BC11");
			bc11.AddProvidesInterface(i11);
			bc11.AddRequiresInterface(i11);

			bc11.RemoveProvidesInterface(i11);
			bc11.RemoveProvidesInterface(i11);
		}
		#endregion
	}
}

#endif