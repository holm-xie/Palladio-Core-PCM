/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.dialogs.issues.IssuesDialog;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.emf.CheckEMFConstraintsJob;
import de.uka.ipd.sdq.workflow.mdsd.oaw.PerformOAWCheckValidation;


class ErrorDisplayRunner implements Runnable {
	
	private List<SeverityAndIssue> issues;
	private boolean shouldProceed;

	public boolean shouldProceedAfterErrorDialog() {
		return shouldProceed;
	}

	public ErrorDisplayRunner(List<SeverityAndIssue> overallResult) {
		super();
		this.issues = overallResult;
	}

	public void run() {
		Dialog dialog = new IssuesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), issues);
		dialog.open();
		this.shouldProceed = dialog.getReturnCode() == IssuesDialog.IGNORE_BUTTON;
	}

}

/**
 * @author Snowball
 *
 */
public class ValidateModelJob 
implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {

	private Logger logger = Logger.getLogger(ValidateModelJob.class);
	private MDSDBlackboard blackboard = null;
	private SimuComWorkflowConfiguration configuration;
	private PerformOAWCheckValidation oawCheckJob;
	private CheckEMFConstraintsJob emfCheckJob;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#execute()
	 */
	public ValidateModelJob(SimuComWorkflowConfiguration configuration) {
		super();
		this.configuration = configuration;
		this.oawCheckJob = new PerformOAWCheckValidation(
				LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID, 
				"pcm", 
				AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		this.emfCheckJob = new CheckEMFConstraintsJob(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException{
		oawCheckJob.setBlackbard(blackboard);
		oawCheckJob.execute(monitor);
		List<SeverityAndIssue> result = oawCheckJob.getResult();
		
		emfCheckJob.setBlackbard(blackboard);
		emfCheckJob.execute(monitor);
		result.addAll(emfCheckJob.getResult());
		
		if (result.size() > 0) {
			logger.warn("Found validation problems in the models");
			displayValidationErrors(result);
			logger.warn("Continuing workflow, ignoring model validation issues");
		}
	}

	private void displayValidationErrors(
			List<SeverityAndIssue> overallResult)
			throws UserCanceledException {
		ErrorDisplayRunner runner = new ErrorDisplayRunner(overallResult);

		/**
		 * Disable the IssuesDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION set
		 * of false
		 */
		if (configuration.isInteractive()) {
			PlatformUI.getWorkbench().getDisplay().syncExec(runner);
			if (!runner.shouldProceedAfterErrorDialog())
				throw new UserCanceledException();
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#getName()
	 */
	public String getName() {
		return "Checking model constraints";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.ISimulationJob#rollback()
	 */
	public void rollback(IProgressMonitor monitor) {
		// Nothing to do here
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob#setBlackbard(de.uka.ipd.sdq.codegen.workflow.Blackboard)
	 */
	public void setBlackbard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}
}
