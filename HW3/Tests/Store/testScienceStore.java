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
		
	}

	@Test
	public void testGetMeScientist() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMeEquipment() {
		fail("Not yet implemented");
	}

}
