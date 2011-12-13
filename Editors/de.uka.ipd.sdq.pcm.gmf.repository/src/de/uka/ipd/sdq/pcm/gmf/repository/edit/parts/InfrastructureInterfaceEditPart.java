/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.InfrastructureInterfaceItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InfrastructureInterfaceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2109;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public InfrastructureInterfaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InfrastructureInterfaceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		InfrastructureInterfaceFigure figure = new InfrastructureInterfaceFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public InfrastructureInterfaceFigure getPrimaryShape() {
		return (InfrastructureInterfaceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InfrastructureInterfaceEntityNameEditPart) {
			((InfrastructureInterfaceEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInfrastructureInterface_Name_LabelFigure());
			return true;
		}
		if (childEditPart instanceof InfrastructureInterfaceInfrastructureSignatureListEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureInfrastructureInterfaceCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((InfrastructureInterfaceInfrastructureSignatureListEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InfrastructureInterfaceEntityNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InfrastructureInterfaceInfrastructureSignatureListEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureInfrastructureInterfaceCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((InfrastructureInterfaceInfrastructureSignatureListEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof InfrastructureInterfaceInfrastructureSignatureListEditPart) {
			return getPrimaryShape()
					.getFigureInfrastructureInterfaceCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(InfrastructureInterfaceEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111);
		types
				.add(PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
			types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
			types
					.add(PalladioComponentModelElementTypes.CompositeComponent_2103);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
			types
					.add(PalladioComponentModelElementTypes.CompleteComponentType_2104);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
			types
					.add(PalladioComponentModelElementTypes.ProvidesComponentType_2105);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111) {
			types.add(PalladioComponentModelElementTypes.SubSystem_2106);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
			types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
			types
					.add(PalladioComponentModelElementTypes.CompositeComponent_2103);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
			types
					.add(PalladioComponentModelElementTypes.CompleteComponentType_2104);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
			types
					.add(PalladioComponentModelElementTypes.ProvidesComponentType_2105);
		}
		if (relationshipType == PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112) {
			types.add(PalladioComponentModelElementTypes.SubSystem_2106);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == PalladioComponentModelElementTypes.InfrastructureSignature_3108) {
				return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
						.getType(InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class InfrastructureInterfaceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureInfrastructureInterface_Name_LabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureInfrastructureInterfaceCompartment;

		/**
		 * @generated
		 */
		public InfrastructureInterfaceFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureInfrastructureInterface_Name_LabelFigure = new WrappingLabel();
			fFigureInfrastructureInterface_Name_LabelFigure.setText("<...>");
			fFigureInfrastructureInterface_Name_LabelFigure
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureInfrastructureInterface_Name_LabelFigure = new GridData();
			constraintFFigureInfrastructureInterface_Name_LabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.horizontalIndent = 0;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.horizontalSpan = 1;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.verticalSpan = 1;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureInfrastructureInterface_Name_LabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureInfrastructureInterface_Name_LabelFigure,
					constraintFFigureInfrastructureInterface_Name_LabelFigure);

			fFigureInfrastructureInterfaceCompartment = new RectangleFigure();
			fFigureInfrastructureInterfaceCompartment.setFill(false);
			fFigureInfrastructureInterfaceCompartment.setOutline(false);
			fFigureInfrastructureInterfaceCompartment.setLineWidth(1);
			fFigureInfrastructureInterfaceCompartment
					.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureInfrastructureInterfaceCompartment = new GridData();
			constraintFFigureInfrastructureInterfaceCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureInfrastructureInterfaceCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureInfrastructureInterfaceCompartment.horizontalIndent = 0;
			constraintFFigureInfrastructureInterfaceCompartment.horizontalSpan = 1;
			constraintFFigureInfrastructureInterfaceCompartment.verticalSpan = 1;
			constraintFFigureInfrastructureInterfaceCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureInfrastructureInterfaceCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureInfrastructureInterfaceCompartment,
					constraintFFigureInfrastructureInterfaceCompartment);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInfrastructureInterface_Name_LabelFigure() {
			return fFigureInfrastructureInterface_Name_LabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureInfrastructureInterfaceCompartment() {
			return fFigureInfrastructureInterfaceCompartment;
		}

	}

}