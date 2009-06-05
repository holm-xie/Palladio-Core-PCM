/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Each ScenarioBehaviour has exactly one Start action which marks the action where the control flows begins. Start actions have no predecessor.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getStart()
 * @model
 * @generated
 */
public interface Start extends AbstractUserAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.predecessor.oclIsUndefined()
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean StartHasNoPredecessor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Start
