/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * @author ihssane
 * 
 * TODO: Kommentare
 * 
 */
public class FileExperimentDAO implements IExperimentDAO {

	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileExperimentDAO(IDAOFactory factory, IDGenerator idGen) {
		this.factory = (FileDAOFactory) factory;
		this.idGen = idGen;
	}

	public Experiment addExperiment(String p_experimentname) {
		ExperimentImpl exp = new ExperimentImpl(factory);
		exp.setExperimentID(idGen.getNextExperimentID());
		exp.setExperimentName(p_experimentname);

		return exp;
	}

	// TODO: Warum werden nicht alle Experimente einmal zu beginn geladen? Performance bei mehrfachem Suchen in vielen Experimenten.
	public Collection<Experiment> findByExperimentName(String searchKey) {
		List<Experiment> result = new ArrayList<Experiment>();
		File[] files = factory.listFiles("experiment");
		for (File file : files) {
			Experiment exp = (Experiment) factory.deserializeFromFile(file);
			((ExperimentImpl) exp).setFactory(factory);
			if (exp.getExperimentName().equals(searchKey))
				result.add(exp);
		}

		return Collections.unmodifiableCollection(result);
	}

	// TODO: Das einmalige Laden w�rde auch hier den Zugriff vereinfachen: return experimentTable.get(id);
	public Experiment get(long id) {
		File[] files = factory.listFiles("experiment" + id);
		Experiment exp = null;
		if (files.length == 0)
			return null;
		else {
			for (File file : files) {
				exp = (Experiment) factory.deserializeFromFile(file);
				((ExperimentImpl) exp).setFactory(factory);
			}
		}
		return exp;
	}

	// TODO: 3x fast der gleiche Code -> Einmal zu Anfang laden.
	public Collection<Experiment> getExperiments() {
		List<Experiment> result = new ArrayList<Experiment>();
		File[] files = factory.listFiles("experiment");
		for (File file : files) {
			Experiment exp = (Experiment) factory.deserializeFromFile(file);
			((ExperimentImpl) exp).setFactory(factory);
			result.add(exp);
		}

		return Collections.unmodifiableCollection(result);
	}

	public void removeExperiment(Experiment experiment, boolean doCascade) {
		factory.removeFile("experiment" + experiment.getExperimentID());
	}

	public void store(Experiment e) {
		factory.serializeToFile("experiment" + e.getExperimentID(), e);
		for (ExperimentRun er : e.getExperimentRuns())
			factory.createExperimentRunDAO().store(er);
	}

}
