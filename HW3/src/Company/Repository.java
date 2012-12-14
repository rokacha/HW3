package Company;
import java.lang.String;
import java.util.ArrayList;

import Unused.Equipment;
import Unused.Shelf;

/**
 * this class holds the information of the equipment the company currently have
 */
public class Repository {
	
	/* Stores the different types of equipment and amounts*/
	private ArrayList<EquipmentSlot> stores;		
	

	/**
	 * Class Constructor
	 */
	public Repository(){
		stores=new ArrayList<EquipmentSlot>();
	}
	
	
	
	/**
	 * 
	 * @param equip
	 * @return
	 */
	public boolean getEquipment(String equip, int amount){
		return true;
	}

	public void newEquip(String equip) {
		// TODO Auto-generated method stub
		
	}

	private int locate(String equip) {
		int place=0;
		while(place<stores.size() && stores.get(place).getType()!=equip) place++;
		if (place==stores.size())place =-1;
		return place;
	}
	
}
