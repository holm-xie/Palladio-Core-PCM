//
// SeedType.cs.cs
//
// This file was generated by XMLSPY 2004 Enterprise Edition.
//
// YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
// OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
//
// Refer to the XMLSPY Documentation for further details.
// http://www.altova.com/xmlspy
//


using System;
using System.Collections;
using System.Xml;
using Altova.Types;

namespace TimeConsumingProcessorXML
{
	public class SeedType : Altova.Xml.Node
	{
		#region Forward constructors
		public SeedType() : base() { SetCollectionParents(); }
		public SeedType(XmlDocument doc) : base(doc) { SetCollectionParents(); }
		public SeedType(XmlNode node) : base(node) { SetCollectionParents(); }
		public SeedType(Altova.Xml.Node node) : base(node) { SetCollectionParents(); }
		#endregion // Forward constructors

		public override void AdjustPrefix()
		{

			for (int i = 0; i < DomChildCount(NodeType.Attribute, "", "InitialSeed"); i++)
			{
				XmlNode DOMNode = GetDomChildAt(NodeType.Attribute, "", "InitialSeed", i);
				InternalAdjustPrefix(DOMNode, false);
			}
		}


		#region InitialSeed accessor methods
		public int GetInitialSeedMinCount()
		{
			return 1;
		}

		public int InitialSeedMinCount
		{
			get
			{
				return 1;
			}
		}

		public int GetInitialSeedMaxCount()
		{
			return 1;
		}

		public int InitialSeedMaxCount
		{
			get
			{
				return 1;
			}
		}

		public int GetInitialSeedCount()
		{
			return DomChildCount(NodeType.Attribute, "", "InitialSeed");
		}

		public int InitialSeedCount
		{
			get
			{
				return DomChildCount(NodeType.Attribute, "", "InitialSeed");
			}
		}

		public bool HasInitialSeed()
		{
			return HasDomChild(NodeType.Attribute, "", "InitialSeed");
		}

		public SchemaString GetInitialSeedAt(int index)
		{
			return new SchemaString(GetDomNodeValue(GetDomChildAt(NodeType.Attribute, "", "InitialSeed", index)));
		}

		public SchemaString GetInitialSeed()
		{
			return GetInitialSeedAt(0);
		}

		public SchemaString InitialSeed
		{
			get
			{
				return GetInitialSeedAt(0);
			}
		}

		public void RemoveInitialSeedAt(int index)
		{
			RemoveDomChildAt(NodeType.Attribute, "", "InitialSeed", index);
		}

		public void RemoveInitialSeed()
		{
			while (HasInitialSeed())
				RemoveInitialSeedAt(0);
		}

		public void AddInitialSeed(SchemaString newValue)
		{
			AppendDomChild(NodeType.Attribute, "", "InitialSeed", newValue.ToString());
		}

		public void InsertInitialSeedAt(SchemaString newValue, int index)
		{
			InsertDomChildAt(NodeType.Attribute, "", "InitialSeed", index, newValue.ToString());
		}

		public void ReplaceInitialSeedAt(SchemaString newValue, int index)
		{
			ReplaceDomChildAt(NodeType.Attribute, "", "InitialSeed", index, newValue.ToString());
		}
		#endregion // InitialSeed accessor methods

		#region InitialSeed collection
        public InitialSeedCollection	MyInitialSeeds = new InitialSeedCollection( );

        public class InitialSeedCollection: IEnumerable
        {
            SeedType parent;
            public SeedType Parent
			{
				set
				{
					parent = value;
				}
			}
			public InitialSeedEnumerator GetEnumerator() 
			{
				return new InitialSeedEnumerator(parent);
			}
		
			IEnumerator IEnumerable.GetEnumerator() 
			{
				return GetEnumerator();
			}
        }

        public class InitialSeedEnumerator: IEnumerator 
        {
			int nIndex;
			SeedType parent;
			public InitialSeedEnumerator(SeedType par) 
			{
				parent = par;
				nIndex = -1;
			}
			public void Reset() 
			{
				nIndex = -1;
			}
			public bool MoveNext() 
			{
				nIndex++;
				return(nIndex < parent.InitialSeedCount );
			}
			public SchemaString  Current 
			{
				get 
				{
					return(parent.GetInitialSeedAt(nIndex));
				}
			}
			object IEnumerator.Current 
			{
				get 
				{
					return(Current);
				}
			}
    	}

        #endregion // InitialSeed collection

        private void SetCollectionParents()
        {
            MyInitialSeeds.Parent = this; 
	}
}
}
