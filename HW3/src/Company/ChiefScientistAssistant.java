package Company;

import java.util.Vector;
import Store.ScienceStore;
import Store.EquipmentPack;

public class ChiefScientistAssistant implements Runnable{

	private Statistics theStatistics;						// Company statistics.
	private Vector<Experiment> expList;						// Experiments List
	private ScienceStore theScienceStore;					// The science store
	private Vector<HeadOfLaboratory> labsList;				// List of labs
	private Repository theRepository;						// The repository
	
	ChiefScientistAssistant (Statistics theStatistics, Vector<Experiment> expList, ScienceStore theScienceStore, 
			Vector<HeadOfLaboratory> labsList,Repository theRepository){
		this.theStatistics=theStatistics;
		this.expList=expList;
		this.theScienceStore=theScienceStore;
		this.labsList=labsList;
		this.theRepository=theRepository;
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
				eqPack=theScienceStore.getMeEquipment(eqType, d);
				
					// If I cannot buy anymore
				if (eqPack==null){
					stopCondition=false;
					break;
				}
				
				theStatistics.iJustSpent(eqPack.getCost());
				theRepository.newEquip(eqType, eqPack.getNumOfItems());
				d=eqList.get(i).getAmount()-theRepository.getAmount(eqType);
			}
		}
		return !stopCondition;
	}
	
	
	
	
	@Override
	public void run() {
		int i,j;								// Indexes: experiments, labs.
		Experiment exp;											// The experiment to run
		HeadOfLaboratory lab=null;								// The laboratory to run it						
		
		for (i=0;i<expList.size();i++){
			if (expList.get(i).getState()==1){
				exp=expList.get(i);
				
					// Are all requirements fulfilled?
				if (!exp.getPrereq().isEmpty())
					break;					// There are still required previous experiments to run
				
					// Do we have the required lab?
				lab=null;
				for (j=0;j<labsList.size();j++)
					if (labsList.get(j).getSpecialization().equals(exp.getSpec()) && labsList.get(j).canRun()){
						lab=labsList.get(j);
							break;
						}
				if (lab==null)				// We don't have the lab, buy it
					theScienceStore.getMeLab(exp.getSpec());
				
					// Buy the required equipment
				if (!buyReqEquipment(exp))
					break;					// We don't have enough in the repository yet
				
					// Now we can run the experiment
				lab.addExp(exp);
			}
		}
		
	}
	
}
