package de.uka.ipd.sdq.simucom.threads;

import java.util.ArrayList;

import de.uka.ipd.sdq.simucom.reflectivevisitor.ReflectiveVisitor;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.SimProcess;

public class ArchitectureVisitor
extends ReflectiveVisitor
implements IThreadActionVisitor {

	protected ArrayList<HistoryElement> localHistory;
	protected SimProcess parent = null;
	
//	public ArchitectureVisitor(SimProcess parent, ArrayList<HistoryElement> history)
//	{
//		localHistory = history;
//		this.parent = parent;
//	}
//	
//	public void visitMethod(Method m) throws Exception {
//		addHistoryEntry("SimulatedThread visits "+m.toString());
//		m.getServiceEffectSpecification().accept(this);
//	}
//
//	public void visitServiceEffect(ServiceEffect se) throws Exception {
//		addHistoryEntry("SimulatedThread visits "+se.toString());
//		new ActivityServiceEffectVisitor(parent,localHistory).visitActivity(se.getSimulatedActivity());
//	}
//		
//	private void addHistoryEntry(String message) {
//		localHistory.add(new HistoryElement(SimTime.NOW,message));
//	}
}
