/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.pcm.core.composition.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionFactoryImpl extends EFactoryImpl implements CompositionFactory {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CompositionFactory init() {
        try {
            CompositionFactory theCompositionFactory = (CompositionFactory) EPackage.Registry.INSTANCE
                    .getEFactory(CompositionPackage.eNS_URI);
            if (theCompositionFactory != null) {
                return theCompositionFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CompositionFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositionFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR:
            return (EObject) createResourceRequiredDelegationConnector();
        case CompositionPackage.EVENT_CHANNEL:
            return (EObject) createEventChannel();
        case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR:
            return (EObject) createEventChannelSourceConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR:
            return (EObject) createEventChannelSinkConnector();
        case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR:
            return (EObject) createProvidedDelegationConnector();
        case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR:
            return (EObject) createRequiredDelegationConnector();
        case CompositionPackage.ASSEMBLY_CONNECTOR:
            return (EObject) createAssemblyConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR:
            return (EObject) createAssemblyEventConnector();
        case CompositionPackage.SOURCE_DELEGATION_CONNECTOR:
            return (EObject) createSourceDelegationConnector();
        case CompositionPackage.SINK_DELEGATION_CONNECTOR:
            return (EObject) createSinkDelegationConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return (EObject) createAssemblyInfrastructureConnector();
        case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return (EObject) createProvidedInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR:
            return (EObject) createRequiredInfrastructureDelegationConnector();
        case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR:
            return (EObject) createRequiredResourceDelegationConnector();
        case CompositionPackage.ASSEMBLY_CONTEXT:
            return (EObject) createAssemblyContext();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceRequiredDelegationConnector createResourceRequiredDelegationConnector() {
        ResourceRequiredDelegationConnectorImpl resourceRequiredDelegationConnector = new ResourceRequiredDelegationConnectorImpl();
        return resourceRequiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannel createEventChannel() {
        EventChannelImpl eventChannel = new EventChannelImpl();
        return eventChannel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannelSourceConnector createEventChannelSourceConnector() {
        EventChannelSourceConnectorImpl eventChannelSourceConnector = new EventChannelSourceConnectorImpl();
        return eventChannelSourceConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventChannelSinkConnector createEventChannelSinkConnector() {
        EventChannelSinkConnectorImpl eventChannelSinkConnector = new EventChannelSinkConnectorImpl();
        return eventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProvidedDelegationConnector createProvidedDelegationConnector() {
        ProvidedDelegationConnectorImpl providedDelegationConnector = new ProvidedDelegationConnectorImpl();
        return providedDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RequiredDelegationConnector createRequiredDelegationConnector() {
        RequiredDelegationConnectorImpl requiredDelegationConnector = new RequiredDelegationConnectorImpl();
        return requiredDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyConnector createAssemblyConnector() {
        AssemblyConnectorImpl assemblyConnector = new AssemblyConnectorImpl();
        return assemblyConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyEventConnector createAssemblyEventConnector() {
        AssemblyEventConnectorImpl assemblyEventConnector = new AssemblyEventConnectorImpl();
        return assemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceDelegationConnector createSourceDelegationConnector() {
        SourceDelegationConnectorImpl sourceDelegationConnector = new SourceDelegationConnectorImpl();
        return sourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SinkDelegationConnector createSinkDelegationConnector() {
        SinkDelegationConnectorImpl sinkDelegationConnector = new SinkDelegationConnectorImpl();
        return sinkDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyInfrastructureConnector createAssemblyInfrastructureConnector() {
        AssemblyInfrastructureConnectorImpl assemblyInfrastructureConnector = new AssemblyInfrastructureConnectorImpl();
        return assemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProvidedInfrastructureDelegationConnector createProvidedInfrastructureDelegationConnector() {
        ProvidedInfrastructureDelegationConnectorImpl providedInfrastructureDelegationConnector = new ProvidedInfrastructureDelegationConnectorImpl();
        return providedInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RequiredInfrastructureDelegationConnector createRequiredInfrastructureDelegationConnector() {
        RequiredInfrastructureDelegationConnectorImpl requiredInfrastructureDelegationConnector = new RequiredInfrastructureDelegationConnectorImpl();
        return requiredInfrastructureDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RequiredResourceDelegationConnector createRequiredResourceDelegationConnector() {
        RequiredResourceDelegationConnectorImpl requiredResourceDelegationConnector = new RequiredResourceDelegationConnectorImpl();
        return requiredResourceDelegationConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext createAssemblyContext() {
        AssemblyContextImpl assemblyContext = new AssemblyContextImpl();
        return assemblyContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositionPackage getCompositionPackage() {
        return (CompositionPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CompositionPackage getPackage() {
        return CompositionPackage.eINSTANCE;
    }

} //CompositionFactoryImpl