package de.uka.ipd.sdq.codegen.workflow;

import java.util.LinkedList;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

public abstract class AbstractCompositeJob implements ICompositeJob {

	protected LinkedList<IJob> myJobs;
	protected Stack<IJob> myExecutedJobs;
	protected Log logger = LogFactory.getLog(OrderPreservingCompositeJob.class);
	String myName = null;

	public AbstractCompositeJob() {
		super();
		myJobs = new LinkedList<IJob>();
		myExecutedJobs = new Stack<IJob>();
	}
	
	public void addJob(IJob job) {
		if (job == null)
			throw new IllegalArgumentException("Job cannot be null");
		
		myJobs.add(job);
	}

	public abstract void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException;

	public String getName() {
		if (myName != null)
			return myName;
		
		String compositeName = "CompositeJob <";
		for(IJob job:myJobs) {
			compositeName += job.getName() + " ";
		}
		compositeName += ">";
		
		return compositeName;
	}
	
	public void setName(String name) {
		this.myName = name;
	}

	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		monitor.subTask("Rollback of "+getName());
		while (!myExecutedJobs.empty()) {
			myExecutedJobs.pop().rollback(monitor);
			monitor.worked(1);
		}
	}
}
