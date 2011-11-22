/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_reliability;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.Qos_reliabilityPackage
 * @generated
 */
public interface Qos_reliabilityFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Qos_reliabilityFactory eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl.Qos_reliabilityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Specified Reliability Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specified Reliability Annotation</em>'.
	 * @generated
	 */
	SpecifiedReliabilityAnnotation createSpecifiedReliabilityAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Qos_reliabilityPackage getQos_reliabilityPackage();

} //Qos_reliabilityFactory