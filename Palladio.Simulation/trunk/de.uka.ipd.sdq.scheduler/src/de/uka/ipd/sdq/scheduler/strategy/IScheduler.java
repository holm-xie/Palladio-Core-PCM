package de.uka.ipd.sdq.scheduler.strategy;

import java.util.Deque;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.passive.WaitingProcess;

/**
 * Scheduling strategy for an active resource. Called by each of its instances
 * to schedule the next processes.
 * 
 * @author jens
 * 
 */
public interface IScheduler {

	/**
	 * Executes the next processes on the given resource instances.
	 * 
	 * @param instance
	 *            Resource instance requesting scheduling.
	 */
	public abstract void schedule(IResourceInstance instance);

	/**
	 * Registers a new process and adds it to the scheduler's runqueue(s).
	 * 
	 * @param process
	 */
	public abstract void addProcess(IActiveProcess process);

	/**
	 * Notifies the scheduler, that a process finished its waiting period and
	 * becomes ready for execution. It takes care of the complete state change
	 * including the removal of the process from its waiting queue.
	 * 
	 * @param waiting_process
	 *            Wrapper for the waiting process.
	 * @param waiting_queue
	 *            Queue where the process is waiting.
	 */
	public abstract void fromWaitingToReady(WaitingProcess waiting_process,
			Deque<WaitingProcess> waiting_queue);

	/**
	 * Notifies the scheduler, that a running process has to change its state to
	 * waiting. Takes care of the complete state change, including the insertion
	 * of the process into the waiting queue.
	 * 
	 * @param waiting_process
	 *            Wrapper for the waiting process. Includes additional
	 *            information about the waiting state.
	 * @param waiting_queue
	 *            The queue where the process has to wait.
	 * @param in_front
	 *            If true, the process is inserted at the front of the queue,
	 *            otherwise it is inserted at the end.
	 */
	public abstract void fromRunningToWaiting(WaitingProcess waiting_process,
			Deque<WaitingProcess> waiting_queue, boolean in_front);

	/**
	 * Schedules the next event for the specified resource instance.
	 * 
	 * @param instance
	 *            Instance a new event is needed for.
	 */
	public abstract void scheduleNextEvent(IResourceInstance instance);

}
