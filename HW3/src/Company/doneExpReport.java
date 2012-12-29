package Company;

public class doneExpReport {
	private final int id;
	private final double timeTaken;
	private final double timeNeeded;
	private final double reward;
	private final String preq;
	
	public doneExpReport(double accumulatedTime,Experiment exp,String _preq) {
		timeNeeded = exp.getRunTime();
		id = exp.getID();
		this.timeTaken = accumulatedTime;
		if (timeNeeded*1.15<accumulatedTime) reward = 0.1*exp.getReward();
		else reward = exp.getReward();
		preq=_preq;
	}
	public int getId() {
		return id;
	}
	public double getTimeTaken() {
		return timeTaken;
	}
	public double getTimeNeeded() {
		return timeNeeded;
	}
	public double getReward() {
		return reward;
	}
	public String toString(){
		
		return "Experiment: "+id+" Requireded Experiments: "+preq+" \tTimeNeeded: "+timeNeeded+
				" \tTime actually taken: "+timeTaken+" \tRewarded: "+reward;
	}
	
}
