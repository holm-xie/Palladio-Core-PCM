/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class ScenarioBehaviourScenarioBehaviourStepsCompartment3CanonicalEditPolicy.
 *
 * @generated
 */
public class ScenarioBehaviourScenarioBehaviourStepsCompartment3CanonicalEditPolicy extends CanonicalEditPolicy {

    /** The my features to synchronize. @generated */
    Set myFeaturesToSynchronize;

    /**
     * Gets the semantic children list.
     *
     * @return the semantic children list
     * @generated
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        List result = new LinkedList();
        for (Iterator it = PalladioComponentModelDiagramUpdater
                .getScenarioBehaviourScenarioBehaviourStepsCompartment_7008SemanticChildren(viewObject).iterator(); it
                .hasNext();) {
            result.add(((PalladioComponentModelNodeDescriptor) it.next()).getModelElement());
        }
        return result;
    }

    /**
     * Checks if is orphaned.
     *
     * @param semanticChildren the semantic children
     * @param view the view
     * @return true, if is orphaned
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case StartEditPart.VISUAL_ID:
        case StopEditPart.VISUAL_ID:
        case EntryLevelSystemCallEditPart.VISUAL_ID:
        case LoopEditPart.VISUAL_ID:
        case BranchEditPart.VISUAL_ID:
        case DelayEditPart.VISUAL_ID:
            if (!semanticChildren.contains(view.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the default factory hint.
     *
     * @return the default factory hint
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

    /**
     * Gets the features to synchronize.
     *
     * @return the features to synchronize
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet();
            myFeaturesToSynchronize.add(UsagemodelPackage.eINSTANCE.getScenarioBehaviour_Actions_ScenarioBehaviour());
        }
        return myFeaturesToSynchronize;
    }

}
