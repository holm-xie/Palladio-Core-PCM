/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage.validation;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.stoex.RandomVariable;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.context.usage.LoopIteration}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface LoopIterationValidator {
	boolean validate();

	boolean validateLoopaction_LoopIteration(AbstractLoopAction value);
	boolean validateIterations_LoopIteration(RandomVariable value);
}
