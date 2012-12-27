package Company;

import java.util.Vector;
import Parser.FDataReader;
/**
 * This Class Holds all the data currently Available in the Company Package.
 * Includes: current Budget,money spent,money gained,scientists bought,equipment bought,labs bought,Experiments done.
 *This thread does not need thread safety because its only updated from one source.
 * @author amit
 *
 */
public class Statistics {
	private double budget;
	private double gained;
	private double spent;
	private Vector<String> scientists;
	private Vector<String> equipment;
	private Vector<String> labs;
	private Vector<String> doneExp;
	
	public static Statistics fromFile(FDataReader r){
		return new Statistics(r.getInt());
	}
	
	public Statistics(int _budget) {
		gained=0;
		spent=0;
		scientists =new Vector<String>();
		equipment =new Vector<String>();
		labs =new Vector<String>();
		doneExp =new Vector<String>();
		budget =_budget;
	}
	
	public void iJustSpent(int num){

			spent = spent+num;
			budget = budget-num;

		
	}
	
	public void iJustEarned(double d){

			gained=gained+d;
			budget=budget+d;

	}
	
	public void boughtScientist(String sci){
	
			scientists.add(sci);
	
	}
	
	public void boughtEquipment(String equip){
	
			equipment.add(equip);
		
	}
	
	public void boughtLab(String lab){
	
			labs.add(lab);
		
	}	
	
	public void finishedExp(String exp){
		
			doneExp.add(exp);
	
	}
	public String toString(){
		
			
			StringBuilder sb = new StringBuilder();
			sb.append("The Statistics are:\n\nFinal Budget: "+budget+"\nSpent Money: "
					+spent+"\nEarned Money: "+gained+"\n\nExperiments Done:\n\n");
			for(int i=0;i<doneExp.size();i++) sb.append("\t"+doneExp.get(i)+"\n");
			sb.append("\nThe Following items were Bought:\n\n\tLabs:\n");
			for(int i=0;i<labs.size();i++) sb.append("\t\t"+labs.get(i)+"\n");
			sb.append("\n\tScientists:\n");
			for(int i=0;i<scientists.size();i++) sb.append("\t\t"+scientists.get(i)+"\n");
			sb.append("\n\tEquipment Packs:\n");
			for(int i=0;i<equipment.size();i++) sb.append("\t\t"+equipment.get(i)+"\n");
			
			return sb.toString();
		
	}
}
