package Store;

import java.util.Vector;
import java.util.Iterator;

/**
 * This class is a container for all purchasable item
 * 		Equipment packages
 * 		Scientists
 * 		Laboratories
 *
 * @author Amit
 */

public class ScienceStore {
	
		/* Fields
	--------------------------------------------------------------------*/
	private Vector<ItemInterface> labs;
	private Vector<ItemInterface> dudes;
	private Vector<ItemInterface> stuff;

	
		/* Factories and constructors
	---------------------------------------------------------------------*/
	/**
	 * Class Constructor
	 * 
	 * Read the items details from the files and put them in the list.
	 * @throws Exception 
	 *
	 */
	public ScienceStore(Vector<ItemInterface> stuff, Vector<ItemInterface> dudes, Vector<ItemInterface> labs) throws Exception{
		this.stuff=stuff;
		this.dudes=dudes;
		this.labs=labs;
		
			// Check that all the elements in the list are from the right type
		int i;
		for (i=0;i<stuff.size();i++)
			if (! (stuff.get(i) instanceof EquipmentPack))
				throw new Exception("The element in the "+i+" place of the equipment list, is not of EquipmentPack type.");
		for (i=0;i<dudes.size();i++)
			if (! (dudes.get(i) instanceof Scientist))
				throw new Exception("The element in the "+i+" place of the scientist list, is not of Scientist type.");	
		for (i=0;i<labs.size();i++)
			if (! (labs.get(i) instanceof Laboratory))
				throw new Exception("The element in the "+i+" place of the laboratories list, is not of Laboratory type.");		
	}	
	
	
		/* Implementations
	-----------------------------------------------------------------------*/
	public String toString(){
		// This should be a pain..no sanity using it
		
		Iterator<ItemInterface> it; 
		String str="Science Store\n";
		
		str+="\tItems Packs\n";
		it= stuff.iterator();
		while (it.hasNext())
			str=str+"\t\t"+it.next().toString()+"\n";
		
		str+="\tLaboratories\n";
		it= labs.iterator();
		while (it.hasNext())
			str=str+"\t\t"+it.next().toString()+"\n";
		
		str+="\tScientists\n";
		it= labs.iterator();
		while (it.hasNext())
			str=str+"\t\t"+it.next().toString()+"\n";
		
		return str;
	}	

	
	
			/* Getters / Setters
	-------------------------------------------------------------------------*/
	
	/*
	 * @Pre:none
	 * @Post:none
	 */
	public int getLabsSize() {
		return labs.size();
	}
	/*
	 * @Pre:none
	 * @Post:none
	 */
	public int getDudesSize() {
		return dudes.size();
	}
	/*
	 * @Pre:none
	 * @Post:none
	 */
	public int getStuffSize() {
		return stuff.size();
	}	
	
	
			/* Methods
	---------------------------------------------------------------*/
		
	/**
	 * 
	 * @param spec -The specialization of the lab required
	 * @return a Laboratory class object (new and unused)
	 * 		null if the required lab does not exist
	 */
	/*
	 * @pre: none
	 * @post: if spec exists in labs -> return object with spec as key
	 * @post: if spec does not exist in labs return null
	 * @post: if object (not null ) was removed, @Pre:getLabsSize()-1==@Post:getLabsSize()
	 */
	public Laboratory getMeLab(String spec){
		return (Laboratory)getItem(labs,spec);
	}
	
	
	/**
	 * 
	 * @param spec -The specialization of the Scientist required
	 * @return a Scientist class object (hard working and obedient)
	 */
	/*
	 * @pre: none
	 * @post: if spec exists in dudes -> return object of type Scientist 
	 * @post: if spec exists in dudes -> return object with spec as key
	 * @post: if spec does not exist in dudes return null
	 * @post: if object (not null ) was removed, @Pre:getDudesSize()-1==@Post:getDudesSize()
	 */
	public Scientist getMeScientist(String spec){
		return (Scientist)getItem(dudes,spec);
	}
	
	
	/**
	 * 
	 * @param equip the name of the equipment required
	 * @param amount the amount to be returned
	 * @return an EquipmentPack class object
	 */
	/*
	 * @pre: none
	 * @post: if spec exists in stuff -> return object of type EquipmentPack
	 * @post: if spec exists in stuff -> return object with spec as key
	 * @Post: if element was returned -> element.getNumOfItems()>=amount
	 * @post: if spec does not exist in stuff return null
	 * @post: if object (not null ) was removed, @Pre:getStuffSize()-1==@Post:getStuffSize()
	 */
	public EquipmentPack getMeEquipment(String equip){
		return (EquipmentPack)getItem(stuff,equip);
	}
	/*
	 * @Pre:none
	 * @Post:none
	 */
	
	private ItemInterface getItem(Vector<ItemInterface> itList, String key){

		ItemInterface chItem=null;
		boolean found=false;
		for(int i=0;i<itList.size()&!found;i++){
			if (itList.get(i).returnKey().equals(key)){
				chItem=itList.get(i);
				itList.remove(i);
				found =true;
			}
		}
		return chItem;		// null if Proper item not found
	}
}
