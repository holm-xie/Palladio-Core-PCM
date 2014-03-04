package de.uka.ipd.sdq.edp2.storage.tests;

import java.io.File;
import java.io.IOException;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.local.file.BackgroundMemoryListImpl;
import de.uka.ipd.sdq.edp2.local.file.DoubleSerializer;
import de.uka.ipd.sdq.edp2.local.file.BackgroundMemoryListImpl.BinaryRepresentation;


/**Tests the behavior of the BackgroundMemoryList and DoubleSerialiser.
 * @author Henning Groenda
 */
public class DoubleBackgroundMemoryListTest {

	private static final double MAX_DELTA = 0.1;

    private static final int LARGE_NUMBER_OF_ELEMENTS = 1000000;
	
	/** Temporary file used to serialize data. */
	private static File tempFile = null;
	/** The used serializer. */
	private static DoubleSerializer doubleSerializer = new DoubleSerializer();
	/** The used background list. */
	private static BackgroundMemoryListImpl<Double,Duration> list;
	/** Unit used for all measurements. */
	private static Unit<Duration> unit;

	@Before
	public void initializeEnvironment() throws IOException {
		tempFile = File.createTempFile(DoubleBackgroundMemoryListTest.class.getName() + "_", ".tst");
		tempFile.deleteOnExit();
		unit = SI.MILLI(SI.SECOND);
	}
	
	/**Checks if a single value can be serialized and deserialized successfully.
	 * @throws IOException
	 */
	@Test
	public void basicDeserialization() throws IOException {
		// Check list instance serialization size
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				doubleSerializer, BinaryRepresentation.DOUBLE, unit);
		assertEquals("File length of empty lists should be 0.", 0, tempFile.length());
		assertEquals("Size of empty array should be 0.", 0, list.size());
		list.add(Measure.valueOf(1.0, unit));
		assertEquals("Size of single element array should be 1.", 1, list.size());
		list.close();
		assertEquals("File length after storing and closing is the expected " +
				"product of object serialization size and number of data elements.", 
				doubleSerializer.getElementLength(), tempFile.length());
		
