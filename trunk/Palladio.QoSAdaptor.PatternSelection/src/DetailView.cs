#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage f�r 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using Palladio.QoSAdaptor.Pattern;
using System.Drawing;
using System.Windows.Forms;

namespace Palladio.QoSAdaptor.PatternSelection
{
	/// <summary>
	/// This class implements a detailed view for a 
	/// PatternDescription. The view is realized as a ListView
	/// </summary>
	internal class DetailView : System.Windows.Forms.Form
	{
		#region data
		private System.ComponentModel.Container components = null;
		/// <summary>
		/// The pattern that shall be shown in detail. 
		/// </summary>
		private IPatternDescription pattern;

		/// <summary>
		/// The list view containing all detail information.
		/// </summary>
		private ListView listView;
		#endregion

		#region constructor	
		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="pattern">The PatternDescription of the 
		/// chosen pattern</param>
		internal DetailView(IPatternDescription pattern)
		{
			this.pattern = pattern; 
			InitializeComponent();
			InitializeListView();
		}
		#endregion

		#region Code generated by the form designer. Comments are in german, because I used the german version of VS.
		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		
		/// <summary>
		/// Erforderliche Methode f�r die Designerunterst�tzung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor ge�ndert werden.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(DetailView));
			// 
			// DetailView
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(650, 250);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Name = "DetailView";
			this.Text = "Detailed description of the "+this.pattern.Name+
						" pattern";

		}
		#endregion

		#region Manually written form code
		/// <summary>
		/// This method creates the listView of the pattern given
		/// in the constructor. 
		/// </summary>
		private void InitializeListView()
		{
			// Create a new ListView control.
			this.listView = new ListView();
			this.listView.Bounds = new Rectangle(new Point(10,10), new Size(630,230));

			// Set the view to show details.
			this.listView.View = View.Details;
			// Display grid lines.
			this.listView.GridLines = true;
   
			// Create columns for the items and subitems.
			this.listView.Columns.Add("", -2, HorizontalAlignment.Left);
			this.listView.Columns.Add("", -2, HorizontalAlignment.Left);
		
			CreateItems();

			// Add the ListView to the control collection.
			this.Controls.Add(this.listView);
			this.listView.Size = new System.Drawing.Size(675, 300);
			// TODO: Change size dynamically
			this.Size = new System.Drawing.Size(700, 350);
		}

		/// <summary>
		/// Method used by InitializeListView to encapsulate the 
		/// creation of the ListItems.
		/// </summary>
		private void CreateItems()
		{
			AddGeneralItems();
			
			AddMismatchItems();

			AddAdaptorTemplateItems();

			AddPredictionModelItems();
		}

		/// <summary>
		/// Adds the general information of the pattern to the list view.
		/// </summary>
		private void AddGeneralItems()
		{
			AddItem("General Info", "", true);
			AddItem("Name", this.pattern.Name, false);
			AddItem("InterfaceModel", this.pattern.InterfaceModel, false);
			AddItem("Description", this.pattern.Description, false);
			AddItem("Source", this.pattern.Source, false);
		}

		/// <summary>
		/// Adds the items corresponding to the mismatch attributes of the 
		/// current pattern.
		/// </summary>
		private void AddMismatchItems()
		{
			AddItem("Mismatches", "", true);

			foreach (IMismatchAttribute mismatchAttribute in 
				this.pattern.MismatchAttributes)
				AddItem(mismatchAttribute.Name, mismatchAttribute.Suitability, 
					false);		
		}

		/// <summary>
		/// Adds the items corresponding to the adaptor templates of the 
		/// current pattern.
		/// </summary>
		private void AddAdaptorTemplateItems ()
		{
			AddItem("Adaptor templates", "", true);

			int counter = 1;
			foreach (string template in this.pattern.AdapterTemplates)
			{
				AddItem("Template "+counter, template, false);
				counter++;
			}	
		}

		/// <summary>
		/// Adds the items corresponding to the prediction models of the 
		/// current pattern.
		/// </summary>
		private void AddPredictionModelItems()
		{
			AddItem("Prediction models", "", true);
	
			int counter = 1;
			foreach (IPredictionModel predictionModel in 
				this.pattern.PredictionModels)
			{
				AddItem(predictionModel.Name, "", true);

				foreach (string template in predictionModel.Templates)
				{
					AddItem("Template "+counter, template, false);
					counter++;	
				}
			}
		}

		/// <summary>
		/// Adds an item to this.listView
		/// </summary>
		/// <param name="text">Text in the first column.</param>
		/// <param name="subtext">Text in the second column.</param>
		/// <param name="highlight">True, if text shall be highlighted, i.e.
		/// is a heading.</param>
		private void AddItem(string text, string subtext, bool highlight)
		{
			ListViewItem mainItem = new ListViewItem(text);
			mainItem.SubItems.Add(subtext);
			if (highlight)
				mainItem.BackColor = System.Drawing.Color.LightGray;
			this.listView.Items.Add(mainItem);
		}
		#endregion
	}
}
