/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.provider;

import AnnotationPackage.DefaultAnnotationDataTypes.util.DefaultAnnotationDataTypesAdapterFactory;

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
public class DefaultAnnotationDataTypesItemProviderAdapterFactory extends DefaultAnnotationDataTypesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);		
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanAnnotationItemProvider booleanAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createBooleanAnnotationAdapter() {
		if (booleanAnnotationItemProvider == null) {
			booleanAnnotationItemProvider = new BooleanAnnotationItemProvider(this);
		}

		return booleanAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleAnnotationItemProvider doubleAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDoubleAnnotationAdapter() {
		if (doubleAnnotationItemProvider == null) {
			doubleAnnotationItemProvider = new DoubleAnnotationItemProvider(this);
		}

		return doubleAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerAnnotationItemProvider integerAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createIntegerAnnotationAdapter() {
		if (integerAnnotationItemProvider == null) {
			integerAnnotationItemProvider = new IntegerAnnotationItemProvider(this);
		}

		return integerAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongAnnotationItemProvider longAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createLongAnnotationAdapter() {
		if (longAnnotationItemProvider == null) {
			longAnnotationItemProvider = new LongAnnotationItemProvider(this);
		}

		return longAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.ShortAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShortAnnotationItemProvider shortAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.ShortAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createShortAnnotationAdapter() {
		if (shortAnnotationItemProvider == null) {
			shortAnnotationItemProvider = new ShortAnnotationItemProvider(this);
		}

		return shortAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringAnnotationItemProvider stringAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createStringAnnotationAdapter() {
		if (stringAnnotationItemProvider == null) {
			stringAnnotationItemProvider = new StringAnnotationItemProvider(this);
		}

		return stringAnnotationItemProvider;
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
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
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
		if (booleanAnnotationItemProvider != null) booleanAnnotationItemProvider.dispose();
		if (doubleAnnotationItemProvider != null) doubleAnnotationItemProvider.dispose();
		if (integerAnnotationItemProvider != null) integerAnnotationItemProvider.dispose();
		if (longAnnotationItemProvider != null) longAnnotationItemProvider.dispose();
		if (shortAnnotationItemProvider != null) shortAnnotationItemProvider.dispose();
		if (stringAnnotationItemProvider != null) stringAnnotationItemProvider.dispose();
	}

}
