/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.part;

import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemEditPart;

/**
 * @generated
 */
public class PcmLoadResourceAction implements IObjectActionDelegate {

	/**
	 * @generated
	 */
	private SystemEditPart mySelectedElement;

	/**
	 * @generated
	 */
	private Shell myShell;

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myShell = targetPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		LoadResourceDialog loadResourceDialog = new LoadResourceDialog(myShell,
				mySelectedElement.getEditingDomain());
		loadResourceDialog.open();
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1
					&& structuredSelection.getFirstElement() instanceof SystemEditPart) {
				mySelectedElement = (SystemEditPart) structuredSelection
						.getFirstElement();
			}
		}
		action.setEnabled(isEnabled());
	}

	/**
	 * @generated
	 */
	private boolean isEnabled() {
		return mySelectedElement != null;
	}

}
