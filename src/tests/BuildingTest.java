package tests;

import global.Building;
import junit.framework.TestCase;

public class BuildingTest extends TestCase {
	Building building;

	@Override
	public void setUp() throws Exception {
		building = new Building();
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testPositiveAddBuilding() {
		assertEquals("", true, building.add());
	}

	public void testPositiveDeleteBuilding() {
		assertEquals("", true, building.delete());
	}

	public void testPositiveListBuilding() {
		int[] i = null;
		assertEquals("", i, building.list());
	}

}