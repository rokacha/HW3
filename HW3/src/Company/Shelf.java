/**
 * 
 */
package Company;
import java.util.Vector;
/**
 *this class simulates a storage shelf
 */
public class Shelf {
	
	private Vector<Equipment> shelf;
	private String label;
	
	public Shelf(String label) {
		this.label = label;
		shelf= new Vector<Equipment>();
	}
	
	/**
	 * 
	 * @return Equipment object
	 * @throws a "no more [NAME_OF_EQUIPMENT] " exception if the shelf is empty;
	 */
	public Equipment dispence() {
		if (!shelf.isEmpty())
			return shelf.remove(shelf.size()-1);
		else throw new RuntimeException ("no more "+label);
	}
	
	public String getLabel() {
		return label;
	}
	
	public void store(Equipment e) {
		shelf.add(e);
	}
		

}
