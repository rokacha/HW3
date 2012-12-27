import Company.*;
import Parser.FDataReader;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//parsing
		if (args.length<6) throw new RuntimeException ("Not Enough input arguments");
		String initialData=args[2];
		String experiments=args[3];
		String equipment=args[4];
		String scientists=args[5];
		String laboratories=args[6];
		int tmp=0;
		FDataReader r = new FDataReader(initialData);
		r.getString();
		tmp=r.getInt();
		Statistics stats = new Statistics(tmp);
		r.getString();
		Repository rep =new Repository(r.getEquipList());
		
	}
}
