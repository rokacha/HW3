package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	private Scanner sc;
	private BufferedReader r;

	
	/** 
	 * Class Constructor
	 * 
	 * @param filePath			the path of the file to be opened for reading
	 * @throws FileNotFoundException 
	 */
	public FDataReader (String filePath) throws FileNotFoundException {
		_filePath=filePath;

			r=new BufferedReader(new FileReader(_filePath));
			sc=new Scanner(r);


	}
	
	
	
	public Vector<EquipmentSlot> getRepList(){

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

		Vector<Integer> ans = new Vector<Integer>();
		while (sc.hasNextInt()) {
			Integer tmp = new Integer(sc.nextInt());
			if (tmp.intValue()!=0)ans.add(tmp);
		}
		return ans;
	}


	/** 
	 * Read an integer from the file
	 * 
	 * @return The integer to be returned
	 * @throws FileNotFoundException 
	 */
	public int getInt() {

		return sc.nextInt();	
	}
	
	
	/** 
	 * Read a string from the file
	 * @return The string to be returned
	 * @throws FileNotFoundException 
	 *
	 */ 
	public String getString() {

		return sc.next();
	}
	
	/**
	 * does the file have a next item?
	 * @return true if the scanner has next
	 * @throws FileNotFoundException 
	 */
	public boolean hasNext(){

		return sc.hasNext();
	}
	/**
	 * Locates a specific entry in the file, returns true if found
	 * @param entry - a string to be looked for
	 * @return boolean (weather found or not)
	 * @throws FileNotFoundException 
	 */
	public boolean locate(String entry){
		String tmp=sc.next();
		while (sc.hasNext()&&!tmp.equals(entry))tmp=sc.next();
		return tmp.equals(entry);
	}
	
	public void close(){
		try {
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}
	
	/** 
	 * Open the file for reading
	 * @throws FileNotFoundException 
	 */
	
	public Vector<EquipmentSlot> getEquipList(){

		Vector<EquipmentSlot> ans = new Vector<EquipmentSlot>();
		while (!sc.hasNextInt()){ // if the next entry is an int the prerequirement list is done
			String tmp=sc.next();
			String type = tmp.substring(0, tmp.indexOf(','));
			int amount = (new Integer(tmp.substring( tmp.indexOf(',')+1))).intValue();
			EquipmentSlot e = new EquipmentSlot(type,amount);
			ans.add(e);
		}
		return ans;
	}
	



	public Vector<Experiment> getExpList() {
		Vector<Experiment> vec =new Vector<Experiment>();
		while (sc.hasNext()){
			int id =sc.nextInt();
			Vector<Integer> preq = getIntVec();
			String spec=sc.next();
			Vector<EquipmentSlot> needed= getEquipList();
			int time = sc.nextInt();
			int reward =  sc.nextInt();
			
			vec.add(new Experiment(id, preq, spec,needed,time ,reward));
		}
		return vec;
	}
	

}
