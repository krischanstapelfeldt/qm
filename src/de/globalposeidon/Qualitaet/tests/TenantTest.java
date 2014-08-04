package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Tenant;

public class TenantTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateTenant()
	 * 
	 * @result create two new tenants. one with specific data, one with empty
	 *         data. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveCreateTenant() {

		Timestamp tstamp = new Timestamp(System.currentTimeMillis());

		String name = "Mustermann" + tstamp;
		String surname = "Max";
		String phone = "01234/5678912";
		String email = "max@mustermann.de";
		assertEquals("", null, new Tenant(name, surname, phone, email));

		assertEquals("", null, new Tenant());
	}

}