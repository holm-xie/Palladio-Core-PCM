/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import QVTRelation.Relation;

import de.uka.ipd.sdq.featuremodel.Feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getCopyException <em>Copy Exception</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getDisambiguationRule <em>Disambiguation Rule</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getFeatureState <em>Feature State</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature()
 * @model
 * @generated
 */
public interface CompletionFeature extends Feature {
	/**
	 * Returns the value of the '<em><b>Copy Exception</b></em>' containment reference list.
	 * The list contents are of type {@link copyException.Exception}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy Exception</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy Exception</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_CopyException()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<copyException.Exception> getCopyException();

	/**
	 * Returns the value of the '<em><b>Disambiguation Rule</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disambiguation Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disambiguation Rule</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_DisambiguationRule()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DisambiguationRule> getDisambiguationRule();

	/**
	 * Returns the value of the '<em><b>Transformation Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link QVTRelation.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Fragment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Fragment</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_TransformationFragment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relation> getTransformationFragment();

	/**
	 * Returns the value of the '<em><b>Feature State</b></em>' attribute.
	 * The default value is <code>"NOT_SET"</code>.
	 * The literals are from the enumeration {@link edu.kit.ipd.sdq.completionfeaturemodel.FeatureState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature State</em>' attribute.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
	 * @see #setFeatureState(FeatureState)
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_FeatureState()
	 * @model default="NOT_SET" required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FeatureState getFeatureState();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getFeatureState <em>Feature State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature State</em>' attribute.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
	 * @see #getFeatureState()
	 * @generated
	 */
	void setFeatureState(FeatureState value);

} // CompletionFeature
