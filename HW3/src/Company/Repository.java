package Company;
import java.lang.String;
import java.util.Vector;


/**
 * this class holds the information of the equipment the company currently have
 */
public class  Repository {
	
	/* Stores the different types of equipment and amounts*/
	private Vector<EquipmentSlot> stores;		// The equipment currently in stores
	

		// Constructor & Factory
	// ------------------------------------------------------------------------
	/**
	 * Factory. creates a repository from file
	 * @param r			the file reader to read from
	 * @return			the repository
	 */

	
	/**
	 * Class Constructor
	 */
	public Repository(Vector<EquipmentSlot> vec){
		stores=vec;
	}
	
	
		// Queries
	// ------------------------------------------------------------------------
	/**
	 * @param equip the equipment type to search for
	 * @return the amount we have on store
	 */
	
	public synchronized int getAmount (String equip){
		int i= locate(equip);
		if (i==-1)
			return 0;		// No such equipment found
		return stores.get(i).getAmount();
	}
	
	
	
		// Actions
	// -------------------------------------------------------------------------
	
	/**
	 * reduce 'amount' items of type equip from the repository, if such amount exist.
	 * @param equip The equipment type required
	 * @param amount The amount required
	 * @return true if such amount exist, false if not (and retrieval failed).
	 */
	public synchronized boolean getEquipment(String equip, int amount){
		int i;
		
		i=locate(equip);
		if (i==-1)
			return false;			// No such item found
		if (stores.get(i).getAmount()<amount)
			return false;			// Not enough items
		stores.get(i).getEq(amount);
		notifyAll();
		return true;

		
	}
	
	/**
	 * add 'amount' items of type equip to the repository. Does not changes the total amount (in stores + in experiments)
	 * @param equip The equipment type
	 * @param amount The amount to be returned
	 * @return always return true
	 */
	public synchronized boolean returnEquipment(String equip, int amount){
		
		stores.elementAt(locate(equip)).returnEq(amount);
		notifyAll();			// Wake up all those who wait for the repository
		return true;
	}
	


	/**
	 * Add new equipment to the stores (either adding to the existing stores or creates a new slot)
	 * @param equip the equipment type
	 * @param amount the amount to add
	 */
	public synchronized boolean newEquip(String equip, int amount) {
		int i=locate(equip);
		if (i==-1)			// Creating a new slot
			stores.add(new EquipmentSlot(equip,amount));
		else		 	// Adding to an existing slot
			stores.elementAt(i).returnEq(amount);
		notifyAll();
		return true;
	}
	
	
	public String toString(){
		String str="Repository\n";
		int i;
		for (i=0;i<stores.size();i++)
			str=str+"\t"+stores.elementAt(i).toString()+"\n";
		return str;
	}
	
	private int locate(String equip) {

		int place=0;
		while(place<stores.size() && !stores.get(place).getType().equals(equip)) 
			place++;
		if (place==stores.size())place =-1;

		return place;
	}



	
	
}
