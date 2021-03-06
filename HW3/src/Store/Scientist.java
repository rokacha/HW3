package Store;

import java.util.Vector;

/**
 * @author Amit
 */


public class Scientist implements ItemInterface {
	
			/* Private Methods
	-------------------------------------------------- */
	private String name;
	private String spec;
	private int cost;
	private String toStr;
	
	
	
			/* Constructors
	-------------------------------------------------- */
	
	/**
	 * Constructor (hidden)
	 * 
	 * @param name		The name of the scientist
	 * @param spec		The scientist Specialization
	 * @param cost		How much we have to pay for him
	 */
	public Scientist(String name, String spec, int cost) {
		this.name = name;
		this.spec = spec;
		this.cost = cost;
		toStr=null;
	}
	
	
	
	/* Interface implementations
-------------------------------------------------- */	
	
	public String toString(){

		if (toStr==(null))

			toStr=name +", a "+spec+" specialist, cost "+cost;
		return toStr;
	}
	
	
	/**
	 * @return how much you have to pay him
	 */
	@Override
	public int getCost() {
		return cost;
	}
	
		
	/**
	 * @return the name of the equipment as a key string (implements the interface)
	 */
	@Override
	public String returnKey(){
		return spec;
	}
	
	
	/**
	 * Put the person in it's proper place in the list of slaves
	 */
	@Override
	public void putMe(Vector<ItemInterface> list){
		int i=0;
		Scientist cmp;
		while (i<list.size()){
			cmp=(Scientist)list.get(i);
			if (cost<cmp.getCost()){
				break;
			}
			i++;
		}
		list.add(i, this);
	}
	
	
	
			/* Getters / Setters
	---------------------------------------------------------*/
	
	/**
	 * @return	the name of the scientist
	 */
	public String getName() {
		return name;
	}	
	
	
	/**
	 * @return the specialization of the scientist
	 */
	public String getSpec() {
		return spec;
	}
}
