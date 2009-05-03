/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Width Aggregated Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getIntervals <em>Intervals</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getAggregationOn <em>Aggregation On</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregatedMeasurements()
 * @model
 * @generated
 */
public interface FixedWidthAggregatedMeasurements extends AggregatedMeasurements {
	/**
	 * Returns the value of the '<em><b>Intervals</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intervals</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intervals</em>' containment reference.
	 * @see #setIntervals(FixedIntervals)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregatedMeasurements_Intervals()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" containment="true" required="true" ordered="false"
	 * @generated
	 */
	FixedIntervals getIntervals();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getIntervals <em>Intervals</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intervals</em>' containment reference.
	 * @see #getIntervals()
	 * @generated
	 */
	void setIntervals(FixedIntervals value);

	/**
	 * Returns the value of the '<em><b>Aggregation On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation On</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation On</em>' reference.
	 * @see #setAggregationOn(BaseMetricDescription)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregatedMeasurements_AggregationOn()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BaseMetricDescription getAggregationOn();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements#getAggregationOn <em>Aggregation On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation On</em>' reference.
	 * @see #getAggregationOn()
	 * @generated
	 */
	void setAggregationOn(BaseMetricDescription value);

	/**
	 * Returns the value of the '<em><b>Data Series</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getAggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Series</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Series</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getFixedWidthAggregatedMeasurements_DataSeries()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries#getAggregatedMeasurements
	 * @model opposite="aggregatedMeasurements" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<DataSeries> getDataSeries();

} // FixedWidthAggregatedMeasurements