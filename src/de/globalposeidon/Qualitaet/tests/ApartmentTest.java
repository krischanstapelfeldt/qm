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
 * This class contains the tests for the apartment class.
 *
 * @author Krischan Stapelfeldt
 *
 */
public class ApartmentTest extends TestCase {

	private DataContainer dataContainer;
	private Building building;
	private Entrance entrance;
	private Apartment apartment;
	private Meter initialMeter;
	private Tenant initialTenant;

	@Override
	@Before
	/**
	 * Ramps the necessary objects up (dataContainer, building, entrance,
	 * apartment).
	 * @throws Throws an exception, when it explodes.
	 */
	public final void setUp() throws Exception {
		dataContainer = new DataContainer();
		building = new Building(dataContainer);
		entrance = new Entrance(building);
		apartment = new Apartment(entrance);
	}

	@Override
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create two new apartments. one with specific data, one with empty data.
	 * insert into database.
	 */
	@Test
	public final void testPositiveCreateApartment() {

		assertEquals("", null, apartment);
//		assertEquals("", null, new Apartment(initialMeter, initialTenant,
//				entrance));

	}

	/**
	 * add meter to selected apartment. insert into database.
	 */
	@Test
	public final void testPositiveAddMeter() {
		apartment.addMeter(initialMeter);
		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * get meter from selected apartment. load from database.
	 */
	@Test
	public final void testPositiveGetMeter() {

		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * add tenant to selected apartment. insert into database.
	 */
	@Test
	public final void testPositiveAddTenant() {

		assertEquals("", true, apartment.addTenant(initialTenant));

	}

	/**
	 * get tenant from selected apartment. load from database.
	 */
	@Test
	public final void testPositiveGetTenant() {

		assertEquals("", initialTenant, apartment.getTenant(0));

	}

	/**
	 * get boolean if apartment is empty. load from database.
	 */
	@Test
	public final void testPositiveApartmentIsEmpty() {

		assertEquals("", true, apartment.apartmentIsEmpty());

	}

	/**
	 * get apartment with all tenants. load from database.
	 */
	@Test
	public final void testPositiveGetApartment() {

		assertEquals("", "", apartment.toString());

	}

}
