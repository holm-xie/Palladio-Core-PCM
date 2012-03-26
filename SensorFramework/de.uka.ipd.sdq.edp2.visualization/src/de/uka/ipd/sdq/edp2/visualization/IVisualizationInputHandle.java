/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;

/**
 * Interface for classes that are being displayed by implementations of {@link AbstractEditor}.
 * Possibly manages multiple inputs as indicated by {@link #supportsMultipleInputs()}
 * @author Dominik Ernst
 *
 */
public abstract class IVisualizationInputHandle<T extends IVisualizationInput> extends Observable implements IEditorInput, Observer, ISelection, IPersistableElement {
	
	protected HashMap<String, Object> properties;
	
	public IVisualizationInputHandle(){
		this.properties = new HashMap<String,Object>();
	}
	
	/**
	 * Method to retrieve all contained {@link IDataSink}s. These are intended to be displayed by the same
	 * {@link IVisualization}.
	 * @return the contained {@link IDataSink}s
	 */
	public abstract ArrayList<T> getInputs();
	
	/**
	 * Adds an {@link IDataSink} to this {@link IVisualizationInputHandle}'s list of inputs.
	 * @param newInput the {@link IDataSink} to add.
	 * @return <code>true</code> if the {@link IDataSink} could be added successfully.
	 */
	public abstract boolean addInput(T newInput);
	
	/**
	 * Removes an {@link IDataSink} from this {@link IVisualizationInputHandle}'s list of inputs.
	 * @param removedInput the {@link IDataSink} to add.
	 * @return <code>true</code> if the {@link IDataSink} could found and removed.
	 */
	public abstract boolean removeInput(T removedInput);
	
	/**
	 * 
	 * @return the inputs-Array's size
	 */
	public abstract int getInputsSize();
	
	/**
	 * Method to return the combined set of input data, which can be displayed by an {@link IVisualization}.
	 * @return
	 */
	public abstract Object getInputData();
	
	/**
	 * Method, which returns <true> if the {@link IVisualizationInputHandle} and its corresponding {@link AbstractEditor}
	 * are able to display multiple {@link IDataSink} objects.
	 * @return <code>true</code> if multiple inputs are supported.
	 */
	public abstract boolean supportsMultipleInputs();
	
	/**
	 * Method that returns a {@link Composite}, which is displayed in the properties view.
	 * The {@link Composite} should contain settings, that are identical for all {@link IVisualizationInput}s
	 * handled by this {@link IVisualizationInputHandle}.
	 * <br>
	 * It is suggested to use a separate bean class and databinding to link the composite (View)
	 * to this {@link IVisualizationInputHandle}'s (Control) properties' (Model)
	 * @param parent the parent {@link Composite}
	 * @return the composite showing and allowing to edit this {@link IVisualizationInput}'s display options.
	 */
	public abstract Composite getCommonPropertiesComposite(Composite parent);
	
	/**
	 * Returns the properties of this {@link IVisualizationInputHandle}. These properties
	 * are typically the same for all {@link IVisualizationInput}s managed by this handle, such as chart titles.
	 * @return the properties of this {@link IVisualizationInputHandle}
	 */
	public abstract HashMap<String, Object> getProperties();
	
	/**
	 * Overwrites the current properties with the provided {@code newProperties}; may be partial overrides, as well.
	 * @param newProperties the properties to overwrite
	 */
	public abstract void setProperties(HashMap<String, Object> newProperties);
}