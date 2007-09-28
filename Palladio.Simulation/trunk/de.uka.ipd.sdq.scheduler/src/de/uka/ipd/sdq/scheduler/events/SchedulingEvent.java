package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;
import umontreal.iro.lecuyer.simevents.Event;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * @author jens
 * 
 */
public class SchedulingEvent extends Event {

	SimActiveResource containingResource;
	IResourceInstance instance;

	public SchedulingEvent(SimActiveResource containingResource, IResourceInstance instance) {
		super();
		this.containingResource = containingResource;
		this.instance = instance;
	}

	@Override
	public void actions() {
		containingResource.getScheduler().schedule(instance);
	}
}
