/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;



/**
 * A HandlerFoctory is responsible for creating Handlers for Terminal,
 * Sequence, Alternative and Loop instances.
 * 
 * @author Ihssane
 *
 */
public interface HandlerFactory {
	
	SymbolHandler createSymbolHandler();
	
	SequenceHandler createSequenceHandler();
	
	AlternativeHandler createAlternativeHandler();
	
	LoopHandler createLoopHandler();
}
