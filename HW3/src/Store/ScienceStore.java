package Store;

import java.util.Vector;
import java.util.Iterator;
import Parser.FDataReader;

/**
 * This class is a container for all purchable item
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
	 */
	public ScienceStore(){
		labs = new Vector<ItemInterface>();
		dudes = new Vector<ItemInterface>();
		stuff = new Vector<ItemInterface>();
		
			/* Read Information from files */
		FDataReader eqReader, scReader, lbReader;
		
		eqReader=new FDataReader("EquipmentForSale");
		while(eqReader.hasNext())
			EquipmentPack.fromFile(eqReader).putMe(stuff);
			
		scReader=new FDataReader("ScientistsForPurchase");
		while(scReader.hasNext())
			Scientist.fromFile(scReader).putMe(dudes);
			
		lbReader = new FDataReader("LaboratoriesForSale");
		while(lbReader.hasNext())
			Laboratory.fromFile(lbReader).putMe(labs);
	}
			
	/**
	 * 
	 * @param spec -The specialization of the lab required
	 * @return a Laboratory class object (new and unused)
	 * 		null if the required lab does not exist
	 */
	public Laboratory getMeLab(String spec){
		return (Laboratory)getItem(labs,spec);
	}
	
	
	/**
	 * 
	 * @param spec -The specialization of the Scientist required
	 * @return a Scientist class object (hard working and obedient)
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

	public EquipmentPack getMeEquipment(String equip, int amount){
		int i=0;
		EquipmentPack cmp;
		while (i<stuff.size()){
			cmp=(EquipmentPack) stuff.get(i);
			if (cmp.getName()==equip && cmp.getNumOfItems()>=amount){
				stuff.remove(i);
				return cmp;
			}
		}
		return null;
	}
	
	
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
	

	private ItemInterface getItem(Vector<ItemInterface> itList, String key){
		int i=0;
		ItemInterface chItem;
		while (i<itList.size()){
			chItem=itList.get(i);
			if (chItem.returnKey()==key){
				itList.remove(i);
				return chItem;
			}
		}
		return null;		// Proper item not found
	}
}
