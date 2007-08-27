package de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.priorityarrays;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.AbstractRunQueue;

public abstract class AbstractPriorityArrayRunQueue extends AbstractRunQueue {

	protected IPriorityManager priorityManager;

	public AbstractPriorityArrayRunQueue(IPriorityManager priorityManager) {
		super();
		this.priorityManager = priorityManager;
	}



}