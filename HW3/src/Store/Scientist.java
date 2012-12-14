package Store;

import java.util.ArrayList;

import Parser.FDataReader;

/**
 * @author Amit
 */


public class Scientist implements ItemInterface {
	
	private String name;
	private String spec;
	private int cost;
	
	
	/**
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
	}
	
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
	
	/**
	 * @return how much you have to pay him
	 */
	public int getCost() {
		return cost;
	}
	
	
	/**
	 * @return the name of the equipment as a key string (implements the interface)
	 */
	public String returnKey(){
		return spec;
	}
	
	
	public String toString(){
		return name +", a "+spec+" specialist, cost "+cost;
	}
	/**
	 * Create a mercenary scientist from the file
	 * @param fd		The file reader
	 * @return			A scientist for hire! (Javadoc wonders!)
	 */
	public static Scientist fromFile(FDataReader fd){
		return new Scientist(fd.getString(),fd.getString(),fd.getInt());
	}

	@Override
	public void putMe(ArrayList<ItemInterface> Here) {
		// TODO Auto-generated method stub
		
	}
}
