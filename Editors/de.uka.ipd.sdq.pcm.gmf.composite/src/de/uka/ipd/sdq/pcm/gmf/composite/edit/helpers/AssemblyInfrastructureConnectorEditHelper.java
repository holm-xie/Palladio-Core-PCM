/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * @generated
 */
public class AssemblyInfrastructureConnectorEditHelper extends
		PalladioComponentModelBaseEditHelper {
	/**
	 * Get the configuration command for an AssemblyConnector.
	 * 
	 * This is modified manually to create the assumed name for the new connector.
	 * 
	 * @generated not
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		AssemblyInfrastructureConnector con = (AssemblyInfrastructureConnector) req
				.getElementToConfigure();
		String name = "InfrastructureConnector ";
		name += con
				.getRequiringAssemblyContext__AssemblyInfrastructureConnector() == null ? ""
				: con
						.getRequiringAssemblyContext__AssemblyInfrastructureConnector()
						.getEntityName();
		name += " -> ";
		name += con
				.getProvidingAssemblyContext__AssemblyInfrastructureConnector() == null ? ""
				: con
						.getProvidingAssemblyContext__AssemblyInfrastructureConnector()
						.getEntityName();

		ICommand cmd2 = new SetValueCommand(new SetRequest(req
				.getElementToConfigure(), EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), name));
		return cmd2;
	}
}
