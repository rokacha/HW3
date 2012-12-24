package Company;

import java.util.Vector;

import Store.*;





import
/**
 * 
 * @author amit
 *
 */
public class ChiefScientist {
	
		// Private Fields
	// ------------------------------------
	private Statistics theStatistics;						// Company statistics.
	private Vector<Experiment> expList;						// Experiments List
	private ScienceStore theScienceStore;					// The science store
	private Vector<HeadOfLaboratory> labsList;				// List of labs
	private Repository theRepository;						// The repository
	
	
	
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
	}
}

