package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Tenant;
/**
 * This class contains the tests for the apartment class
 * @author Krischan Stapelfeldt
 *
 */
public class ApartmentTest extends TestCase {

	DataContainer dataContainer;
	Building building;
	Entrance entrance;
	Apartment apartment;
	Meter initialMeter;
	Tenant initialTenant;
	/**
	 * Ramps the necessary objects up (dataContainer, building, entrance, apartment)
	 */
	@Before
	public void setUp() throws Exception {
		dataContainer = new DataContainer();
		building = new Building(dataContainer);
		entrance = new Entrance(building);
		apartment = new Apartment(initialMeter, entrance);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create two new apartments. one with specific data, one with empty data. insert into database.
	 */
	@Test
	public void testPositiveCreateApartment() {

		assertEquals("", null, apartment);
		assertEquals("", null, new Apartment(initialMeter,initialTenant,entrance));

	}

	/**
	 * add meter to selected apartment. insert into database.
	 */
	@Test
	public void testPositiveAddMeter() {
		apartment.addMeter(initialMeter);
		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * get meter from selected apartment. load from database.
	 */
	@Test
	public void testPositiveGetMeter() {

		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * add tenant to selected apartment. insert into database.
	 */
	@Test
	public void testPositiveAddTenant() {

		assertEquals("", true, apartment.addTenant(initialTenant));

	}

	/**
	 * get tenant from selected apartment. load from database.
	 */
	@Test
	public void testPositiveGetTenant() {
		
		assertEquals("", initialTenant, apartment.getTenant(0));

	}

	/**
	 * get boolean if apartment is empty. load from database.
	 */
	@Test
	public void testPositiveApartmentIsEmpty() {

		assertEquals("", true, apartment.apartmentIsEmpty());

	}

	/**
	 * get apartment with all tenants. load from database.
	 */
	@Test
	public void testPositiveGetApartment() {

		assertEquals("", "", apartment.toString());

	}

}