/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Flow Level Source Code Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink#getControlflow <em>Controlflow</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getControlFlowLevelSourceCodeLink()
 * @model
 * @generated
 */
public interface ControlFlowLevelSourceCodeLink extends MethodLevelSourceCodeLink {
	/**
	 * Returns the value of the '<em><b>Controlflow</b></em>' reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.ControlFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflow</em>' reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getControlFlowLevelSourceCodeLink_Controlflow()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ControlFlow> getControlflow();

} // ControlFlowLevelSourceCodeLink