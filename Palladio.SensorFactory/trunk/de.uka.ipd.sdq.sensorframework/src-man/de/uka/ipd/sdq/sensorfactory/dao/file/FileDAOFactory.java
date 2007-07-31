/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO;

/**
 * @author ihssane
 * 
 */
public class FileDAOFactory implements IDAOFactory {

    private IExperimentDAO experimentDAO;
    private IExperimentRunDAO experimentRunDAO;
    private IMeasurementDAO measurementDAO;
    private ISensorDAO sensorDAO;
    private IDGenerator idGen;
    private long factoryID;
    private String root;

    public FileDAOFactory(long id, String path) {
	this.factoryID = id;
	this.root = path;
	idGen = new IDGenerator();
    }

    public String getPath() {
	return root;
    }

    public File[] listFiles(String filename) {
	File path = new File(root);
	final String fn = filename;
	return path.listFiles(new FilenameFilter() {

	    public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(".ser")
			&& name.toLowerCase().contains(fn);
	    }

	});
    }

    public IExperimentDAO createExperimentDAO() {
	if (this.experimentDAO == null)
	    this.experimentDAO = new FileExperimentDAO(this, idGen);
	return this.experimentDAO;
    }

    public IExperimentRunDAO createExperimentRunDAO() {
	if (this.experimentRunDAO == null)
	    this.experimentRunDAO = new FileExperimentRunDAO(this, idGen);
	return this.experimentRunDAO;
    }

    public IMeasurementDAO createMeasurementDAO() {
	if (this.measurementDAO == null)
	    this.measurementDAO = new FileMeasurementDAO(this, idGen);
	return this.measurementDAO;
    }

    public ISensorDAO createSensorDAO() {
	if (this.sensorDAO == null)
	    this.sensorDAO = new FileSensorDAO(this, idGen);
	return this.sensorDAO;
    }

    public IStateDAO createStateDAO() {
	// TODO Auto-generated method stub
	return null;
    }

    public boolean removeFile(String fileName) {
	File path = new File(new File(this.root), fileName + ".ser");
	return path.delete();
    }

    public void serializeToFile(String fileName, Object ser) {
	OutputStream fos = null;
	File path = new File(new File(this.root), fileName + ".ser");
	try {
	    fos = new FileOutputStream(path);
	    ObjectOutputStream o = new ObjectOutputStream(fos);
	    o.writeObject(ser);
	} catch (IOException e) {
	    System.err.println(e);
	} finally {
	    try {
		fos.close();
	    } catch (Exception e) {
	    }
	}
    }

    public Object deserializeFromFile(String fileName) {
	File path = new File(new File(this.root), fileName + ".ser");
	return deserializeFromFile(path);
    }

    public Object deserializeFromFile(File file) {
	InputStream fis = null;
	Object result = null;
	try {
	    fis = new FileInputStream(file);
	    ObjectInputStream o = new ObjectInputStream(fis);
	    result = o.readObject();
	}

	catch (IOException e) {
	    System.err.println(e);
	} catch (ClassNotFoundException e) {
	    System.err.println(e);
	} finally {
	    try {
		fis.close();
	    } catch (Exception e) {
	    }
	}
	return result;
    }

    public void finalizeAndClose() {
	// TODO Auto-generated method stub

    }

    public String getDescription() {
	return "";
    }

    public long getID() {
	return factoryID;
    }

    public String getName() {
	return "File datasource";
    }

    public String getPersistendInfo() {
	// TODO Auto-generated method stub
	return null;
    }

    public void setID(int i) {
	factoryID = i;
    }

}
