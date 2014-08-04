package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Person;

public class EntranceTest extends TestCase {

	Entrance entranceWithApartment;
	Entrance entranceWithApartmentAndMeter;
	Apartment initialApartment;
	Meter initialMeter;
	ArrayList<Meter> meters;
	ArrayList<Apartment> apartments;

	@Before
	public void setUp() throws Exception {
		meters = new ArrayList<Meter>();
		apartments = new ArrayList<Apartment>();
		entranceWithApartment = new Entrance(initialApartment);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateEntrance()
	 * 
	 * @result create two new entrances. one with specific data, one with empty
	 *         data. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveCreateEntrance() {

		assertEquals("", null, entranceWithApartment);
		assertEquals("", null, entranceWithApartmentAndMeter = new Entrance(initialApartment,initialMeter));

	}

	/**
	 * testPositiveAddMeter()
	 * 
	 * @result add meter to selected ArrayList. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveAddMeter() {
		
		assertEquals("", null, meters.add(initialMeter));

	}

	/**
	 * testPositiveGetMeter()
	 * 
	 * @result get meter from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetMeter() {

		assertEquals("", initialMeter, meters.get(0));

	}
	/**
	 * testPositiveRemoveMeter()
	 * 
	 * @result remove meter from selected ArrayList. delete from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveRemoveMeter() {

		assertEquals("", null, meters.remove(0));

	}

	/**
	 * testPositiveAddApartment()
	 * 
	 * @result add apartment to selected ArrayList. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveAddApartment() {

		assertEquals("", null, apartments.add(initialApartment));

	}

	/**
	 * testPositiveGetApartment()
	 * 
	 * @result get apartment from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetApartment() {
		
		assertEquals("", initialApartment, meters.get(0));

	}

	/**
	 * testPositiveRemoveApartment()
	 * 
	 * @result remove apartment from selected ArrayList. delete from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveRemoveApartment() {
		
		assertEquals("", true, apartments.remove(0));

	}

	/**
	 * testPositiveGetEmptyApartments()
	 * 
	 * @result get empty apartments from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetEmptyApartments() {

		// TODO: fill tmpList with data
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		
		assertEquals("", tmpList, entranceWithApartmentAndMeter.getEmptyApartments());

	}

	/**
	 * testPositiveGetRentedApartments()
	 * 
	 * @result get rented apartments from selected ArrayList. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetRentedApartments() {
		
		// TODO: fill tmpList with data
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		
		assertEquals("", tmpList, entranceWithApartmentAndMeter.getRentedApartments());

	}

	/**
	 * testPositiveEntranceIsEmpty()
	 * 
	 * @result get boolean if entrance is empty. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveEntranceIsEmpty() {

		assertEquals("", true, entranceWithApartmentAndMeter.entranceIsEmpty());

	}

	/**
	 * testPositiveGetEntrance()
	 * 
	 * @result get entrance with all apartments. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetEntrance() {

		assertEquals("", "", entranceWithApartmentAndMeter.toString());

	}

}