package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelCreationWizard;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

public class NewSeffDiagramAction
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}