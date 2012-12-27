import java.util.Vector;

import Company.*;
import Parser.FDataReader;
import Store.*;


public class Driver {

	/**
	 * @param args - names of files to be read in the following order:
	 *  initialData,ExperimentsList,EquipmentForSale,ScientistsForSale,LaboratoriesForSale;
	 */
	public static void main(String[] args) {
		
		// -----------------parsing----------------------------
		
		if (args.length<6) throw new RuntimeException ("Not Enough input arguments");
		String initialData=args[2];
		String experiments=args[3];
		String equipment=args[4];
		String scientists=args[5];
		String laboratories=args[6];
		
		//---------------Making The Science Store----------
		
		Vector<ItemInterface> labs = new Vector<ItemInterface>();
		Vector<ItemInterface> dudes = new Vector<ItemInterface>();
		Vector<ItemInterface> stuff = new Vector<ItemInterface>();
		FDataReader r = new FDataReader(equipment);
		while(r.hasNext())
			(new EquipmentPack(r.getString(),r.getInt(),r.getInt())).putMe(stuff);
		r.changeFile(scientists);
		while(r.hasNext())
			(new Scientist(r.getString(),r.getString(),r.getInt())).putMe(dudes);
		r.changeFile(laboratories);
		while(r.hasNext())
			(new Laboratory(r.getString(),r.getString(),r.getInt(),r.getInt())).putMe(labs);
		ScienceStore store = new ScienceStore(stuff,dudes,labs);
		
		//-------------Making The Experiment List---------------
		
		r.changeFile(experiments);
		Vector<Experiment> exp=r.getExpList();
		
		//-------------Making Statistics and Repository-----------------
		
		r.changeFile(initialData);
		r.getString(); //string should be "Budget"
		Statistics stats = new Statistics(r.getInt());
		r.getString(); //String should be "Repository"
		Repository rep =new Repository(r.getRepList());  //also reads the "laboratories" String
		
		//---------------Making The Cheif Scientist and list of Laboratories-------------
		
		ChiefScientist chief=new ChiefScientist(stats,exp,store,rep);
		Vector<HeadOfLaboratory> heads =new Vector<HeadOfLaboratory>();
		while (r.hasNext()) heads.add(new HeadOfLaboratory (r.getString(),r.getString(),r.getInt(),rep,chief));
		chief.addLabList(heads);
		
		//-----------------Running the program---------------------------
		
		chief.run();
	}
}
