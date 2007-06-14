/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation.validation;

import de.uka.ipd.sdq.context.usage.UsageContext;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ActualAllocationContextValidator {
	boolean validate();

	boolean validateActualResourceDemands_ActualAllocationContext(EList value);
	boolean validateUsageContext_ActualAllocationContext(UsageContext value);
}
