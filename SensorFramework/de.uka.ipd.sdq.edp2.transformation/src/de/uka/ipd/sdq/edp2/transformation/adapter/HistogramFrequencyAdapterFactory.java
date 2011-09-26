package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import de.uka.ipd.sdq.edp2.visualization.FactoryConnector;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;
import de.uka.ipd.sdq.edp2.visualization.editors.HistogramEditorInput;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;
/**
 * A factory for {@link HistogramFrequencyAdapter} elements. Responsible for persistance and restoring.
 * @author Dominik Ernst
 *
 */
public class HistogramFrequencyAdapterFactory extends ElementFactory {

	private static Logger logger = Logger
			.getLogger(HistogramFrequencyAdapterFactory.class
					.getCanonicalName());
	/**
	 * This factory's ID as it must be used when referenced in an extension.
	 */
	private final static String FACTORY_ID = "de.uka.ipd.sdq.edp2.visualization.adapter.HistogramFrequencyAdapterFactory";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
	 */
	@Override
	public IAdaptable createElement(IMemento memento) {
		HistogramFrequencyAdapter histogramAdapter = new HistogramFrequencyAdapter();
		
		HashMap<String, Object> restoredProperties = histogramAdapter.getProperties();
		memento = memento.getChild(restoredProperties.get(ELEMENT_KEY)
				.toString());
		//default properties are overridden with persisted properties from the memento
		overrideFromMemento(memento, restoredProperties);
		//properties are set for the restored element
		histogramAdapter.setProperties(restoredProperties);
		
		FactoryConnector factoryConnector = new FactoryConnector();
		Object sourceFactory = factoryConnector.getAdapter(memento.getString(SOURCE_KEY),
				IElementFactory.class);
		
		IDataSource createdSource = (IDataSource) ((IElementFactory) sourceFactory)
		.createElement(memento);
		
		logger.log(Level.INFO, "Created source of HistoGramFrequencyAdapter: "+createdSource.toString());
		
		createdSource.addObserver(histogramAdapter);
		histogramAdapter.setSource(createdSource);
		histogramAdapter.transformData();
		
		return histogramAdapter;
	}

	/**
	 * 
	 * @return this factory's ID.
	 */
	public static String getFactoryId() {
		return FACTORY_ID;
	}

}
