package Unused;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import Company.Experiment;
import Company.HeadOfLaboratory;
import Company.Repository;
import Store.*;

public class Utils {
	/**
	 * @param fileName - the file to parse from, assumes the budget exists and is the first entry in the file
	 * @return Integer - The budget
	 * @throws FileNotFoundException - if filename incorrect
	 */
	public int readBudget(String fileName) throws FileNotFoundException{
		int ans=0;
		Scanner sc= reader(fileName);
		if (sc.next()=="Budget")
			ans = sc.nextInt();
		return ans;
	}
	
	/**
	 * @param fileName - the file to read from, assumes the Repository entry ends at Laboratories entry
	 * @param rep - the Repository Object to update
	 * @throws FileNotFoundException - if filename incorrect
	 */
	public void updateRepository(String fileName,Repository rep) throws FileNotFoundException{
		Scanner sc = reader(fileName);
		find (sc,"Repository");
		boolean found=false;
		while (!found){
			String item = sc.next();
			int num;
			if (item=="Laboratories")found=true;
			else{
				num=sc.nextInt();
				for (int i=0;i<num;i++)	rep.newEquip(item);
			}
		}
	}
	
	/**
	 * @param fileName - the file to read from, assumes the Laboratories entry is last in the file
	 * @return a Vector of HeadOfLaboraty Objects with the same info as in the file
	 * @throws FileNotFoundException -if filename incorrect
	 */
	public Vector<HeadOfLaboratory> updateLabs(String fileName) throws FileNotFoundException{
		Vector<HeadOfLaboratory> ans = new Vector<HeadOfLaboratory>();
		Scanner sc = reader(fileName);
		find (sc,"Laboratories");
		while (sc.hasNext()){
			String head =sc.next();
			String spec = sc.next();
			int scientists = sc.nextInt();
			ans.add(new HeadOfLaboratory(head,spec,scientists));
		}
		return ans;
	}
	
	/**
	 * Used to parse the Experiment file and get a list of all experiments according
	 * @param filename - the file to parse from , assumes each experiment comes in fixed structure
	 * @return a vector of Experiment type objects
	 * @throws FileNotFoundException - if filename incorrect
	 */
	public Vector<Experiment> getExperiments(String filename) throws FileNotFoundException{
		Vector<Experiment> ans =new Vector<Experiment>();
		Scanner sc = reader(filename);
		while (sc.hasNext()){
			String[] line = sc.nextLine().split("\t");
			
			int ID = string2Int(line[0]);
			Vector<Integer> prereq = string2IntVec(line[1]);
			String spec=line[2];
			int runTime=string2Int(line[3]);
			int reward = string2Int(line[4]);
			
			ans.add(new Experiment(ID,prereq,spec,runTime,reward));
		}
		return ans;
	}
	
	/**
	 * assumes all files follow strict structure
	 * Fills the store with goodies according to the input files
	 * @param store - ScienceStore object to be filled
	 * @param packs - a file to read the equipment packs from
	 * @param scientists - a file to read the scientists from
	 * @param labs - a file to read the labs from
	 * @throws FileNotFoundException 
	 */
	public void updateStore(ScienceStore store,String packs, String scientists, String labs) throws FileNotFoundException{
		updatePacks(store,packs);
		updatePeople(store,scientists);
		updateLabs(store,labs);
	}
	
	
	private void updateLabs(ScienceStore store, String labs) throws FileNotFoundException {
		Scanner sc = reader(labs);
		while (sc.hasNext()){
	//		store.addToStore(new Laboratory(sc.next(),sc.next(),sc.nextInt(),sc.nextInt()));
		}
		
	}

	private void updatePeople(ScienceStore store, String scientists) throws FileNotFoundException {
		Scanner sc = reader(scientists);
		while (sc.hasNext()){
		//	store.addToStore(new Scientist(sc.next(),sc.next(),sc.nextInt()));
		}
		
	}

	private void updatePacks(ScienceStore store, String packs) throws FileNotFoundException {
		Scanner sc = reader(packs);
		while (sc.hasNext()){
	//		store.addToStore(new EquipmentPack(sc.next(),sc.nextInt(),sc.nextInt()));
		}
		
	}

	private Vector<Integer> string2IntVec(String str) {
		Vector<Integer> ans = new Vector<Integer>();
		String[] tmp = str.split(" ");
		for (int i=0;i<tmp.length;i++)
			ans.add(new Integer(string2Int(tmp[i])));
		return ans;
	}

	private int string2Int(String str){
		int ans=0;
		while (str.length()>0){
			int tmp = str.charAt(1)-'0';
			ans=ans*10+tmp;
			str=str.substring(1);
		}
		return ans;
	}
	
	private void find(Scanner sc,String str){
		boolean found=false;
		while (!found)found= sc.next()==str;
	}
	
	private Scanner reader(String fileName) throws FileNotFoundException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		Scanner sc = new Scanner(r);
		return sc;
		
	}
}
