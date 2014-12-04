/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.util.ResourcetypeAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The
 * adapters generated by this factory convert EMF adapter notifications into calls to
 * {@link #fireNotifyChanged fireNotifyChanged}. The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ResourcetypeItemProviderAdapterFactory extends ResourcetypeAdapterFactory implements
        ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
            PalladioComponentModelEditPlugin.INSTANCE, ResourcetypePackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType
     * isFactoryForType}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourcetypeItemProviderAdapterFactory() {
        this.supportedTypes.add(IEditingDomainItemProvider.class);
        this.supportedTypes.add(IStructuredItemContentProvider.class);
        this.supportedTypes.add(ITreeItemContentProvider.class);
        this.supportedTypes.add(IItemLabelProvider.class);
        this.supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceSignatureItemProvider resourceSignatureItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createResourceSignatureAdapter() {
        if (this.resourceSignatureItemProvider == null) {
            this.resourceSignatureItemProvider = new ResourceSignatureItemProvider(this);
        }

        return this.resourceSignatureItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceRepositoryItemProvider resourceRepositoryItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createResourceRepositoryAdapter() {
        if (this.resourceRepositoryItemProvider == null) {
            this.resourceRepositoryItemProvider = new ResourceRepositoryItemProvider(this);
        }

        return this.resourceRepositoryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected SchedulingPolicyItemProvider schedulingPolicyItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSchedulingPolicyAdapter() {
        if (this.schedulingPolicyItemProvider == null) {
            this.schedulingPolicyItemProvider = new SchedulingPolicyItemProvider(this);
        }

        return this.schedulingPolicyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CommunicationLinkResourceTypeItemProvider communicationLinkResourceTypeItemProvider;

    /**
     * This creates an adapter for a
     * {@link de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createCommunicationLinkResourceTypeAdapter() {
        if (this.communicationLinkResourceTypeItemProvider == null) {
            this.communicationLinkResourceTypeItemProvider = new CommunicationLinkResourceTypeItemProvider(this);
        }

        return this.communicationLinkResourceTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceInterfaceItemProvider resourceInterfaceItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createResourceInterfaceAdapter() {
        if (this.resourceInterfaceItemProvider == null) {
            this.resourceInterfaceItemProvider = new ResourceInterfaceItemProvider(this);
        }

        return this.resourceInterfaceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProcessingResourceTypeItemProvider processingResourceTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createProcessingResourceTypeAdapter() {
        if (this.processingResourceTypeItemProvider == null) {
            this.processingResourceTypeItemProvider = new ProcessingResourceTypeItemProvider(this);
        }

        return this.processingResourceTypeItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return this.parentAdapterFactory == null ? this : this.parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParentAdapterFactory(final ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object type) {
        return this.supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(final Notifier notifier, final Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object adapt(final Object object, final Object type) {
        if (this.isFactoryForType(type)) {
            final Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return this.childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<?> getNewChildDescriptors(final Object object, final EditingDomain editingDomain) {
        return this.childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return this.childCreationExtenderManager;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void addListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void removeListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(final Notification notification) {
        this.changeNotifier.fireNotifyChanged(notification);

        if (this.parentAdapterFactory != null) {
            this.parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public void dispose() {
        if (this.resourceSignatureItemProvider != null) {
            this.resourceSignatureItemProvider.dispose();
        }
        if (this.processingResourceTypeItemProvider != null) {
            this.processingResourceTypeItemProvider.dispose();
        }
        if (this.resourceRepositoryItemProvider != null) {
            this.resourceRepositoryItemProvider.dispose();
        }
        if (this.schedulingPolicyItemProvider != null) {
            this.schedulingPolicyItemProvider.dispose();
        }
        if (this.communicationLinkResourceTypeItemProvider != null) {
            this.communicationLinkResourceTypeItemProvider.dispose();
        }
        if (this.resourceInterfaceItemProvider != null) {
            this.resourceInterfaceItemProvider.dispose();
        }
    }

}
