#if TEST
using System.IO;
using System.Text;
using System.Xml;
using NUnit.Framework;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.UnitTests.TestClasses;

namespace Palladio.FiniteStateMachines.UnitTests
{
	/// <summary>
	/// Test of the FSM serialization.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/15 09:52:56  kelsaka
	/// *** empty log message ***
	///
	/// </code>
	/// </remarks>
	[TestFixture]
	public class SerializationTest
	{
		IFiniteStateMachine testFSM;

		/// <summary>
		/// </summary>
		[SetUp]
		public void Init() 
		{
			this.testFSM = BuildExampleFSM();
		}

		[Test]
		public void XMLWriterSaveTest()
		{
			IFiniteStateMachine fsm = BuildExampleFSM();
			IXMLSerializer serializer = new XMLSerializer();
			XmlTextWriter writer = new XmlTextWriter(".\\testFSM-W.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;
			writer.Indentation= 4;
			writer.Namespaces = true;
			writer.WriteStartDocument();
		
			serializer.Save(writer, fsm);

			writer.Close();
		}

		[Test]
		public void XMLFilenameSaveTest()
		{
			IFiniteStateMachine fsm = BuildExampleFSM();
			IXMLSerializer serializer = new XMLSerializer();
			serializer.Save(new FileInfo(".\\testFSM-F.xml"), fsm);
		}

		[Test]
		[ExpectedException(typeof(AttributeNotSupportedException))]
		public void AttributeNotSerializeable()
		{
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();;
			IXMLSerializer serializer = new XMLSerializer();
			serializer.Save(new FileInfo(".\\testFSM-F.xml"), fsm);
		}

		[Test]
		public void AttributeSerialize()
		{
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();;
			IXMLSerializer serializer = new XMLSerializer();
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.Save(new FileInfo(".\\testFSM-test.xml"), fsm);
		}

		[Test]
		public void AddMultipleAttributeSerializersForSameAttributeType()
		{
			IXMLSerializer serializer = new XMLSerializer();
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
		}

		private IFiniteStateMachine BuildExampleFSM()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
			states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.StartState = states["1"];
			return fsm;
		}

		private IFiniteStateMachine BuildExampleFSMAttributes()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
			
			states.StoredStates[0].Attributes.Add(new Test1AttributeType(), new Test1Attribute());
			states.StoredStates[1].Attributes.Add(new Test1AttributeType(), new Test1Attribute());

			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);

			ITransition t1 = FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]);
			t1.Attributes.Add(new Test1AttributeType(), new Test1Attribute());
			fsm.AddTransitions (t1);

			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
			states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.StartState = states["1"];
			return fsm;
		}
	}
}
#endif