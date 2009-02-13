package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;

public abstract class SimProcess extends SimulationElement 
implements ISimProcessDelegate, ISchedulableProcess {

	protected static Logger logger = 
		Logger.getLogger(SimProcess.class.getName());
	

	ISimProcessDelegate delegate = null;
	private Process processStatus = null;
	private long id;

	private boolean isDebug;
	
	protected SimProcess(SimuComModel model, String name) {
		super(model, name);
		delegate = model.getSimEngineFactory().createSimProcess(this,model,name);
		isDebug = model.getConfig().isDebug();
		id = getNextID();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#lifeCycle()
	 */
	public final void lifeCycle() {
		addProcessToSimStatus();
		try {
			this.internalLifeCycle();
		} catch (Exception e) {
			logger.warn("Simulation caused an exception. Caught it in SimProcess Lifecycle Method",e);
			((SimuComModel)getModel()).setStatus(SimuComResult.ERROR,
					e);
			logger.debug("Trying to stop simulation now...");
			this.getModel().getSimulationControl().stop();
		}
		removeProcessFromSimStatus();
	}

	/**
	 * 
	 */
	protected void removeProcessFromSimStatus() {
		logger.info("Terminating SimProcess "+this.getName());
		if (isDebug) {
			this.getModel().getSimulationStatus().getProcessStatus().getProcesses().remove(processStatus);
		}
	}

	/**
	 * Clients may override default behaviour, e.g., PassiveResource
	 */
	protected void addProcessToSimStatus() {
		logger.info("Starting simulation process "+this.getName());

		if (isDebug) {
			processStatus = SimucomstatusFactory.eINSTANCE.createProcess();
			this.getModel().getSimulationStatus().getProcessStatus().getProcesses().add(processStatus);
			processStatus.setId(this.getName());
			processStatus.setProcessStartTime(this.getModel().getSimulationControl().getCurrentSimulationTime());
		}
	}
	
	protected abstract void internalLifeCycle();

	// Strategy dependent methods

	public void hold(double d) {
		if (isDebug) {
			WaitForDelay action = SimucomstatusFactory.eINSTANCE.createWaitForDelay();
			action.setActionStartTime(this.getModel().getSimulationControl().getCurrentSimulationTime());
			action.setDelay(d);
			this.getSimProcessStatus().setCurrentAction(action);
		}
		delegate.hold(d);
	}

	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	public void passivate() {
		delegate.passivate();
	}
	
	public void activate() {
		this.scheduleAt(0);
	}

	public void scheduleAt(double d) {
		delegate.scheduleAt(d);
	}
	
	public String getId() {
		return getName() + "_" + id;
	}
	
	public ISchedulableProcess getRootProcess(){
		// TODO: What is expected here?
		return null;
	}
	
	public boolean isFinished() {
		return isTerminated();
	}

	public Process getSimProcessStatus() {
		return this.processStatus;
	}
	
	private static long processID = 0;
	
	protected static long getNextID(){
		return processID++;
	}
	
	private ArrayList<IActiveResource> terminatedObservers = new ArrayList<IActiveResource>();
	private List<IActiveResource> removedObservers = new ArrayList<IActiveResource>();;
	
	public void fireTerminated() {
		for (IActiveResource o : terminatedObservers)
			o.notifyTerminated(this);
		terminatedObservers.removeAll(removedObservers);
		removedObservers.clear();
	}
	
	public void addTerminatedObserver(IActiveResource r) {
		terminatedObservers.add(r);
	}

	public void removeTerminatedObserver(IActiveResource r) {
		removedObservers.add(r);
	}

}
