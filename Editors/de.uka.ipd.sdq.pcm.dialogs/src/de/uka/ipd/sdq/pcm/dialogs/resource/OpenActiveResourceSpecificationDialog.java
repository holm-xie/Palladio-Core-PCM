package de.uka.ipd.sdq.pcm.dialogs.resource;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;

public class OpenActiveResourceSpecificationDialog extends OpenEditPolicy {

    @Override
    protected Command getOpenCommand(Request request) {
        ProcessingResourceSpecification specification = (ProcessingResourceSpecification) (((View) ((IGraphicalEditPart) getHost())
                .getModel()).getElement());
        ResourceSet set = (specification.getResourceContainer_ProcessingResourceSpecification()).eResource()
                .getResourceSet();
        EObject resourceType = null;
        ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
        // Set types to show and their super types
        filterList.add(ProcessingResourceType.class);
        filterList.add(ResourceRepository.class);
        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        // set EReference that should be set (in this case: active resource type)
        additionalReferences.add(ResourceenvironmentPackage.eINSTANCE
                .getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification());
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, set);
        dialog.setProvidedService(ProcessingResourceType.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return null;
        }

        if (!(dialog.getResult() instanceof ProcessingResourceType)) {
            return null;
        }
        resourceType = (ProcessingResourceType) dialog.getResult();

        ICommand icmd = new SetValueCommand(new SetRequest(specification,
                ResourceenvironmentPackage.eINSTANCE
                        .getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification(),
                resourceType));
        return new ICommandProxy(icmd);
    }

}
