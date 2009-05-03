package de.uka.ipd.sdq.ByCounter.UsingByCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
public class CountingResultDeserialisationExample {
	
	public static void main(String[] args){
		CountingResultDeserialisationExample scra = new CountingResultDeserialisationExample();
		@SuppressWarnings("unused")
		List<CountingResult> results = scra.readSerialisedCountingResults();
	}
	
	private final static String DEFAULT_PATH_WITH_SERIALISED_RESULTS = 
		"."+File.separator+"input";
	
	public List<CountingResult> readSerialisedCountingResults(){
		//Mapping between the two opcode representations
		System.out.println("Int(eger) value of opcode with name IADD: "+
				ASMOpcodesMapper.getInstance().getOpcodeInteger("IADD"));
		System.out.println("String of opcode with numeric value 50: "+
				ASMOpcodesMapper.getInstance().getOpcodeString(50));
		
		//Working with serialised bytecode counts
		System.out.println("\n"+"Entering readSerialisedCountingResults " +
				"at directory "+(new File(".")).getAbsolutePath());
		List<CountingResult> deserialisedResults = new ArrayList<CountingResult>();
		File currDir = new File(DEFAULT_PATH_WITH_SERIALISED_RESULTS);
		System.out.println("Current dir: "+currDir.getAbsolutePath());
		File currSCResultFile;
		String[] currDirContents = currDir.list();
		System.out.println(currDirContents.length+" files found.");
		for (int i = 0; i < currDirContents.length; i++) {
			if(currDirContents[i].endsWith(".SCResult")){
				System.out.println("Found");
				currSCResultFile = new File(currDir+File.separator+currDirContents[i]);
				if(!currSCResultFile.isDirectory()){
					FileInputStream fis;
					ObjectInputStream ois;
					try {
						fis = new FileInputStream(currSCResultFile);
						ois = new ObjectInputStream(fis);
						CountingResult result = (CountingResult) ois.readObject();
						System.out.println("Data parsed from serialised" +
								"CountingResult instance from file " +
								currDirContents[i]+": ");
						System.out.println("ID="+result.getID()+"");
						System.out.println("qualifying method name="+result.getQualifyingMethodName()+"");
						System.out.println("total counts="+result.getTotalOpcodeCount(true)+"");
						
						//etc.
						result.getFileType();
						result.getInputCharacterisation();
						result.getOutputCharacterisation();
						result.getMethodCallCounts();
						result.getOpcodeCounts();
						result.getOpcodeCount(50);

						System.out.println("invocation start="+result.getMethodInvocationBeginning()+"");
						System.out.println("method reporting time="+result.getMethodReportingTime()+"");
						deserialisedResults.add(result);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Error! "+currSCResultFile.getAbsolutePath());
				}
			}
		}
		return deserialisedResults;
	}
}