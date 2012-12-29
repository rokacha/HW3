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
	private Vector<Integer> preq;
	private Vector<Integer> constPreq;
	private int reward;
	private int state; //1 - incomplete, 2 - in progress, 3- complete
	
public Experiment(int _ID,Vector<Integer> prereq, String _spec,Vector<EquipmentSlot> _equip, int _time,int _reward){
	
	experimentID=_ID;
	specialization=_spec;
	runTime=_time;
	reward=_reward;
	state=1;	
	preq = prereq;
	equip=(_equip);
	constPreq=new Vector<Integer>();
	if (!preq.isEmpty())
		for (int i=0;i<preq.size();i++) 
			constPreq.add(new Integer(preq.get(i)));
	
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
	Vector<Integer> vec =new Vector<Integer>(preq);
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
	while (i<preq.size()&&!found){
		if (preq.elementAt(i).intValue()==id){
			found=true;
			preq.remove(i);
		}
		i++;
	}
	
}
public String getConstPreq() {
	StringBuilder sb =new StringBuilder();
	if (!constPreq.isEmpty()){
		for (int i=0;i<constPreq.size();i++){
			sb.append(constPreq.get(i));
			if (i<constPreq.size()-1) sb.append(" , ");
		}
	}
	else sb.append("None");
	return sb.toString();
}

}
