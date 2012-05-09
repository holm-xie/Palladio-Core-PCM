package de.uka.ipd.sdq.edp2.example;import java.util.Collection;import java.util.Date;import java.util.List;import java.util.Random;import java.util.Vector;import java.util.logging.Level;import java.util.logging.Logger;import javax.measure.Measure;import javax.measure.quantity.Dimensionless;import javax.measure.quantity.Duration;import javax.measure.unit.BaseUnit;import javax.measure.unit.SI;import javax.measure.unit.Unit;import org.eclipse.emf.common.util.EList;import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;import de.uka.ipd.sdq.edp2.impl.Measurement;import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;import de.uka.ipd.sdq.edp2.models.ExperimentData.DataType;import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;import de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic;import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;import de.uka.ipd.sdq.edp2.models.Repository.Repository;/**Contains all exemplary including an example model instance. * This class also demonstrates the use of EDP2 for storing measurements and creating descriptions. * The implemented example follows the EDP2 creation steps:  * <li> * <ul/>Step 1: Build ExperimentSetting * <ul/>Step 2: Prepare Experiment Run (Add Raw Measurements, AggregationFunctions) * <ul/>Step 3: Run the experiment and generate measurements * </li> * All Measurements are stored in a Measurements directory. * Additionally, all standard descriptions can be retrieved.
 * @author groenda
 */
