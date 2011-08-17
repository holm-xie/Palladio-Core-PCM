/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace.provider;

import de.fzi.se.validation.testbased.trace.util.TraceAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceItemProviderAdapterFactory extends TraceAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.ExecutionTrace} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTraceItemProvider executionTraceItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.ExecutionTrace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionTraceAdapter() {
		if (executionTraceItemProvider == null) {
			executionTraceItemProvider = new ExecutionTraceItemProvider(this);
		}

		return executionTraceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.TraceAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceActionItemProvider traceActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.TraceAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTraceActionAdapter() {
		if (traceActionItemProvider == null) {
			traceActionItemProvider = new TraceActionItemProvider(this);
		}

		return traceActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentParameterAssignmentItemProvider componentParameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentParameterAssignmentAdapter() {
		if (componentParameterAssignmentItemProvider == null) {
			componentParameterAssignmentItemProvider = new ComponentParameterAssignmentItemProvider(this);
		}

		return componentParameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.InternalCall} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalCallItemProvider internalCallItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.InternalCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInternalCallAdapter() {
		if (internalCallItemProvider == null) {
			internalCallItemProvider = new InternalCallItemProvider(this);
		}

		return internalCallItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutgoingBusinessCallItemProvider outgoingBusinessCallItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOutgoingBusinessCallAdapter() {
		if (outgoingBusinessCallItemProvider == null) {
			outgoingBusinessCallItemProvider = new OutgoingBusinessCallItemProvider(this);
		}

		return outgoingBusinessCallItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutgoingInfrastructureCallsItemProvider outgoingInfrastructureCallsItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOutgoingInfrastructureCallsAdapter() {
		if (outgoingInfrastructureCallsItemProvider == null) {
			outgoingInfrastructureCallsItemProvider = new OutgoingInfrastructureCallsItemProvider(this);
		}

		return outgoingInfrastructureCallsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.fzi.se.validation.testbased.trace.OperationCall} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCallItemProvider operationCallItemProvider;

	/**
	 * This creates an adapter for a {@link de.fzi.se.validation.testbased.trace.OperationCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationCallAdapter() {
		if (operationCallItemProvider == null) {
			operationCallItemProvider = new OperationCallItemProvider(this);
		}

		return operationCallItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (executionTraceItemProvider != null) executionTraceItemProvider.dispose();
		if (traceActionItemProvider != null) traceActionItemProvider.dispose();
		if (componentParameterAssignmentItemProvider != null) componentParameterAssignmentItemProvider.dispose();
		if (internalCallItemProvider != null) internalCallItemProvider.dispose();
		if (outgoingBusinessCallItemProvider != null) outgoingBusinessCallItemProvider.dispose();
		if (outgoingInfrastructureCallsItemProvider != null) outgoingInfrastructureCallsItemProvider.dispose();
		if (operationCallItemProvider != null) operationCallItemProvider.dispose();
	}

}
