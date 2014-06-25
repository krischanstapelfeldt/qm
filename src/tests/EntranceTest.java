package tests;

import global.Entrance;
import junit.framework.TestCase;

public class EntranceTest extends TestCase {
	Entrance entrance;

	@Override
	public void setUp() throws Exception {
		entrance = new Entrance();
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testPositiveAddEntrance() {
		assertEquals("", true, entrance.add());
	}

	public void testPositiveDeleteEntrance() {
		assertEquals("", true, entrance.delete());
	}

	public void testPositiveListEntrance() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, entrance.list(id));
	}

}