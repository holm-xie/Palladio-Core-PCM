package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.SolverParamsType;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;

public class Pcm2LqnStrategy implements SolverStrategy {

	private static Logger logger = Logger.getLogger(Pcm2LqnStrategy.class.getName());
	
	// the following filenames should be OS-independent
	private static final String FILENAME_INPUT = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.xml";
	private static final String FILENAME_RESULT = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.out";
	private static final String FILENAME_LQN = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.lqn";
	
	// the lqn tools should be in the system path
	private static final String FILENAME_LQNS = "lqns";
	private static final String FILENAME_LQSIM = "lqsim";
	private static final String FILENAME_LQN2XML = "lqn2xml";
	
	
	private long overallDuration = 0;
	private ILaunchConfiguration config;
	
	public Pcm2LqnStrategy(ILaunchConfiguration configuration) {
		config = configuration;
	}

	public Pcm2LqnStrategy() {
	}
	
	public void loadTransformedModel(String fileName) {
	}

	public void solve() {
		String solverProgram = getSolverProgramName();

		long timeBeforeCalc = System.nanoTime();
		
		int exitVal = 0;
		try {
			Process proc = Runtime.getRuntime().exec(solverProgram+" -o"+
					FILENAME_RESULT+" "+FILENAME_LQN);
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
            errorGobbler.start();
            outputGobbler.start();

            exitVal = proc.waitFor();
            logger.warn(solverProgram+" ExitValue: "+ exitVal);
		} catch (Throwable e) {
			logger.error("Running "+solverProgram+" failed!");
			e.printStackTrace();
		}
		
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		overallDuration += duration;
		logger.warn("Finished Running "+solverProgram+":\t\t"+ duration + " ms");
		logger.warn("Completed Analysis:\t\t"+ overallDuration + " ms overall");
		
		if (exitVal==0) showOutput(FILENAME_RESULT);
	}

	private String getSolverProgramName() {
		String solverProgram = "";
		try {
			solverProgram = config.getAttribute(MessageStrings.SOLVER,
					MessageStrings.LQNS_SOLVER);
		} catch (CoreException e1) {
			logger.error("Could not determine LQN Solver. Check Configuration.");
		}

		if (solverProgram.equals(MessageStrings.LQNS_SOLVER))
			solverProgram = FILENAME_LQNS;
		else
			solverProgram = FILENAME_LQSIM;
		return solverProgram;
	}
	
	/**
	 * Reads the output file and shows its content 
	 * in a new text editor window.
	 * @param filename
	 */
	private void showOutput(String filename) {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);

		ResultWindow rw = new ResultWindow(content);
		rw.open();
	}
	
	public void storeTransformedModel(String fileName) {
	}

	public void transform(PCMInstance model) {
		long startTime = System.nanoTime();
		
		runDSolver(model);
		
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		overallDuration += duration;
		logger.warn("Finished DSolver:\t\t"+ duration + " ms");
		

		long timeBeforeTransform = System.nanoTime();
		
		runPcm2Lqn(model);
		
		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform-timeBeforeTransform);
		overallDuration += duration2;
		logger.warn("Finished PCM2LQN:\t\t"+ duration2 + " ms");
	}
	
	private void runPcm2Lqn(PCMInstance model) {
		
		LqnBuilder lqnBuilder = new LqnBuilder();

		ResourceEnvironment2Lqn reVisitor = new ResourceEnvironment2Lqn(lqnBuilder, config);
		reVisitor.doSwitch(model.getResourceEnvironment());
		
		UsageModel2Lqn umVisitor = new UsageModel2Lqn(lqnBuilder, new ContextWrapper(model));
		umVisitor.doSwitch(model.getUsageModel());
		
		lqnBuilder.finalizeLqnModel(config);
		
		LqnXmlHandler lqnXmlHandler = new LqnXmlHandler(lqnBuilder.getLqnModel());
		lqnXmlHandler.saveModelToXMI(FILENAME_INPUT);

		Pcm2LqnHelper.clearGuidMap();
		runLqn2Xml();
		
	}
	
	/**
	 * Converts the resulting XML file back to the old LQN file format.
	 */
	private void runLqn2Xml() {
		try {
			Process proc = Runtime.getRuntime().exec(
					FILENAME_LQN2XML+" -o" + FILENAME_LQN + 
					" -Olqn " + FILENAME_INPUT);

			StreamGobbler errorGobbler = new StreamGobbler(proc
					.getErrorStream(), "ERROR");
			StreamGobbler outputGobbler = new StreamGobbler(proc
					.getInputStream(), "OUTPUT");
			errorGobbler.start();
			outputGobbler.start();

			int exitVal = proc.waitFor();
			logger.warn("lqn2xml ExitValue: " + exitVal);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void runDSolver(PCMInstance model) {
		// TODO: fix this (only uses one usage scenario):
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		try {
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}
	}
}

class StreamGobbler extends Thread {
	
	private static Logger logger = Logger.getLogger(StreamGobbler.class.getName());
	
	InputStream is;
	String type;

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				//if (type.equals("ERROR")) logger.error(line);
				logger.error(line);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}