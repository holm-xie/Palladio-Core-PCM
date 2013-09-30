/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.entity.util.EntityValidator;
import de.uka.ipd.sdq.pcm.repository.*;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage
 * @generated
 */
public class RepositoryValidator extends EObjectValidator {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final RepositoryValidator INSTANCE = new RepositoryValidator();

    /**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
    public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.repository";

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Seff Type Used Twice' of 'Basic Component'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int BASIC_COMPONENT__NO_SEFF_TYPE_USED_TWICE = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Required
     * Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
     * Interfaces Have To Conform To Complete Type' of 'Implementation Component Type'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
     * Interface Have To Conform To Component Type' of 'Implementation Component Type'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE = 4;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provide Same Or More Interfaces As Complete Component Type' of 'Implementation Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE = 5;

				/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Require Same Or Fewer Interfaces As Complete Component Type' of 'Implementation Component Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPLEMENTATION_COMPONENT_TYPE__REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE = 6;

				/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Protocol Type ID Used Twice' of 'Interface'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE = 7;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parameter Names Have To Be Unique For ASignature' of 'Operation Signature'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final int OPERATION_SIGNATURE__PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE = 8;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Signatures Have To Be Unique For An Interface' of 'Operation Interface'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    public static final int OPERATION_INTERFACE__SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE = 9;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided Or Required By AUsefull Complete Component Type' of 'Complete Component Type'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int COMPLETE_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_OR_REQUIRED_BY_AUSEFULL_COMPLETE_COMPONENT_TYPE = 10;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Provided
     * Interfaces Have To Conform To Provided Type2' of 'Complete Component Type'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int COMPLETE_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_PROVIDED_TYPE2 = 11;

    /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'At Least One Interface Has To Be Provided By AUsefull Provides Component Type' of 'Provides Component Type'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final int PROVIDES_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_BY_AUSEFULL_PROVIDES_COMPONENT_TYPE = 12;

    /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 12;

    /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected IdentifierValidator identifierValidator;

    /**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected CompositionValidator compositionValidator;

    /**
	 * The cached base package validator.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected EntityValidator entityValidator;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public RepositoryValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
		compositionValidator = CompositionValidator.INSTANCE;
		entityValidator = EntityValidator.INSTANCE;
	}

    /**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EPackage getEPackage() {
	  return RepositoryPackage.eINSTANCE;
	}

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case RepositoryPackage.PASSIVE_RESOURCE:
				return validatePassiveResource((PassiveResource)value, diagnostics, context);
			case RepositoryPackage.BASIC_COMPONENT:
				return validateBasicComponent((BasicComponent)value, diagnostics, context);
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE:
				return validateImplementationComponentType((ImplementationComponentType)value, diagnostics, context);
			case RepositoryPackage.REPOSITORY_COMPONENT:
				return validateRepositoryComponent((RepositoryComponent)value, diagnostics, context);
			case RepositoryPackage.PROVIDED_ROLE:
				return validateProvidedRole((ProvidedRole)value, diagnostics, context);
			case RepositoryPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case RepositoryPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case RepositoryPackage.REPOSITORY:
				return validateRepository((Repository)value, diagnostics, context);
			case RepositoryPackage.INTERFACE:
				return validateInterface((Interface)value, diagnostics, context);
			case RepositoryPackage.REQUIRED_CHARACTERISATION:
				return validateRequiredCharacterisation((RequiredCharacterisation)value, diagnostics, context);
			case RepositoryPackage.EVENT_GROUP:
				return validateEventGroup((EventGroup)value, diagnostics, context);
			case RepositoryPackage.EVENT_TYPE:
				return validateEventType((EventType)value, diagnostics, context);
			case RepositoryPackage.SIGNATURE:
				return validateSignature((Signature)value, diagnostics, context);
			case RepositoryPackage.EXCEPTION_TYPE:
				return validateExceptionType((ExceptionType)value, diagnostics, context);
			case RepositoryPackage.INFRASTRUCTURE_SIGNATURE:
				return validateInfrastructureSignature((InfrastructureSignature)value, diagnostics, context);
			case RepositoryPackage.INFRASTRUCTURE_INTERFACE:
				return validateInfrastructureInterface((InfrastructureInterface)value, diagnostics, context);
			case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE:
				return validateInfrastructureRequiredRole((InfrastructureRequiredRole)value, diagnostics, context);
			case RepositoryPackage.REQUIRED_ROLE:
				return validateRequiredRole((RequiredRole)value, diagnostics, context);
			case RepositoryPackage.OPERATION_SIGNATURE:
				return validateOperationSignature((OperationSignature)value, diagnostics, context);
			case RepositoryPackage.OPERATION_INTERFACE:
				return validateOperationInterface((OperationInterface)value, diagnostics, context);
			case RepositoryPackage.OPERATION_REQUIRED_ROLE:
				return validateOperationRequiredRole((OperationRequiredRole)value, diagnostics, context);
			case RepositoryPackage.SOURCE_ROLE:
				return validateSourceRole((SourceRole)value, diagnostics, context);
			case RepositoryPackage.SINK_ROLE:
				return validateSinkRole((SinkRole)value, diagnostics, context);
			case RepositoryPackage.OPERATION_PROVIDED_ROLE:
				return validateOperationProvidedRole((OperationProvidedRole)value, diagnostics, context);
			case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE:
				return validateInfrastructureProvidedRole((InfrastructureProvidedRole)value, diagnostics, context);
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE:
				return validateCompleteComponentType((CompleteComponentType)value, diagnostics, context);
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE:
				return validateProvidesComponentType((ProvidesComponentType)value, diagnostics, context);
			case RepositoryPackage.COMPOSITE_COMPONENT:
				return validateCompositeComponent((CompositeComponent)value, diagnostics, context);
			case RepositoryPackage.PRIMITIVE_DATA_TYPE:
				return validatePrimitiveDataType((PrimitiveDataType)value, diagnostics, context);
			case RepositoryPackage.COLLECTION_DATA_TYPE:
				return validateCollectionDataType((CollectionDataType)value, diagnostics, context);
			case RepositoryPackage.COMPOSITE_DATA_TYPE:
				return validateCompositeDataType((CompositeDataType)value, diagnostics, context);
			case RepositoryPackage.INNER_DECLARATION:
				return validateInnerDeclaration((InnerDeclaration)value, diagnostics, context);
			case RepositoryPackage.ROLE:
				return validateRole((Role)value, diagnostics, context);
			case RepositoryPackage.PARAMETER_MODIFIER:
				return validateParameterModifier((ParameterModifier)value, diagnostics, context);
			case RepositoryPackage.COMPONENT_TYPE:
				return validateComponentType((ComponentType)value, diagnostics, context);
			case RepositoryPackage.PRIMITIVE_TYPE_ENUM:
				return validatePrimitiveTypeEnum((PrimitiveTypeEnum)value, diagnostics, context);
			default:
				return true;
		}
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validatePassiveResource(PassiveResource passiveResource, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(passiveResource, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(passiveResource, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(passiveResource, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateBasicComponent(BasicComponent basicComponent, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(basicComponent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(basicComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateBasicComponent_NoSeffTypeUsedTwice(basicComponent, diagnostics, context);
		return result;
	}

    /**
     * Validates the NoSeffTypeUsedTwice constraint of '<em>Basic Component</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateBasicComponent_NoSeffTypeUsedTwice(BasicComponent basicComponent,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		return basicComponent.NoSeffTypeUsedTwice(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateImplementationComponentType(ImplementationComponentType implementationComponentType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(implementationComponentType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(implementationComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(implementationComponentType, diagnostics, context);
		return result;
	}

    /**
	 * Validates the RequiredInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(
            ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return implementationComponentType.RequiredInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

    /**
	 * Validates the providedInterfacesHaveToConformToCompleteType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(
            ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return implementationComponentType.providedInterfacesHaveToConformToCompleteType(diagnostics, context);
	}

    /**
	 * Validates the ProvidedInterfaceHaveToConformToComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(
            ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return implementationComponentType.ProvidedInterfaceHaveToConformToComponentType(diagnostics, context);
	}

    /**
	 * Validates the ProvideSameOrMoreInterfacesAsCompleteComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return implementationComponentType.ProvideSameOrMoreInterfacesAsCompleteComponentType(diagnostics, context);
	}

				/**
	 * Validates the RequireSameOrFewerInterfacesAsCompleteComponentType constraint of '<em>Implementation Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(ImplementationComponentType implementationComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return implementationComponentType.RequireSameOrFewerInterfacesAsCompleteComponentType(diagnostics, context);
	}

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRepositoryComponent(RepositoryComponent repositoryComponent, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(repositoryComponent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(repositoryComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(repositoryComponent, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredRole(RequiredRole requiredRole, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(requiredRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(requiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(requiredRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(role, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(role, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(role, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInterface(Interface interface_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(interface_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(interface_, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_NoProtocolTypeIDUsedTwice(interface_, diagnostics, context);
		return result;
	}

    /**
     * Validates the NoProtocolTypeIDUsedTwice constraint of '<em>Interface</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateInterface_NoProtocolTypeIDUsedTwice(Interface interface_, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return interface_.NoProtocolTypeIDUsedTwice(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRepository(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(repository, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(repository, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(repository, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataType, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateRequiredCharacterisation(RequiredCharacterisation requiredCharacterisation,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requiredCharacterisation, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateComponentType(ComponentType componentType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return true;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationSignature(OperationSignature operationSignature, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationSignature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(operationSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationSignature_ParameterNamesHaveToBeUniqueForASignature(operationSignature, diagnostics, context);
		return result;
	}

    /**
	 * Validates the ParameterNamesHaveToBeUniqueForASignature constraint of '<em>Operation Signature</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationSignature_ParameterNamesHaveToBeUniqueForASignature(
            OperationSignature operationSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationSignature.ParameterNamesHaveToBeUniqueForASignature(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(signature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(signature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(signature, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateExceptionType(ExceptionType exceptionType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exceptionType, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationInterface(OperationInterface operationInterface, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_NoProtocolTypeIDUsedTwice(operationInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationInterface_SignaturesHaveToBeUniqueForAnInterface(operationInterface, diagnostics, context);
		return result;
	}

    /**
	 * Validates the SignaturesHaveToBeUniqueForAnInterface constraint of '<em>Operation Interface</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationInterface_SignaturesHaveToBeUniqueForAnInterface(
            OperationInterface operationInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return operationInterface.SignaturesHaveToBeUniqueForAnInterface(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInfrastructureSignature(InfrastructureSignature infrastructureSignature,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureSignature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureSignature, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureSignature, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInfrastructureRequiredRole(InfrastructureRequiredRole infrastructureRequiredRole,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureRequiredRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureRequiredRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateEventType(EventType eventType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(eventType, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateEventGroup(EventGroup eventGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(eventGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(eventGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_NoProtocolTypeIDUsedTwice(eventGroup, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateCompleteComponentType(CompleteComponentType completeComponentType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(completeComponentType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(completeComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(completeComponentType, diagnostics, context);
		return result;
	}

    /**
     * Validates the AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType
     * constraint of '<em>Complete Component Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public boolean validateCompleteComponentType_AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(
            CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return completeComponentType.AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(diagnostics, context);
	}

    /**
	 * Validates the providedInterfacesHaveToConformToProvidedType2 constraint of '<em>Complete Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateCompleteComponentType_providedInterfacesHaveToConformToProvidedType2(
            CompleteComponentType completeComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return completeComponentType.providedInterfacesHaveToConformToProvidedType2(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidesComponentType(ProvidesComponentType providesComponentType,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(providesComponentType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providesComponentType, diagnostics, context);
		if (result || diagnostics != null) result &= validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(providesComponentType, diagnostics, context);
		return result;
	}

    /**
	 * Validates the AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType constraint of '<em>Provides Component Type</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidesComponentType_AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(
            ProvidesComponentType providesComponentType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return providesComponentType.AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationRequiredRole(OperationRequiredRole operationRequiredRole,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationRequiredRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationRequiredRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(operationRequiredRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateSourceRole(SourceRole sourceRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sourceRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(sourceRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInfrastructureProvidedRole(InfrastructureProvidedRole infrastructureProvidedRole,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureProvidedRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureProvidedRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateOperationProvidedRole(OperationProvidedRole operationProvidedRole,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationProvidedRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationProvidedRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(operationProvidedRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateCompositeComponent(CompositeComponent compositeComponent, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compositeComponent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= compositionValidator.validateComposedStructure_MultipleConnectorsConstraint(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= compositionValidator.validateComposedStructure_MultipleConnectorsConstraintForAssemblyConnectors(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= entityValidator.validateComposedProvidingRequiringEntity_ProvidedRolesMustBeBound(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequiredInterfacesHaveToConformToCompleteType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_providedInterfacesHaveToConformToCompleteType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvidedInterfaceHaveToConformToComponentType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_ProvideSameOrMoreInterfacesAsCompleteComponentType(compositeComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateImplementationComponentType_RequireSameOrFewerInterfacesAsCompleteComponentType(compositeComponent, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateSinkRole(SinkRole sinkRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sinkRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sinkRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(sinkRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validatePrimitiveDataType(PrimitiveDataType primitiveDataType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveDataType, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateCollectionDataType(CollectionDataType collectionDataType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionDataType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionDataType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(collectionDataType, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateCompositeDataType(CompositeDataType compositeDataType, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compositeDataType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeDataType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(compositeDataType, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInnerDeclaration(InnerDeclaration innerDeclaration, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(innerDeclaration, diagnostics, context);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateInfrastructureInterface(InfrastructureInterface infrastructureInterface,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(infrastructureInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(infrastructureInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterface_NoProtocolTypeIDUsedTwice(infrastructureInterface, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateProvidedRole(ProvidedRole providedRole, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		if (!validate_NoCircularContainment(providedRole, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(providedRole, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_idHasToBeUnique(providedRole, diagnostics, context);
		return result;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validateParameterModifier(ParameterModifier parameterModifier, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return true;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean validatePrimitiveTypeEnum(PrimitiveTypeEnum primitiveTypeEnum, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
		return true;
	}

    /**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // RepositoryValidator
