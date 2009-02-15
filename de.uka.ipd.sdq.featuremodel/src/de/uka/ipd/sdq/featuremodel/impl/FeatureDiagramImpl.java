/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.featuremodel.Constraint;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.Node;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl#getRootFeature <em>Root Feature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureDiagramImpl extends NamedElementImpl implements FeatureDiagram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany";
	/**
	 * The cached value of the '{@link #getRootFeature() <em>Root Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFeature()
	 * @generated
	 * @ordered
	 */
	protected Node rootFeature;
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.FEATURE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getRootFeature() {
		return rootFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootFeature(Node newRootFeature, NotificationChain msgs) {
		Node oldRootFeature = rootFeature;
		rootFeature = newRootFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE, oldRootFeature, newRootFeature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootFeature(Node newRootFeature) {
		if (newRootFeature != rootFeature) {
			NotificationChain msgs = null;
			if (rootFeature != null)
				msgs = ((InternalEObject)rootFeature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE, null, msgs);
			if (newRootFeature != null)
				msgs = ((InternalEObject)newRootFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE, null, msgs);
			msgs = basicSetRootFeature(newRootFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE, newRootFeature, newRootFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE:
				return basicSetRootFeature(null, msgs);
			case featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE:
				return getRootFeature();
			case featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS:
				return getConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE:
				setRootFeature((Node)newValue);
				return;
			case featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE:
				setRootFeature((Node)null);
				return;
			case featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS:
				getConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE:
				return rootFeature != null;
			case featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FeatureDiagramImpl