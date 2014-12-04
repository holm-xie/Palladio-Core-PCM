/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ProcessingResourceTypeItemProvider extends ResourceTypeItemProvider {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ProcessingResourceTypeItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addHardwareInducedFailureType__ProcessingResourceTypePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Hardware Induced Failure Type Processing Resource
     * Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addHardwareInducedFailureType__ProcessingResourceTypePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_ProcessingResourceType_hardwareInducedFailureType__ProcessingResourceType_feature"),
                        this.getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_ProcessingResourceType_hardwareInducedFailureType__ProcessingResourceType_feature",
                                "_UI_ProcessingResourceType_type"),
                        ResourcetypePackage.Literals.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE,
                        true, false, true, null, null, null));
    }

    /**
     * This returns ProcessingResourceType.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/ProcessingResourceType"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> FB: Adapted method
     * to produce a more informative label for display in non-PCM editors. In PCM editors, display
     * is not controlled by this method but through a more general mechanism (I'n not sure where
     * it's actually controlled, maybe the
     * de.uka.ipd.sdq.pcmbench.tabs.PropertyLabelProvider.getText() method?) <!-- end-user-doc -->
     *
     * @generated not
     */
    @Override
    public String getText(final Object object) {
        return ((ProcessingResourceType) object).getEntityName() + " [ID: " + ((ProcessingResourceType) object).getId()
                + "]" + " <" + this.getString("_UI_ProcessingResourceType_type") + ">";
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
