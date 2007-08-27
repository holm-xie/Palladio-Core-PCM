package de.uka.ipd.sdq.scheduler.resources.balancing.balancers;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;

/**
 * Moves one process to each idle resource, if possilbe.
 * 
 * @author jens.happe
 * 
 */
public class OneToIdleBalancer extends AbstractLoadBalancer {

	public OneToIdleBalancer(double balanceInterval,
			MultipleQueuesStrategy queueHolder, boolean prio_increasing,
			boolean queue_ascending, int max_iterations) {
		super(balanceInterval, queueHolder, prio_increasing, queue_ascending,
				max_iterations);
	}


	@Override
	protected boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		return (queueHolder.isIdle(firstInstance) == queueHolder
				.isIdle(secondInstance));
	}
}
