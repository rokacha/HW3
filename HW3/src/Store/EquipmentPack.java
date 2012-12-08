package Store;

public class EquipmentPack {
	
	private String name;
	private int numOfItems;
	private int cost;
	
	public EquipmentPack(String _name,int _numOfItems,int _cost){
		name=_name;
		numOfItems=_numOfItems;
		cost=_cost;
	}
	public String getName() {
		return name;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public int getCost() {
		return cost;
	}
}
