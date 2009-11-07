/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see measurements.MeasurementsFactory
 * @model kind="package"
 * @generated
 */
public interface MeasurementsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "measurements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///measurements.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "measurements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementsPackage eINSTANCE = measurements.impl.MeasurementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link measurements.impl.MachineReferenceImpl <em>Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.MachineReferenceImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getMachineReference()
	 * @generated
	 */
	int MACHINE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.VirtualMachineReferenceImpl <em>Virtual Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.VirtualMachineReferenceImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getVirtualMachineReference()
	 * @generated
	 */
	int VIRTUAL_MACHINE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__ID = MACHINE_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__NAME = MACHINE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Host Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE = MACHINE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE_FEATURE_COUNT = MACHINE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.PlainMachineReferenceImpl <em>Plain Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.PlainMachineReferenceImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getPlainMachineReference()
	 * @generated
	 */
	int PLAIN_MACHINE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE__ID = MACHINE_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE__NAME = MACHINE_REFERENCE__NAME;

	/**
	 * The number of structural features of the '<em>Plain Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE_FEATURE_COUNT = MACHINE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link measurements.impl.TaskSetImpl <em>Task Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.TaskSetImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getTaskSet()
	 * @generated
	 */
	int TASK_SET = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__ROOT_TASK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Probe Spec Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__PROBE_SPEC_REPOSITORY = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Machine References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET__MACHINE_REFERENCES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Task Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SET_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link measurements.impl.AbstractTaskImpl <em>Abstract Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.AbstractTaskImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getAbstractTask()
	 * @generated
	 */
	int ABSTRACT_TASK = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__DESCRIPTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link measurements.impl.SequenceTaskImpl <em>Sequence Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.SequenceTaskImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getSequenceTask()
	 * @generated
	 */
	int SEQUENCE_TASK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK__TASKS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.ParallelTaskImpl <em>Parallel Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.ParallelTaskImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getParallelTask()
	 * @generated
	 */
	int PARALLEL_TASK = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK__TASKS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parallel Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.MeasurementScriptImpl <em>Measurement Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.MeasurementScriptImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getMeasurementScript()
	 * @generated
	 */
	int MEASUREMENT_SCRIPT = 7;

	/**
	 * The feature id for the '<em><b>Task Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT__TASK_SETS = 0;

	/**
	 * The feature id for the '<em><b>Machine Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Measurement Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link measurements.impl.MachineDescriptionImpl <em>Machine Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.MachineDescriptionImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getMachineDescription()
	 * @generated
	 */
	int MACHINE_DESCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__IP = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Machine Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__MACHINE_MAPPINGS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Machine Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link measurements.impl.MachineMappingImpl <em>Machine Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.MachineMappingImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getMachineMapping()
	 * @generated
	 */
	int MACHINE_MAPPING = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Machine Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING__MACHINE_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.MachineTaskImpl <em>Machine Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.MachineTaskImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getMachineTask()
	 * @generated
	 */
	int MACHINE_TASK = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK__MACHINE = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link measurements.impl.LoopTaskImpl <em>Loop Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see measurements.impl.LoopTaskImpl
	 * @see measurements.impl.MeasurementsPackageImpl#getLoopTask()
	 * @generated
	 */
	int LOOP_TASK = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__ID = ABSTRACT_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK__TASK = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link measurements.VirtualMachineReference <em>Virtual Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine Reference</em>'.
	 * @see measurements.VirtualMachineReference
	 * @generated
	 */
	EClass getVirtualMachineReference();

	/**
	 * Returns the meta object for the reference '{@link measurements.VirtualMachineReference#getHostMachine <em>Host Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host Machine</em>'.
	 * @see measurements.VirtualMachineReference#getHostMachine()
	 * @see #getVirtualMachineReference()
	 * @generated
	 */
	EReference getVirtualMachineReference_HostMachine();

	/**
	 * Returns the meta object for class '{@link measurements.MachineReference <em>Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Reference</em>'.
	 * @see measurements.MachineReference
	 * @generated
	 */
	EClass getMachineReference();

	/**
	 * Returns the meta object for the attribute '{@link measurements.MachineReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see measurements.MachineReference#getName()
	 * @see #getMachineReference()
	 * @generated
	 */
	EAttribute getMachineReference_Name();

	/**
	 * Returns the meta object for class '{@link measurements.PlainMachineReference <em>Plain Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plain Machine Reference</em>'.
	 * @see measurements.PlainMachineReference
	 * @generated
	 */
	EClass getPlainMachineReference();

	/**
	 * Returns the meta object for class '{@link measurements.TaskSet <em>Task Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Set</em>'.
	 * @see measurements.TaskSet
	 * @generated
	 */
	EClass getTaskSet();

	/**
	 * Returns the meta object for the attribute '{@link measurements.TaskSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see measurements.TaskSet#getName()
	 * @see #getTaskSet()
	 * @generated
	 */
	EAttribute getTaskSet_Name();

	/**
	 * Returns the meta object for the containment reference '{@link measurements.TaskSet#getRootTask <em>Root Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Task</em>'.
	 * @see measurements.TaskSet#getRootTask()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_RootTask();

	/**
	 * Returns the meta object for the containment reference '{@link measurements.TaskSet#getProbeSpecRepository <em>Probe Spec Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Probe Spec Repository</em>'.
	 * @see measurements.TaskSet#getProbeSpecRepository()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_ProbeSpecRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link measurements.TaskSet#getMachineReferences <em>Machine References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine References</em>'.
	 * @see measurements.TaskSet#getMachineReferences()
	 * @see #getTaskSet()
	 * @generated
	 */
	EReference getTaskSet_MachineReferences();

	/**
	 * Returns the meta object for class '{@link measurements.AbstractTask <em>Abstract Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Task</em>'.
	 * @see measurements.AbstractTask
	 * @generated
	 */
	EClass getAbstractTask();

	/**
	 * Returns the meta object for the attribute '{@link measurements.AbstractTask#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see measurements.AbstractTask#getDescription()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Description();

	/**
	 * Returns the meta object for the attribute '{@link measurements.AbstractTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see measurements.AbstractTask#getName()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Name();

	/**
	 * Returns the meta object for class '{@link measurements.SequenceTask <em>Sequence Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Task</em>'.
	 * @see measurements.SequenceTask
	 * @generated
	 */
	EClass getSequenceTask();

	/**
	 * Returns the meta object for the containment reference list '{@link measurements.SequenceTask#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see measurements.SequenceTask#getTasks()
	 * @see #getSequenceTask()
	 * @generated
	 */
	EReference getSequenceTask_Tasks();

	/**
	 * Returns the meta object for class '{@link measurements.ParallelTask <em>Parallel Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Task</em>'.
	 * @see measurements.ParallelTask
	 * @generated
	 */
	EClass getParallelTask();

	/**
	 * Returns the meta object for the containment reference list '{@link measurements.ParallelTask#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see measurements.ParallelTask#getTasks()
	 * @see #getParallelTask()
	 * @generated
	 */
	EReference getParallelTask_Tasks();

	/**
	 * Returns the meta object for class '{@link measurements.MeasurementScript <em>Measurement Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Script</em>'.
	 * @see measurements.MeasurementScript
	 * @generated
	 */
	EClass getMeasurementScript();

	/**
	 * Returns the meta object for the reference list '{@link measurements.MeasurementScript#getTaskSets <em>Task Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Task Sets</em>'.
	 * @see measurements.MeasurementScript#getTaskSets()
	 * @see #getMeasurementScript()
	 * @generated
	 */
	EReference getMeasurementScript_TaskSets();

	/**
	 * Returns the meta object for the containment reference list '{@link measurements.MeasurementScript#getMachineDescriptions <em>Machine Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Descriptions</em>'.
	 * @see measurements.MeasurementScript#getMachineDescriptions()
	 * @see #getMeasurementScript()
	 * @generated
	 */
	EReference getMeasurementScript_MachineDescriptions();

	/**
	 * Returns the meta object for class '{@link measurements.MachineDescription <em>Machine Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Description</em>'.
	 * @see measurements.MachineDescription
	 * @generated
	 */
	EClass getMachineDescription();

	/**
	 * Returns the meta object for the attribute '{@link measurements.MachineDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see measurements.MachineDescription#getName()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EAttribute getMachineDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link measurements.MachineDescription#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see measurements.MachineDescription#getIp()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EAttribute getMachineDescription_Ip();

	/**
	 * Returns the meta object for the containment reference list '{@link measurements.MachineDescription#getMachineMappings <em>Machine Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Mappings</em>'.
	 * @see measurements.MachineDescription#getMachineMappings()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EReference getMachineDescription_MachineMappings();

	/**
	 * Returns the meta object for class '{@link measurements.MachineMapping <em>Machine Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Mapping</em>'.
	 * @see measurements.MachineMapping
	 * @generated
	 */
	EClass getMachineMapping();

	/**
	 * Returns the meta object for the reference '{@link measurements.MachineMapping#getMachineReference <em>Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine Reference</em>'.
	 * @see measurements.MachineMapping#getMachineReference()
	 * @see #getMachineMapping()
	 * @generated
	 */
	EReference getMachineMapping_MachineReference();

	/**
	 * Returns the meta object for class '{@link measurements.MachineTask <em>Machine Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Task</em>'.
	 * @see measurements.MachineTask
	 * @generated
	 */
	EClass getMachineTask();

	/**
	 * Returns the meta object for the reference '{@link measurements.MachineTask#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see measurements.MachineTask#getMachine()
	 * @see #getMachineTask()
	 * @generated
	 */
	EReference getMachineTask_Machine();

	/**
	 * Returns the meta object for class '{@link measurements.LoopTask <em>Loop Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Task</em>'.
	 * @see measurements.LoopTask
	 * @generated
	 */
	EClass getLoopTask();

	/**
	 * Returns the meta object for the containment reference '{@link measurements.LoopTask#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task</em>'.
	 * @see measurements.LoopTask#getTask()
	 * @see #getLoopTask()
	 * @generated
	 */
	EReference getLoopTask_Task();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeasurementsFactory getMeasurementsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link measurements.impl.VirtualMachineReferenceImpl <em>Virtual Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.VirtualMachineReferenceImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getVirtualMachineReference()
		 * @generated
		 */
		EClass VIRTUAL_MACHINE_REFERENCE = eINSTANCE.getVirtualMachineReference();

		/**
		 * The meta object literal for the '<em><b>Host Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE = eINSTANCE.getVirtualMachineReference_HostMachine();

		/**
		 * The meta object literal for the '{@link measurements.impl.MachineReferenceImpl <em>Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.MachineReferenceImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getMachineReference()
		 * @generated
		 */
		EClass MACHINE_REFERENCE = eINSTANCE.getMachineReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_REFERENCE__NAME = eINSTANCE.getMachineReference_Name();

		/**
		 * The meta object literal for the '{@link measurements.impl.PlainMachineReferenceImpl <em>Plain Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.PlainMachineReferenceImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getPlainMachineReference()
		 * @generated
		 */
		EClass PLAIN_MACHINE_REFERENCE = eINSTANCE.getPlainMachineReference();

		/**
		 * The meta object literal for the '{@link measurements.impl.TaskSetImpl <em>Task Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.TaskSetImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getTaskSet()
		 * @generated
		 */
		EClass TASK_SET = eINSTANCE.getTaskSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SET__NAME = eINSTANCE.getTaskSet_Name();

		/**
		 * The meta object literal for the '<em><b>Root Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__ROOT_TASK = eINSTANCE.getTaskSet_RootTask();

		/**
		 * The meta object literal for the '<em><b>Probe Spec Repository</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__PROBE_SPEC_REPOSITORY = eINSTANCE.getTaskSet_ProbeSpecRepository();

		/**
		 * The meta object literal for the '<em><b>Machine References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SET__MACHINE_REFERENCES = eINSTANCE.getTaskSet_MachineReferences();

		/**
		 * The meta object literal for the '{@link measurements.impl.AbstractTaskImpl <em>Abstract Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.AbstractTaskImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getAbstractTask()
		 * @generated
		 */
		EClass ABSTRACT_TASK = eINSTANCE.getAbstractTask();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__DESCRIPTION = eINSTANCE.getAbstractTask_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__NAME = eINSTANCE.getAbstractTask_Name();

		/**
		 * The meta object literal for the '{@link measurements.impl.SequenceTaskImpl <em>Sequence Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.SequenceTaskImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getSequenceTask()
		 * @generated
		 */
		EClass SEQUENCE_TASK = eINSTANCE.getSequenceTask();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_TASK__TASKS = eINSTANCE.getSequenceTask_Tasks();

		/**
		 * The meta object literal for the '{@link measurements.impl.ParallelTaskImpl <em>Parallel Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.ParallelTaskImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getParallelTask()
		 * @generated
		 */
		EClass PARALLEL_TASK = eINSTANCE.getParallelTask();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL_TASK__TASKS = eINSTANCE.getParallelTask_Tasks();

		/**
		 * The meta object literal for the '{@link measurements.impl.MeasurementScriptImpl <em>Measurement Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.MeasurementScriptImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getMeasurementScript()
		 * @generated
		 */
		EClass MEASUREMENT_SCRIPT = eINSTANCE.getMeasurementScript();

		/**
		 * The meta object literal for the '<em><b>Task Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_SCRIPT__TASK_SETS = eINSTANCE.getMeasurementScript_TaskSets();

		/**
		 * The meta object literal for the '<em><b>Machine Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS = eINSTANCE.getMeasurementScript_MachineDescriptions();

		/**
		 * The meta object literal for the '{@link measurements.impl.MachineDescriptionImpl <em>Machine Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.MachineDescriptionImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getMachineDescription()
		 * @generated
		 */
		EClass MACHINE_DESCRIPTION = eINSTANCE.getMachineDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_DESCRIPTION__NAME = eINSTANCE.getMachineDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_DESCRIPTION__IP = eINSTANCE.getMachineDescription_Ip();

		/**
		 * The meta object literal for the '<em><b>Machine Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_DESCRIPTION__MACHINE_MAPPINGS = eINSTANCE.getMachineDescription_MachineMappings();

		/**
		 * The meta object literal for the '{@link measurements.impl.MachineMappingImpl <em>Machine Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.MachineMappingImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getMachineMapping()
		 * @generated
		 */
		EClass MACHINE_MAPPING = eINSTANCE.getMachineMapping();

		/**
		 * The meta object literal for the '<em><b>Machine Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_MAPPING__MACHINE_REFERENCE = eINSTANCE.getMachineMapping_MachineReference();

		/**
		 * The meta object literal for the '{@link measurements.impl.MachineTaskImpl <em>Machine Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.MachineTaskImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getMachineTask()
		 * @generated
		 */
		EClass MACHINE_TASK = eINSTANCE.getMachineTask();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_TASK__MACHINE = eINSTANCE.getMachineTask_Machine();

		/**
		 * The meta object literal for the '{@link measurements.impl.LoopTaskImpl <em>Loop Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see measurements.impl.LoopTaskImpl
		 * @see measurements.impl.MeasurementsPackageImpl#getLoopTask()
		 * @generated
		 */
		EClass LOOP_TASK = eINSTANCE.getLoopTask();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_TASK__TASK = eINSTANCE.getLoopTask_Task();

	}

} //MeasurementsPackage
