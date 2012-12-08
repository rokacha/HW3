/**
 * 
 */
package Store;

public class Laboratory {
	private String head;
	private String spec;
	private int scientists;
	private int cost;
	
	
	public Laboratory(String head, String spec, int scientists, int cost) {
		this.head = head;
		this.spec = spec;
		this.scientists = scientists;
		this.cost = cost;
	}


	public String getHead() {
		return head;
	}


	public String getSpec() {
		return spec;
	}


	public int getScientists() {
		return scientists;
	}


	public int getCost() {
		return cost;
	}

}
