package Store;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testScienceStore {
	ScienceStore store;
	
	@Before
	public void setUp() throws Exception {
	store=new ScienceStore();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetMeLab() {
		int before=store.getLabsSize();
		store.getMeLab("Serology");
		int after =store.getLabsSize();
		assertEquals(before-1,after);
	}

	@Test
	public void testGetMeScientist() {
		int before=store.getDudesSize();
		store.getMeScientist("Haematology");
		int after =store.getDudesSize();
		assertEquals(before-1,after);
	}

	@Test
	public void testGetMeEquipment() {
		int before=store.getStuffSize();
		store.getMeEquipment("Stirrer");
		int after =store.getStuffSize();
		assertEquals(before-1,after);
	}

}
