/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.validation;

import de.uka.ipd.sdq.featuremodel.Node;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.featuremodel.Node}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface NodeValidator {
	boolean validate();

	boolean validateChildren(EList<Node> value);
	boolean validateMin(int value);
	boolean validateMax(int value);
	boolean validateName(String value);
}
