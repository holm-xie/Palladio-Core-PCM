/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ImplementationComponentTypeParentCompleteComponentTypesReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidedRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.RequiredRoleReorientCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.CompleteComponentTypeEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ImplementationComponentTypeParentCompleteComponentTypesEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * @generated
 */
public class CompleteComponentTypeItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = new CompoundCommand();
		Collection allEdges = new ArrayList();
		View view = (View) getHost().getModel();
		allEdges.addAll(view.getSourceEdges());
		allEdges.addAll(view.getTargetEdges());
		for (Iterator it = allEdges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			EditPart nextEditPart = (EditPart) getHost().getViewer()
					.getEditPartRegistry().get(nextEdge);
			EditCommandRequestWrapper editCommandRequest = new EditCommandRequestWrapper(
					new DestroyElementRequest(
							((CompleteComponentTypeEditPart) getHost())
									.getEditingDomain(), req
									.isConfirmationRequired()),
					Collections.EMPTY_MAP);
			cc.add(nextEditPart.getCommand(editCommandRequest));
		}
		cc.add(getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		}));
		return cc;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PalladioComponentModelElementTypes.ProvidedRole_4101 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingProvidedRole_4101Command(req)
					: null;
		}
		if (PalladioComponentModelElementTypes.RequiredRole_4102 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRequiredRole_4102Command(req)
					: null;
		}
		if (PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingImplementationComponentTypeParentCompleteComponentTypes_4103Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingProvidedRole_4101Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof InterfaceProvidingEntity) {
			return UnexecutableCommand.INSTANCE;
		}
		InterfaceProvidingEntity source = (InterfaceProvidingEntity) sourceEObject;
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateProvidedRole_4101(source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRequiredRole_4102Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof InterfaceRequiringEntity) {
			return UnexecutableCommand.INSTANCE;
		}
		InterfaceRequiringEntity source = (InterfaceRequiringEntity) sourceEObject;
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRequiredRole_4102(source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingImplementationComponentTypeParentCompleteComponentTypes_4103Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof ImplementationComponentType
				|| false == targetEObject instanceof CompleteComponentType) {
			return UnexecutableCommand.INSTANCE;
		}
		ImplementationComponentType source = (ImplementationComponentType) sourceEObject;
		CompleteComponentType target = (CompleteComponentType) targetEObject;
		if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateImplementationComponentTypeParentCompleteComponentTypes_4103(
						source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(
				sourceEObject,
				RepositoryPackage.eINSTANCE
						.getImplementationComponentType_ParentCompleteComponentTypes(),
				target);
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ProvidedRoleEditPart.VISUAL_ID:
			return getMSLWrapper(new ProvidedRoleReorientCommand(req));
		case RequiredRoleEditPart.VISUAL_ID:
			return getMSLWrapper(new RequiredRoleReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
			return getMSLWrapper(new ImplementationComponentTypeParentCompleteComponentTypesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
