/**
 * 
 */
package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.openarchitectureware.check.CheckFacade;
import org.openarchitectureware.expression.ExecutionContext;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.issues.Issue;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * @author Snowball
 *
 */
public class PerformOAWCheckValidation 
implements IJobWithResult<ArrayList<SeverityAndIssue>>, IBlackboardInteractingJob<MDSDBlackboard> {

	private MDSDBlackboard blackboard;
	private ExecutionContextImpl ctx;
	private ArrayList<SeverityAndIssue> result;

	private String partitionName;
	private String checkFilename;
	private EPackage[] ePackages;

	/**
	 * @param partitionName
	 * @param checkFilename
	 * @param packages
	 */
	public PerformOAWCheckValidation(String partitionName,
			String checkFilename, EPackage[] packages) {
		super();
		
		this.partitionName = partitionName;
		this.checkFilename = checkFilename;
		ePackages = packages;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

		Issues issues = new IssuesImpl();

		ResourceSetPartition partition = this.blackboard.getPartition(this.partitionName);
		partition.resolveAllProxies();

		for (Resource r : partition.getResourceSet().getResources()) {
			// Check resource with oAW's check language
			CheckFacade.checkAll(
					this.checkFilename, 
					getElementsInResource(r),
					getExecutionContext(), 
					issues);
		}

		this.result = getSeverityAndIssues(issues);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#getName()
	 */
	public String getName() {
		return "Checking oAW constraints";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// not-needed
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IJobWithResult#getResult()
	 */
	public ArrayList<SeverityAndIssue> getResult() {
		return this.result;
	}

	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	private Collection<EObject> getElementsInResource(Resource resource) {
		TreeIterator<EObject> items = resource.getAllContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		for (;items.hasNext();) {
			result.add(items.next());
		}
		
		return result;
	}
	
	private ExecutionContext getExecutionContext() {
		if (ctx == null) {
			ctx = new ExecutionContextImpl();
			List<EPackage> l = getMetamodelPackages();
			for (Iterator<EPackage> iter = l.iterator(); iter.hasNext();) {
				EPackage pkg = iter.next();
				ctx.registerMetaModel(new EmfMetaModel(pkg));
			}
		}
		return ctx;
	}
	
	private ArrayList<SeverityAndIssue> getSeverityAndIssues(
			Issues issues) {
		ArrayList<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		for (Issue issue : issues.getErrors())
			result.add(new SeverityAndIssue(SeverityAndIssue.ERROR,issue.getMessage(),(EObject)issue.getElement()));
		for (Issue issue : issues.getWarnings())
			result.add(new SeverityAndIssue(SeverityAndIssue.WARNING,issue.getMessage(),(EObject)issue.getElement()));
		return result;
	}
	
	private List<EPackage> getMetamodelPackages() {
		return Arrays.asList(this.ePackages);
	}
}