public class ExampleData {	/** Logger for this class. */	private final static Logger logger = Logger.getLogger(StoreExample.class.getCanonicalName());	/** EMF initialization. Must exist but not be used in the further code. */	@SuppressWarnings("unused")	private final static ExperimentDataPackage experimentDataPackage = ExperimentDataPackage.eINSTANCE;	/** Shortcut to experiment data factory. */	private final ExperimentDataFactory experimentDataFactory = ExperimentDataFactory.eINSTANCE;		// Create default units	private final Unit<Duration> timeUnit = SI.SECOND;	private final Unit<Dimensionless> numberUnit = new BaseUnit<Dimensionless>("Threads");	/* Metric descriptions	 * They are only assigned once in the constructor. Declaring the field final does not work	 * as the assignment is delegate to another method which is not recognized as correct	 * initialization in the constructor.	 */	public static final String SimTimeUUID = "_38mSASUPEd6gmLudJva2Dw";	public static final String ResponseTimeUUID = "_QC3ucCUQEd6gmLudJva2Dw";	public static final String AbsoluteFrequencyUUID = "_AiroIZMbEd6Vw8NDgVSYcg";	public static final String AssignedThreadsUUID = "_0xrYsCUQEd6gmLudJva2Dw";	public static final String WaitingTimeUUID = "_nU2AICUQEd6gmLudJva2Dw"; 	public static final String DemandedTimeUUID = "_fvNrgCUQEd6gmLudJva2Dw";	public static final String ArchitectureQualityEstimationUUID = "_lss1MEhpEd-SQI4N8E0NHA";	public static final String ArchitectureQualityEstimationLowUUID = "_BRpvcEigEd-uCvl0Z-GteQ";	public static final String ArchitectureQualityEstimationMediumUUID = "_JYesoEigEd-4XZQqGmj8Pg";	public static final String ArchitectureQualityEstimationHighUUID = "_LCpvcEigEd-s193kEND-BA";	private BaseMetricDescription SimTime;	private BaseMetricDescription ResponseTime;	private BaseMetricDescription DemandedTime;	private BaseMetricDescription WaitingTime;	private BaseMetricDescription AssignedThreads;	private BaseMetricDescription AbsoluteFrequency;	private BaseMetricDescription ArchitectureQualityEstimation;	private MetricSetDescription ResponseTimeSimulated;	private MetricSetDescription DemandedTimeSimulated;	private MetricSetDescription WaitingTimeSimulated;	private MetricSetDescription AssignedThreadsSimulated;	private Identifier architectureQualityIdentifierLow;	@SuppressWarnings("unused") // Only write access within the example	private Identifier architectureQualityIdentifierMedium;	@SuppressWarnings("unused") // Only write access within the example	private Identifier architectureQualityIdentifierHigh;	// Experiment data	private ExperimentGroup groupA;	private Edp2Measure serviceCallA;	private Edp2Measure cpuA;	private Edp2Measure architectureQualityA;	private ExperimentSetting settingA;	// specific for each simulated run	private ExperimentRun runA0;	private Measurements measurementServiceCallA;	private Measurements measurementArchitectureQuality;	private MeasurementsRange range;	private RawMeasurements rawMeasurements;		public ExampleData() {	}		/**Returns all exemplary descriptions.	 * @return A collection containing all descriptions.	 */	public Collection<Description> getDescriptions() {		Vector<Description> list = new Vector<Description>();		list.add(SimTime);		list.add(ResponseTime);		list.add(DemandedTime);		list.add(WaitingTime);		list.add(AssignedThreads);		list.add(AbsoluteFrequency);		list.add(ArchitectureQualityEstimation);		list.add(ResponseTimeSimulated);		list.add(DemandedTimeSimulated);		list.add(WaitingTimeSimulated);		list.add(AssignedThreadsSimulated);		return list;	}	/**Creates all exemplary metric set descriptions.	 */	public Collection<MetricDescription> createExampleMetricSetDescriptions(EList<Description> existingDescriptions) {		Collection<MetricDescription> newDescriptions = new Vector<MetricDescription>();		ResponseTimeSimulated = checkExistingMetricSetDescription(existingDescriptions, newDescriptions, 				"_MenvIiUREd6gmLudJva2Dw",				"Response Time (Simulated)",				"Response time determined in a simulation. Consists of the simulation "						+ "time when the response time began and the response time itself.",				SimTime, ResponseTime);		DemandedTimeSimulated = checkExistingMetricSetDescription(existingDescriptions, newDescriptions, 				"_tUkRciUREd6gmLudJva2Dw",				"Demanded Time (Simulated)",				"Demanded time determined in a simulation. Consists of the simulation "						+ "time when the time was demanded and the demanded time itself.",				SimTime, DemandedTime);				WaitingTimeSimulated = checkExistingMetricSetDescription(existingDescriptions, newDescriptions, 				"_3cXn4iUREd6gmLudJva2Dw",				"Waiting Time (Simulated)",				"Waiting time determined in a simulation. Consists of the simulation "						+ "time when the waiting time is stored and the waiting time itself.",				SimTime, WaitingTime);		AssignedThreadsSimulated = checkExistingMetricSetDescription(existingDescriptions, newDescriptions, 				"_M3ynoiUSEd6gmLudJva2Dw",				"Assigned Threads (Simulated)",				"Number of threads assigned to a processor within a simulation. "						+ "Consists of the time when the number has changed and the new "						+ "number of assigned threads itself.", SimTime,				AssignedThreads);		logger.info("Metric descriptions created.");		return newDescriptions;	}	/**Checks if a list of metric descriptions contains a descriptions and creates it if not.	 * @param existingDescriptions List of existing descriptions.	 * @param newDescriptions List of descriptions newly created.	 * @param uuid UUID of the description.	 * @param name Name of the description.	 * @param textualDescription Textual description of the description.	 * @param submetric1 First sub metric of the metric set.	 * @param submetric2 Second sub metric of the metric set.	 * @return the (existing or created) metric description.	 */	private MetricSetDescription checkExistingMetricSetDescription(			EList<Description> existingDescriptions,			Collection<MetricDescription> newDescriptions, String uuid,			String name, String textualDescription,			BaseMetricDescription submetric1, BaseMetricDescription submetric2) {		if (existingDescriptions != null) {			// look for metric with UUID			for (Description description : existingDescriptions) {				if (description.getUuid().equals(uuid))					return (MetricSetDescription) description;			}		}		// existing descriptions is null OR the description was not found		MetricSetDescription description = experimentDataFactory				.createMetricSetDescription(name, textualDescription);		description.setUuid(uuid);		description.getSubsumedMetrics().add(submetric1);		description.getSubsumedMetrics().add(submetric2);		newDescriptions.add(description);		return description;	}	/**Checks if a list of metric descriptions contains a descriptions and creates it if not.	 * @param existingDescriptions List of existing descriptions.	 * @param newDescriptions List of descriptions newly created.	 * @param uuid UUID of the description.	 * @param name Name of the description.	 * @param textualDescription Textual description of the description.	 * @param captureType Capture type of the description.	 * @param scale Scale of the description.	 * @param defaultUnit Default unit of the description.	 * @param monotonic Property monotonic of the description.	 * @param dataType Data type.	 * @return the (existing or created) metric description.	 */	@SuppressWarnings("unchecked")	private NumericalBaseMetricDescription checkExistingNumericalBaseMetricDescription(			final EList<Description> existingDescriptions,			final Collection<MetricDescription> newDescriptions,			final String uuid, final String name,			final String textualDescription, final CaptureType captureType,			final Scale scale, final Unit defaultUnit,			final Monotonic monotonic, final DataType dataType) {		if (existingDescriptions != null) {			// look for metric with UUID			for (Description description : existingDescriptions) {				if (description.getUuid().equals(uuid))					return (NumericalBaseMetricDescription) description;			}		}		// existing descriptions is null OR the description was not found		NumericalBaseMetricDescription description = experimentDataFactory				.createNumericalBaseMetricDescription(name, textualDescription,						captureType, scale, dataType, defaultUnit, monotonic, PersistenceKindOptions.BINARY_PREFERRED);		description.setUuid(uuid);		newDescriptions.add(description);		return description;	}		/**Checks if a list of metric descriptions contains a descriptions and creates it if not.	 * @param existingDescriptions List of existing descriptions.	 * @param newDescriptions List of descriptions newly created.	 * @param uuid UUID of the description.	 * @param name Name of the description.	 * @param textualDescription Textual description of the description.	 * @param captureType Capture type of the description.	 * @param scale Scale of the description.	 * @param defaultUnit Default unit of the description.	 * @param monotonic Property monotonic of the description.	 * @param dataType Data type.	 * @return the (existing or created) metric description.	 */	private TextualBaseMetricDescription checkExistingTextualBaseMetricDescription(			final EList<Description> existingDescriptions,			final Collection<MetricDescription> newDescriptions,			final String uuid, final String name,			final String textualDescription, final Scale scale,			final Monotonic monotonic, final DataType dataType) {		if (existingDescriptions != null) {			// look for metric with UUID			for (Description description : existingDescriptions) {				if (description.getUuid().equals(uuid)) {					checkExistingArchitectureQualityIdentifiers((TextualBaseMetricDescription) description);					return (TextualBaseMetricDescription) description;				}			}		}		// existing descriptions is null OR the description was not found		TextualBaseMetricDescription description = experimentDataFactory				.createTextualBaseMetricDescription(name, textualDescription,						scale, dataType, monotonic);		description.setUuid(uuid);		if (description.getUuid().equals(ArchitectureQualityEstimationUUID)) {			checkExistingArchitectureQualityIdentifiers(description);		}		newDescriptions.add(description);		return description;	}	/**	 * Checks if a textual base description contains the three architecture	 * quality identifiers. They are created if they do not exist.	 * 	 * @param description The metric description to check for the identifiers.	 */	private void checkExistingArchitectureQualityIdentifiers(			TextualBaseMetricDescription description) {		architectureQualityIdentifierLow = checkExistingIdentifier(				description, ArchitectureQualityEstimationLowUUID, "Low");		architectureQualityIdentifierMedium = checkExistingIdentifier(				description, ArchitectureQualityEstimationMediumUUID,				"Medium");		architectureQualityIdentifierHigh = checkExistingIdentifier(				description, ArchitectureQualityEstimationHighUUID, "High");	}		/**Checks if the provided identifier is part of the textual description. If not, the identifier is created and added to the description.	 * @param description The description to check.	 * @param uuid UUID of the identifier.	 * @param literal The literal (if the identifier is created).	 * @return The found or created identifier.	 */	private Identifier checkExistingIdentifier(			TextualBaseMetricDescription description,			String uuid, String literal) {		if (description != null) {			// look for identifier and return			for (Identifier identifier : description.getIdentifiers()) {				if (identifier.getUuid().equals(uuid))					return identifier;			}			// create identifier if not found			Identifier identifier = experimentDataFactory.createIdentifier(literal);			identifier.setUuid(uuid);			description.getIdentifiers().add(identifier);			return identifier;		}		throw new IllegalArgumentException("Description must not be null.");	}	/**Creates all exemplary base metric descriptions.	 * Reuses existing ones (if available).	 * @param existingDescriptions List of all existing metric descriptions.	 */	public Collection<MetricDescription> createExampleBaseMetricDescriptions(EList<Description> existingDescriptions) {		Collection<MetricDescription> newDescriptions = new Vector<MetricDescription>();		SimTime = checkExistingNumericalBaseMetricDescription(existingDescriptions,				newDescriptions, SimTimeUUID, "Simulation Time",				"Time passed within a simulation. Starting with 0.0.",				CaptureType.REAL_NUMBER, Scale.INTERVAL, timeUnit,				Monotonic.YES, DataType.QUANTITATIVE);		ResponseTime = checkExistingNumericalBaseMetricDescription(existingDescriptions,				newDescriptions, ResponseTimeUUID, "Response Time",				"Response Time, for example of a service call.",				CaptureType.REAL_NUMBER, Scale.INTERVAL, timeUnit, Monotonic.NO, DataType.QUANTITATIVE);		AbsoluteFrequency = checkExistingNumericalBaseMetricDescription(				existingDescriptions,				newDescriptions,				AbsoluteFrequencyUUID,				"Frequency",				"Absolute frequency of measurements or events. For example, of "						+ "measurements lying within an interval of a histogram.",				CaptureType.INTEGER_NUMBER, Scale.RATIO, numberUnit,				Monotonic.NO, DataType.QUANTITATIVE);		ArchitectureQualityEstimation = checkExistingTextualBaseMetricDescription(				existingDescriptions,				newDescriptions,				ArchitectureQualityEstimationUUID,				"Architecture Quality Estimation",				"Expresses a subjective expert estimation on a software architecture's overall quality.",				Scale.ORDINAL, Monotonic.NO, DataType.QUALITATIVE);		AssignedThreads = checkExistingNumericalBaseMetricDescription(				existingDescriptions, newDescriptions, AssignedThreadsUUID,				"Assigned Threads",				"Number of threads assigned to a processor. This includes active "						+ "as well as waiting threads.",				CaptureType.INTEGER_NUMBER, Scale.INTERVAL, numberUnit,				Monotonic.NO, DataType.QUANTITATIVE);		WaitingTime = checkExistingNumericalBaseMetricDescription(existingDescriptions,				newDescriptions, WaitingTimeUUID, "Waiting Time",				"Overall time spend waiting during a single resource demand.",				CaptureType.REAL_NUMBER, Scale.INTERVAL, timeUnit, Monotonic.NO, DataType.QUANTITATIVE);		DemandedTime = checkExistingNumericalBaseMetricDescription(existingDescriptions,				newDescriptions, DemandedTimeUUID, "Demanded Time",				"Time demanded at a resource for processing.",				CaptureType.REAL_NUMBER, Scale.INTERVAL, timeUnit, Monotonic.NO, DataType.QUANTITATIVE);		return newDescriptions;	}	/**Creates the exemplary experiment meta data.	 */	public void createExampleExperimentMetadata() {		// create measures		serviceCallA = experimentDataFactory.createEdp2Measure(				"Service Call A", ResponseTimeSimulated);		cpuA = experimentDataFactory.createEdp2Measure(				"CPU A", AssignedThreadsSimulated);		architectureQualityA = experimentDataFactory.createEdp2Measure(				"Architecture A", ArchitectureQualityEstimation);		// create experiment group		groupA = experimentDataFactory.createExperimentGroup("Exemplary use of EDP2");		groupA.getMeasure().add(serviceCallA); // belongs to the group		groupA.getMeasure().add(cpuA);  // belongs to the group		groupA.getMeasure().add(architectureQualityA);  // belongs to the group		// create experiment settings		settingA = experimentDataFactory.createExperimentSetting(groupA, "Experiment Setting #1");		settingA.getMeasure().add(serviceCallA); // used in this setting		settingA.getMeasure().add(cpuA); // used in this setting		settingA.getMeasure().add(architectureQualityA); // used in this setting		logger.info("Example metadata created.");	}		/**Returns the exemplary experiment meta data.	 * @return the meta data.	 */	public ExperimentGroup getExampleExperimentGroup() {		return groupA;	}		/**Prepares all data series for a run of experiment setting A.	 */	private void prepareExperimentRunForSettingA() {		// service call a		measurementServiceCallA = experimentDataFactory				.createMeasurements(serviceCallA);		runA0 = experimentDataFactory.createExperimentRun(settingA);		runA0.getMeasurements().add(measurementServiceCallA);		range = experimentDataFactory				.createMeasurementsRange(measurementServiceCallA);		rawMeasurements = experimentDataFactory.createRawMeasurements(range);		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);		// architecture quality estimation a		measurementArchitectureQuality = experimentDataFactory.createMeasurements(architectureQualityA);		runA0.getMeasurements().add(measurementArchitectureQuality);		MeasurementsUtility				.createDAOsForRawMeasurements(experimentDataFactory						.createRawMeasurements(experimentDataFactory								.createMeasurementsRange(measurementArchitectureQuality)));		logger.info("Experiment run for setting A prepared.");	}		/**Simulates the run of an experiment and generates (dummy) measurements.	 */	private void runExperimentForSettingA() {		runA0.setStartTime(new Date());		Random random = new Random();		Measurement measurement;		// create 1000 dummy measurements for service call A.		for (int i = 0; i < 1000; i++) {			measurement = new Measurement(measurementServiceCallA.getMeasure().getMetric());			measurement.setMeasuredValue(0, Measure.valueOf(i, timeUnit));			measurement.setMeasuredValue(1, Measure.valueOf(random.nextDouble() * 10.0, timeUnit));			MeasurementsUtility.storeMeasurement(measurementServiceCallA, measurement);		}		// create		//TODO zufallszahl assigned threads		logger.info("Measurements for service call A generated.");		// create one architecture quality estimation of architecture quality estimation A.		measurement = new Measurement(measurementArchitectureQuality.getMeasure().getMetric());		measurement.setMeasuredValue(0, architectureQualityIdentifierLow);		MeasurementsUtility.storeMeasurement(measurementArchitectureQuality, measurement);		logger.info("Measurements for architecture quality A generated.");	}			/**Simulates running an experiment.	 */	public void simulateExperimentRun() {		prepareExperimentRunForSettingA();		runExperimentForSettingA();		logger.info("Experiment run finished. Example data created.");	}		/**Reads and prints the exemplary data stored for the experiment group in the repository.	 * Does only print the generated example data in the DAOs. All data must be created by	 * the other example data code to ensure correct functionality.	 * @param repo The repository.	 * @param experimentGroupUuid UUID of the experiment group which is queried.	 * @return Formatted data.	 */	@SuppressWarnings("unchecked")	public String printStoredMeasurements(Repository repo, String experimentGroupUuid) {		try {			String result = "";			// get DAOs			for (ExperimentGroup group : repo.getExperimentGroups()) {				if (group.getUuid().equals(experimentGroupUuid)) {					EList<DataSeries> dataSeries = group.getExperimentSettings()							.get(0).getExperimentRuns().get(0).getMeasurements()							.get(0).getMeasurementsRanges().get(0)							.getRawMeasurements().getDataSeries();					OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility							.getOrdinalMeasurementsDao(dataSeries.get(0));					OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility							.getOrdinalMeasurementsDao(dataSeries.get(1));					// print stored data					result += "Stored service call example data\n";					result += "--------------------------------\n\n";					// label data series according to metric definitions					MetricSetDescription md = (MetricSetDescription) dataSeries.get(0)							.getRawMeasurements().getMeasurementsRange()							.getMeasurements().getMeasure().getMetric();					result += md.getSubsumedMetrics().get(0).getName() + "\t"							+ md.getSubsumedMetrics().get(1).getName() + "\n";					// list data					List<Measure> list1 = omdSeries1.getMeasurements();					List<Measure> list2 = omdSeries2.getMeasurements();					for (int pos = 0; pos < list1.size(); pos++) {						result += list1.get(pos) + "\t" + list2.get(pos) + "\n";					}					dataSeries = group.getExperimentSettings().get(0)							.getExperimentRuns().get(0).getMeasurements()							.get(1).getMeasurementsRanges().get(0)							.getRawMeasurements().getDataSeries();					NominalMeasurementsDao nmd = MeasurementsUtility.getNominalMeasurementsDao(dataSeries.get(0));					result += "Architecture Quality Estimation was: "							+ nmd.getObservedIdentifierBasedMeasurements()									.getObservedIdentifiers().get(0)									.getIdentifier().getLiteral();				}			}			return result;		} catch (NullPointerException npe) {			logger.log(Level.SEVERE, "Access to created example measurements failed. The data is either not created by the example code or there are store/load errors.");			return "";		}	}	/**Reads and prints the example data from a repository.	 * @param repo The repository.	 * @return Formatted data or <code>null</code> if there is no data.	 */	public String printStoredMeasurements(Repository repo) {		return printStoredMeasurements(repo, groupA.getUuid());	}}			