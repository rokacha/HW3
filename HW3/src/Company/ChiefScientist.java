package Company;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import Store.*;

/**
 * 
 * @author amit
 *
 */
public class ChiefScientist implements Observer {
	
		// Private Fields
	// ------------------------------------
	private Statistics theStatistics;						// Company statistics.
	private Vector<Experiment> expList;						// Experiments List
	private ScienceStore theScienceStore;					// The science store
	private Vector<HeadOfLaboratory> labsList;				// List of labs
	private Repository theRepository;						// The repository
	
	private ChiefScientistAssistant igor;					// There is only one Igor
	
	
		// Constructor
	// -------------------------------------
	/**
	 * Class Constructor
	 * 
	 * @param iDataPath	File path for initial data
	 * @param expListPath File path for the experiments list
	 * @param eqSalePath File path for equipment for sale
	 * @param scSalePath File path for scientists for sale
	 * @param labSalePath File path for labs for sale
	 */
	public ChiefScientist(String iDataPath, String expListPath, String eqSalePath, String scSalePath, String labSalePath){
		theScienceStore = new ScienceStore(eqSalePath, scSalePath, labSalePath);			// Create the science store
		
		
		igor=new ChiefScientistAssistant (theStatistics, expList, theScienceStore, labsList, theRepository);
	}
	
		public ChiefScientist(Statistics stats, Vector<Experiment> exp,
			ScienceStore store, Repository rep) {
		// TODO Auto-generated constructor stub
	}

	// 
	public void update(Observable o, Object report_){
		
			// Update the statistics
		doneExpReport report= (doneExpReport)report_;			
		theStatistics.finishedExp(""+report.getId());			// Update: the experiment was done
		theStatistics.iJustEarned(report.getReward());			// Update: we earned money!
		
			// Remove the experiment from the list
		int i;
		for (i=0;i<expList.size();i++)
			if (expList.get(i).getID()==report.getId())
			{
				expList.get(i).setState(3);			// Set to complete
				break;
			}
			
			// Remove requirements
		for (i=0;i<expList.size();i++)
			expList.get(i).removePrereq(i);
	}
	
	public ChiefScientistAssistant thisIsIgor(){
		return igor;
	}

	public void addLabList(Vector<HeadOfLaboratory> heads) {
		// TODO Auto-generated method stub
		
	}
}
