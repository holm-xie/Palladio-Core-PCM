/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ComposedProvidingRequiringEntityCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class ComposedProvidingRequiringEntityItemSemanticEditPolicy.
 *
 * @generated
 */
public class ComposedProvidingRequiringEntityItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new composed providing requiring entity item semantic edit policy.
	 *
	 * @generated
	 */
	public ComposedProvidingRequiringEntityItemSemanticEditPolicy() {
		super(
				PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_1000);
	}

	/**
	 * Gets the creates the command.
	 *
	 * @param req the req
	 * @return the creates the command
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.ComposedProvidingRequiringEntity_2002 == req
				.getElementType()) {
			return getGEFWrapper(new ComposedProvidingRequiringEntityCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * Gets the duplicate command.
	 *
	 * @param req the req
	 * @return the duplicate command
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * The Class DuplicateAnythingCommand.
	 *
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * Instantiates a new duplicate anything command.
		 *
		 * @param editingDomain the editing domain
		 * @param req the req
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}
	}
}
