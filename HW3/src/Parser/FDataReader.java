package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class is used for reading data from files
 * 
 * @author Hagay
 */

/* This class is used to read data from the configuration files.
 * ------------------------------------------------------------------- */

public class FDataReader {

	/** 
	 * Class Constructor
	 * 
	 * @param filePath			the path of the file to be opened for reading
	 */
	public FDataReader (String filePath) {
		_filePath=filePath;
		isOpen=false;
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
	
	private String _filePath;
	private BufferedReader bfReader;
	private Scanner sc;
	private boolean isOpen;
}
