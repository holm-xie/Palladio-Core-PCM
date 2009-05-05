package de.uka.ipd.sdq.dsexplore.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

public class EMFHelper {
	
	/**
	 * Checks for two PCM model elements whether they are the same, i.e. whether
	 * they have the same ID. The model elements have to be derived from
	 * Identifier. Note that two systems might use the same assembly contexts
	 * and components, but still are two different systems. If one of the 
	 * Identifiers in null, false is returned. 
	 * 
	 * @param i1
	 *            One Identifier
	 * @param i2
	 *            Another Identifier
	 * @return true if i1.getId().equals(i2.getId()), false otherwise
	 */
	public static boolean checkIdentity(Identifier i1, Identifier i2) {
		if (i1 == null || i2 == null)
			return false;
		if (i1.getId().equals(i2.getId())) {
			// logger.debug("Two model elements match with Id: "+i1.getId());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Save the given EObject to the file given by filename.
	 * 
	 * @param modelToSave
	 *            The EObject to save
	 * @param fileName
	 *            The filename where to save.
	 */
	public static void saveToXMIFile(final EObject modelToSave, final String fileName) {
		
		Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");
		
		logger.debug("Saving " + modelToSave.toString() + " to " + fileName);

		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
	
		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(modelToSave);
		


		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (FileNotFoundException e){
			if (fileName.length() > 250){
				//try again with a shorter filename
				saveToXMIFile(modelToSave, fileName.substring(0, fileName.indexOf("-"))+"-shortened-"+fileName.hashCode());
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		// logger.debug("Saved " + fileURI);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param fileName
	 *            the filename specifying the file to load from
	 * @return The EObject loaded from the file
	 */
	public static EObject loadFromXMIFile(final String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		registerPackages(resourceSet);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		Resource resource = null;
		// Demand load resource for this file.
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			Logger.getLogger("de.uka.ipd.sdq.dsexplore").error(e.getMessage());
			return null;
		}

		// logger.debug("Loaded " + uri);

		// if (!fileName.endsWith(".assembly") &&
		// !fileName.endsWith("repository")) {
		// // Validate the contents of the loaded resource.
		// for (Iterator j = resource.getContents().iterator(); j.hasNext();) {
		// EObject eObject = (EObject) j.next();
		// Diagnostic diagnostic = Diagnostician.INSTANCE
		// .validate(eObject);
		// if (diagnostic.getSeverity() != Diagnostic.OK) {
		// System.out.println();
		// System.out.println(diagnostic.getMessage());
		// // printDiagnostic(diagnostic, "");
		//					
		// }
		// }
		// }
		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param resourceSet
	 *            The resource set to register all contained model packages
	 *            with.
	 */
	private static void registerPackages(final ResourceSet resourceSet) {

		resourceSet.getPackageRegistry().put(AllocationPackage.eNS_URI,
				AllocationPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ParameterPackage.eNS_URI,
				ParameterPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				ResourceenvironmentPackage.eNS_URI,
				ResourceenvironmentPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(ResourcetypePackage.eNS_URI,
				ResourcetypePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI,
				RepositoryPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SeffPackage.eNS_URI,
				SeffPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SystemPackage.eNS_URI,
				SystemPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(UsagemodelPackage.eNS_URI,
				UsagemodelPackage.eINSTANCE);
		
	}
	
}
