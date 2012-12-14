/**
 * @author Amit
 */

package Store;
import Parser.FDataReader;
import java.util.Vector;

public class Laboratory implements ItemInterface {

	/* Private Fields
	 * ------------------------------------*/
	private String head;			// Name of head of laboratory
	private String spec;			// Laboratory specialization
	private int scientists;			// Number of scientists
	private int cost;				// Cost
	private String toStr="";		// A string to return with toString
	
	/* Inherited Methods
	 * ------------------------------------*/
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
	
	
	/**
	 * Put the laboratory in it's proper place in the list of laboratories
	 */
	public void putMe(Vector<ItemInterface> list){
		int i=0;
		Laboratory cmp;
		while (i<list.size()){
			cmp=(Laboratory)list.get(i);
			if (cost<cmp.getCost()){
				break;
			}
			i++;
		}
		list.add(i, this);
	}
	
	
	

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

	public String toString(){
		if (this.toStr=="")
			toStr=
				spec+" Laboratory, headed by "
				+head+". Having "
				+scientists+" scientists and cost "
				+cost;
		return toStr;
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
