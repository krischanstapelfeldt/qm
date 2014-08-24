package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.MeterReader;
import de.globalposeidon.Qualitaet.model.Reading;
import de.globalposeidon.Qualitaet.model.ReadingInfo;

/**
 * This class contains the tests for the reading class
 * 
 * @author Krischan Stapelfeldt
 *
 */
public class ReadingTest extends TestCase {
	/**
	 * No ramp up necessary
	 */
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create new reading. insert into database.
	 */
	@Test
	public void testPositiveSetReading() {

		Meter meter = null;
		MeterReader reader = null;
		ReadingInfo info = null;
		assertEquals("", null, new Reading(meter, reader, info));

	}

	// TODO: new method - getReading(Integer id)

	// /**
	// * get reading by id. load from database.
	// */
	// @Test
	// public void testPositiveGetReading() {
	//
	// Integer id = null;
	// assertEquals("", true, new Reading().getReading(id));
	//
	// }

}