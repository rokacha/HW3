package Company;
import java.lang.String;
import java.util.ArrayList;


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
	public synchronized boolean getEquipment(String equip, int amount){
		int place = locate(equip);
		if (place == -1) return false;
		else if (stores.get(place).getAmount()<amount) return false;
			else stores.get(place).reduce(amount);
		return true;
	}

	public synchronized void newEquip(String equip,int amount) {
		int place= locate(equip);
		if (place==-1) stores.add(new EquipmentSlot(equip,amount));
		else stores.get(place).add(amount);
		
	}

	private synchronized int locate(String equip) {
		int place=0;
		while(place<stores.size() && !stores.get(place).getType().equals(equip)) place++;
		if (place==stores.size()) place =-1;
		return place;
	}
	
}