		// check if deserialization works with another instance
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		assertEquals("Deserilized test list must contain one element.", 1, list.size());
		assertEquals("Value before and after serialization must be the same.", 1.0, list.get(0).doubleValue(unit),MAX_DELTA);
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSizeMinusOne() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				doubleSerializer, BinaryRepresentation.DOUBLE, unit);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE - 1, 0);
		list.close();
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSize() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				doubleSerializer, BinaryRepresentation.DOUBLE, unit);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE, 0);
		list.close();
	}

	/**Checks the behavior at chunk size limit (limit - 1).
	 * @throws IOException
	 */
	@Test
	public void basicDeserializationChunkSizePlusOne() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				doubleSerializer, BinaryRepresentation.DOUBLE, unit);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE + 1, 0);
		list.close();
	}
	
	/**Creates the specified number of elements in the list, closes it, and checks if values are the same.
	 * Asserts correct file size.
	 * @param numberElements Number of data elements to create.
	 * @param valueOffset Offset to add on the values stored.
	 * @throws IOException
	 */
	public void basicDeserializationChunkSize(long numberElements, int valueOffset) throws IOException {
		long oldListSize = list.size();
		
		// create and serialize elements
		for (double i = 0; i < numberElements; i++) {
			list.add(Measure.valueOf(i + 1 + valueOffset,unit));
		}
		list.close();
		assertEquals("File length after storing and closing is expected to be the " +
				"product of object serialization size and number of data elements.", 
				doubleSerializer.getElementLength() * (numberElements + oldListSize), tempFile.length());

		// check if deserialization works with another instance
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		assertEquals("Deserialized test list must contain " + (numberElements + oldListSize) + " element(s).", 
				numberElements + oldListSize, list.size());
		for (double i = 0; i < numberElements; i++) {
			assertEquals("Value(s) before and after serialization must be the same.", 
					i + 1 + valueOffset, list.get((int) (oldListSize + i)).doubleValue(unit),MAX_DELTA);
		}
	}
	
	/**Checks the behavior for large number of elements.
	 * @throws IOException
	 */
	@Test
	public void largeNumberOfElements() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				doubleSerializer, BinaryRepresentation.DOUBLE, unit);
		basicDeserializationChunkSize(LARGE_NUMBER_OF_ELEMENTS, 0);
		list.close();
	}

	/**Checks if repetitive writing is possible. Also checks if there are errors when
	 * writing if all chunks are full.
	 * @throws IOException
	 */
	@Test
	public void repetitiveWriting() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE, 0);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE - 1, 
				2 * BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE);
		basicDeserializationChunkSize(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE + 2,
				4 * BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE);
		list.close();
	}
	
	/**Checks if an exception is throw if null Objects are added to the list.
	 * @throws IOException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void nullElementException() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.add(null);
		list.close();
	}
	
	/**Checks if empty lists are serialized and deserialized correctly.
	 * @throws IOException
	 */
	@Test
	public void noElementsInList() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		assertEquals("Size of empty list is not 0.", list.size(), 0);
		list.close();
		assertEquals("File size of empty list is not 0.", tempFile.length(), 0);
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		assertEquals("Size of empty list after deserialization is not 0.", list.size(), 0);
		list.close();
	}
	
	@Test(expected=IllegalStateException.class)
	public void noAddAfterClose() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.close();
		list.add(Measure.valueOf(1.0, unit));
	}

	@Test(expected=IllegalStateException.class)
	public void noGetAfterClose() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.close();
		list.get(1);
	}
	
	@Test(expected=IllegalStateException.class)
	public void noCloseAfterClose() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.close();
		list.close();
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void onlyPositiveIndices() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.get(-1);
		list.close();
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void keepIndicesWithinExistingElements() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		list.add(Measure.valueOf(1.1, unit));
		list.get(1);
		list.get(2);
		list.close();
	}
	
	/**Checks if the same file can be read correctly using different chunk sizes.
	 * @throws IOException
	 */
	@Test
	public void differentChunkSizes() throws IOException {
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		long numberElements = BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE + 2;
		// create and serialize elements
		for (double i = 0; i < numberElements; i++) {
			list.add(Measure.valueOf(i + 1, unit));
		}
		list.close();
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE / 4, BinaryRepresentation.DOUBLE, unit);
		assertEquals("Deserialized test list must contain " + numberElements + " element(s).", 
				numberElements, list.size(),MAX_DELTA);
		for (double i = 0; i < numberElements; i++) {
		    assertEquals("Value(s) before and after serialization must be the same.", 
					i + 1, list.get((int) i).doubleValue(unit),MAX_DELTA);
		}
		list.close();
	}
	
	@SuppressWarnings({ "static-access" })
	@Test
	public void settingElementsInList() throws IOException {
		int numberElements = list.DEFAULT_CHUNK_SIZE + 20;
		int valueOffset = 30;
		double[] values = new double[numberElements];
		// create elements
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		for (int i = 0; i < numberElements; i++) {
			values[i] = i + 1 + valueOffset;
			list.add(Measure.valueOf(values[i], unit));
		}
		// serialize
		list.close();
		
		// Check if changes are stored correctly
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		// select chunk and set value in another chunk
		list.get(0);
		double newValue = Math.random() * 100000;
		Measure<Double,Duration> oldValue;
		int positionOfChange = numberElements - 10; 
		oldValue = list.set(positionOfChange, Measure.valueOf(newValue, unit));
		assertEquals("Value must not be changed by serialization and setting a new value.",
				values[positionOfChange], oldValue.doubleValue(unit),MAX_DELTA);
		// select another chunk and look if value is stored in list
		list.get(0);
		assertEquals("Changed value not stored correctly.", 
				newValue, list.get(positionOfChange).doubleValue(unit),MAX_DELTA);
		values[positionOfChange] = newValue;
		list.close();
		
		// Check if only changed value is changed
		list = new BackgroundMemoryListImpl<Double,Duration>(tempFile.getAbsolutePath(),
				new DoubleSerializer(), BinaryRepresentation.DOUBLE, unit);
		for (int i = 0; i < numberElements; i++) {
			assertEquals("Value(s) before and after serialization must be the same.", 
					values[i], list.get(i).doubleValue(unit),MAX_DELTA);
		}
	}
}
