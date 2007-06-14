/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation.impl;

import de.uka.ipd.sdq.context.actual_allocation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AllocationFactoryImpl extends EFactoryImpl implements AllocationFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AllocationFactory init() {
		try {
			AllocationFactory theAllocationFactory = (AllocationFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Context/Allocation/1.0"); 
			if (theAllocationFactory != null) {
				return theAllocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AllocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AllocationPackage.ACTUAL_ALLOCATION_CONTEXT: return createActualAllocationContext();
			case AllocationPackage.ACTUAL_RESOURCE_DEMAND: return createActualResourceDemand();
			case AllocationPackage.ACTUAL_ALLOCATION: return createActualAllocation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualAllocationContext createActualAllocationContext() {
		ActualAllocationContextImpl actualAllocationContext = new ActualAllocationContextImpl();
		return actualAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualResourceDemand createActualResourceDemand() {
		ActualResourceDemandImpl actualResourceDemand = new ActualResourceDemandImpl();
		return actualResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualAllocation createActualAllocation() {
		ActualAllocationImpl actualAllocation = new ActualAllocationImpl();
		return actualAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationPackage getAllocationPackage() {
		return (AllocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AllocationPackage getPackage() {
		return AllocationPackage.eINSTANCE;
	}

} //AllocationFactoryImpl
