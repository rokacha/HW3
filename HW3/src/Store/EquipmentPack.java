package Store;

import java.util.Vector;

import Parser.FDataReader;

/** This class represent an equipment pack
 * 
 * @author Amit
 * 
 */

public class EquipmentPack implements ItemInterface {
	
		/* Private Fields */
	private String name;
	private int numOfItems;
	private int cost;
	private String toStr="";		// A string to return with toString
	
	
	/**
	 * Put the laboratory in it's proper place in the list of laboratories
	 */
	public void putMe(Vector<ItemInterface> list){
		
	int i=0;
	boolean found=false;
	while(i<list.size()&&!found){
		if(list.elementAt(i).getCost()<cost){
			i++;
		}
		else if (((EquipmentPack)list.elementAt(i)).numOfItems>numOfItems){
			i++;
			}
		else found=true;
		
	
	}
	list.insertElementAt(this, i);
	}
	
	
	/** 
	 * Constructor
	 * 
	 * @param _name				Name of the item
	 * @param _numOfItems		Number of items in the pack
	 * @param _cost				Pack cost
	 */
	public EquipmentPack(String _name,int _numOfItems,int _cost){
		name=_name;
		numOfItems=_numOfItems;
		cost=_cost;
	}
	
	
	/**
	 * @return return the name
	 */
	public String getName() {
		return name;
	}	

	
	/**
	 * @return return the number of items in the pack
	 */
	public int getNumOfItems() {
		return numOfItems;
	}

	
	/**
	 * @return the cost of the pack (implements the interface)
	 */
	public int getCost() {
		return cost;
	}
	
	
	/**
	 * @return the name of the equipment as a key string (implements the interface)
	 */
	public String returnKey(){
		return name;
	}
	
	
	/**
	 * Read an equipment pack from the file
	 * 
	 * @param fd 	The FDataReader to be used to get the data
	 * @return 		The equipment pack
	 */
	public static EquipmentPack fromFile(FDataReader fd){
		return new EquipmentPack(fd.getString(),fd.getInt(),fd.getInt());
	}
	
	/**
	 * Implements the toString method.
	 */
	public String toString(){
		if (toStr=="")
			toStr=name+"(" +numOfItems+")";
		return toStr;
	}
}
