package Company;
import java.lang.String;
import java.util.Vector;

/**
 * this class holds the information of the equipment the company currently have
 */
public class Repository {

	private Vector<Shelf> closet;
	
	public Repository(){
		closet = new Vector<Shelf>();
	} 
	
	public Equipment dispence(String equip){
		int place = locate(equip);
		if (place==-1){
			newEquip(equip);
			throw new RuntimeException ("no " + equip + " in stock");
		}
		else return closet.elementAt(place).dispence();
	}

	public void newEquip(String equip) {
		// TODO Auto-generated method stub
		
	}

	private int locate(String equip) {
		int place=0;
		while(place<closet.size() && closet.elementAt(place).getLabel()!=equip) place++;
		if (place==closet.size())place =-1;
		return place;
	}
	
}
