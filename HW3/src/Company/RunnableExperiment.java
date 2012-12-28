package Company;

import java.util.Observable;
import java.util.Vector;
import java.util.Date;

public class RunnableExperiment extends Observable implements Runnable{

	private Experiment exp;
	private long accumulatedTime;
	private int timeNeeded;
	private final Vector<EquipmentSlot> neededEquip;

	private Repository rep;
	private Date watch;
	
	public RunnableExperiment(Experiment _exp,Repository _rep) {
		this.exp = _exp;
		accumulatedTime=0;
		timeNeeded=exp.getRunTime();
		neededEquip=exp.getEquip();
		rep=_rep;
		watch=new Date();
		
	}


	@Override
	public void run() {
		
		while(timeNeeded>0){
			System.out.println("working on exp "+exp.getID() + "needed time is"+ timeNeeded);
			long bef = watch.getTime();
			getEquip();
			if (timeNeeded>8) {
				try {
					Thread.sleep(800);
				} catch (InterruptedException ignored) {
				}
				System.out.println("exp "+exp.getID()+" just ran 8 hours--");
				timeNeeded=timeNeeded-8;
			}
			else {
				try {
					Thread.sleep(100*timeNeeded);
				} catch (InterruptedException ignored) {
				}
				System.out.println("exp "+exp.getID()+" just ran "+timeNeeded+" hours");
				timeNeeded=0;
			}
			returnEquip();
			accumulatedTime=accumulatedTime+(watch.getTime()-bef)/100;
			if (timeNeeded>0) try {
				Thread.sleep(1600);
			} catch (InterruptedException ignored) {
			}
			
		}
		doneExpReport a=new doneExpReport(accumulatedTime,exp);
		setChanged();
		System.out.println("thread containing exp "+exp.getID()+" just finished");
		notifyObservers(a);
		
	}



	private void getEquip() {
		synchronized(rep){
		for (int i=0;i<neededEquip.size();i++){
				try {
					while (!rep.getEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount())){
						System.out.println("cant get equip "+neededEquip.get(i).getType()+ " for exp "+exp.getID()+" (goes to sleep)");
						rep.wait();
					}
				} catch (InterruptedException e) {

				}
			//	System.out.println(exp.getID()+"wakes up");
			}
		System.out.println("exp "+exp.getID()+" just got equipment");
		rep.notifyAll();
		
		}
	}


	private void returnEquip() {
		synchronized(rep){
			for (int i=0;i<neededEquip.size();i++){
			
				try {
					while (!rep.returnEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount()))
						rep.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("exp "+exp.getID()+" just returned equipment");
			rep.notifyAll();
		}
	}

}
