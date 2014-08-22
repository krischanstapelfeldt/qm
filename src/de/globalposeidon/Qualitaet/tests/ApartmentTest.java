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

public class ApartmentTest extends TestCase {

	DataContainer dataContainer;
	Building building;
	Entrance entrance;
	Apartment apartment;
	Meter initialMeter;
	Tenant initialTenant;

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
	 * testPositiveCreateApartment()
	 * 
	 * @result create two new apartments. one with specific data, one with empty
	 *         data. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveCreateApartment() {

		assertEquals("", null, apartment);
		assertEquals("", null, new Apartment(initialMeter,initialTenant,entrance));

	}

	/**
	 * testPositiveAddMeter()
	 * 
	 * @result add meter to selected apartment. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveAddMeter() {
		apartment.addMeter(initialMeter);
		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * testPositiveGetMeter()
	 * 
	 * @result get meter from selected apartment. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetMeter() {

		assertEquals("", initialMeter, apartment.getMeter(0));

	}

	/**
	 * testPositiveAddTenant()
	 * 
	 * @result add tenant to selected apartment. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveAddTenant() {

		assertEquals("", true, apartment.addTenant(initialTenant));

	}

	/**
	 * testPositiveGetTenant()
	 * 
	 * @result get tenant from selected apartment. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetTenant() {
		
		assertEquals("", initialTenant, apartment.getTenant(0));

	}

	/**
	 * testPositiveApartmentIsEmpty()
	 * 
	 * @result get boolean if apartment is empty. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveApartmentIsEmpty() {

		assertEquals("", true, apartment.apartmentIsEmpty());

	}

	/**
	 * testPositiveGetApartment()
	 * 
	 * @result get apartment with all tenants. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetApartment() {

		assertEquals("", "", apartment.toString());

	}

}