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
import de.globalposeidon.Qualitaet.model.Metertype;
import de.globalposeidon.Qualitaet.model.Renter;

/**
 * This class contains the tests for the entrance class.
 *
 * @author Krischan Stapelfeldt
 *
 */
public class EntranceTest extends TestCase {

	private Entrance entranceWithApartment;
	private Entrance entranceWithApartmentAndMeter;
	private DataContainer dataContainer;
	private Building building;
	private Entrance entrance;
	private Apartment apartment;
	private Meter meter;
	private ArrayList<Meter> meters;
	private ArrayList<Apartment> apartments;

	@Override
	@Before
	/**
	 * Ramps the necessary objects up (dataContainer, building, meters,
	 * entrance, apartment)
	 * 
	 * @throws Throws
	 *             an exception, when catching fire
	 */
	public final void setUp() throws Exception {
		dataContainer = new DataContainer();
		building = new Building(dataContainer);
		entrance = new Entrance(building);
		apartment = new Apartment(entrance);
		meter = new Meter(001, Metertype.GAS, entrance);
		
		meters = new ArrayList<Meter>();
		apartments = new ArrayList<Apartment>();
//		entranceWithAparstment = new Entrance(apartment, building);
		
	}

	@Override
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create two new entrances. one with specific data, one with empty data.
	 * insert into database.
	 */
	@Test
	public final void testPositiveCreateEntrance() {
		
		assertNotNull(entrance);
// TODO: One with specific data
//		assertNotNull();
//		assertEquals("", null, entranceWithApartment);
//		assertEquals("", null, entranceWithApartmentAndMeter = new Entrance(
//				initialApartment, initialMeter, building));

	}

	/**
	 * add meter to selected ArrayList. insert into database.
	 */
	@Test
	public final void testPositiveAddMeter() {
		
		entrance.addMeter(meter);
		assertEquals("", meter, entrance.getMeter(0));
//		assertEquals("", null, meters.add(initialMeter));

	}

	/**
	 * get meter from selected ArrayList. load from database.
	 */
	@Test
	public final void testPositiveGetMeter() {
		
		entrance.addMeter(meter);
		assertEquals("", meter, entrance.getMeter(0));

	}

	/**
	 * remove meter from selected ArrayList. delete from database.
	 */
	@Test
	public final void testPositiveRemoveMeter() {
		
		entrance.addMeter(meter);
		assertEquals("", meter, entrance.removeMeter(0));

	}

	/**
	 * add apartment to selected ArrayList. insert into database.
	 */
	@Test
	public final void testPositiveAddApartment() {

		entrance.addApartment(apartment);
		assertEquals("", apartment, entrance.getApartment(0));

	}

	/**
	 * get apartment from selected ArrayList. load from database.
	 */
	@Test
	public final void testPositiveGetApartment() {
		
		entrance.addApartment(apartment);
		assertEquals("", apartment, entrance.getApartment(0));
	}

	/**
	 * remove apartment from selected ArrayList. delete from database.
	 */
	@Test
	public final void testPositiveRemoveApartment() {
		
		entrance.addApartment(apartment);
		assertEquals("", apartment, entrance.removeApartment(0));

	}

	/**
	 * get empty apartments from selected ArrayList. load from database.
	 */
	@Test
	public final void testPositiveGetEmptyApartments() {

		// TODO: fill tmpList with data
		final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();

		assertEquals("", tmpList,
				entranceWithApartmentAndMeter.getEmptyApartments());

	}

	/**
	 * get rented apartments from selected ArrayList. load from database.
	 */
	@Test
	public final void testPositiveGetRentedApartments() {

		// TODO: fill tmpList with data
		final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();

//		assertEquals("", tmpList,
//				entranceWithApartmentAndMeter.getRentedApartments());

	}

	/**
	 * get boolean if entrance is empty. load from database.
	 */
	@Test
	public final void testPositiveEntranceIsEmpty() {

		assertEquals("", true, entrance.entranceIsEmpty());

	}

	/**
	 * get entrance with all apartments. load from database.
	 */
	@Test
	public final void testPositiveGetEntrance() {

		assertEquals("", "", entrance.toString());

	}

}
