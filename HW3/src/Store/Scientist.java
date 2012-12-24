package Store;

import java.util.Vector;

import Parser.FDataReader;

/**
 * @author Amit
 */


public class Scientist implements ItemInterface {
	
	/* Private Methods
	 * -------------------------------- */
	private String name;
	private String spec;
	private int cost;
	private String toStr;
	
	
	/**
	 * Create a mercenary scientist from the file
	 * @param fd		The file reader
	 * @return			A scientist for hire! (Javadoc wonders!)
	 */
	public static Scientist fromFile(FDataReader fd){
		return new Scientist(fd.getString(),fd.getString(),fd.getInt());
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
<<<<<<< HEAD
=======
	 * Constructor
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
	
	/**
>>>>>>> branch 'master' of https://github.com/rokacha/HW3.git
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
	

	public String toString(){

		if (toStr==(null))

			toStr=name +", a "+spec+" specialist, cost "+cost;
		return toStr;
	}
	/* Interface implementation
	--------------------------------------*/
	/**
	 * Put the person in it's proper place in the list of slaves
	 */
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
}
