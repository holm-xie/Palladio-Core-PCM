package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.CheckClassAdapter;

import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;
import de.uka.ipd.sdq.ByCounter.utils.PathMapper;

/**
 * The instrumentor class is the central class to apply an 
 * instrumentation to a targeted class and receive the results.

 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class Instrumenter {
	
	private ClassAdapter classAdapter = null;
	
	private String classCanonicalName;
	
	private ClassReader classReader = null;

	private ClassWriter classWriter = null;
	
	private boolean instrumentationFinished;
	
	private InstrumentationParameters instrumentationParameters;

	private byte[] instrumentedBytes;
	
	private Logger log;
	
	private long timestampAfterReaderAccept_3;
	
	private long timestampBeforeASMSetup_1;
	
	private long timestampBeforeReaderAccept_2;
	
	private long timestampBeforeReaderInitialisation_0;

	private long timestampInstrumenterInitialisation;
	
	
	private byte[] uninstrumentedBytes;

	
	/**
	 * Creates an <code>Instrumenter</code> for the specified class.
	 * @param classAsBytes The class that holds the methods that are 
	 * to be instrumented as byte array.
	 * @param parameters {@link InstrumentationParameters} instance that specifies how and what to instrument.
	 */
	public Instrumenter(
			byte[] classAsBytes, 
			InstrumentationParameters parameters) {
		this.instrumentationParameters = parameters;
		this.classReader = new ClassReader(classAsBytes);
		this.classCanonicalName = classReader.getClassName();
		this.initialize();	// needs class name
	
		// Setup instrumenting.
		this.timestampBeforeASMSetup_1 = System.nanoTime();
		setupASM();
	}
	
	/** 
	 * Creates an <code>Instrumenter</code> for the specified class.
	 * @param className The name of the class holding the methods that shall be instrumented.
	 * Needs to be fully qualified as this is used to find the correct class.
	 * @param params {@link InstrumentationParameters} instance that specifies how and what to instrument.
	 * @throws ClassNotFoundException If the specified name cannot be resolved, this exception is thrown.
	 * Check your className if you get this exception.
	 */
	public Instrumenter(
			String className, 
			InstrumentationParameters params
			) throws ClassNotFoundException{
		this.instrumentationParameters = params;
		try {
			this.classReader = new ClassReader(className);// try to get a reader for the given classname		
		} catch (IOException e) {
			this.log.error(e);
			throw new ClassNotFoundException("Could not load class with the name '" +
					className.toString() + "'.");
		}
		this.classCanonicalName = classReader.getClassName();
		this.initialize();	// needs class name

		// Setup instrumenting.
		this.timestampBeforeASMSetup_1 = System.nanoTime();
		setupASM();
	}

	/** Simple getter
	 * @return class adapter used by this instrumenter
	 */
	public ClassAdapter getClassAdapter() {
		return classAdapter;
	}

	/** Simple getter
	 * @return the canonical name of the class for which this instrumenter is responsible
	 */
	public String getClassCanonicalName() {
		return classCanonicalName;
	}

	/**
	 * Gets the name of the instrumented class.
	 * @return The internal name of the class that is instrumented.
	 * The internal name of a class is its fully qualified name (as returned by Class.getName(), where '.' are replaced by '/'.) 
	 */
	public String getClassName() {
		return this.classReader.getClassName();
	}

	/** Simple getter
	 * @return the class reader instance
	 */
	public ClassReader getClassReader() {
		return classReader;
	}

	/** Simple getter
	 * @return the class writer instance
	 */
	public ClassWriter getClassWriter() {
		return classWriter;
	}

	/** Simple getter
	 * @return the instrumentationParameters
	 */
	public InstrumentationParameters getInstrumentationParameters() {
		return instrumentationParameters;
	}

	/**
	 * Get the instrumented bytecode (before that, instrument if needed)
	 * @return A byte array containing the modified bytecode.
	 */
	public synchronized byte[] getInstrumentedBytes() {
		log.debug("getInstrumentedBytes called");
		if(!this.instrumentationFinished){
			log.error("Trying to get bytes even though instrumentation was not yet done");
		}
		return this.instrumentedBytes;
	}
	
	/** If already instrumented, return the bytesize of the instrumentation result.
	 * Otherwise, return -1.
	 * @return
	 */
	public long getInstrumentedBytesize() {
		if(this.instrumentedBytes!=null){
			return this.instrumentedBytes.length;
		}else{
			return -1L;
		}
	}
		
	/** Return the time measurements and bytesizes obtained during characterisation.
	 * @return time measurements and bytesizes in an array - see source code for details.
	 */
	public long[] getMeasurements(){
		return new long[]{
				this.timestampInstrumenterInitialisation,
				this.timestampBeforeReaderInitialisation_0, 
				this.timestampBeforeASMSetup_1, 
				this.timestampBeforeReaderAccept_2, 
				this.timestampAfterReaderAccept_3, 
				this.getUninstrumentedBytesize(),
				this.getInstrumentedBytesize()};
	}
	
	public long getTimestampAfterReaderAccept_3() {
		return timestampAfterReaderAccept_3;
	}

	public long getTimestampBeforeASMSetup_1() {
		return timestampBeforeASMSetup_1;
	}

	public long getTimestampBeforeReaderAccept_2() {
		return timestampBeforeReaderAccept_2;
	}

	public long getTimestampBeforeReaderInitialisation_0() {
		return timestampBeforeReaderInitialisation_0;
	}

	public long getTimestampInstrumenterInitialisation() {
		return timestampInstrumenterInitialisation;
	}

	public byte[] getUninstrumentedBytes() {
		return uninstrumentedBytes;
	}

	/** if uninstrumentedBytes field is not null, return it size. Otherwise,
	 * return -1.
	 * @return see method description above.
	 */
	public long getUninstrumentedBytesize() {
		if(this.uninstrumentedBytes!=null){
			return this.uninstrumentedBytes.length;
		}else{
			return -1L;
		}
	}

	/** 
	 * Initializes the instrumenters fields used for the instrumentation process
	 * and does some validity checks on the given {@link InstrumentationParameter}s.
	 */
	private void initialize() {
		PropertyConfigurator.configure("log4j.properties");
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		this.classAdapter = null;
		// do not set classReader to null - it is used already
		this.classWriter = null;
		this.timestampInstrumenterInitialisation = System.nanoTime(); //FIXME ???
		this.timestampAfterReaderAccept_3 = -1;
		this.timestampBeforeASMSetup_1 = -1;
		this.timestampBeforeReaderAccept_2 = -1;
		this.instrumentationFinished = false;
		this.instrumentedBytes = null;
		this.uninstrumentedBytes = null;
		this.timestampBeforeReaderInitialisation_0 = System.nanoTime();
		if(instrumentationParameters.getMethodsToInstrument()==null){
			log.error("Instrumenter got no methods to instrument " +
					"(methodsToInstrument instance is null");
		} else {
			// count the methods for this specific class
			int nr = 0; 
			for(int i = 0; i < instrumentationParameters.getMethodsToInstrument().size(); i++) {
				if(instrumentationParameters.getMethodsToInstrument().get(i).
						getCanonicalClassName().equals(this.getClassCanonicalName().replace('/', '.'))) {
					nr++;
				}
			}
			if(nr==0){
				log.error("Instrumenter got no methods to instrument " +
				"(methodsToInstrument size is zero");
			} else {
				log.debug("Instrumenter has "+nr+" methods to instrument");
			}
		}
	}

	/**
	 * Instrument bytecode using ASM. To get the results, call
	 * getInstrumentedBytes().
	 * @return True, when the instrumentation of all specified methods
	 * was successful, false otherwise.
	 */
	public synchronized boolean instrument() {
		MethodCountClassAdapter mcca = ((MethodCountClassAdapter) this.classAdapter); 
		
		// no methods instrumented yet; set that status
		mcca.resetMethodStatusToFalse();
		
		this.timestampBeforeReaderAccept_2 = System.nanoTime();
		
		// run the classes through the instrumentation process
		this.classReader.accept(mcca, ClassReader.EXPAND_FRAMES);
		
		// do a validity check on the resulting class
		CheckClassAdapter.verify(this.classReader, false, new PrintWriter(System.out));
		this.timestampAfterReaderAccept_3 = System.nanoTime();
		this.instrumentedBytes = this.classWriter.toByteArray();
		this.instrumentationFinished = true;
		
		// check whether all methods could be instrumented,
		// if not this is very likely an error.
		boolean retValue=true;
		String canonicalClassName;
		String thisCanonicalClassName;
		MethodDescriptor methDesc;
		for(int i = 0; i < mcca.methodInstrumentationStatus.length; i++) {
			methDesc = instrumentationParameters.getMethodsToInstrument().get(i);
			canonicalClassName = methDesc.getCanonicalClassName();
			thisCanonicalClassName = this.getClassCanonicalName().replace('/', '.');
			if(!canonicalClassName.equals(thisCanonicalClassName)) {
				// this method is from another class; skip
				log.debug("At this point (while instrumenting "+
						thisCanonicalClassName+") nothing to do with method "+
						methDesc.getMethodName()+" in class "+canonicalClassName);
				continue;
			}
			if(mcca.methodInstrumentationStatus[i] == false) {
				String message = "FAILURE while instrumenting \n"+
				instrumentationParameters.getMethodsToInstrument().get(i).toString_Linebreaks();
				log.error(message);
				String s = javax.swing.JOptionPane.showInputDialog("ERROR: "+message);
				retValue = false;
			}else{
				String message = "SUCCESS with instrumenting \n"+
				instrumentationParameters.getMethodsToInstrument().get(i).toString_Linebreaks();
				log.info(message);
//				String s = javax.swing.JOptionPane.showInputDialog("OK: "+message);
			}
		}
		// all methods were instrumented, return success.
		return retValue;
	}

	/**
	 * 
	 * @return When true, the instrumentation process has finished.
	 */
	public boolean isInstrumentationFinished() {
		return instrumentationFinished;
	}

	/**
	 * Registers a {@link ICharacterisationHook}.
	 * @see ICharacterisationHook
	 * @param hook
	 */
	public void registerCharacterisationHook(ICharacterisationHook hook) {
    	// register hooks
		MethodCountClassAdapter methodCClassAdapter = (MethodCountClassAdapter)classAdapter;
	    if(!this.classAdapter.getClass().getName().equals(MethodCountClassAdapter.class.getName())) {
			log.error("Error: Only dynamic instrumentation supports hooks.");
		} else {
			methodCClassAdapter.registerCharacterisationHook(hook);
		}
	}

	/**
	 * @param instrumentationParameters the instrumentationParameters to set
	 */
	public void setInstrumentationParameters(
			InstrumentationParameters instrumentationParameters) {
		this.instrumentationParameters = instrumentationParameters;
	}
				

	/**
	 * Constructs the ASM visitor chain.
	 * @param methodsToInstrument A List of method names in the given class to instrument.
	 */
	@SuppressWarnings("deprecation")
	private void setupASM() {
		// report which methods are being instrumented
		for(MethodDescriptor methodd 
				: instrumentationParameters.getMethodsToInstrument()) {
			if(methodd.getCanonicalClassName().equals(this.getClassCanonicalName().replace('/', '.'))) {
				log.info("Instrumenting the method '" + methodd.getMethodName()
					+ "' in the class '" + this.getClassCanonicalName() + "'.");
			}
		}
		
		// set the COMPUTE_MAXS flag for automatic stack size compution
		this.classWriter = new ClassWriter(this.classReader, ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		this.uninstrumentedBytes = this.classWriter.toByteArray();

		// Remember: the order of the visitor construction does not relate to 
		// their execution order.
		
		// Debug output (for bytecode output remove comments:
		//log.debug("The new bytecode is the following:\n");
		ClassVisitor next = this.classWriter;
	    //TODO document this ClassVisitor trace = new TraceClassVisitor(next, new PrintWriter(System.out));
	    //next = trace;
	    ClassVisitor check = new CheckClassAdapter(next);
	    next = check;
		// end Debug output
	    
	    if(!instrumentationParameters.getCountStatically()){
	    	this.classAdapter = new MethodCountClassAdapter(next, instrumentationParameters);
	    } else {
	    	this.classAdapter = new MethodSectionCountClassAdapter(next, instrumentationParameters);
	    }
	}
	
	/** TODO shift to test package...
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean test() {
		//TODO refactor to a separate class?
		
		// TODO add derivePackageTokensFromCanonicalName(canonicalName) testing!
		
		String input1 = "de.uka.ipd.sdq.ByCounter.Instrumenter.class";
		String input2 = "de.uka.ipd.sdq.ByCounter.Instrumenter";
		String input3 = "de/uka/ipd/sdq/ByCounter/Instrumenter.class";
		String input4 = "de/uka/ipd/sdq/ByCounter/Instrumenter.class";
		String input5 = "Instrumenter.class";
		String input6 = "Instrumenter";
		String input7 = "/de.uka.ipd.sdq.ByCounter.Instrumenter.class";
		String input8 = "/de/uka/ipd/sdq/ByCounter/Instrumenter.class";
		String input9 = "/Instrumenter.class";
		
		String output = "Instrumenter";
		boolean globalSuccess = true;
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input1))){
			globalSuccess=false;
			System.out.println(input1+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input2))){
			globalSuccess=false;
			System.out.println(input2+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input3))){
			globalSuccess=false;
			System.out.println(input3+" was not converted to "+output);
		}
		
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input4))){
			globalSuccess=false;
			System.out.println(input4+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input5))){
			globalSuccess=false;
			System.out.println(input5+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input6))){
			globalSuccess=false;
			System.out.println(input6+" was not converted to "+output);
		}
		
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input7))){
			globalSuccess=false;
			System.out.println(input7+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input8))){
			globalSuccess=false;
			System.out.println(input8+" was not converted to "+output);
		}
		if(!output.equals(PathMapper.deriveShortClassNameFromCanonicalName(input9))){
			globalSuccess=false;
			System.out.println(input9+" was not converted to "+output);
		}
		return globalSuccess;
	}
}
