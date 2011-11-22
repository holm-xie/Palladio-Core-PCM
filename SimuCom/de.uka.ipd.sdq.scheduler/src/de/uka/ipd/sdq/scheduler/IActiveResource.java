package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;


/**
 * An active resource can execute demands of schedulable processes. Active
 * resources are shared by multiple processes so that they need to use
 * scheduling strategies to assign processing time of the resources to
 * processes.
 * 
 * @author jens
 * 
 */
public interface IActiveResource {

	/**
	 * Processes the specified demand of the process.
	 */
	public abstract void process(ISchedulableProcess process, int resourceServiceId, double demand);
	
	/**
	 * Returns the remaining demand for a process.
	 */
	public abstract double getRemainingDemand(ISchedulableProcess process);
	
	/**
	 * Update (currently consuming) demand for a process.
	 */
	public abstract void updateDemand(ISchedulableProcess process, double demand);

	/**
	 * Creates the initial events for the resource.
	 */
	public abstract void start();

	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	public abstract String getId();

	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	public abstract String getName();

	public abstract void stop(); 

	public abstract void registerProcess(IRunningProcess runningProcess);
	
	public abstract void notifyTerminated(ISchedulableProcess simProcess);

	/**
	 * Get the number of processes currently having requests issued to this resource and waiting
	 * for the request to complete.
	 * @param simResourceInstance
	 * @return
	 */
	public abstract int getQueueLengthFor(
			SimResourceInstance simResourceInstance);
	
	public void addObserver(IActiveResourceStateSensor observer);
		
	public void removeObserver(IActiveResourceStateSensor observer);

}