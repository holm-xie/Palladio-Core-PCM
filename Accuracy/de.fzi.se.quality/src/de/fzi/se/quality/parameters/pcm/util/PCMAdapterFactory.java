/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.util;

import de.fzi.se.quality.parameters.BusinessOperationReference;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.InfrastructureOperationReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;

import de.fzi.se.quality.parameters.pcm.*;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage
 * @generated
 */
public class PCMAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PCMPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PCMPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMSwitch<Adapter> modelSwitch =
		new PCMSwitch<Adapter>() {
			@Override
			public Adapter casePCMParameterReference(PCMParameterReference object) {
				return createPCMParameterReferenceAdapter();
			}
			@Override
			public Adapter casePCMParameterValue(PCMParameterValue object) {
				return createPCMParameterValueAdapter();
			}
			@Override
			public Adapter casePCMInfrastructureOperationReference(PCMInfrastructureOperationReference object) {
				return createPCMInfrastructureOperationReferenceAdapter();
			}
			@Override
			public Adapter casePCMBusinessOperationReference(PCMBusinessOperationReference object) {
				return createPCMBusinessOperationReferenceAdapter();
			}
			@Override
			public Adapter casePCMComponentReference(PCMComponentReference object) {
				return createPCMComponentReferenceAdapter();
			}
			@Override
			public Adapter casePCMComponentParameterReference(PCMComponentParameterReference object) {
				return createPCMComponentParameterReferenceAdapter();
			}
			@Override
			public Adapter casePCMOperationParameterReference(PCMOperationParameterReference object) {
				return createPCMOperationParameterReferenceAdapter();
			}
			@Override
			public Adapter casePCMRequiredBusinessOperationReturnParameterReference(PCMRequiredBusinessOperationReturnParameterReference object) {
				return createPCMRequiredBusinessOperationReturnParameterReferenceAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseParameterReference(ParameterReference object) {
				return createParameterReferenceAdapter();
			}
			@Override
			public Adapter caseParameterValue(ParameterValue object) {
				return createParameterValueAdapter();
			}
			@Override
			public Adapter caseOperationReference(OperationReference object) {
				return createOperationReferenceAdapter();
			}
			@Override
			public Adapter caseComponentReference(ComponentReference object) {
				return createComponentReferenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterReference
	 * @generated
	 */
	public Adapter createPCMParameterReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterValue
	 * @generated
	 */
	public Adapter createPCMParameterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference <em>Infrastructure Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference
	 * @generated
	 */
	public Adapter createPCMInfrastructureOperationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference <em>Business Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference
	 * @generated
	 */
	public Adapter createPCMBusinessOperationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentReference
	 * @generated
	 */
	public Adapter createPCMComponentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference <em>Component Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference
	 * @generated
	 */
	public Adapter createPCMComponentParameterReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference <em>Operation Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference
	 * @generated
	 */
	public Adapter createPCMOperationParameterReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference <em>Required Business Operation Return Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference
	 * @generated
	 */
	public Adapter createPCMRequiredBusinessOperationReturnParameterReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.ParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.ParameterReference
	 * @generated
	 */
	public Adapter createParameterReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.ParameterValue
	 * @generated
	 */
	public Adapter createParameterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.OperationReference <em>Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.OperationReference
	 * @generated
	 */
	public Adapter createOperationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.parameters.ComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.parameters.ComponentReference
	 * @generated
	 */
	public Adapter createComponentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PCMAdapterFactory
