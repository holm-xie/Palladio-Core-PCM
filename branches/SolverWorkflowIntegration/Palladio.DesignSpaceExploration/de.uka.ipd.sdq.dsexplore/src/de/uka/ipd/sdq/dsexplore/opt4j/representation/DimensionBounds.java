/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.genotype.Bounds;

import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision;
import de.uka.ipd.sdq.pcm.designdecision.Domain;
import de.uka.ipd.sdq.pcm.designdecision.DoubleRange;
import de.uka.ipd.sdq.pcm.designdecision.Enumeration;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.IntegerRange;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.SoapOrRmi;

class DimensionBounds implements Bounds<Double> {
	

	protected Problem problem;

	public DimensionBounds(Problem problem){
		this.problem = problem;
		
	}

	@Override
	public Double getLowerBound(int index) {
		if (IntegerRange.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())){
			return this.getLowerIntBound(index);
		} else if (DoubleRange.class.isInstance(this.problem.getDesigndecision().get(index).getDomain()) ){
			return this.getLowerDoubleBound(index);
		} else if (Enumeration.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())){
			return this.getLowerEnumerationBound(index);
		} else 
			throw new RuntimeException("Domain of design decision not supported: "+this.problem.getDesigndecision().get(index).getDomain().getClass().getName());
	}

	@Override
	public Double getUpperBound(int index) {
		if (IntegerRange.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())){
			return this.getUpperIntBound(index);
		} else if (DoubleRange.class.isInstance(this.problem.getDesigndecision().get(index).getDomain()) ){
			return this.getUpperDoubleBound(index);
		} else if (Enumeration.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())){
			return this.getUpperEnumerationBound(index);
		} else 
			throw new RuntimeException("Domain of design decision not supported: "+this.problem.getDesigndecision().get(index).getDomain().getClass().getName());
	}
	

	private Double getLowerEnumerationBound(int index) {
		//Lower bound for enumeration types is always 0.
		return 0.0;
	}
	
	private Double getUpperEnumerationBound(int index) {
		int upperEnumerationBound = 0;
		Domain domain = this.problem.getDesigndecision().get(index).getDomain();
		if (EquivalentComponents.class.isInstance(domain)){
			upperEnumerationBound = ((EquivalentComponents)domain).getRepositorycomponent().size()-1;
		} else if (AvailableServers.class.isInstance(domain)){
			upperEnumerationBound = ((AvailableServers)domain).getResourcecontainer().size()-1;
		} else if (SoapOrRmi.class.isInstance(domain)){
			upperEnumerationBound = 1;
		} else {
			throw new RuntimeException("Domain of design decision not supported: "+this.problem.getDesigndecision().get(index).getDomain().getClass().getName());
		}
		
		return new Double(upperEnumerationBound);
	}
	
	private Double getLowerDoubleBound(int index) {
		DoubleRange range = (DoubleRange)this.problem.getDesigndecision().get(index).getDomain();
		return range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + Double.MIN_VALUE;
	}

	private Double getUpperDoubleBound(int index) {
		DoubleRange range = (DoubleRange)this.problem.getDesigndecision().get(index).getDomain();
		return range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - Double.MIN_VALUE;
	}
	
	private Double getLowerIntBound(int index) {
		IntegerRange range = (IntegerRange)this.problem.getDesigndecision().get(index).getDomain();
		return Double.valueOf(range.isLowerBoundIncluded() ? range.getFrom() : range.getFrom() + 1);
	}

	private Double getUpperIntBound(int index) {
		IntegerRange range = (IntegerRange)this.problem.getDesigndecision().get(index).getDomain();
		return Double.valueOf(range.isUpperBoundIncluded() ? range.getTo() : range.getTo() - 1);
	}

	public int numberOfDimensions() {
		//here, the sizes of the arrays have to be the same!
		return this.problem.getDesigndecision().size();
	}
	
	public boolean isInteger(int index){
		return (
				Enumeration.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())
				|| IntegerRange.class.isInstance(this.problem.getDesigndecision().get(index).getDomain()));
	}
	
	public boolean isEnum(int index){
		return (
				Enumeration.class.isInstance(this.problem.getDesigndecision().get(index).getDomain())
				);
	}

}