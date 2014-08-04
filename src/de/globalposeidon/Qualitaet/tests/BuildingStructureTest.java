package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.BuildingStructure;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Renter;

public class BuildingStructureTest extends TestCase {

	Building initialBuilding;
	BuildingStructure buildingStructure;

	@Before
	public void setUp() throws Exception {
		buildingStructure = new BuildingStructure(initialBuilding);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateBuildingStructure()
	 * 
	 * @result create a new buildingstructure with specific data. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveCreateBuildingStructure() {

		assertEquals("", null, buildingStructure);

	}

	/**
	 * testPositiveAddBuilding()
	 * 
	 * @result add building to selected buildingstructure. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveAddBuilding() {
		buildingStructure.addBuilding(initialBuilding);
		assertEquals("", initialBuilding, buildingStructure.getBuilding(0));

	}

	/**
	 * testPositiveGetBuilding()
	 * 
	 * @result get building from selected buildingstructure. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetBuilding() {
		
		assertEquals("", initialBuilding, buildingStructure.getBuilding(0));

	}

	/**
	 * testPositiveRemoveBuilding()
	 * 
	 * @result remove building from selected buildingstructure. delete from database.
	 * @author ks
	 */
	@Test
	public void testPositiveRemoveBuilding() {
		
		assertEquals("", true, buildingStructure.removeBuilding(0));

	}

	/**
	 * testPositiveGetBuildingStructure()
	 * 
	 * @result get buildingstructure with all buildings. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetBuildingStructure() {

		assertEquals("", "", buildingStructure.toString());

	}

}