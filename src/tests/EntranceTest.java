package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import global.Entrance;
import junit.framework.TestCase;

public class EntranceTest extends TestCase {
	Entrance entrance;

	@Before
	public void setUp() throws Exception {
		entrance = new Entrance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositiveAddEntrance() {
		assertEquals("", true, entrance.add());
	}

	@Test
	public void testPositiveDeleteEntrance() {
		assertEquals("", true, entrance.delete());
	}

	@Test
	public void testPositiveListEntrance() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, entrance.list(id));
	}

}