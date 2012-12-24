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
<<<<<<< HEAD
	private String toStr;		// A string to return with toString
=======
	private String toStr;			// A string to return with toString
>>>>>>> branch 'master' of https://github.com/rokacha/HW3.git
	
	/**
	 * Read a 'for sale' laboratory from the file
	 * 
	 * @param fd 	The FDataReader to be used to get the data
	 * @return 		The laboratory
	 */
	public static Laboratory fromFile(FDataReader fd){
		return new Laboratory(fd.getString(),fd.getString(),fd.getInt(),fd.getInt());
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
		toStr=null;
	}


	/* Inherited Methods
	 * ------------------------------------*/
	/**
	 * 
	 * @return The cost of the lab
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
	
	
<<<<<<< HEAD
=======
	/**
	 * Put the laboratory in it's proper place in the list of laboratories
	 */
	@Override
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
		toStr=null;
	}

>>>>>>> branch 'master' of https://github.com/rokacha/HW3.git
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


	public String toString(){
<<<<<<< HEAD
		if (toStr==""|toStr==null)
=======
		if (toStr.equals(null))
>>>>>>> branch 'master' of https://github.com/rokacha/HW3.git
			toStr=
				spec+" Laboratory, headed by "
				+head+". Having "
				+scientists+" scientists and cost "
				+cost;
		return toStr;
	}
}
