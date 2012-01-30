package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;

import javax.measure.unit.Unit;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;

import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;

/**
 * Interface used to describe elements that are managed by an
 * {@link IVisualizationInputHandle}. It is important to note that the actual
 * input to an {@link IVisualization} is the {@link IVisualizationInputHandle}
 * and not implementations of this interface.
 * 
 * @author Dominik Ernst
 * 
 */
public abstract class IVisualizationInput extends Observable implements
		IDataSink {

	/**
	 * Key under which this class' name is stored in the properties.
	 */
	protected static final String ELEMENT_KEY = "elementName";

	/**
	 * The properties of this {@link IVisualizationInput}, which are persisted
	 * and displayed in the 'Display'-Tab of the Properties-View.
	 */
	protected HashMap<String, Object> properties;
	/**
	 * The {@link IVisualizationInput}'s or rather {@link IDataSink}'s
	 * predecessor.
	 */
	protected AbstractDataSource source;

	/**
	 * Returns a new Instance of the data type, which is required to display the
	 * data of this {@link IVisualizationInput}.
	 * 
	 * @return a new Instance of the data type, which is required to display the
	 *         data of this {@link IVisualizationInput}.
	 */
	public abstract Object getDataTypeInstance();

	/**
	 * Returns the Data in a Form that they can be wrapped by the type provided
	 * in {@link #getDataTypeInstance()}.
	 * 
	 * @return the Data in a Form that they can be wrapped by the type provided
	 *         in {@link #getDataTypeInstance()}.
	 */
	public abstract Object getData();

	/**
	 * Returns a list of all applied {@link AbstractTransformation}s before this
	 * {@link IVisualizationInput}.
	 * 
	 * @return the list of applied {@link AbstractTransformation} elements.
	 */
	public ArrayList<AbstractTransformation> getListOfTransformations() {
		// a list which holds all transformations (not the current datasource
		// and not the current visualization)
		ArrayList<AbstractTransformation> listOfTransformations = new ArrayList<AbstractTransformation>();
		// while it is not clear, if there are any transformations at all,
		// use the new source
		// as the direct predecessor
		AbstractDataSource previousElement = getSource();
		// if the previousElement is also an implementation of IDataSink, it
		// consequently is a transformation
		while (previousElement instanceof IDataSink) {
			AbstractTransformation previousTransformation = (AbstractTransformation) previousElement;
			listOfTransformations.add(previousTransformation);
			previousElement = previousTransformation.getSource();
		}
		return listOfTransformations;
	}

	/**
	 * Creates a copy of the transformations of this {@link IVisualizationInput}
	 * for the given {@link AbstractDataSource}. This method is used if the user
	 * adds another input to an existing {@link IVisualization}. It ensures
	 * compatibility by using the same transformations and settings for these.
	 * Returns the last element of the copied chain, which is an
	 * {@link IVisualizationInput}.
	 * 
	 * @param source
	 *            the {@link AbstractDataSource} for which the copy is created
	 * @return the last element of the copied chain.
	 */
	public IVisualizationInput createTransformationsChainCopy(
			AbstractDataSource source) {
		ArrayList<AbstractTransformation> listOfTransformations = (ArrayList<AbstractTransformation>) getListOfTransformations()
				.clone();
		// invert the list of transformations' order
		Collections.reverse(listOfTransformations);
		AbstractDataSource inputSource = source;
		// create copies of the elements, using the previously created copy as
		// each element's source
		if (!listOfTransformations.isEmpty()) {
			AbstractTransformation firstTransformation = (AbstractTransformation) listOfTransformations
					.remove(0).createCopyForSource(source);
			AbstractTransformation lastTransformation = firstTransformation;
			for (AbstractTransformation transformation : listOfTransformations) {
				lastTransformation = (AbstractTransformation) transformation
						.createCopyForSource(lastTransformation);
			}
			inputSource = lastTransformation;
		}
		return (IVisualizationInput) createCopyForSource(inputSource);

	}

	/**
	 * Returns a composite, which displays and allows to edit the specific
	 * properties for the implementing class.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @return the {@link Composite} allowing to modify this input's properties
	 */
	public abstract Composite getSpecificPropertiesComposite(Composite parent);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getSource()
	 */
	@Override
	public AbstractDataSource getSource() {
		return source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#setSource(de.uka.ipd.sdq.
	 * edp2.visualization.IDataSource)
	 */
	@Override
	public void setSource(AbstractDataSource source) {
		if (this.source != null)
			getSource().deleteObserver(this);
		this.source = source;
		source.addObserver(this);
	}

	/**
	 * Returns a default String-representation, which describes this {@link IVisualizationInput}.
	 * Further processing of this label is done by {@link IVisualizationInputHandle}s, which support multiple
	 * inputs.
	 * @return
	 */
	public String getDefaultName() {
		return source.getMeasurementsRange().getMeasurements().getMeasure().getMeasuredObject();
	}
	
	/**
	 * Returns all {@link Unit}s, which may be used by Visualizations.
	 * @return
	 */
	public Unit[] getDefaultUnits(){
		BaseMetricDescription[] metrics = MetricDescriptionUtility.toBaseMetricDescriptions(source.getMeasurementsRange().getMeasurements().getMeasure().getMetric());
		ArrayList<Unit> units = new ArrayList<Unit>();
		for (BaseMetricDescription metric : metrics){
			if (metric instanceof NumericalBaseMetricDescription){
				units.add(((NumericalBaseMetricDescription)metric).getDefaultUnit());
			}
		}
		return units.toArray(new Unit[]{});
	}

}
