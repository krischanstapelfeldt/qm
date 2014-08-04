package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Renter;

public class BuildingTest extends TestCase {

	Renter renter;
	Entrance initialEntrance;
	ArrayList<Entrance> entrances;
	Building building;

	@Before
	public void setUp() throws Exception {
		renter = new Renter();
		building = new Building(renter, initialEntrance);
		entrances = new ArrayList<Entrance>();
		entrances.add(initialEntrance);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateBuilding()
	 * 
	 * @result create a new building with specific data. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveCreateBuilding() {

		assertEquals("", true, building);

	}

	/**
	 * testPositiveGetRenter()
	 * 
	 * @result get renter from selected building. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetRenter() {
		
		assertEquals("", renter, building.getRenter());

	}

	/**
	 * testPositiveReplaceRenter()
	 * 
	 * @result replace renter with a new renter. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveReplaceRenter() {

		Renter newRenter = new Renter();
		building.replaceRenter(newRenter);
		assertEquals("", newRenter, building.getRenter());

	}
	/**
	 * testPositiveAddEntrance()
	 * 
	 * @result add entrance to selected building. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveAddEntrance() {
		building.addEntrance(initialEntrance);
		assertEquals("", initialEntrance, building.getEntrance(0));

	}

	/**
	 * testPositiveGetEntrance()
	 * 
	 * @result get entrance from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetEntrance() {
		
		assertEquals("", initialEntrance, building.getEntrance(0));

	}

	/**
	 * testPositiveRemoveEntrance()
	 * 
	 * @result remove entrance from selected ArrayList. delete from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveRemoveEntrance() {
		
		assertEquals("", true, building.removeEntrance(0));

	}

	/**
	 * testPositiveBuildingIsEmpty()
	 * 
	 * @result get empty buildings from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveBuildingIsEmpty() {

		assertEquals("", true, building.buildingIsEmpty());

	}

	/**
	 * testPositiveGetBuilding()
	 * 
	 * @result get building with all entrances. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetBuilding() {

		assertEquals("", null, building.toString());

	}

}