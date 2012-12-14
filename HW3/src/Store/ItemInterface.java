package Store;
import java.util.Vector;

/**
 * This interface represent any item that can be purchased from the store.
 * 
 * @author Hagay
 *
 */
public interface ItemInterface {
	
	
	/**
	 * Put the item in it's correct place inside itemList
	 * @param itemList the list list to put the item in
	 */
	public void putMe(Vector<ItemInterface> itemList);
	
	
	/**
	 * Returns the cost of the item
	 * 
	 * @return
	 */
	public int getCost();
	
	
	/**
	 * This function return the key by which this object should be searched.
	 * 
	 * @return The key string
	 */
	public String returnKey();
	
}
