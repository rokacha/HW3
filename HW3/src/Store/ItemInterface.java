package Store;
import java.util.ArrayList;

/**
 * This interface represent any item that can be purchased from the store.
 * 
 * @author Hagay
 *
 */
public interface ItemInterface {
	
	public void putMe(ArrayList<ItemInterface> Here);
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
