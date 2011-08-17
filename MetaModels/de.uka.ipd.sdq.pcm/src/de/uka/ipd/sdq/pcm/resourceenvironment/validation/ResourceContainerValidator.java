/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.validation;

import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ResourceContainerValidator {
	boolean validate();

	boolean validateActiveResourceSpecifications_ResourceContainer(EList<ProcessingResourceSpecification> value);
	boolean validatePassiveResourceSpecifications_ResourceContainer(EList<PassiveResourceSpecification> value);
}