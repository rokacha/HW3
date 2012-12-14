package Store;

import java.util.ArrayList;
import java.util.Iterator;
import Parser.FDataReader;

/**
 * This class is a container for all things purchable item
 * 		Equipment packages
 * 		Scientists
 * 		Laboratories
 *
 * @author Amit
 */

public class ScienceStore {
	
	private ArrayList<ItemInterface> labs;
	private ArrayList<ItemInterface> dudes;
	private ArrayList<ItemInterface> stuff;
	
	
	/**
	 * Default Class Constructor
	 * No parameter needed
	 * Read the items from the files and put them in lists.
	 * 
	 */
	public ScienceStore(){
		labs = new ArrayList<ItemInterface>();
		dudes = new ArrayList<ItemInterface>();
		stuff = new ArrayList<ItemInterface>();
		
			/* Read Information from files */
		FDataReader eqReader, scReader, lbReader;
		
		eqReader=new FDataReader("EquipmentForSale.txt");
		while(eqReader.hasNext())
			stuff.add(EquipmentPack.fromFile(eqReader));
			
		scReader=new FDataReader("ScientistsForPurchase.txt");
		while(scReader.hasNext())
			dudes.add(Scientist.fromFile(scReader));
			
		lbReader = new FDataReader("LaboratoriesForSale.txt");
		while(lbReader.hasNext())
			labs.add(Laboratory.fromFile(lbReader));
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
	 * @param equip -The name of the equipment required
	 * @return an EquipmentPack class object (bill is in the mail)
	 */

	public EquipmentPack getMeEquipment(String equip){
		return (EquipmentPack)getItem(stuff,equip);
	}
	
	public int getLabsSize(){
		return labs.size() ;	
	}
	public int getDudesSize(){
		return dudes.size() ;	
	}
	public int getStuffSize(){
		return stuff.size() ;	
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
	

	private ItemInterface getItem(ArrayList<ItemInterface> itList, String key){
		
		
		
		ItemInterface item=null;
		int place=0;
		boolean found=false;
		while (place<itList.size()&&!found){
			place=place+1;
			if (itList.get(place).returnKey().equals(key)){
				item=itList.get(place);
				itList.remove(place);
				found=true;
			}
		}
		return item;		// Proper item not found
	}
	
}
