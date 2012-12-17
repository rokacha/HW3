package Store;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testScienceStore {
	ScienceStore store;
	
	@Before
	public void setUp() throws Exception {
	store=new ScienceStore("EquipmentForSale.txt","ScientistsForPurchase.txt","LaboratoriesForSale.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetMeLab() {
		
		int before=store.getLabsSize();
		Laboratory a =store.getMeLab("Serology"); //i know exists in there
		int after =store.getLabsSize();
		assertEquals(before-1,after);
		assertEquals("Serology",a.getSpec());
		Laboratory b= store.getMeLab("ma sheba lecha"); // i know doesnt exist
		assertNull(b);


	}

	@Test
	public void testGetMeScientist() {
		int before=store.getDudesSize();
		Scientist a = store.getMeScientist("Haematology");
		int after =store.getDudesSize();
		assertEquals(before-1,after);
		assertEquals("Haematology",a.getSpec());
		Scientist b= store.getMeScientist("ma sheba lecha"); // i know doesnt exist
		assertNull(b);
	}

	@Test
	public void testGetMeEquipment() {
		int before=store.getStuffSize();
		EquipmentPack a =store.getMeEquipment("Stirrer",1);
		int after =store.getStuffSize();
		assertEquals(before-1,after);
		assertEquals("Stirrer",a.getName());
		assertTrue(1<=a.getNumOfItems());
		EquipmentPack b= store.getMeEquipment("Nuclear warhead",1); // i hope its not there
		assertNull(b);
	}

}
