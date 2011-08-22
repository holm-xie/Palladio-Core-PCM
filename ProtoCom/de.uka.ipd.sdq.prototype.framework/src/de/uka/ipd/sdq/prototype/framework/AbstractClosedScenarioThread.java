package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;

public abstract class AbstractClosedScenarioThread extends AbstractScenarioThread {

	public AbstractClosedScenarioThread(
			Experiment exp,
			ExperimentRun expRun,
			String scenarioName, 
			RunProperties runProps) {
		super(exp, expRun, scenarioName, runProps);
		
	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {
		long start = System.nanoTime();
		usageScenario.run();
		takeScenarioMeasurement(start);
	}
	
	
	


}