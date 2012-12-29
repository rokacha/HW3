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
	private Vector<HeadOfLaboratory> labsList;				// List of labs
	
	private ChiefScientistAssistant igor;					// There is only one Igor
	private Thread t;										// Igor thread
	
	
		// Constructor
	// -------------------------------------

	public ChiefScientist(Statistics theStatistics, Vector<Experiment> expList, ScienceStore theScienceStore,
			Repository theRepository){
		this.theStatistics=theStatistics;
		this.expList=expList;
		igor=new ChiefScientistAssistant (theStatistics, expList, theScienceStore, labsList, theRepository,this);
		t=new Thread(igor);
	}
	
	public void addLabList(Vector<HeadOfLaboratory> labsList){
		this.labsList=labsList;
		igor.addLabList(labsList);
	}
	
		// 
	public void update(Observable o, Object report_){
		
			// Update the statistics
		doneExpReport report= (doneExpReport)report_;
		theStatistics.finishedExp(report.toString());			// Update: the experiment was done
		theStatistics.iJustEarned(report.getReward());			// Update: we earned money!
		
		
			// Mark as completed
		int i;
		for (i=0;i<expList.size();i++)
			if (expList.get(i).getID()==report.getId())
			{
				expList.get(i).setState(3);			// Set to complete
				break;
			}
		
			// Remove requirements
		for (int j=0;j<expList.size();j++)
			expList.get(j).removePrereq(report.getId());
		System.out.println("chief was updated that "+report.getId()+" was done");
	}
	
	public void run(){
		t.start();
	}
}
