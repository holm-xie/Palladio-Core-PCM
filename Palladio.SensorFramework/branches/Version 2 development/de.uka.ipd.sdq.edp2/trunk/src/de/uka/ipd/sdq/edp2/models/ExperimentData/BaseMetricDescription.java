/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.unit.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getCaptureType <em>Capture Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getDataType <em>Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getScale <em>Scale</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getMonotonic <em>Monotonic</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getDefaultUnit <em>Default Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription()
 * @model
 * @generated
 */
public interface BaseMetricDescription extends MetricDescription {
	/**
	 * Returns the value of the '<em><b>Capture Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capture Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capture Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType
	 * @see #setCaptureType(CaptureType)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription_CaptureType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CaptureType getCaptureType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getCaptureType <em>Capture Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capture Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType
	 * @see #getCaptureType()
	 * @generated
	 */
	void setCaptureType(CaptureType value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DataType
	 * @see #setDataType(DataType)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DataType
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.ExperimentData.Scale}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Scale
	 * @see #setScale(Scale)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription_Scale()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Scale getScale();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Scale
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Scale value);

	/**
	 * Returns the value of the '<em><b>Monotonic</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monotonic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monotonic</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic
	 * @see #setMonotonic(Monotonic)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription_Monotonic()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Monotonic getMonotonic();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getMonotonic <em>Monotonic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monotonic</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic
	 * @see #getMonotonic()
	 * @generated
	 */
	void setMonotonic(Monotonic value);

	/**
	 * Returns the value of the '<em><b>Default Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no unit for NominalMeasurements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Unit</em>' attribute.
	 * @see #setDefaultUnit(Unit)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getBaseMetricDescription_DefaultUnit()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSUnit" ordered="false"
	 * @generated
	 */
	Unit getDefaultUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription#getDefaultUnit <em>Default Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Unit</em>' attribute.
	 * @see #getDefaultUnit()
	 * @generated
	 */
	void setDefaultUnit(Unit value);

} // BaseMetricDescription