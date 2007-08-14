/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.provider;

import de.uka.ipd.sdq.capra.measurement.util.MeasurementAdapterFactory;

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
public class MeasurementItemProviderAdapterFactory extends MeasurementAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public MeasurementItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.TimeProbe} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeProbeItemProvider timeProbeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.TimeProbe}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeProbeAdapter() {
		if (timeProbeItemProvider == null) {
			timeProbeItemProvider = new TimeProbeItemProvider(this);
		}

		return timeProbeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeSpanSensorItemProvider timeSpanSensorItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeSpanSensorAdapter() {
		if (timeSpanSensorItemProvider == null) {
			timeSpanSensorItemProvider = new TimeSpanSensorItemProvider(this);
		}

		return timeSpanSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.Condition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionItemProvider conditionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConditionAdapter() {
		if (conditionItemProvider == null) {
			conditionItemProvider = new ConditionItemProvider(this);
		}

		return conditionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.VisitProbe} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisitProbeItemProvider visitProbeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.VisitProbe}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVisitProbeAdapter() {
		if (visitProbeItemProvider == null) {
			visitProbeItemProvider = new VisitProbeItemProvider(this);
		}

		return visitProbeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.StateSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateSensorItemProvider stateSensorItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.StateSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateSensorAdapter() {
		if (stateSensorItemProvider == null) {
			stateSensorItemProvider = new StateSensorItemProvider(this);
		}

		return stateSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.CountingSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountingSensorItemProvider countingSensorItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.CountingSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCountingSensorAdapter() {
		if (countingSensorItemProvider == null) {
			countingSensorItemProvider = new CountingSensorItemProvider(this);
		}

		return countingSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HistogramRecorderItemProvider histogramRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.HistogramRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHistogramRecorderAdapter() {
		if (histogramRecorderItemProvider == null) {
			histogramRecorderItemProvider = new HistogramRecorderItemProvider(this);
		}

		return histogramRecorderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FullTimeSpanRecorderItemProvider fullTimeSpanRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFullTimeSpanRecorderAdapter() {
		if (fullTimeSpanRecorderItemProvider == null) {
			fullTimeSpanRecorderItemProvider = new FullTimeSpanRecorderItemProvider(this);
		}

		return fullTimeSpanRecorderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SteadyStateRecorderItemProvider steadyStateRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSteadyStateRecorderAdapter() {
		if (steadyStateRecorderItemProvider == null) {
			steadyStateRecorderItemProvider = new SteadyStateRecorderItemProvider(this);
		}

		return steadyStateRecorderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.FullStateRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FullStateRecorderItemProvider fullStateRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.FullStateRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFullStateRecorderAdapter() {
		if (fullStateRecorderItemProvider == null) {
			fullStateRecorderItemProvider = new FullStateRecorderItemProvider(this);
		}

		return fullStateRecorderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.capra.measurement.FinalValueRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalValueRecorderItemProvider finalValueRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.capra.measurement.FinalValueRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFinalValueRecorderAdapter() {
		if (finalValueRecorderItemProvider == null) {
			finalValueRecorderItemProvider = new FinalValueRecorderItemProvider(this);
		}

		return finalValueRecorderItemProvider;
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
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
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
		if (timeProbeItemProvider != null) timeProbeItemProvider.dispose();
		if (timeSpanSensorItemProvider != null) timeSpanSensorItemProvider.dispose();
		if (conditionItemProvider != null) conditionItemProvider.dispose();
		if (visitProbeItemProvider != null) visitProbeItemProvider.dispose();
		if (stateSensorItemProvider != null) stateSensorItemProvider.dispose();
		if (countingSensorItemProvider != null) countingSensorItemProvider.dispose();
		if (histogramRecorderItemProvider != null) histogramRecorderItemProvider.dispose();
		if (fullTimeSpanRecorderItemProvider != null) fullTimeSpanRecorderItemProvider.dispose();
		if (steadyStateRecorderItemProvider != null) steadyStateRecorderItemProvider.dispose();
		if (fullStateRecorderItemProvider != null) fullStateRecorderItemProvider.dispose();
		if (finalValueRecorderItemProvider != null) finalValueRecorderItemProvider.dispose();
	}

}
