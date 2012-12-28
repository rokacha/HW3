/**
 * 
 */
package Company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 *this class governs all the activities in a Lab like the running of experiments
 *receiving and assigning new experiments. 
 */
public class HeadOfLaboratory{
	
	private String head;
	private String specialization;
	private int numOfScientists;
	private ExecutorService exe;
	private Repository rep;
	private ChiefScientist chief;
	
	
	public HeadOfLaboratory(String head, String specialization,	int numOfScientists,Repository _rep,ChiefScientist _chief) {
		this.head = head;
		this.specialization = specialization;
		this.numOfScientists = numOfScientists;
		exe = Executors.newFixedThreadPool(numOfScientists);
		rep=_rep;
		chief=_chief;
	}

	public String getHead() {
		return head;
	}

	public String getSpecialization() {
		return specialization;
	}

	public int getNumOfScientists() {
		return numOfScientists;
	}

	public boolean canRun(){
		return (((ThreadPoolExecutor) exe).getActiveCount() < numOfScientists); //approximately true
	}

	public void addExp(Experiment exp) {
		RunnableExperiment e = new RunnableExperiment(exp,rep);
		e.addObserver(chief);
		exe.execute(e);
	}
	
	public void AddScientist(){
		shutDown();
		numOfScientists++;
		exe = Executors.newFixedThreadPool(numOfScientists);
	}
	
	public void shutDown(){
		exe.shutdown();
		try {
			exe.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException ignored) {

		}
		
	}
	
}
