/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.fzi.gast.statements.Statement;

import de.uka.ipd.sdq.pcm.seff.LoopAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl#getLinkedLoopAction <em>Linked Loop Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl#getLoopStatement <em>Loop Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopLoggingPositionLinkImpl extends OutputLoggingPositionLinkImpl implements LoopLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedLoopAction() <em>Linked Loop Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedLoopAction()
	 * @generated
	 * @ordered
	 */
	protected LoopAction linkedLoopAction;

	/**
	 * The cached value of the '{@link #getLoopStatement() <em>Loop Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopStatement()
	 * @generated
	 * @ordered
	 */
	protected Statement loopStatement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.LOOP_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction getLinkedLoopAction() {
		if (linkedLoopAction != null && linkedLoopAction.eIsProxy()) {
			InternalEObject oldLinkedLoopAction = (InternalEObject)linkedLoopAction;
			linkedLoopAction = (LoopAction)eResolveProxy(oldLinkedLoopAction);
			if (linkedLoopAction != oldLinkedLoopAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION, oldLinkedLoopAction, linkedLoopAction));
			}
		}
		return linkedLoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction basicGetLinkedLoopAction() {
		return linkedLoopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedLoopAction(LoopAction newLinkedLoopAction) {
		LoopAction oldLinkedLoopAction = linkedLoopAction;
		linkedLoopAction = newLinkedLoopAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION, oldLinkedLoopAction, linkedLoopAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getLoopStatement() {
		if (loopStatement != null && loopStatement.eIsProxy()) {
			InternalEObject oldLoopStatement = (InternalEObject)loopStatement;
			loopStatement = (Statement)eResolveProxy(oldLoopStatement);
			if (loopStatement != oldLoopStatement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT, oldLoopStatement, loopStatement));
			}
		}
		return loopStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement basicGetLoopStatement() {
		return loopStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopStatement(Statement newLoopStatement) {
		Statement oldLoopStatement = loopStatement;
		loopStatement = newLoopStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT, oldLoopStatement, loopStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				if (resolve) return getLinkedLoopAction();
				return basicGetLinkedLoopAction();
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT:
				if (resolve) return getLoopStatement();
				return basicGetLoopStatement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				setLinkedLoopAction((LoopAction)newValue);
				return;
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT:
				setLoopStatement((Statement)newValue);
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
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				setLinkedLoopAction((LoopAction)null);
				return;
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT:
				setLoopStatement((Statement)null);
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
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION:
				return linkedLoopAction != null;
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT:
				return loopStatement != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopLoggingPositionLinkImpl
