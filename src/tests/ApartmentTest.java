package tests;

import global.Apartment;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApartmentTest extends TestCase {
	Apartment apartment;

	@Before
	public void setUp() throws Exception {
		apartment = new Apartment();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositiveAddApartment() {
		assertEquals("", true, apartment.add());
	}

	@Test
	public void testPositiveDeleteApartment() {
		assertEquals("", true, apartment.delete());
	}

	@Test
	public void testPositiveListApartment() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, apartment.list(id));
	}

}