/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.resources;

import scheduler.SchedulerLibrary;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.ProcessConfiguration;
import scheduler.configuration.SchedulerConfiguration;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * @author Snowball
 * 
 */
public class ScheduledResource extends AbstractScheduledResource {

	private static final String PATHMAP_TO_SCHEDULER_LIBRARY = "pathmap://PCM_MODELS/Library.scheduler";
	private static long resourceId = 1;
	private String processingRate = "0";

	private double totalDemandedTime;

	public ScheduledResource(
			SimuComModel myModel,
			String typeID,
			String resourceContainerID,
			String resourceTypeID,
			String description,
			String processingRate,
			Double mttf,
			Double mttr,
			String schedulingStrategyID,
			int numberOfCores,
			boolean requiredByContainer) {
		super(myModel, typeID, resourceContainerID, resourceTypeID,
				description, schedulingStrategyID, numberOfCores,
				requiredByContainer);
		this.processingRate = processingRate;

		// Reliability Stuff.
		this.mttf = mttf;
		this.mttr = mttr;
		this.canBeUnavailable = (myModel.getConfiguration().getSimulateFailures()
				&& (this.mttf > 0.0) && (this.mttr > 0.0));

		// used to let resource fail and be repaired again:
		if (this.canBeUnavailable) {
			createAvailabilityEvents(myModel);
		}
	}

	@Override
	protected IActiveResource createActiveResource(SimuComModel myModel) {
		logger.debug("Creating scheduled resource with strategy "
				+ this.schedulingStrategyID + " and "
				+ this.numberOfInstances + " replicas!");
		IActiveResource aResource = getScheduledResource(myModel,
				schedulingStrategyID, this.numberOfInstances,
				"Utilisation of " + this.getName() + " " + this.description);
		return aResource;
	}
	
	/* Loads scheduler configuration */
	private IActiveResource getResource(String schedulerLibFileName,
			String schedulerName, int numReplicas, String sensorDescription) {

		SchedulerLibrary lib = (SchedulerLibrary) SchedulerTools
				.loadFromXMI(schedulerLibFileName);
		SchedulerConfiguration selectedConf = null;
		for (SchedulerConfiguration conf : lib.getSchedulerConfiguration()) {
			if (conf.getName().equals(schedulerName)) {
				selectedConf = conf;
				break;
			}
		}
		if (selectedConf != null) {
			resourceConf = ConfigurationFactory.eINSTANCE
					.createActiveResourceConfiguration();
			resourceConf.setName(schedulerName);
			resourceConf.setReplicas(numReplicas);
			resourceConf.setSchedulerConfiguration(selectedConf);
			IActiveResource resource = getModel().getSchedulingFactory()
					.createActiveResource(resourceConf);
			return resource;
		}
		return null;
	}
	
	private IActiveResource getScheduledResource(SimuComModel simuComModel, String schedulingStrategyID,
			int numberOfCores, String sensorDescription) {
		IActiveResource scheduledResource = null;
		// active resources scheduled by standard scheduling techniques
		if (schedulingStrategyID.equals(SchedulingStrategy.FCFS)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimFCFSResource(SchedulingStrategy.FCFS,
							getNextResourceId());
		} else if (schedulingStrategyID.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimProcessorSharingResource(
							SchedulingStrategy.PROCESSOR_SHARING,
							getNextResourceId(), numberOfCores);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.DELAY)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimDelayResource(
							SchedulingStrategy.DELAY,
							getNextResourceId());
		} else if (schedulingStrategyID.equals(SchedulingStrategy.LINUX_2_6_O1)) {
		// active resources scheduled by improved scheduler
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY,
					"Linux 2.6.22", numberOfCores, sensorDescription);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.LINUX_2_6_CFS)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimProcessorSharingResource(
							SchedulingStrategy.LINUX_2_6_CFS,
							getNextResourceId(), numberOfCores);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_7) || schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_VISTA) || schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_SERVER_2003)) {
			// Windows 7, Windows Vista and Windows Server 2003 share the same
			// scheduler
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY,
					"Windows 2003", numberOfCores, sensorDescription);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_XP)) {
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY,
					"Windows XP", numberOfCores, sensorDescription);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.SPECIAL_WINDOWS)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimProcessorSharingResourceWindows(
							SchedulingStrategy.SPECIAL_WINDOWS.toString(),
							getNextResourceId(), numberOfCores);
		} else if (schedulingStrategyID.equals(SchedulingStrategy.SPECIAL_LINUXO1)) {
			scheduledResource = getModel().getSchedulingFactory()
					.createSimProcessorSharingResourceLinuxO1(
							SchedulingStrategy.SPECIAL_LINUXO1.toString(),
							getNextResourceId(), numberOfCores);
		} else {
            scheduledResource = getModel().getSchedulingFactory().createResourceFromExtension(
            		schedulingStrategyID,
                    getNextResourceId());
			//scheduledResource = ISchedulingFactory.eINSTANCE
			//		.createSimGinpexDiskResource(
			//				SchedulingStrategy.GINPEX_DISK.toString(),
			//				getNextResourceId(), getModel().getConfig().getHddParameterConfig());
		}
		
		if (scheduledResource instanceof SimuComExtensionResource) {
			// The resource takes additional configuration that is available in the SimuComModel object
			// As the scheduler project is currently SimuCom-agnostic, we use the SimuComExtensionResource class
			// to initialize the resource wit a SimuCom-related object.
			((SimuComExtensionResource)scheduledResource).initialize(simuComModel);
		}

		return scheduledResource;
	}

	private void registerProcessWindows(ISchedulableProcess process,
			IActiveResource resource) {
		if (resourceConf != null) {
			ProcessConfiguration processConf = ConfigurationFactory.eINSTANCE
					.createProcessConfiguration();
			processConf.setName(process.getId());
			processConf.setPriority(PriorityClass.DEFAULT);
			processConf.setReplicas(1);
			ProcessWithPriority p = (ProcessWithPriority) getModel().getSchedulingFactory()
					.createRunningProcess(process, processConf, resourceConf);

			resource.registerProcess(p);
		}
	}

	@Override
	protected double calculateDemand(double demand) {
		return demand
				/ (Double) Context.evaluateStatic(processingRate, Double.class);
	}

	@Override
	public void activateResource() {
		aResource.start();
		super.activateResource();
	}

	@Override
	public void consumeResource(SimuComSimProcess process, int resourceServiceID, double abstractDemand) {
		// Check first if the resource is currently available.
		// This works for the standard resource types (CPU, HDD, DELAY).
		assertAvailability();

		registerProcessWindows(process, aResource);
		double concreteDemand = calculateDemand(abstractDemand);
		fireDemand(concreteDemand);
		this.totalDemandedTime += concreteDemand;
		aResource.process(process, resourceServiceID, concreteDemand);
	}
	
	@Override
	public double getRemainingDemandForProcess(SimuComSimProcess thread) {
		return aResource.getRemainingDemand(thread);
	}
	
	@Override
	public void updateDemand(SimuComSimProcess thread, double demand) {
		aResource.updateDemand(thread, demand);
	}

	@Override
	public void deactivateResource() {
		// calculate overall utilization and inform listeners
		double totalTime = getModel().getSimulationControl()
				.getCurrentSimulationTime()
				* this.numberOfInstances;
		if (totalDemandedTime > totalTime) {
			totalDemandedTime = totalTime;
		}
		fireOverallUtilization(totalDemandedTime, totalTime);

		aResource.stop();
	}

	public static String getNextResourceId() {
		return Long.toString(resourceId++);
	}

	@Override
	public IActiveResource getScheduledResource() {
		return aResource;
	}

}
