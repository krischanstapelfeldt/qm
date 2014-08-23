package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
/**
 * This class contains the tests for the entrance class
 * @author Krischan Stapelfeldt
 *
 */
public class EntranceTest extends TestCase {

	Entrance entranceWithApartment;
	Entrance entranceWithApartmentAndMeter;
	DataContainer dataContainer;
	Building building;
	Apartment initialApartment;
	Meter initialMeter;
	ArrayList<Meter> meters;
	ArrayList<Apartment> apartments;

	/**
	 * Ramps the necessary objects up (dataContainer, building, meters, entrance, apartment)
	 */
	@Before
	public void setUp() throws Exception {
		dataContainer = new DataContainer();
		building = new Building(dataContainer);
		meters = new ArrayList<Meter>();
		apartments = new ArrayList<Apartment>();
		entranceWithApartment = new Entrance(initialApartment,building);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create two new entrances. one with specific data, one with empty
	 *         data. insert into database.
	 */
	@Test
	public void testPositiveCreateEntrance() {

		assertEquals("", null, entranceWithApartment);
		assertEquals("", null, entranceWithApartmentAndMeter = new Entrance(initialApartment,initialMeter,building));

	}

	/**
	 * add meter to selected ArrayList. insert into database.
	 */
	@Test
	public void testPositiveAddMeter() {
		
		assertEquals("", null, meters.add(initialMeter));

	}

	/**
	 * get meter from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveGetMeter() {

		assertEquals("", initialMeter, meters.get(0));

	}
	/**
	 * remove meter from selected ArrayList. delete from database.
	 */
	@Test
	public void testPositiveRemoveMeter() {

		assertEquals("", null, meters.remove(0));

	}

	/**
	 * add apartment to selected ArrayList. insert into database.
	 */
	@Test
	public void testPositiveAddApartment() {

		assertEquals("", null, apartments.add(initialApartment));

	}

	/**
	 * get apartment from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveGetApartment() {
		
		assertEquals("", initialApartment, meters.get(0));

	}

	/**
	 * remove apartment from selected ArrayList. delete from database.
	 */
	@Test
	public void testPositiveRemoveApartment() {
		
		assertEquals("", true, apartments.remove(0));

	}

	/**
	 * get empty apartments from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveGetEmptyApartments() {

		// TODO: fill tmpList with data
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		
		assertEquals("", tmpList, entranceWithApartmentAndMeter.getEmptyApartments());

	}

	/**
	 * get rented apartments from selected ArrayList. load from database.
	 */
	@Test
	public void testPositiveGetRentedApartments() {
		
		// TODO: fill tmpList with data
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		
		assertEquals("", tmpList, entranceWithApartmentAndMeter.getRentedApartments());

	}

	/**
	 * get boolean if entrance is empty. load from database.
	 */
	@Test
	public void testPositiveEntranceIsEmpty() {

		assertEquals("", true, entranceWithApartmentAndMeter.entranceIsEmpty());

	}

	/**
	 * get entrance with all apartments. load from database.
	 */
	@Test
	public void testPositiveGetEntrance() {

		assertEquals("", "", entranceWithApartmentAndMeter.toString());

	}

}