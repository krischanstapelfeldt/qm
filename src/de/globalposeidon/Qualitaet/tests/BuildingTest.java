package de.globalposeidon.Qualitaet.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Building;
import junit.framework.TestCase;

public class BuildingTest extends TestCase {
	Building building;

	@Before
	public void setUp() throws Exception {
		building = new Building();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositiveAddBuilding() {
		assertEquals("", true, building.add());
	}

	@Test
	public void testPositiveDeleteBuilding() {
		assertEquals("", true, building.delete());
	}

	@Test
	public void testPositiveListBuilding() {
		int[] i = null;
		assertEquals("", i, building.list());
	}

}