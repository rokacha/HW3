package Company;

import java.util.Vector;
import Store.*;

public class ChiefScientistAssistant implements Runnable{

	private Statistics theStatistics;						// Company statistics.
	private Vector<Experiment> expList;						// Experiments List
	private ScienceStore theScienceStore;					// The science store
	private Vector<HeadOfLaboratory> labsList;				// List of labs
	private Repository theRepository;						// The repository
	private ChiefScientist chief;
	
	ChiefScientistAssistant (Statistics theStatistics, Vector<Experiment> expList, ScienceStore theScienceStore, 
			Vector<HeadOfLaboratory> labsList,Repository theRepository,ChiefScientist _chief){
		this.theStatistics=theStatistics;
		this.expList=expList;
		this.theScienceStore=theScienceStore;
		this.labsList=labsList;
		this.theRepository=theRepository;
		chief=_chief;
	}
	
	
	private boolean buyReqEquipment(Experiment exp){
		Vector<EquipmentSlot> eqList = exp.getEquip();
		int i;
		boolean stopCondition=false;
		int d;			// how much is missing
		String eqType;
		EquipmentPack eqPack;
		
			// Scan the list of required equipment. Buy until you have enough.
		for (i=0;i<eqList.size() && !stopCondition;i++){
			eqType=eqList.get(i).getType();
			d=eqList.get(i).getAmount()-theRepository.getAmount(eqType);
			while (d>0){
				eqPack=theScienceStore.getMeEquipment(eqType);
				
					// If I cannot buy anymore
				if (eqPack!=null){
					d=d-eqPack.getNumOfItems();
					theStatistics.iJustSpent(eqPack.getCost());
					theStatistics.boughtEquipment(eqPack.toString());
				}
				else break;
				synchronized(theRepository){
					while (!theRepository.newEquip(eqType, eqPack.getNumOfItems())){
						try {
							System.out.println("cant store equip "+eqType+" in rep");
							theRepository.wait();
						} catch (InterruptedException ignored){	}
					}
					theRepository.notifyAll();
				}
			}
		}
		return !stopCondition;
	}
	
	
	private void tryToStart(Experiment exp){
		HeadOfLaboratory lab=null;								// The laboratory to run it	
		
			// Do we have the required lab?
		for (int i=0;i<labsList.size();i++)
			if (labsList.get(i).getSpecialization().equals(exp.getSpec())){
				lab=labsList.get(i);
				break;
			}
		if (lab==null){				// We don't have the lab, buy it
			Laboratory l = theScienceStore.getMeLab(exp.getSpec());
			lab=new HeadOfLaboratory(l.getHead(),l.getSpec(),l.getScientists(),theRepository,chief);
			this.labsList.add(lab);
			theStatistics.iJustSpent(l.getCost());
			theStatistics.boughtLab(l.toString());
		
		}
	//	 if( !lab.canRun()){
	//		 return ;
	//	 }
		if (!buyReqEquipment(exp))			// Buy the required equipment
			return ;

			// Now we can run the experiment
		exp.setState(2);
		lab.addExp(exp);
		return ;
	}
	
	
	
	
	@Override
	public void run() {
		int i;								

		boolean stopFlag=false;				// Are we done running things?
		
		while (!stopFlag){
			stopFlag=true;
			for (i=0;i<expList.size();i++){
				if (expList.get(i).getState()!=3)
					stopFlag=false;
				if (expList.get(i).getState()==1&expList.get(i).getPrereq().isEmpty())
					tryToStart(expList.get(i));	
			}
		}
		for(i=0;i<labsList.size();i++)
			labsList.get(i).shutDown();
		System.out.println(theStatistics.toString());
		// Finished!
	}


	public void addLabList(Vector<HeadOfLaboratory> list) {
		labsList=list;
		
	}
	
}