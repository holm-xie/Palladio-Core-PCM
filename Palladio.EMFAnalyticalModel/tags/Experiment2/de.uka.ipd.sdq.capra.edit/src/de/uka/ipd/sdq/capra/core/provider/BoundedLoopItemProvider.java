/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.provider;


import de.uka.ipd.sdq.capra.core.BoundedLoop;
import de.uka.ipd.sdq.capra.core.CoreFactory;
import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.provider.CapraEditPlugin;

import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.capra.core.BoundedLoop} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BoundedLoopItemProvider
	extends OperatorItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundedLoopItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS);
			childrenFeatures.add(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS);
			childrenFeatures.add(CorePackage.Literals.BOUNDED_LOOP__NUMBER_OF_ITERATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns BoundedLoop.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BoundedLoop"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_BoundedLoop_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(BoundedLoop.class)) {
			case CorePackage.BOUNDED_LOOP__REPEATED_PROCESS:
			case CorePackage.BOUNDED_LOOP__TARGET_PROCESS:
			case CorePackage.BOUNDED_LOOP__NUMBER_OF_ITERATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createSuccessfulTermination()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createProbabilisticPrefix()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createBoundedLoop()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createParallelComposition()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createRenaming()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS,
				 CoreFactory.eINSTANCE.createProcessVariableUsage()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createSuccessfulTermination()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createProbabilisticPrefix()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createBoundedLoop()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createParallelComposition()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createRenaming()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS,
				 CoreFactory.eINSTANCE.createProcessVariableUsage()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.BOUNDED_LOOP__NUMBER_OF_ITERATIONS,
				 ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CorePackage.Literals.BOUNDED_LOOP__REPEATED_PROCESS ||
			childFeature == CorePackage.Literals.BOUNDED_LOOP__TARGET_PROCESS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CapraEditPlugin.INSTANCE;
	}

}
