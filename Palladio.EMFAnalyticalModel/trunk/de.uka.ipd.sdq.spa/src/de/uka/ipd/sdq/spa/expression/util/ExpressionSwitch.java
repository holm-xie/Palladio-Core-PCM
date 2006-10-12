/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.util;

import de.uka.ipd.sdq.spa.expression.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage
 * @generated
 */
public class ExpressionSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionPackage.TERMINAL: {
				Terminal terminal = (Terminal)theEObject;
				Object result = caseTerminal(terminal);
				if (result == null) result = caseRegularExpression(terminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.REGULAR_EXPRESSION: {
				RegularExpression regularExpression = (RegularExpression)theEObject;
				Object result = caseRegularExpression(regularExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.SYMBOL: {
				Symbol symbol = (Symbol)theEObject;
				Object result = caseSymbol(symbol);
				if (result == null) result = caseTerminal(symbol);
				if (result == null) result = caseRegularExpression(symbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.SLEEP: {
				Sleep sleep = (Sleep)theEObject;
				Object result = caseSleep(sleep);
				if (result == null) result = caseTerminal(sleep);
				if (result == null) result = caseRegularExpression(sleep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				Object result = caseSequence(sequence);
				if (result == null) result = caseOperation(sequence);
				if (result == null) result = caseRegularExpression(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				Object result = caseOperation(operation);
				if (result == null) result = caseRegularExpression(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.RELEASE: {
				Release release = (Release)theEObject;
				Object result = caseRelease(release);
				if (result == null) result = caseTerminal(release);
				if (result == null) result = caseRegularExpression(release);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.PARALLEL: {
				Parallel parallel = (Parallel)theEObject;
				Object result = caseParallel(parallel);
				if (result == null) result = caseOperation(parallel);
				if (result == null) result = caseRegularExpression(parallel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.OPTION: {
				Option option = (Option)theEObject;
				Object result = caseOption(option);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				Object result = caseLoop(loop);
				if (result == null) result = caseOperation(loop);
				if (result == null) result = caseRegularExpression(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ALTERNATIVE: {
				Alternative alternative = (Alternative)theEObject;
				Object result = caseAlternative(alternative);
				if (result == null) result = caseOperation(alternative);
				if (result == null) result = caseRegularExpression(alternative);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ACQUIRE: {
				Acquire acquire = (Acquire)theEObject;
				Object result = caseAcquire(acquire);
				if (result == null) result = caseTerminal(acquire);
				if (result == null) result = caseRegularExpression(acquire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTerminal(Terminal object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Regular Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Regular Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegularExpression(RegularExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSymbol(Symbol object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sleep</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sleep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSleep(Sleep object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parallel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parallel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParallel(Parallel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOption(Option object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Alternative</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Alternative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAlternative(Alternative object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Acquire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Acquire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAcquire(Acquire object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ExpressionSwitch
