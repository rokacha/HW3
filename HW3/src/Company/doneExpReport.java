package Company;

public class doneExpReport {
	private final int id;
	private final long timeTaken;
	private final long timeNeeded;
	private final double reward;
	
	public doneExpReport(long timeTaken,Experiment exp) {
		timeNeeded = exp.getRunTime();
		id = exp.getID();
		this.timeTaken = timeTaken;
		if (timeNeeded*1.15>timeTaken) reward = 0.1*exp.getReward();
		else reward = exp.getReward();
	}
	public int getId() {
		return id;
	}
	public long getTimeTaken() {
		return timeTaken;
	}
	public long getTimeNeeded() {
		return timeNeeded;
	}
	public double getReward() {
		return reward;
	}
	public String toString(){
		
		return "Experiment: "+id+"\tTimeNeeded: "+timeNeeded+
				"\tTime actually taken: "+timeTaken+"\tRewarded: "+reward;
	}
	
}
