package de.uka.ipd.sdq.edp2.models.ExperimentData.presentation;

import java.util.logging.Logger;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultSequence;
import de.uka.ipd.sdq.edp2.visualization.wizards.DefaultViewsWizard;

/**
 * Listener for selections in the TreeViewer of {@link ExperimentDataEditor}.
 * Creates a new {@link EDP2Source}, which is associated with the selected
 * {@link RawMeasurements}. Upon Doubleklick on a {@link RawMeasurements}-object
 * it opens a Dialog and offers possible combinations of visualizations and
 * transformations to display the data encapsulated by the object. All
 * combinations are objects of the Type {@link DefaultSequence} and displayed in
 * the {@link DefaultViewsWizard}.
 * 
 * @author ernst
 * 
 */
public class DoubleClickListener implements IDoubleClickListener {

	private final static Logger logger = Logger
			.getLogger(DoubleClickListener.class.getCanonicalName());

	@Override
	public void doubleClick(DoubleClickEvent event) {
		Object selectedObject = null;
		if (event.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			selectedObject = selection.getFirstElement();
		}
		RawMeasurements measurement = null;
		// check for the object to contain actual data
		if (selectedObject instanceof RawMeasurements) {
			measurement = (RawMeasurements) selectedObject;

			if (measurement != null && !measurement.getDataSeries().isEmpty()) {

				EDP2Source source = new EDP2Source(measurement);

				// open the wizard with reference to the selected source
				// it shows possible visualizations, which are instances of
				// DefaultSequence
				DefaultViewsWizard wizard = new DefaultViewsWizard(source);
				WizardDialog wdialog = new WizardDialog(EDP2EditorPlugin
						.getPlugin().getWorkbench().getActiveWorkbenchWindow()
						.getShell(), wizard);
				wdialog.open();

				if (wdialog.getReturnCode() == Window.OK) {
					DefaultSequence selection = wizard.getSelectedDefault();

					if (selection.getSize() > 0) {
						if (selection.getSequenceProperties().size() > 0) {
							selection.getFirstSequenceElement().setProperties(
									selection.getSequenceProperties().get(0));
						}
						selection.getFirstSequenceElement().setSource(source);
					}
					for (int i = 1; i < selection.getSize(); i++) {
						selection.getSequenceElements().get(i).setProperties(
								selection.getSequenceProperties().get(i));
						selection.getSequenceElements().get(i).setSource(
								selection.getSequenceElements().get(i - 1));
					}

					IVisualizationInput visualization = selection.getVisualization();
					visualization.setProperties(selection
							.getVisualizationProperties());
					if (selection.getSize() > 0) {
						visualization.setSource(selection
								.getLastSequenceElement());
					} else {
						visualization.setSource(source);
					}
					JFreeChartEditorInputHandle input = new JFreeChartEditorInputHandle(visualization);
					
					try {
						IWorkbenchPage page = EDP2EditorPlugin.getPlugin()
								.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage();
						IEditorPart editor = page
								.openEditor(input,
										"de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor");
						page.addPartListener(new PartEventListener());
					} catch (PartInitException e) { // TODO Auto-generated
						// catchblock
						e.printStackTrace();
					}

					
				}
			} else {
				throw new RuntimeException("Empty Measurements!");
			}
		}

	}

}
