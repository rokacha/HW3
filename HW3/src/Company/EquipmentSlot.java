package Company;

import java.util.Vector;

/**
 * This class contains the pair: equipment type, amount
 * @author Hagay
 *
 */
public class EquipmentSlot {

	private String type;
	private int amount;
	
	/**
	 * Class Constructor
	 * 
	 * @param type		equipment type name
	 * @param amount	amount
	 */
	public EquipmentSlot(String type, int amount){
		this.type=type;
		this.amount=amount;
	}
	

	public EquipmentSlot(EquipmentSlot equip) {
		this.type=equip.type;
		this.amount=equip.amount;
	}


	/**
	 * Getter
	 * @return the amount in that store
	 */
	public int getAmount(){
		return amount;
	}
	
	/**
	 * Getter
	 * @return the type of the equipment in that slot
	 */
	public String getType(){
		return type;
	}
	
	
	/**
	 * add items to the slot
	 * @param a the amount of items to add
	 */
	public void add(int a){
		amount+=a;
	}
	
	/**
	 * reduce the amount of items in the slot
	 * @param r the amount to reduce
	 * @return the amount left in the slot (after reduction)
	 */
	public int reduce(int r){
		if (r>amount){
			amount=0;
			return 0;
		}
		else{
			amount-=r;
			return amount;
		}
	}

	public String toString() {
		return "There is "+amount+ " of "+type;
	}
	
}
