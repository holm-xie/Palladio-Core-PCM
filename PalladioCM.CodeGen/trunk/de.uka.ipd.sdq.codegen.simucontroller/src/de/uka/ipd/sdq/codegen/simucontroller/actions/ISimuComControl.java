package de.uka.ipd.sdq.codegen.simucontroller.actions;

import de.uka.ipd.sdq.simucomframework.IStatusObserver;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;


/**
 * Control interface for the SimuCom Framework. It defines two methods, which
 * for starting and stopping simulation are responsible.
 * 
 * @author Roman Andrej
 */
public interface ISimuComControl {

	public SimuComStatus startSimulation(SimuComConfig config, IStatusObserver statusObserver);
	public void stopSimulation();
	public Throwable getErrorThrowable();
}
