package tests;

import global.Apartment;
import junit.framework.TestCase;

public class ApartmentTest extends TestCase {
	Apartment apartment;

	@Override
	public void setUp() throws Exception {
		apartment = new Apartment();
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testPositiveAddApartment() {
		assertEquals("", true, apartment.add());
	}

	public void testPositiveDeleteApartment() {
		assertEquals("", true, apartment.delete());
	}

	public void testPositiveListApartment() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, apartment.list(id));
	}

}