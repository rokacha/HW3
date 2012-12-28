/**
 * 
 */
package Company;

import java.util.Vector;
import java.lang.String;

/**
 *This Class stores all the info an experiment hold and needs to run
 */
public class Experiment {
	
	private int experimentID;
	private String specialization;
	private int runTime;
	private Vector<EquipmentSlot> equip;
	private Vector<Integer> prerequirements;
	private int reward;
	private int state; //1 - incomplete, 2 - in progress, 3- complete
	
public Experiment(int _ID,Vector<Integer> prereq, String _spec,Vector<EquipmentSlot> _equip, int _time,int _reward){
	
	experimentID=_ID;
	specialization=_spec;
	runTime=_time;
	reward=_reward;
	state=1;	
	prerequirements = prereq;
	equip=(_equip);
	
}
public int getReward() {
	return reward;
}
public int getID(){
	return experimentID;
}

public String getSpec(){
	return specialization;
}

public Vector<Integer> getPrereq(){
	Vector<Integer> vec =new Vector<Integer>(prerequirements);
	return vec;
}

public int getState(){
	return state;
}

public int getRunTime() {
	return runTime;
}

public Vector<EquipmentSlot> getEquip() {
	Vector<EquipmentSlot> ans= new Vector<EquipmentSlot>();
	for(int i=0;i<equip.size();i++)
		ans.add(new EquipmentSlot(equip.get(i)));
	return ans;
}
public void setState(int _state){
	if (_state<4&_state>0) this.state=_state;
}

public void removePrereq(int id){
	int i=0;
	boolean found = false;
	while (i<prerequirements.size()&&!found){
		if (prerequirements.elementAt(i).intValue()==id){
			found=true;
			prerequirements.remove(i);
		}
	}
	
}
private void setEquip(Vector<EquipmentSlot> _equip) {
	
	while(!_equip.isEmpty()){
		EquipmentSlot e = _equip.remove(0);
		equip.add(e);
	}
	
}

}
