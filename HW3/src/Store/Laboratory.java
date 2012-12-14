/**
 * @author Amit
 */

package Store;
import Parser.FDataReader;

public class Laboratory implements ItemInterface {

	private String head;
	private String spec;
	private int scientists;
	private int cost;
	
	/**
	 * Constructor
	 * 
	 * @param head				Head of the lab name
	 * @param spec				Lab specialization
	 * @param scientists		How many scientists comes with the lab
	 * @param cost				How much it cost
	 */
	
	public Laboratory(String head, String spec, int scientists, int cost) {
		this.head = head;
		this.spec = spec;
		this.scientists = scientists;
		this.cost = cost;
	}

	/**
	 * 
	 * @return Name of lab head
	 */
	public String getHead() {
		return head;
	}


	/**
	 * 
	 * @return Lab specialization
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * 
	 * @return Number of scientists
	 */
	public int getScientists() {
		return scientists;
	}

	/**
	 * 
	 * @return The cost of the lab
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
		return 
				spec+" Laboratory, headed by "
				+head+". Having "
				+scientists+" scientists and cost "
				+cost;
	}
	
	/**
	 * Read a 'for sale' laboratory from the file
	 * 
	 * @param fd 	The FDataReader to be used to get the data
	 * @return 		The laboratory
	 */
	public static Laboratory fromFile(FDataReader fd){
		return new Laboratory(fd.getString(),fd.getString(),fd.getInt(),fd.getInt());
	}
}
