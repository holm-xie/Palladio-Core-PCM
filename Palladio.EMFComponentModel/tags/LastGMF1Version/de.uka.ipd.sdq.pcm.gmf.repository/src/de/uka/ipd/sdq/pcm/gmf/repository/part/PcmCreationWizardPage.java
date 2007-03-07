/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;

/**
 * @generated
 */
public class PcmCreationWizardPage extends EditorWizardPage {

	/**
	 * @generated
	 */
	public PcmCreationWizardPage(IWorkbench workbench,
			IStructuredSelection selection) {
		super("CreationWizardPage", workbench, selection); //$NON-NLS-1$
		setTitle("Create repository_model Diagram");
		setDescription("Create a new repository_model diagram.");
	}

	/**
	 * @generated
	 */
	public IFile createAndOpenDiagram(IPath containerPath, String fileName,
			InputStream initialContents, String kind, IWorkbenchWindow dWindow,
			IProgressMonitor progressMonitor, boolean saveDiagram) {
		return PcmDiagramEditorUtil.createAndOpenDiagram(
				getDiagramFileCreator(), containerPath, fileName,
				initialContents, kind, dWindow, progressMonitor,
				isOpenNewlyCreatedDiagramEditor(), saveDiagram);
	}

	/**
	 * @generated
	 */
	protected String getDefaultFileName() {
		return "default"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public DiagramFileCreator getDiagramFileCreator() {
		return PcmDiagramFileCreator.getInstance();
	}

	/**
	 * @generated
	 */
	protected String getDiagramKind() {
		return RepositoryEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		if (super.validatePage()) {
			String fileName = getFileName();
			if (fileName == null) {
				return false;
			}
			// appending file extension to correctly process file names including "." symbol
			IPath path = getContainerFullPath()
					.append(
							getDiagramFileCreator().appendExtensionToFileName(
									fileName));
			path = path.removeFileExtension().addFileExtension("repository"); //$NON-NLS-1$
			if (ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
				setErrorMessage("Model File already exists: "
						+ path.lastSegment());
				return false;
			}
			return true;
		}
		return false;
	}

}
