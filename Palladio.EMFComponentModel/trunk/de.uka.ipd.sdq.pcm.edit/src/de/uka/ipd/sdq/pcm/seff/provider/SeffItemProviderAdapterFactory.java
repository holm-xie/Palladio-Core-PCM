/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.provider;

import de.uka.ipd.sdq.pcm.seff.util.SeffAdapterFactory;

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
public class SeffItemProviderAdapterFactory extends SeffAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	public SeffItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);		
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.StopAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StopActionItemProvider stopActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.StopAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createStopActionAdapter() {
		if (stopActionItemProvider == null) {
			stopActionItemProvider = new StopActionItemProvider(this);
		}

		return stopActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricResourceDemandItemProvider parametricResourceDemandItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createParametricResourceDemandAdapter() {
		if (parametricResourceDemandItemProvider == null) {
			parametricResourceDemandItemProvider = new ParametricResourceDemandItemProvider(this);
		}

		return parametricResourceDemandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.StartAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartActionItemProvider startActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.StartAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createStartActionAdapter() {
		if (startActionItemProvider == null) {
			startActionItemProvider = new StartActionItemProvider(this);
		}

		return startActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandingSEFFItemProvider resourceDemandingSEFFItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createResourceDemandingSEFFAdapter() {
		if (resourceDemandingSEFFItemProvider == null) {
			resourceDemandingSEFFItemProvider = new ResourceDemandingSEFFItemProvider(this);
		}

		return resourceDemandingSEFFItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandingBehaviourItemProvider resourceDemandingBehaviourItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createResourceDemandingBehaviourAdapter() {
		if (resourceDemandingBehaviourItemProvider == null) {
			resourceDemandingBehaviourItemProvider = new ResourceDemandingBehaviourItemProvider(this);
		}

		return resourceDemandingBehaviourItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ReleaseAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseActionItemProvider releaseActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ReleaseAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createReleaseActionAdapter() {
		if (releaseActionItemProvider == null) {
			releaseActionItemProvider = new ReleaseActionItemProvider(this);
		}

		return releaseActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.LoopAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopActionItemProvider loopActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.LoopAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createLoopActionAdapter() {
		if (loopActionItemProvider == null) {
			loopActionItemProvider = new LoopActionItemProvider(this);
		}

		return loopActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.IterationCount} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationCountItemProvider iterationCountItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.IterationCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createIterationCountAdapter() {
		if (iterationCountItemProvider == null) {
			iterationCountItemProvider = new IterationCountItemProvider(this);
		}

		return iterationCountItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.InternalAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalActionItemProvider internalActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.InternalAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createInternalActionAdapter() {
		if (internalActionItemProvider == null) {
			internalActionItemProvider = new InternalActionItemProvider(this);
		}

		return internalActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ForkAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkActionItemProvider forkActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ForkAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createForkActionAdapter() {
		if (forkActionItemProvider == null) {
			forkActionItemProvider = new ForkActionItemProvider(this);
		}

		return forkActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalCallActionItemProvider externalCallActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createExternalCallActionAdapter() {
		if (externalCallActionItemProvider == null) {
			externalCallActionItemProvider = new ExternalCallActionItemProvider(this);
		}

		return externalCallActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbabilisticBranchTransitionItemProvider probabilisticBranchTransitionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createProbabilisticBranchTransitionAdapter() {
		if (probabilisticBranchTransitionItemProvider == null) {
			probabilisticBranchTransitionItemProvider = new ProbabilisticBranchTransitionItemProvider(this);
		}

		return probabilisticBranchTransitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.BranchAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchActionItemProvider branchActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.BranchAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createBranchActionAdapter() {
		if (branchActionItemProvider == null) {
			branchActionItemProvider = new BranchActionItemProvider(this);
		}

		return branchActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.AquireAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AquireActionItemProvider aquireActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.AquireAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAquireActionAdapter() {
		if (aquireActionItemProvider == null) {
			aquireActionItemProvider = new AquireActionItemProvider(this);
		}

		return aquireActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.BranchCondition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchConditionItemProvider branchConditionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.BranchCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createBranchConditionAdapter() {
		if (branchConditionItemProvider == null) {
			branchConditionItemProvider = new BranchConditionItemProvider(this);
		}

		return branchConditionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionIteratorActionItemProvider collectionIteratorActionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createCollectionIteratorActionAdapter() {
		if (collectionIteratorActionItemProvider == null) {
			collectionIteratorActionItemProvider = new CollectionIteratorActionItemProvider(this);
		}

		return collectionIteratorActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardedBranchTransitionItemProvider guardedBranchTransitionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createGuardedBranchTransitionAdapter() {
		if (guardedBranchTransitionItemProvider == null) {
			guardedBranchTransitionItemProvider = new GuardedBranchTransitionItemProvider(this);
		}

		return guardedBranchTransitionItemProvider;
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
		if (stopActionItemProvider != null) stopActionItemProvider.dispose();
		if (parametricResourceDemandItemProvider != null) parametricResourceDemandItemProvider.dispose();
		if (startActionItemProvider != null) startActionItemProvider.dispose();
		if (resourceDemandingSEFFItemProvider != null) resourceDemandingSEFFItemProvider.dispose();
		if (resourceDemandingBehaviourItemProvider != null) resourceDemandingBehaviourItemProvider.dispose();
		if (releaseActionItemProvider != null) releaseActionItemProvider.dispose();
		if (loopActionItemProvider != null) loopActionItemProvider.dispose();
		if (iterationCountItemProvider != null) iterationCountItemProvider.dispose();
		if (internalActionItemProvider != null) internalActionItemProvider.dispose();
		if (forkActionItemProvider != null) forkActionItemProvider.dispose();
		if (externalCallActionItemProvider != null) externalCallActionItemProvider.dispose();
		if (probabilisticBranchTransitionItemProvider != null) probabilisticBranchTransitionItemProvider.dispose();
		if (branchActionItemProvider != null) branchActionItemProvider.dispose();
		if (aquireActionItemProvider != null) aquireActionItemProvider.dispose();
		if (branchConditionItemProvider != null) branchConditionItemProvider.dispose();
		if (collectionIteratorActionItemProvider != null) collectionIteratorActionItemProvider.dispose();
		if (guardedBranchTransitionItemProvider != null) guardedBranchTransitionItemProvider.dispose();
	}

}
