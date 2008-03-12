package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;

import org.apache.log4j.Logger;

public class Source {
	
	private static Logger logger = Logger.getLogger(Source.class);
	
    private byte[] buffer;
    private long crc;
    private int length;
    static int MAX_LENGTH;
    
    public Source(InputStream fileName) {
        buffer = fillBuffer(fileName);
        length = buffer.length;
        MAX_LENGTH = Math.max(length, MAX_LENGTH);        
        CRC32 crc32 = new CRC32();
        crc32.update(buffer, 0, length);
        crc = crc32.getValue();
    }
    
    public long getCRC() {
        return crc;
    }
    
    public int getLength() {
        return length;
    }
    
    public byte[] getBuffer() {
        return buffer;
    }
    
    private static byte[] fillBuffer(InputStream sif) {
        try {        	    
            ArrayList<Byte> resultList = new ArrayList<Byte>();
                       
            int value;
            while( (value = sif.read()) != -1 ) {            	            	
            	resultList.add(new Integer(value).byteValue());
            }                    
               
            return convertToByteArray(resultList);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        
        return null;
    }
    
    static private byte[] convertToByteArray(ArrayList<Byte> list) {
    	byte[] byteArray = new byte[list.size()];
    	
    	Iterator<Byte> listIterator = list.iterator();
    	int x = 0;
    	while(listIterator.hasNext()) {
    		byteArray[x] = listIterator.next(); 
    		x++;
    	}
    	
    	return byteArray;    	
    }
}
