package Company;

import java.util.Observable;
import java.util.Vector;
import java.util.Date;

public class RunnableExperiment extends Observable implements Runnable{

	private Experiment exp;
	private long accumulatedTime;
	private int timeNeeded;
	private final Vector<EquipmentSlot> neededEquip;
	private boolean[] currentEquip;
	private Repository rep;
	private Date watch;
	
	public RunnableExperiment(Experiment _exp,Repository _rep) {
		this.exp = _exp;
		accumulatedTime=0;
		timeNeeded=exp.getRunTime();
		neededEquip=exp.getEquip();
		currentEquip= new boolean[neededEquip.size()];
		rep=_rep;
		watch=new Date();
		
	}



	@Override
	public void run() {
		while(timeNeeded>0){
			long bef = watch.getTime();
			getEquip();
			if (timeNeeded>8) {
				try {
					Thread.sleep(800);
				} catch (InterruptedException ignored) {
				}
				timeNeeded=timeNeeded-8;
			}
			else {
				try {
					Thread.sleep(100*timeNeeded);
				} catch (InterruptedException ignored) {
				}
				timeNeeded=0;
			}
			returnEquip();
			accumulatedTime=accumulatedTime+(watch.getTime()-bef)/100;
		}
		doneExpReport a=new doneExpReport(accumulatedTime,exp);
		setChanged();
		notifyObservers(a);

	}



	private void returnEquip() {
		for(int i=0;i<currentEquip.length;i++){
			currentEquip[i]= !rep.returnEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount());	
		}
		
		
	}



	private void getEquip() {
		boolean done=false;
		boolean tmp=true;
		int i=0;
		while(!done){
			if (!currentEquip[i]){
				String name= neededEquip.get(i).getType();
				int amount= neededEquip.get(i).getAmount();
				currentEquip[i] = rep.getEquipment(name, amount);
				tmp=tmp&currentEquip[i]; //not good
			}
			i++;
			if (i==neededEquip.size()){
				i=0;
				done=tmp;
				tmp=true;
			}
		}
		
	}

}
