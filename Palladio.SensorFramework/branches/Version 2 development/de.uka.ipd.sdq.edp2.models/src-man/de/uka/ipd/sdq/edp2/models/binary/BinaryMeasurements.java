/**
 * 
 */
package de.uka.ipd.sdq.edp2.models.binary;

import java.util.List;
import java.util.RandomAccess;

import javax.measure.Measure;

/**Model for accessing binary measurements.
 * @author groenda
 * @param <T> Type of measurements stored.
 */
public interface BinaryMeasurements<T extends Measure<?, ?>> extends RandomAccess, List<T> {
}