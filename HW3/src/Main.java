import Company.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ScienceStore a=new ScienceStore();
		//System.out.print(a.toString());
		Statistics st=new Statistics();
		st.iJustEarned(200);
		st.iJustSpent(25);
		st.boughtEquipment("equipment blablabla");
		st.boughtLab("lab blablabla");
		st.boughtScientist("scientist blablabla");
		st.finishedExp("experiment blablabla");
		System.out.println(st.toString());

	}
}
