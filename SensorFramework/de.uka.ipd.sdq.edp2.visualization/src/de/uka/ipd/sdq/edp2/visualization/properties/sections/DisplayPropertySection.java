package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * GUI controls for displaying options of {@link AbstractEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection extends AbstractPropertySection {
	/** Logger */
	private static Logger logger = Logger
			.getLogger(DisplayPropertySection.class.getCanonicalName());

	/**
	 * Key which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	/**
	 * Composite for all properties of all JFreeCharts
	 */
	private CommonChartPropertiesComposite commonComposite;
	/**
	 * Composite for the properties of the currently displayed chart.
	 */
	private Composite specificComposite;
	/**
	 * The last active editor;
	 */
	private JFreeChartEditor editor;
	/**
	 * The parent composite.
	 */
	private Composite parent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.parent = parent;
		if (getInput() != null) {
			commonComposite = getInput().getCommonChartProperties()
					.retrieveComposite(parent);
			specificComposite = getInput().getChartProperties()
					.retrieveComposite(parent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput
	 * (org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
	}

	/**
	 * Retrieves the input of the currently active editor.
	 * 
	 * @return the current {@link IDataSink}
	 */
	public JFreeChartEditorInput getInput() {
		if (Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() == null) {
			return null;
		}
		editor = (JFreeChartEditor) Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return (JFreeChartEditorInput) editor.getEditorInput();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		updateInput();
	}

	private void updateInput() {
		if (getInput() != null) {
			specificComposite.dispose();
			commonComposite.dispose();
		}
		commonComposite = getInput().getCommonChartProperties().retrieveComposite(parent);
		specificComposite = getInput().getChartProperties().retrieveComposite(
				parent);
	}

}