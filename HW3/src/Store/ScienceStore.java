package Store;

import java.util.Vector;


/**
 * this class is a container for all things buyable (equipment packages, scientists, laboratories)
 *
 */
public class ScienceStore {
	
	private Vector<Laboratory> labs;
	private Vector<Scientist> dudes;
	private Vector<EquipmentPack> stuff;
	
	public ScienceStore(){
		labs = new Vector<Laboratory>();
		dudes = new Vector<Scientist>();
		stuff = new Vector<EquipmentPack>();
	}
	
	public void addToStore(Object o){
		if (o instanceof Laboratory) labs.add((Laboratory)o);
		else if (o instanceof Scientist)	dudes.add((Scientist)o);
		else if (o instanceof EquipmentPack) stuff.add((EquipmentPack)o);
		else throw new RuntimeException ("Not a Valid ScienceStore item");
	}
	/**
	 * 
	 * @param spec -The specialization of the lab required
	 * @return a Laboratory class object (new and unused)
	 */
	public Laboratory getMeLab(String spec){
		int place = doWeHaveLab(spec);
		if (place==-1)throw new RuntimeException("Let me see if I have in the back a lab for "+spec+" ... Nope!!!");
		return labs.remove(place);
	}
	/**
	 * 
	 * @param spec -The specialization of the Scientist required
	 * @return a Scientist class object (hard working and obedient)
	 */
	public Scientist getMeScientist(String spec){
		int place = doWeHaveDude(spec);
		if (place==-1)throw new RuntimeException("Let me see if I have in the back a guy for "+spec+" ... Nope!!!");
		return dudes.remove(place);
	}
	/**
	 * 
	 * @param equip -The name of the equipment required
	 * @return an EquipmentPack class object (bill is in the mail)
	 */

	public EquipmentPack getMeEquipment(String equip){
		int place = doWeHaveStuff(equip);
		if (place==-1)throw new RuntimeException("Let me see if I have in the back a "+equip+" ... Nope!!!");
		return stuff.remove(place);
	}
	
	private int doWeHaveLab(String spec){
		int place = 0;
		while (place<labs.size()&&labs.elementAt(place).getSpec()!=spec)place++;
		if (place==labs.size())place =-1;
		return place;
	}
	
	private int doWeHaveDude(String spec){
		int place = 0;
		while (place<dudes.size()&&dudes.elementAt(place).getSpec()!=spec)place++;
		if (place==labs.size())place =-1;
		return place;
	}
	
	private int doWeHaveStuff(String equip){
		int place = 0;
		while (place<stuff.size()&&stuff.elementAt(place).getName()!=equip)place++;
		if (place==stuff.size())place =-1;
		return place;
	}
	
}
