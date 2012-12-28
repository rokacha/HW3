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
	
	private Vector<ItemInterface> labs;
	private Vector<ItemInterface> dudes;
	private Vector<ItemInterface> stuff;

	/**
	 * Class Constructor
	 * 
	 * Read the items details from the files and put them in the list.
	 *
	 */

	public ScienceStore(Vector<ItemInterface> _labs, Vector<ItemInterface> _dudes, Vector<ItemInterface> _stuff){

		labs =_labs;
		dudes = _dudes;
		stuff = _stuff;
		
		
	}
			
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
	 * @return an EquipmentPack class object (bill is in the mail)
	 */
	/*
	 * @pre: none
	 * @post: if spec exists in stuff -> return object of type EquipmentPack
	 * @post: if spec exists in stuff -> return object with spec as key
	 * @Post: if element was returned -> element.getNumOfItems()>=amount
	 * @post: if spec does not exist in stuff return null
	 * @post: if object (not null ) was removed, @Pre:getStuffSize()-1==@Post:getStuffSize()
	 */
	public EquipmentPack getMeEquipment(String equip, int amount){
		int i=0;
		EquipmentPack cmp=null,tmp;
		boolean found=false;
		while (i<stuff.size()&&!found){
			
			tmp=((EquipmentPack)stuff.get(i));
			if (tmp.getName().equals(equip) && (tmp.getNumOfItems()>=amount)){
				cmp=(EquipmentPack) stuff.remove(i);
				found=true;
			}
			i++;
		}
		return cmp;
	}
	/*
	 * @Pre:none
	 * @Post:none
	 */
	
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

	private ItemInterface getItem(Vector<ItemInterface> itList, String key){
		int i=0;
		ItemInterface chItem=null;
		boolean found=false;
		while (i<itList.size()&!found){
			i++;
			if (itList.get(i).returnKey().equals(key)){
				chItem=itList.get(i);
				itList.remove(i);
			}
		}
		return chItem;		// null if Proper item not found
	}
}
