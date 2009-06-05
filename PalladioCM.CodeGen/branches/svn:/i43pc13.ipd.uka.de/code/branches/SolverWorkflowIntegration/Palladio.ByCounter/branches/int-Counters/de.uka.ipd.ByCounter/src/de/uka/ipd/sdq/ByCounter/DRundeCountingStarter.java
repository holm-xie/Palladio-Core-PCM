package de.uka.ipd.sdq.ByCounter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.execution.RuntimeMethodParameters;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.CSVResultWriter;
import de.uka.ipd.sdq.ByCounter.utils.CSVWriterAndAppender;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;
import de.uka.ipd.sdq.palladiofileshare.algorithms.SimpleLZW;

/** Tests for bytecode instrumentation.
 * Demonstrates how to use the BytecodeCounter.
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class DRundeCountingStarter {
	
	public static final Boolean COMPRESSED = true;
	public static final Boolean UNCOMPRESSED = false;
	
	public static final Boolean[] fileflags = new Boolean[]{
		UNCOMPRESSED,
		};
	
	public static final String[]  filenames = new String[]{
		"t0.pdf",
		};
	
	public static final Integer[] filesizes = new Integer[]{
		8703,  //t0
		};
	
	
	/** Tests application entry point.
	 * @param args No arguments needed or evaluated.
	 */
	public static void main(String[] args) {
		//MK TODO wozu war das?: new Thread().start();//FIXME
		//MK TODO early CountingResultCollector construction; initialize the singleton
		
		int fileIndex = 0; //compare for SimpleLZW.run_MK().variant local var
		DRundeCountingStarter cs = new DRundeCountingStarter();
		cs.runAll(fileIndex);
	}
	
	private BytecodeCounter counter;

	private Logger log;
	
	private CountingResultCollector resultColl;
	
	private String testClassName;
	
	private MethodDescriptor testMethodToExecute;
		
	private MethodDescriptor testMethodToInstrument;
	
	/**
	 * Default constructor, see source
	 */
	public DRundeCountingStarter(){
		PropertyConfigurator.configure("log4j.properties");
		this.log 					= Logger.getLogger(this.getClass().getCanonicalName());
		this.resultColl 			= CountingResultCollector.getInstance();
		this.testClassName 			= SimpleLZW.class.getCanonicalName();
		this.counter 				= new BytecodeCounter(this.testClassName);
		this.testMethodToInstrument = new MethodDescriptor("public static final byte[] lzwcompress_inlined(byte[] input, int maxDictSize)");
		this.testMethodToExecute 	= new MethodDescriptor("public void run_MK(int fileIndex)");//it is very helpful not to have any parameters here...
		log.debug("Using class "+testClassName+" " +
				"\n\t\t"+"(instrumented: "+testMethodToInstrument+", " +
				"\n\t\t"+"called: "+testMethodToExecute+").");
	}
	
	/**
	 * Performs the actual counting by calling BytecodeCounter.count(...)
	 */
	private void runAll(int fileIndex){
		
		ArrayList<MethodDescriptor> methodsToInstrument = new ArrayList<MethodDescriptor>();
		methodsToInstrument.add(this.testMethodToInstrument);
		
		//TODO clarify whether double-assigning of methods to instrument is needed or not
		InstrumentationParameters instParams = new InstrumentationParameters(
				methodsToInstrument, //list of methods to instrument
				false,	//use high registers for counting (if false, registers will be created dynamically)
				true, 	//use CountingResultCollector (if false, write directly to the HDD)
				true, 	// use array parameter recording //TODO TOTEST
				false, 	//count statically //TODO TOTEST
				-1,		//-1 is important - see docs for InstrumentationParameters
				-1 		//-1 is important - see docs for InstrumentationParameters
			);
		this.counter.setInstrumentationParams(instParams);
		log.debug(""+counter.getInstrumentationParams()/*.toString()*/);
		
		
		//TODO clarify whether double-assigning of methods to instrument is needed or not
		RuntimeMethodParameters rmp = new RuntimeMethodParameters(
				new Object[]{new Integer(fileIndex)},
				new int[]{RuntimeMethodParameters.TO_PRIMITIVE_INT});
		List<RuntimeMethodParameters> params;
		params = new ArrayList<RuntimeMethodParameters>();
		params.add(rmp);

		long start = System.nanoTime();
		this.counter.countMethods(
				methodsToInstrument, 
				testMethodToExecute, 
				params
			);
		long stop = System.nanoTime();
		long counting = stop-start;
		
		log.info(counting								+ " ns to count (aka \t"+
				Math.round((double) counting/1000)		+ " us aka \t"+
				Math.round((double) counting/1000000)	+ " ms aka \t"+
				Math.round((double) counting/1000000000)+ " s)");
		
		String resultFileNameSpecifier = ""+fileIndex;
		if(fileIndex<10){
			resultFileNameSpecifier = "0"+resultFileNameSpecifier;
		}
		resultColl.registerWriter(
				new CSVResultWriter(
						true, 	// append grand total at the end
						';',  	// char (character) for separating entries in the file 
						true, 	// listInvokeOpcodes
						true, 	// performIntegrityCheckOnInvokeOpcodes
						"DRunde."+resultFileNameSpecifier, // CSV file name "core"
						"csv", 	// CSV file name "suffix" (file extension)
						".", 	// path to CSV file
						true, 	// write booleans as integers
						false, 	// write opcodes as integers (not as String pseudonames)
						false, 	// write unused opcodes, too (i.e. those with count 0)
						true,	// truncate undefined opcodes (i.e. those with >199)
						false	// write array details to a separate file
				)
			);
		CountingResult[] finalResults = resultColl.getResultsAsArray();
		log.info(finalResults.length+" counting results found, logging them: ");
		for(CountingResult r : finalResults) {
			r.addCharacterisation(
					"Filename", 
					CSVWriterAndAppender.STRING_COLUMN_TYPE, 
					filenames[fileIndex]);
			r.addCharacterisation(
					"Filesize", 
					CSVWriterAndAppender.INTEGER_COLUMN_TYPE, 
					filesizes[fileIndex]);
			r.addCharacterisation(
					"Compressed", 
					CSVWriterAndAppender.BOOLEAN_COLUMN_TYPE, 
					fileflags[fileIndex]);
			resultColl.logResult(r); //including delegation to registered writers
		}
		// clear all collected results - they should not be output during the next run
		resultColl.clearResults();
	}
}
//TODO verify that instrumentation parameters have been set -> ODT document; 
//will be delegated to 
// countMethods(
//	List<MethodDescriptor>, 
//	MethodDescriptor, 
//  List<RuntimeMethodParameters>)
//
