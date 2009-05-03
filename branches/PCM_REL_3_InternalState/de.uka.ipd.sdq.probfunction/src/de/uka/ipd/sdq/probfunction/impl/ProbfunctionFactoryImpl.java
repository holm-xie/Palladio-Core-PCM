/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.SamplePDF;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProbfunctionFactoryImpl extends EFactoryImpl implements ProbfunctionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProbfunctionFactory init() {
		try {
			ProbfunctionFactory theProbfunctionFactory = (ProbfunctionFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ProbFunction/1.0"); 
			if (theProbfunctionFactory != null) {
				return theProbfunctionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProbfunctionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbfunctionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProbfunctionPackage.BOXED_PDF: return createBoxedPDF();
			case ProbfunctionPackage.CONTINUOUS_SAMPLE: return createContinuousSample();
			case ProbfunctionPackage.PROBABILITY_MASS_FUNCTION: return createProbabilityMassFunction();
			case ProbfunctionPackage.SAMPLE: return createSample();
			case ProbfunctionPackage.SAMPLE_PDF: return createSamplePDF();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxedPDF createBoxedPDF() {
		BoxedPDFImpl boxedPDF = new BoxedPDFImpl();
		return boxedPDF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinuousSample createContinuousSample() {
		ContinuousSampleImpl continuousSample = new ContinuousSampleImpl();
		return continuousSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityMassFunction createProbabilityMassFunction() {
		ProbabilityMassFunctionImpl probabilityMassFunction = new ProbabilityMassFunctionImpl();
		return probabilityMassFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sample createSample() {
		SampleImpl sample = new SampleImpl();
		return sample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SamplePDF createSamplePDF() {
		SamplePDFImpl samplePDF = new SamplePDFImpl();
		return samplePDF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbfunctionPackage getProbfunctionPackage() {
		return (ProbfunctionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProbfunctionPackage getPackage() {
		return ProbfunctionPackage.eINSTANCE;
	}

} //ProbfunctionFactoryImpl