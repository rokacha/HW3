package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import Company.EquipmentSlot;
import Company.Experiment;

/**
 * This class is used for reading data from files
 * 
 * @author Hagay
 */

/* This class is used to read data from the configuration files.
 * ------------------------------------------------------------------- */

public class FDataReader {

	private String _filePath;
	private BufferedReader bfReader;
	private Scanner sc;
	private boolean isOpen;
	
	/** 
	 * Class Constructor
	 * 
	 * @param filePath			the path of the file to be opened for reading
	 */
	public FDataReader (String filePath) {
		_filePath=filePath;
		isOpen=false;
	}
	
	
	
	public Vector<EquipmentSlot> getRepList(){
		if (!isOpen)
			open();
		Vector<EquipmentSlot> ans = new Vector<EquipmentSlot>();
		boolean go=false;
		String tmpS = sc.next();
		int tmpI = 0;
		if (!tmpS.equals("Laboratories")){
			tmpI=sc.nextInt();
			go=true;
		}
		while (go) {	// if the next entry is an int the prerequirement list is done
			ans.add(new EquipmentSlot(tmpS,tmpI));
			tmpS = sc.next();
			if (sc.hasNextInt()) tmpI=sc.nextInt();
			go =!tmpS.equals("Laboratories");
		}
		return ans;
	}
	
	
	public Vector<Integer> getIntVec() {
		if (!isOpen)
			open();
		Vector<Integer> ans = new Vector<Integer>();
		while (sc.hasNextInt()) ans.add(new Integer(sc.nextInt()));
		return ans;
	}


	/** 
	 * Read an integer from the file
	 * 
	 * @return The integer to be returned
	 */
	public int getInt(){
		if (!isOpen)
			open();
		return sc.nextInt();	
	}
	
	
	/** 
	 * Read a string from the file
	 * 
	 * @return The string to be returned
	 *
	 */ 
	public String getString(){
		if (!isOpen)
			open();
		return sc.next();
	}
	
	/**
	 * Is the file has next item?
	 * @return true if the scanner has next
	 */
	public boolean hasNext(){
		if (!isOpen)
			open();
		return sc.hasNext();
	}
	/**
	 * Locates a specific entry in the file, returns true if found
	 * @param entry - a string to be looked for
	 * @return boolean (weather found or not)
	 */
	public boolean locate(String entry){
		if (!isOpen)
			open();
		String tmp=sc.next();
		while (sc.hasNext()&&!tmp.equals(entry))tmp=sc.next();
		return tmp.equals(entry);
	}
	
	public void close(){
		if (isOpen)
		sc.close();
		isOpen=false;
	}
	
	/** 
	 * Open the file for reading
	 */
	private void open(){
		if (!isOpen) {
			try {
				bfReader = new BufferedReader(new FileReader(_filePath));
			}
			catch (FileNotFoundException e) {
				System.console().printf(_filePath," Not Found!");
			}
			sc = new Scanner(bfReader);
			isOpen=true;
		}
	}
	
	public Vector<EquipmentSlot> getEquipList(){
		if (!isOpen)
			open();
		Vector<EquipmentSlot> ans = new Vector<EquipmentSlot>();
		while (!sc.hasNextInt()) 	// if the next entry is an int the prerequirement list is done
			ans.add(new EquipmentSlot(sc.next(),sc.nextInt()));
		return ans;
	}
	public void changeFile(String file){
		if (isOpen) close();
		_filePath=file;
	}



	public Vector<Experiment> getExpList() {
		Vector<Experiment> vec =new Vector<Experiment>();
		while (sc.hasNext()) vec.add(new Experiment(sc.nextInt(), getIntVec(), sc.next(), getEquipList(), sc.nextInt(), sc.nextInt()));
		return vec;
	}
	

}
