package de.uka.ipd.sdq.dsolver;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.context.allocation.ActualAllocation;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.context.usage.Usage;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.assembly.Assembly;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

public class PCMInstance {
	
	private static Logger logger = 
		Logger.getLogger(PCMInstance.class.getName());
	
	private Allocation allocation;

	private Assembly assembly;

	private Repository repository;

	private ResourceEnvironment resourceEnvironment;

	private ResourceRepository resourceRepository;

	private de.uka.ipd.sdq.pcm.system.System system;

	private UsageModel usageModel;
	
	private Usage usage;
	
	private ActualAllocation actualAllocation;
	
	private String storagePath;

	public PCMInstance(Properties config) {
		this.storagePath = config.getProperty("Storage_Path");
		this.usage = UsageFactory.eINSTANCE.createUsage();
		this.actualAllocation = AllocationFactory.eINSTANCE.createActualAllocation();
		loadFromFiles(config);
		
//		UsageScenario us = (UsageScenario) usageModel.getUsageScenario_UsageModel().get(0);
//		EList actions = us.getScenarioBehaviour_UsageScenario().getActions_ScenarioBehaviour();
//		EntryLevelSystemCall elsc = (EntryLevelSystemCall) actions.get(1);
//		EList blah = elsc.getActualParameterUsage_EntryLevelSystemCall();
//		ParameterUsage parUsage = (ParameterUsage) blah.get(0);
//		PrimitiveParameterCharacterisation ppc = (PrimitiveParameterCharacterisation) parUsage
//				.getParameterCharacterisation_ParameterUsage().get(0);
//		CompareExpression exp = StochasticsFactory.eINSTANCE.createCompareExpression();
//		ppc.setSpecification_RandomVariable(exp);
	}

	public Allocation getAllocation() {
		return allocation;
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	public Assembly getAssembly() {
		return assembly;
	}

	public void setAssembly(Assembly assembly) {
		this.assembly = assembly;
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public ResourceEnvironment getResourceEnvironment() {
		return resourceEnvironment;
	}

	public void setResourceEnvironment(ResourceEnvironment resourceEnvironment) {
		this.resourceEnvironment = resourceEnvironment;
	}

	public ResourceRepository getResourceRepository() {
		return resourceRepository;
	}

	public void setResourceRepository(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	public de.uka.ipd.sdq.pcm.system.System getSystem() {
		return system;
	}

	public void setSystem(de.uka.ipd.sdq.pcm.system.System system) {
		this.system = system;
	}

	public UsageModel getUsageModel() {
		return usageModel;
	}

	public void setUsageModel(UsageModel usageModel) {
		this.usageModel = usageModel;
	}

	
	public ActualAllocation getActualAllocation() {
		return actualAllocation;
	}

	public void setActualAllocation(ActualAllocation actualAllocation) {
		this.actualAllocation = actualAllocation;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	public void loadFromFiles(Properties config) {
		String filename = config.getProperty("Filename_Allocation");
		this.allocation = ((Allocation) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_Assembly");
		this.assembly = ((Assembly) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_Repository");
		this.repository = ((Repository) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_ResourceEnvironment");
		this.resourceEnvironment = ((ResourceEnvironment) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_ResourceType");
		this.resourceRepository = ((ResourceRepository) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_System");
		this.system = ((de.uka.ipd.sdq.pcm.system.System) loadFromXMIFile(filename));
		filename = config.getProperty("Filename_UsageModel");
		this.usageModel = ((UsageModel) loadFromXMIFile(filename));
	}	
	
	public void saveToFiles(String fileNamePrefix){
		fileNamePrefix = storagePath + "\\" + fileNamePrefix;
		saveToXMIFile(allocation, fileNamePrefix+".allocation");
		saveToXMIFile(assembly, fileNamePrefix+".assembly");
		saveToXMIFile(repository, fileNamePrefix+".repository");
		saveToXMIFile(resourceEnvironment, fileNamePrefix+".resourceenvironment");
		saveToXMIFile(resourceRepository, fileNamePrefix+".resourcetype");
		saveToXMIFile(system, fileNamePrefix+".system");
		saveToXMIFile(usageModel, fileNamePrefix+".usagemodel");
		
		saveToXMIFile(usage, fileNamePrefix+".usage");
		saveToXMIFile(actualAllocation, fileNamePrefix+".actualallocation");
		
	}
	
	private EObject loadFromXMIFile(String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extentions.
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
			logger.error(e.getMessage());
			System.exit(1);
		}

		//logger.debug("Loaded " + uri);

//		if (!fileName.endsWith(".assembly") &&
//		    !fileName.endsWith("repository")) {
//			// Validate the contents of the loaded resource.
//			for (Iterator j = resource.getContents().iterator(); j.hasNext();) {
//				EObject eObject = (EObject) j.next();
//				Diagnostic diagnostic = Diagnostician.INSTANCE
//						.validate(eObject);
//				if (diagnostic.getSeverity() != Diagnostic.OK) {
//					System.out.println();
//					System.out.println(diagnostic.getMessage());
//					// printDiagnostic(diagnostic, "");
//					
//				}
//			}
//		}
		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}
	
	
	private void saveToXMIFile(EObject modelToSave, String fileName) {
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
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		//logger.debug("Saved " + fileURI);
	}
	
	
	private void registerPackages(ResourceSet resourceSet) {

		resourceSet.getPackageRegistry().put(AllocationPackage.eNS_URI,
				AllocationPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(AssemblyPackage.eNS_URI,
				AssemblyPackage.eINSTANCE);
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
