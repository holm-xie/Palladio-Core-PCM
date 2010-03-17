package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * @author roman
 * 
 * The class encapsulates all configuration options for SimuCom.
 */
public class SimuComConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3364130550065874984L;
	
	public static final String DATASOURCE_ID = "datasourceID";
	public static final String SHOULD_THROW_EXCEPTION = "shouldThrowException";
	public static final String MAXIMUM_MEASUREMENT_COUNT = "maximumMeasurementCount";
	public static final String USE_FIXED_SEED = "useFixedSeed";
	public static final String FIXED_SEED_PREFIX = "fixedSeed";
	
	/** SimuCom configuration tab */
	public static String EXPERIMENT_RUN = "experimentRun";
	public static String SIMULATION_TIME = "simTime";
	public static String VERBOSE_LOGGING = "verboseLogging";
	public static String SIMULATE_FAILURES = "simulateFailures";
	public static String USE_CONFIDENCE = "useConfidenceStopCondition";
	public static String CONFIDENCE_LEVEL = "confidenceLevel";
	public static String CONFIDENCE_HALFWIDTH = "confidenceHalfWidth";
	public static String CONFIDENCE_MODELELEMENT_URI = "confidenceModelElementURI";
	public static String CONFIDENCE_MODELELEMENT_NAME = "confidenceModelElementName";
	
	/** configuration options */
	private String nameExperimentRun;
	private long simuTime;
	private boolean verboseLogging;
	private boolean simulateFailures = false;
	private long datasourceID;
	private Integer runNumber;
	private Long maxMeasurementsCount;
	private boolean isDebug;
	private long[] randomSeed = null;
	private IRandomGenerator randomNumberGenerator = null;
	private boolean useConfidence = false;
	private int confidenceLevel = 0;
	private int confidenceHalfWidth = 0;
	private URI confidenceModelElementURI;
	private String confidenceModelElementName;

	/**
	 * @param configuration a map which maps configuration option IDs to their values. 
	 * The required keys are SimuComConfig.EXPERIMENT_RUN, SimuComConfig.SIMULATION_TIME 
	 * SimuComConfig.MAXIMUM_MEASUREMENT_COUNT SimuComConfig.VERBOSE_LOGGING, 
	 * SimuComConfig.DATASOURCE_ID. Optional keys are SimuComConfig.SIMULATE_FAILURES and
	 * USE_CONFIDENCE. If USE_CONFIDENCE is set to true, you also need to set 
	 * SimuComConfig.CONFIDENCE_LEVEL, SimuComConfig.CONFIDENCE_HALFWIDTH, 
	 * SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, SimuComConfig.CONFIDENCE_MODELELEMENT_URI 
	 * 
	 */
	public SimuComConfig(Map<String,Object> configuration, int runNo, boolean debug){
		try {
			this.nameExperimentRun = (String) configuration.get(
					EXPERIMENT_RUN);
			this.simuTime = Long.valueOf((String)configuration.get(
					SIMULATION_TIME));
			this.maxMeasurementsCount = Long.valueOf((String)configuration.get(
					MAXIMUM_MEASUREMENT_COUNT));
			this.verboseLogging = (Boolean)configuration.get(
					VERBOSE_LOGGING);
			this.datasourceID = (Integer)configuration.get(
					DATASOURCE_ID);
			this.runNumber = runNo;
			this.isDebug = debug;
			this.randomSeed = getSeedFromConfig(configuration);
			
			if (configuration.containsKey(SIMULATE_FAILURES)){
				this.simulateFailures = (Boolean)configuration.get(
						SIMULATE_FAILURES);
			}
			
			// confidence information is optional in the map. It this.useConfidence defaults to false.
			if (configuration.containsKey(USE_CONFIDENCE)) {
				this.useConfidence = (Boolean) configuration
						.get(USE_CONFIDENCE);
				this.confidenceLevel = Integer.valueOf((String) configuration
						.get(CONFIDENCE_LEVEL));
				this.confidenceHalfWidth = Integer
						.valueOf((String) configuration
								.get(CONFIDENCE_HALFWIDTH));
				this.confidenceModelElementName = (String) configuration
						.get(CONFIDENCE_MODELELEMENT_NAME);
				this.confidenceModelElementURI = URI
						.createURI((String) configuration
								.get(CONFIDENCE_MODELELEMENT_URI));

			}
		} catch (Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
		}
	}

	private long[] getSeedFromConfig(Map<String,Object> configuration) {
		if ((Boolean)configuration.get(USE_FIXED_SEED)) {
			long[] seed = new long[6];
			for (int i = 0; i < 6; i++) {
				seed[i] = Long.parseLong((String)configuration.get(FIXED_SEED_PREFIX+i));
			}
			return seed;
		}
		return null;
	}
	
	public String getNameExperimentRun() {
		return nameExperimentRun + " RunNo. "+runNumber;
	}

	public long getSimuTime() {
		return simuTime;
	}

	public long getMaxMeasurementsCount() {
		return maxMeasurementsCount;
	}
	
	public boolean getVerboseLogging() {
		return verboseLogging || isDebug;
	}
	
	public boolean getSimulateFailures() {
		return simulateFailures;
	}

	public long getDatasourceID() {
		return this.datasourceID;
	}

	public boolean isDebug() {
		return this.isDebug;
	}
	
	public boolean isUseConfidence() {
		return useConfidence;
	}

	public int getConfidenceLevel() {
		return confidenceLevel;
	}

	public int getConfidenceHalfWidth() {
		return confidenceHalfWidth;
	}
	
	public String getConfidenceModelElementName() {
		return confidenceModelElementName;
	}
	
	public URI getConfidenceModelElementURI() {
		return confidenceModelElementURI;
	}

	public String getEngine() {
		return "de.uka.ipd.sdq.simucomframework.ssj.SSJSimEngineFactory";
	}
	
	public IRandomGenerator getRandomGenerator() {
		if (randomNumberGenerator == null) {
			randomNumberGenerator = new SimuComDefaultRandomNumberGenerator(randomSeed);
		}
		return randomNumberGenerator;
	}

}
