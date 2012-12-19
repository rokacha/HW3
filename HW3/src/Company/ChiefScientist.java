package Company;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import Parser.FDataReader;
import Store.ScienceStore;

/**
 * 
 * @author amit
 *
 */
public class ChiefScientist implements Observer {

	private Vector<HeadOfLaboratory> labs;
	private Vector<Experiment> exp;
	private Statistics stats;
	private ScienceStore scienceRus;
	private Repository rep;
	private Thread bob;
	
	
	public ChiefScientist(String equip,String scien,String laboratories,String initial,String experiments) {
		scienceRus= new ScienceStore(equip,scien,laboratories);
		stats= new Statistics();
		rep= new Repository();
		bob = new Thread(new ChiefScientistAssistant());
		labs= new Vector<HeadOfLaboratory>();
		exp = new Vector<Experiment>();
		readFromFile();
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	private void readFromFile() {
		FDataReader reader = new FDataReader("InitialData.txt");
		if (reader.locate("Laboratories")){
			while (reader.hasNext()){
				String head=reader.getString();
				String spec=reader.getString();
				int numOfScientists=reader.getInt();
				labs.add(new HeadOfLaboratory(head,spec,numOfScientists, rep,this));
			}
		}
		reader.close();
		reader = new FDataReader("ExperimentList.txt"); 
		while (reader.hasNext()){
			int id = reader.getInt();
			Vector<Integer> prereq = reader.getIntVec();
			String spec= reader.getString();
			Vector<EquipmentSlot> equip = reader.getEquipList();
			int time = reader.getInt();
			int reward = reader.getInt();
			exp.add(new Experiment(id,prereq,spec,equip,time,reward));
		}
		reader.close();
	}

}
