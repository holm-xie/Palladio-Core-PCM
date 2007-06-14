/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;

import de.uka.ipd.sdq.stoex.RandomVariable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.LoopIteration#getIterations_LoopIteration <em>Iterations Loop Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getLoopIteration()
 * @model
 * @generated
 */
public interface LoopIteration extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Loopaction Loop Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loopaction Loop Iteration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loopaction Loop Iteration</em>' reference.
	 * @see #setLoopaction_LoopIteration(AbstractLoopAction)
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getLoopIteration_Loopaction_LoopIteration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractLoopAction getLoopaction_LoopIteration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loopaction Loop Iteration</em>' reference.
	 * @see #getLoopaction_LoopIteration()
	 * @generated
	 */
	void setLoopaction_LoopIteration(AbstractLoopAction value);

	/**
	 * Returns the value of the '<em><b>Iterations Loop Iteration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations Loop Iteration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations Loop Iteration</em>' containment reference.
	 * @see #setIterations_LoopIteration(RandomVariable)
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getLoopIteration_Iterations_LoopIteration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RandomVariable getIterations_LoopIteration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.usage.LoopIteration#getIterations_LoopIteration <em>Iterations Loop Iteration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations Loop Iteration</em>' containment reference.
	 * @see #getIterations_LoopIteration()
	 * @generated
	 */
	void setIterations_LoopIteration(RandomVariable value);

} // LoopIteration
