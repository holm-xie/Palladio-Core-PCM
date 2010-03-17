package de.uka.ipd.sdq.simucomframework.resources;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ThroughputZeroOrNegativeException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class SimulatedLinkingResource extends AbstractScheduledResource {

	protected static Logger logger = Logger
			.getLogger(SimulatedLinkingResource.class.getName());

	private String throughput;
	private String latencySpec;

	public SimulatedLinkingResource(SimuComModel myModel, String typeID,
			String description, String d, String latencySpec,
			Double failureProbability) {
		super(myModel, typeID, description, SchedulingStrategy.FCFS);
		this.latencySpec = latencySpec;
		this.throughput = d;
		this.failureProbability = failureProbability;
		this.canFail = (myModel.getConfig().getSimulateFailures() && this.failureProbability > 0.0);
	}

	@Override
	protected double calculateDemand(double demand) {
		double calculatedThroughput = NumberConverter.toDouble(StackContext
				.evaluateStatic(throughput));
		if (calculatedThroughput <= 0) {
			throw new ThroughputZeroOrNegativeException(
					"Throughput at resource " + getName()
							+ " was less or equal zero");
		}
		double result = NumberConverter.toDouble(StackContext
				.evaluateStatic(latencySpec))
				+ demand / calculatedThroughput;

		logger.debug("A network load of " + result + " has been determined.");

		return result;
	}

	@Override
	public void consumeResource(SimProcess thread, double demand) {
		throw new RuntimeException("Not supported in this branch of the simulation's code");
	}

	@Override
	public IActiveResource getScheduledResource() {
		// TODO Auto-generated method stub
		return null;
	}

}