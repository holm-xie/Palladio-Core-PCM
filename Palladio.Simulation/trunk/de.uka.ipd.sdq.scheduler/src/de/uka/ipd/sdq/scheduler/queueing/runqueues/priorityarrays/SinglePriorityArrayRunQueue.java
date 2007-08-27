package de.uka.ipd.sdq.scheduler.queueing.runqueues.priorityarrays;

import java.util.List;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;


public class SinglePriorityArrayRunQueue extends AbstractPriorityArrayRunQueue  {
	
	private PriorityArray priorityArray;

	public SinglePriorityArrayRunQueue(IPriorityManager priorityManager) {
		super(priorityManager);
		this.priorityArray = new PriorityArray(priorityManager);
	}

	@Override
	protected int numWaitingProcesses() {
		return priorityArray.getNumberOfProcesses();
	}

	@Override
	public ActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		return priorityArray.getNextRunnableProcess(instance);
	}
	
	@Override
	public ActiveProcess getNextRunnableProcess() {
		return priorityArray.getNextRunnableProcess();
	}

	@Override
	public boolean removePendingProcess(ActiveProcess process) {
		return priorityArray.removeProcess(process);
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SinglePriorityArrayRunQueue(this.priorityManager);
	}

	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		return priorityArray.identifyMovableProcesses(targetInstance,prio_increasing,queue_ascending,processes_needed);
	}

	@Override
	public ProcessQueue<ActiveProcess> getBestRunnableQueue(
			IResourceInstance instance) {
		return this.priorityArray.getBestRunnableQueue(instance);
	}

	@Override
	public boolean containsPending(ActiveProcess process) {
		return priorityArray.contains(process);
	}

	@Override
	protected void addProcessToRunQueue(ActiveProcess process, boolean inFront) {
		priorityArray.add(process, inFront);
	}
}
