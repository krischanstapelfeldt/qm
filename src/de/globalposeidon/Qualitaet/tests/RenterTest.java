package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Renter;

public class RenterTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateRenter()
	 * 
	 * @result create two new renter. one with specific data, one with empty
	 *         data. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveCreateRenter() {

		Timestamp tstamp = new Timestamp(System.currentTimeMillis());

		String name = "Mustermann" + tstamp;
		String surname = "Max";
		String phone = "01234/5678912";
		String email = "max@mustermann.de";
		assertEquals("", null, new Renter(name, surname, phone, email));

		assertEquals("", null, new Renter());
	}

}