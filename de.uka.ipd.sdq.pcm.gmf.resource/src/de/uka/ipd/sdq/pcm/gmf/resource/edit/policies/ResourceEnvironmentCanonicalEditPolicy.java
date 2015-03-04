/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainer2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelLinkDescriptor;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * @generated
 */
public class ResourceEnvironmentCanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    private Set<EStructuralFeature> myFeaturesToSynchronize;

    /**
     * @generated
     */
    protected void refreshOnActivate() {
        // Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
        List<?> c = getHost().getChildren();
        for (int i = 0; i < c.size(); i++) {
            ((EditPart) c.get(i)).activate();
        }
        super.refreshOnActivate();
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        LinkedList<EObject> result = new LinkedList<EObject>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getResourceEnvironment_1000SemanticChildren(viewObject);
        for (PalladioComponentModelNodeDescriptor d : childDescriptors) {
            result.add(d.getModelElement());
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
        return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
    }

    /**
     * @generated
     */
    private boolean isMyDiagramElement(View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        return visualID == ResourceContainerEditPart.VISUAL_ID || visualID == LinkingResourceEditPart.VISUAL_ID;
    }

    /**
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet<EStructuralFeature>();
            myFeaturesToSynchronize.add(ResourceenvironmentPackage.eINSTANCE
                    .getResourceEnvironment_ResourceContainer_ResourceEnvironment());
            myFeaturesToSynchronize.add(ResourceenvironmentPackage.eINSTANCE
                    .getResourceEnvironment_LinkingResources__ResourceEnvironment());
        }
        return myFeaturesToSynchronize;
    }

    /**
     * @generated
     */
    protected void refreshSemantic() {
        if (resolveSemanticElement() == null) {
            return;
        }
        LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
        List<PalladioComponentModelNodeDescriptor> childDescriptors = PalladioComponentModelDiagramUpdater
                .getResourceEnvironment_1000SemanticChildren((View) getHost().getModel());
        LinkedList<View> orphaned = new LinkedList<View>();
        // we care to check only views we recognize as ours
        LinkedList<View> knownViewChildren = new LinkedList<View>();
        for (View v : getViewChildren()) {
            if (isMyDiagramElement(v)) {
                knownViewChildren.add(v);
            }
        }
        // alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
        //
        // iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
        // iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
        // to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
        for (Iterator<PalladioComponentModelNodeDescriptor> descriptorsIterator = childDescriptors.iterator(); descriptorsIterator
                .hasNext();) {
            PalladioComponentModelNodeDescriptor next = descriptorsIterator.next();
            String hint = PalladioComponentModelVisualIDRegistry.getType(next.getVisualID());
            LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
            for (View childView : getViewChildren()) {
                EObject semanticElement = childView.getElement();
                if (next.getModelElement().equals(semanticElement)) {
                    if (hint.equals(childView.getType())) {
                        perfectMatch.add(childView);
                        // actually, can stop iteration over view children here, but
                        // may want to use not the first view but last one as a 'real' match (the way original CEP does
                        // with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
                    }
                }
            }
            if (perfectMatch.size() > 0) {
                descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
                // use only one view (first or last?), keep rest as orphaned for further consideration
                knownViewChildren.remove(perfectMatch.getFirst());
            }
        }
        // those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
        // or those we have potential matches to, and thus need to be recreated, preserving size/location information.
        orphaned.addAll(knownViewChildren);
        //
        ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
                childDescriptors.size());
        for (PalladioComponentModelNodeDescriptor next : childDescriptors) {
            String hint = PalladioComponentModelVisualIDRegistry.getType(next.getVisualID());
            IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
            CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter,
                    Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
            viewDescriptors.add(descriptor);
        }

        boolean changed = deleteViews(orphaned.iterator());
        //
        CreateViewRequest request = getCreateViewRequest(viewDescriptors);
        Command cmd = getCreateViewCommand(request);
        if (cmd != null && cmd.canExecute()) {
            SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
            executeCommand(cmd);
            @SuppressWarnings("unchecked")
            List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
            createdViews.addAll(nl);
        }
        if (changed || createdViews.size() > 0) {
            postProcessRefreshSemantic(createdViews);
        }

        Collection<IAdaptable> createdConnectionViews = refreshConnections();

        if (createdViews.size() > 1) {
            // perform a layout of the container
            DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
            executeCommand(new ICommandProxy(layoutCmd));
        }

        createdViews.addAll(createdConnectionViews);

        makeViewsImmutable(createdViews);
    }

    /**
     * @generated
     */
    private Diagram getDiagram() {
        return ((View) getHost().getModel()).getDiagram();
    }

    /**
     * @generated
     */
    private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
        return getEditPart(descriptor.getSource(), domain2NotationMap);
    }

    /**
     * @generated
     */
    private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
        return getEditPart(descriptor.getDestination(), domain2NotationMap);
    }

    /**
     * @generated
     */
    protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap,
            int hintVisualId) {
        View view = (View) domain2NotationMap.getHinted(domainModelElement,
                PalladioComponentModelVisualIDRegistry.getType(hintVisualId));
        if (view != null) {
            return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
        }
        return null;
    }

    /**
     * @generated
     */
    @SuppressWarnings("serial")
    protected static class Domain2Notation extends HashMap<EObject, View> {
        /**
         * @generated
         */
        public boolean containsDomainElement(EObject domainElement) {
            return this.containsKey(domainElement);
        }

        /**
         * @generated
         */
        public View getHinted(EObject domainEObject, String hint) {
            return this.get(domainEObject);
        }

        /**
         * @generated
         */
        public void putView(EObject domainElement, View view) {
            if (!containsKey(view.getElement())) {
                this.put(domainElement, view);
            }
        }

    }

    /**
     * @generated
     */
    private Collection<IAdaptable> refreshConnections() {
        Domain2Notation domain2NotationMap = new Domain2Notation();
        Collection<PalladioComponentModelLinkDescriptor> linkDescriptors = collectAllLinks(getDiagram(),
                domain2NotationMap);
        Collection existingLinks = new LinkedList(getDiagram().getEdges());
        for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
            Edge nextDiagramLink = (Edge) linksIterator.next();
            int diagramLinkVisualID = PalladioComponentModelVisualIDRegistry.getVisualID(nextDiagramLink);
            if (diagramLinkVisualID == -1) {
                if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
                    linksIterator.remove();
                }
                continue;
            }
            EObject diagramLinkObject = nextDiagramLink.getElement();
            EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
            EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
            for (Iterator<PalladioComponentModelLinkDescriptor> linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
                    .hasNext();) {
                PalladioComponentModelLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator.next();
                if (diagramLinkObject == nextLinkDescriptor.getModelElement()
                        && diagramLinkSrc == nextLinkDescriptor.getSource()
                        && diagramLinkDst == nextLinkDescriptor.getDestination()
                        && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
                    linksIterator.remove();
                    linkDescriptorsIterator.remove();
                    break;
                }
            }
        }
        deleteViews(existingLinks.iterator());
        return createConnections(linkDescriptors, domain2NotationMap);
    }

    /**
     * @generated
     */
    private Collection<PalladioComponentModelLinkDescriptor> collectAllLinks(View view,
            Domain2Notation domain2NotationMap) {
        if (!ResourceEnvironmentEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view))) {
            return Collections.emptyList();
        }
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceEnvironmentEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getResourceEnvironment_1000ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceContainerEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getResourceContainer_2004ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case LinkingResourceEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getLinkingResource_2005ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ProcessingResourceSpecificationEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getProcessingResourceSpecification_3003ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case ResourceContainer2EditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater.getResourceContainer_3005ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID: {
            if (!domain2NotationMap.containsKey(view.getElement())) {
                result.addAll(PalladioComponentModelDiagramUpdater
                        .getCommunicationLinkResourceSpecification_3004ContainedLinks(view));
            }
            domain2NotationMap.putView(view.getElement(), view);
            break;
        }
        }
        for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
            result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
        }
        for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
            result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<IAdaptable> createConnections(Collection<PalladioComponentModelLinkDescriptor> linkDescriptors,
            Domain2Notation domain2NotationMap) {
        LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
        for (PalladioComponentModelLinkDescriptor nextLinkDescriptor : linkDescriptors) {
            EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
            EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
            if (sourceEditPart == null || targetEditPart == null) {
                continue;
            }
            CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
                    nextLinkDescriptor.getSemanticAdapter(),
                    PalladioComponentModelVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND,
                    false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
            CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
            ccr.setType(RequestConstants.REQ_CONNECTION_START);
            ccr.setSourceEditPart(sourceEditPart);
            sourceEditPart.getCommand(ccr);
            ccr.setTargetEditPart(targetEditPart);
            ccr.setType(RequestConstants.REQ_CONNECTION_END);
            Command cmd = targetEditPart.getCommand(ccr);
            if (cmd != null && cmd.canExecute()) {
                executeCommand(cmd);
                IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
                if (viewAdapter != null) {
                    adapters.add(viewAdapter);
                }
            }
        }
        return adapters;
    }

    /**
     * @generated
     */
    private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
        View view = (View) domain2NotationMap.get(domainModelElement);
        if (view != null) {
            return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
        }
        return null;
    }

}