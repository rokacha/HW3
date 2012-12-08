/**
 * 
 */
package Company;

import java.util.Vector;
import java.util.concurrent.Executor;

/**
 *this class governs all the activities in a Lab like the running of experiments
 *receiving and assigning new experiments. 
 */
public class HeadOfLaboratory implements Executor{
	
	private String head;
	private String specialization;
	private int numOfScientists;
	private Vector<Thread> running;
	
	public HeadOfLaboratory(String head, String specialization,	int numOfScientists) {
		this.head = head;
		this.specialization = specialization;
		this.numOfScientists = numOfScientists;
		running= new Vector<Thread>();
	}

	public void execute(Runnable exp) {
		if ((running.size()-1)<numOfScientists){
			running.add(new Thread(exp));
			exp.run();
		}
		else throw new RuntimeException ("not enough Scientists in the lab to run "+exp.toString()+" too");
		
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
	
	
}
