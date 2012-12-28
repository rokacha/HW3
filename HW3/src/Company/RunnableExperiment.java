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

		//currentEquip= new boolean[neededEquip.size()];
		rep=_rep;
		watch=new Date();
		
	}



	@Override
	public void run() {
		System.out.println("working on exp "+exp.getID());
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
			if (timeNeeded>0) try {
				Thread.sleep(1600);
			} catch (InterruptedException ignored) {
			}
		}
		doneExpReport a=new doneExpReport(accumulatedTime,exp);
		setChanged();
		notifyObservers(a);

	}



	private void getEquip() {
		for (int i=0;i<=neededEquip.size();i++){
			
				try {
					while (!rep.getEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount())){
						System.out.println("cant get equip "+neededEquip.get(i).getType()+ " for exp "+exp.getID());
						rep.wait();
					}
				} catch (InterruptedException e) {

				}
			}
	}
/*		while(!done){
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
			}*/

	private void returnEquip() {
		/*	for(int i=0;i<currentEquip.length;i++){
			currentEquip[i]= !rep.returnEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount());	
		}*/
		for (int i=0;i<=neededEquip.size();i++){
			
			try {
				while (!rep.returnEquipment(neededEquip.get(i).getType(),neededEquip.get(i).getAmount()))
					rep.wait();
			} catch (InterruptedException e) {

			}
		}
		
	}

}
