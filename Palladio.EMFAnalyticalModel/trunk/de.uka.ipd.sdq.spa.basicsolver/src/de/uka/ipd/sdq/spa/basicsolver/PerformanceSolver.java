package de.uka.ipd.sdq.spa.basicsolver;

import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.spa.basicsolver.operations.PDFOperations;
import de.uka.ipd.sdq.spa.basicsolver.operations.RUOperations;
import de.uka.ipd.sdq.spa.basicsolver.operations.RUTableOperations;
import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Parallel;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

public class PerformanceSolver {
	
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private RUTableOperations performanceOps;
	
	private ExpressionSwitch exprSwitch = new ExpressionSwitch() {

		@Override
		public Object caseAcquire(Acquire object) {
			System.err.println("Acquire ignored in performance computation!");
			return super.caseAcquire(object);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object caseAlternative(Alternative object) {
			 
			Hashtable<ActiveResource, ManagedPDF> leftRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getLeftOption().getRegexp());
			Hashtable<ActiveResource, ManagedPDF> rightRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getRightOption().getRegexp());
			double leftProb = object.getLeftOption().getProbability();
			double rightProb = object.getRightOption().getProbability();
			return performanceOps.computeAlternative(leftRUs, leftProb , rightRUs, rightProb);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object caseLoop(Loop loop) {
			Hashtable<ActiveResource, ManagedPDF> innerRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(loop.getRegExp());
			IProbabilityMassFunction iterations = pfFactory.transformToPMF( loop.getIterationsPMF() );
			return performanceOps.computeIteration(innerRUs, iterations);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object caseParallel(Parallel object) {
			Hashtable<ActiveResource, ManagedPDF> leftRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getLeftTask());
			Hashtable<ActiveResource, ManagedPDF> rightRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getRightTask());
			return performanceOps.computeParallel(leftRUs, rightRUs);
		}

		@Override
		public Object caseRelease(Release object) {
			System.err.println("Release ignored in performance prediction!");
			return super.caseRelease(object);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object caseSequence(Sequence object) {
			Hashtable<ActiveResource, ManagedPDF> leftRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getLeftRegExp());
			Hashtable<ActiveResource, ManagedPDF> rightRUs = (Hashtable<ActiveResource, ManagedPDF>) doSwitch(object.getRightRegExp());
			return performanceOps.computeSequence(leftRUs, rightRUs);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object caseSymbol(Symbol symbol) {
			List<ResourceUsage> resourceUsageList = (List<ResourceUsage>) symbol.getResourceUsages();
			return performanceOps.getResourceUsageTimes(resourceUsageList);
		}
	};
	
	public PerformanceSolver(int numSamplingPoints){
		PDFOperations pdfOps = new PDFOperations(numSamplingPoints);
		RUOperations ruOps = new RUOperations(pdfOps);
		performanceOps = new RUTableOperations(ruOps);
	}
	
	public PerformanceSolver(RUTableOperations performanceOps){
		this.performanceOps = performanceOps;
	}

	@SuppressWarnings("unchecked")
	public Hashtable<ActiveResource, ManagedPDF> getDemandTimes(Expression expression){
		return (Hashtable<ActiveResource, ManagedPDF>) exprSwitch.doSwitch(expression);
	}

}
