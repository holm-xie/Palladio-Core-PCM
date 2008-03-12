package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * Replaces Harness.java from original SPEC compression
 * @author kelsaka
 *
 */
public class CompressionRunner {    
	private static Logger logger = Logger.getLogger(CompressionRunner.class);
	
    public static Source SOURCE;
    public static byte[][] COMPRESS_BUFFERS;
    public static byte[][] DECOMPRESS_BUFFERS;
    public static Compress CB;
	
	public byte[] compress(InputStream inputStream) {				
		prepareBuffers(inputStream);

		int threadID = (int)Thread.currentThread().getId();				
		return runCompress(threadID).getBuffer();
	}

	static OutputBuffer runCompress(int btid) {		
    	
	    OutputBuffer comprBuffer, decomprBufer;
	    comprBuffer = CB.performAction(SOURCE.getBuffer(),
	    		SOURCE.getLength(),
	            CB.COMPRESS,
	            COMPRESS_BUFFERS[btid - 1]);
	    /*decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
	            comprBuffer.getLength(),
	            CB.UNCOMPRESS,
	            DECOMPRESS_BUFFERS[btid - 1]);*/
        logger.info(SOURCE.getLength() + " " + SOURCE.getCRC() + " ");
        logger.info(comprBuffer.getLength() + comprBuffer.getCRC() + " ");                
        //logger.info(decomprBufer.getLength() + " " + decomprBufer.getCRC());
    
        return comprBuffer;
	}
	
    static void prepareBuffers(InputStream inputStream) {
        CB = new Compress();
        
    	SOURCE = new Source(inputStream);

        //DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        //COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        DECOMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH]; //FIXME: 20
        COMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH]; //FIXME: 20
    }

	
}
