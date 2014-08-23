package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Renter;
/**
 * This class contains the tests for the building class
 * @author Krischan Stapelfeldt
 *
 */
public class BuildingTest extends TestCase {

	DataContainer dataContainer;
	Renter renter;
	Entrance initialEntrance;
	ArrayList<Entrance> entrances;
	Building building;

	/**
	 * Ramps the necessary objects up (dataContainer, renter, building, entrance)
	 */
	@Before
	public void setUp() throws Exception {
		dataContainer = new DataContainer();
		renter = new Renter();
		building = new Building(renter, initialEntrance, dataContainer);
		entrances = new ArrayList<Entrance>();
		entrances.add(initialEntrance);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create a new building with specific data. insert into database.
	 */
	@Test
	public void testPositiveCreateBuilding() {

		assertEquals("", true, building);

	}

	/**
	 * get renter from selected building. load from database.
	 */
	@Test
	public void testPositiveGetRenter() {
		
		assertEquals("", renter, building.getRenter());

	}

	/**
	 * replace renter with a new renter. insert into database.
	 */
	@Test
	public void testPositiveReplaceRenter() {

		Renter newRenter = new Renter();
		building.setRenter(newRenter);
		assertEquals("", newRenter, building.getRenter());

	}
	/**
	 * add entrance to selected building. insert into database.
	 */
	@Test
	public void testPositiveAddEntrance() {
		building.addEntrance(initialEntrance);
		assertEquals("", initialEntrance, building.getEntrance(0));

	}

	/**
	 * get entrance from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveGetEntrance() {
		
		assertEquals("", initialEntrance, building.getEntrance(0));

	}

	/**
	 * remove entrance from selected ArrayList. delete from database.
	 */
	@Test
	public void testPositiveRemoveEntrance() {
		
		assertEquals("", true, building.removeEntrance(0));

	}

	/**
	 * get empty buildings from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveBuildingIsEmpty() {

		assertEquals("", true, building.buildingIsEmpty());

	}

	/**
	 * get building with all entrances. load from database.
	 */
	@Test
	public void testPositiveGetBuilding() {
		assertEquals("", null, building.toString());
	}

}