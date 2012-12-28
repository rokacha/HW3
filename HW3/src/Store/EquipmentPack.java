package Store;

import java.util.Vector;

/** This class represent an equipment pack
 * 
 * @author Amit
 * 
 */

public class EquipmentPack implements ItemInterface {
	
				/* Fields
	---------------------------------------------*/
	private String name;
	private int numOfItems;
	private int cost;
	private String toStr;		// A string to return with toString
	
	
	
				/* Constructor
	---------------------------------------------*/

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
		toStr=null;
	}



	/* Inherited Methods
	 * ------------------------------------*/
	public String toString(){

		if (toStr==(null))
			toStr=name+"(" +numOfItems+")";
		return toStr;
	}
	
	
	/**
	 * Put the laboratory in it's proper place in the list of laboratories
	 */
	@Override
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
	 * @return the name of the equipment as a key string (implements the interface)
	 */
	@Override
	public String returnKey(){
		return name;
	}	
	
	/**
	 * @return the cost of the pack (implements the interface)
	 */
	@Override
	public int getCost() {
		return cost;
	}	
	
	
	
			/* Getters / Setters
	------------------------------------------------------------*/
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

}
