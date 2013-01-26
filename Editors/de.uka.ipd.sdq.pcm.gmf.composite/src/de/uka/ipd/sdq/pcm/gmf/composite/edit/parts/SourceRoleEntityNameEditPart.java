/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelTextSelectionEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelParserProvider;

/**
 * The Class SourceRoleEntityNameEditPart.
 * 
 * @generated
 */
public class SourceRoleEntityNameEditPart extends LabelEditPart implements ITextAwareEditPart, IBorderItemEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 5015;

    /** The manager. @generated */
    private DirectEditManager manager;

    /** The parser. @generated */
    private IParser parser;

    /** The parser elements. @generated */
    private List parserElements;

    /** The default text. @generated */
    private String defaultText;

    /**
     * @generated
     */
    static {
        registerSnapBackPosition(
                PalladioComponentModelVisualIDRegistry
                        .getType(de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEntityNameEditPart.VISUAL_ID),
                new Point(0, 0));
    }

    /**
     * Instantiates a new source role entity name edit part.
     * 
     * @param view
     *            the view
     * @generated
     */
    public SourceRoleEntityNameEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     * 
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new PalladioComponentModelTextSelectionEditPolicy());
    }

    /**
     * Gets the border item locator.
     * 
     * @return the border item locator
     * @generated
     */
    public IBorderItemLocator getBorderItemLocator() {
        IFigure parentFigure = getFigure().getParent();
        if (parentFigure != null && parentFigure.getLayoutManager() != null) {
            Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
            return (IBorderItemLocator) constraint;
        }
        return null;
    }

    /**
     * Refresh bounds.
     * 
     * @generated
     */
    public void refreshBounds() {
        int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
        int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
        int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
        int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
        getBorderItemLocator().setConstraint(new Rectangle(x, y, width, height));
    }

    /**
     * Gets the label text helper.
     * 
     * @param figure
     *            the figure
     * @return the label text helper
     * @generated
     */
    protected String getLabelTextHelper(IFigure figure) {
        if (figure instanceof WrappingLabel) {
            return ((WrappingLabel) figure).getText();
        } else {
            return ((Label) figure).getText();
        }
    }

    /**
     * Sets the label text helper.
     * 
     * @param figure
     *            the figure
     * @param text
     *            the text
     * @generated
     */
    protected void setLabelTextHelper(IFigure figure, String text) {
        if (figure instanceof WrappingLabel) {
            ((WrappingLabel) figure).setText(text);
        } else {
            ((Label) figure).setText(text);
        }
    }

    /**
     * Gets the label icon helper.
     * 
     * @param figure
     *            the figure
     * @return the label icon helper
     * @generated
     */
    protected Image getLabelIconHelper(IFigure figure) {
        if (figure instanceof WrappingLabel) {
            return ((WrappingLabel) figure).getIcon();
        } else {
            return ((Label) figure).getIcon();
        }
    }

    /**
     * Sets the label icon helper.
     * 
     * @param figure
     *            the figure
     * @param icon
     *            the icon
     * @generated
     */
    protected void setLabelIconHelper(IFigure figure, Image icon) {
        if (figure instanceof WrappingLabel) {
            ((WrappingLabel) figure).setIcon(icon);
        } else {
            ((Label) figure).setIcon(icon);
        }
    }

    /**
     * Sets the label.
     * 
     * @param figure
     *            the new label
     * @generated
     */
    public void setLabel(IFigure figure) {
        unregisterVisuals();
        setFigure(figure);
        defaultText = getLabelTextHelper(figure);
        registerVisuals();
        refreshVisuals();
    }

    /**
     * Gets the model children.
     * 
     * @return the model children
     * @generated
     */
    protected List getModelChildren() {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the child by semantic hint.
     * 
     * @param semanticHint
     *            the semantic hint
     * @return the child by semantic hint
     * @generated
     */
    public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
        return null;
    }

    /**
     * Gets the parser element.
     * 
     * @return the parser element
     * @generated
     */
    protected EObject getParserElement() {
        return resolveSemanticElement();
    }

    /**
     * Gets the label icon.
     * 
     * @return the label icon
     * @generated
     */
    protected Image getLabelIcon() {
        return null;
    }

    /**
     * Gets the label text.
     * 
     * @return the label text
     * @generated
     */
    protected String getLabelText() {
        String text = null;
        EObject parserElement = getParserElement();
        if (parserElement != null && getParser() != null) {
            text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
        }
        if (text == null || text.length() == 0) {
            text = defaultText;
        }
        return text;
    }

    /**
     * Sets the label text.
     * 
     * @param text
     *            the new label text
     * @generated
     */
    public void setLabelText(String text) {
        setLabelTextHelper(getFigure(), text);
        Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (pdEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
        }
        Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
        if (sfEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
        }
    }

    /**
     * Gets the edits the text.
     * 
     * @return the edits the text
     * @generated
     */
    public String getEditText() {
        if (getParserElement() == null || getParser() == null) {
            return ""; //$NON-NLS-1$
        }
        return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
    }

    /**
     * Checks if is editable.
     * 
     * @return true, if is editable
     * @generated
     */
    protected boolean isEditable() {
        return false;
    }

    /**
     * Gets the edits the text validator.
     * 
     * @return the edits the text validator
     * @generated
     */
    public ICellEditorValidator getEditTextValidator() {
        return new ICellEditorValidator() {

            public String isValid(final Object value) {
                if (value instanceof String) {
                    final EObject element = getParserElement();
                    final IParser parser = getParser();
                    try {
                        IParserEditStatus valid = (IParserEditStatus) getEditingDomain().runExclusive(
                                new RunnableWithResult.Impl() {

                                    public void run() {
                                        setResult(parser.isValidEditString(new EObjectAdapter(element), (String) value));
                                    }
                                });
                        return valid.getCode() == ParserEditStatus.EDITABLE ? null : valid.getMessage();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                // shouldn't get here
                return null;
            }
        };
    }

    /**
     * Gets the completion processor.
     * 
     * @return the completion processor
     * @generated
     */
    public IContentAssistProcessor getCompletionProcessor() {
        if (getParserElement() == null || getParser() == null) {
            return null;
        }
        return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
    }

    /**
     * Gets the parser options.
     * 
     * @return the parser options
     * @generated
     */
    public ParserOptions getParserOptions() {
        return ParserOptions.NONE;
    }

    /**
     * Gets the parser.
     * 
     * @return the parser
     * @generated
     */
    public IParser getParser() {
        if (parser == null) {
            parser = PalladioComponentModelParserProvider
                    .getParser(
                            PalladioComponentModelElementTypes.SourceRole_3013,
                            getParserElement(),
                            PalladioComponentModelVisualIDRegistry
                                    .getType(de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEntityNameEditPart.VISUAL_ID));
        }
        return parser;
    }

    /**
     * Gets the manager.
     * 
     * @return the manager
     * @generated
     */
    protected DirectEditManager getManager() {
        if (manager == null) {
            setManager(new TextDirectEditManager(this, TextDirectEditManager.getTextCellEditorClass(this),
                    PalladioComponentModelEditPartFactory.getTextCellEditorLocator(this)));
        }
        return manager;
    }

    /**
     * Sets the manager.
     * 
     * @param manager
     *            the new manager
     * @generated
     */
    protected void setManager(DirectEditManager manager) {
        this.manager = manager;
    }

    /**
     * Perform direct edit.
     * 
     * @generated
     */
    protected void performDirectEdit() {
        getManager().show();
    }

    /**
     * Perform direct edit.
     * 
     * @param eventLocation
     *            the event location
     * @generated
     */
    protected void performDirectEdit(Point eventLocation) {
        if (getManager().getClass() == TextDirectEditManager.class) {
            ((TextDirectEditManager) getManager()).show(eventLocation.getSWTPoint());
        }
    }

    /**
     * Perform direct edit.
     * 
     * @param initialCharacter
     *            the initial character
     * @generated
     */
    private void performDirectEdit(char initialCharacter) {
        if (getManager() instanceof TextDirectEditManager) {
            ((TextDirectEditManager) getManager()).show(initialCharacter);
        } else {
            performDirectEdit();
        }
    }

    /**
     * Perform direct edit request.
     * 
     * @param request
     *            the request
     * @generated
     */
    protected void performDirectEditRequest(Request request) {
        final Request theRequest = request;
        try {
            getEditingDomain().runExclusive(new Runnable() {

                public void run() {
                    if (isActive() && isEditable()) {
                        if (theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
                            Character initialChar = (Character) theRequest.getExtendedData().get(
                                    RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
                            performDirectEdit(initialChar.charValue());
                        } else if ((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
                            DirectEditRequest editRequest = (DirectEditRequest) theRequest;
                            performDirectEdit(editRequest.getLocation());
                        } else {
                            performDirectEdit();
                        }
                    }
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Refresh visuals.
     * 
     * @generated
     */
    protected void refreshVisuals() {
        super.refreshVisuals();
        refreshLabel();
        refreshFont();
        refreshFontColor();
        refreshUnderline();
        refreshStrikeThrough();
    }

    /**
     * Refresh label.
     * 
     * @generated
     */
    protected void refreshLabel() {
        setLabelTextHelper(getFigure(), getLabelText());
        setLabelIconHelper(getFigure(), getLabelIcon());
        Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (pdEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
        }
        Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
        if (sfEditPolicy instanceof PalladioComponentModelTextSelectionEditPolicy) {
            ((PalladioComponentModelTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
        }
    }

    /**
     * Refresh underline.
     * 
     * @generated
     */
    protected void refreshUnderline() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null && getFigure() instanceof WrappingLabel) {
            ((WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
        }
    }

    /**
     * Refresh strike through.
     * 
     * @generated
     */
    protected void refreshStrikeThrough() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null && getFigure() instanceof WrappingLabel) {
            ((WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
        }
    }

    /**
     * Refresh font.
     * 
     * @generated
     */
    protected void refreshFont() {
        FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
        if (style != null) {
            FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD
                    : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
            setFont(fontData);
        }
    }

    /**
     * Sets the font color.
     * 
     * @param color
     *            the new font color
     * @generated
     */
    protected void setFontColor(Color color) {
        getFigure().setForegroundColor(color);
    }

    /**
     * Adds the semantic listeners.
     * 
     * @generated
     */
    protected void addSemanticListeners() {
        if (getParser() instanceof ISemanticParser) {
            EObject element = resolveSemanticElement();
            parserElements = ((ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
            for (int i = 0; i < parserElements.size(); i++) {
                addListenerFilter("SemanticModel" + i, this, (EObject) parserElements.get(i)); //$NON-NLS-1$
            }
        } else {
            super.addSemanticListeners();
        }
    }

    /**
     * Removes the semantic listeners.
     * 
     * @generated
     */
    protected void removeSemanticListeners() {
        if (parserElements != null) {
            for (int i = 0; i < parserElements.size(); i++) {
                removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
            }
        } else {
            super.removeSemanticListeners();
        }
    }

    /**
     * Gets the accessible edit part.
     * 
     * @return the accessible edit part
     * @generated
     */
    protected AccessibleEditPart getAccessibleEditPart() {
        if (accessibleEP == null) {
            accessibleEP = new AccessibleGraphicalEditPart() {

                public void getName(AccessibleEvent e) {
                    e.result = getLabelTextHelper(getFigure());
                }
            };
        }
        return accessibleEP;
    }

    /**
     * Gets the font style owner view.
     * 
     * @return the font style owner view
     * @generated
     */
    private View getFontStyleOwnerView() {
        return getPrimaryView();
    }

    /**
     * Handle notification event.
     * 
     * @param event
     *            the event
     * @generated
     */
    protected void handleNotificationEvent(Notification event) {
        Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            Integer c = (Integer) event.getNewValue();
            setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            refreshFont();
        } else {
            if (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
                refreshLabel();
            }
            if (getParser() instanceof ISemanticParser) {
                ISemanticParser modelParser = (ISemanticParser) getParser();
                if (modelParser.areSemanticElementsAffected(null, event)) {
                    removeSemanticListeners();
                    if (resolveSemanticElement() != null) {
                        addSemanticListeners();
                    }
                    refreshLabel();
                }
            }
        }
        super.handleNotificationEvent(event);
    }

    /**
     * Creates the figure.
     * 
     * @return the i figure
     * @generated
     */
    protected IFigure createFigure() {
        IFigure label = createFigurePrim();
        defaultText = getLabelTextHelper(label);
        return label;
    }

    /**
     * Creates the figure prim.
     * 
     * @return the i figure
     * @generated
     */
    protected IFigure createFigurePrim() {
        return new RoleLabelFigure();
    }

    /**
     * The Class RoleLabelFigure.
     * 
     * @generated
     */
    public class RoleLabelFigure extends WrappingLabel {

        /**
         * Instantiates a new role label figure.
         * 
         * @generated
         */
        public RoleLabelFigure() {
            this.setText("<IRole>");
        }

    }

}
