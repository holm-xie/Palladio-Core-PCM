/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.validation;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyContext}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AssemblyContextValidator {
	boolean validate();

	boolean validateEncapsulatedComponent_ChildComponentContext(ProvidesComponentType value);
	boolean validateParentStructure_AssemblyContext(ComposedStructure value);
	boolean validateComponentParameterUsage_AssemblyContext(EList<VariableUsage> value);
}
