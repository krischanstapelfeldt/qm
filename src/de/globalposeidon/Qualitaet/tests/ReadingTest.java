package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.MeterReader;
import de.globalposeidon.Qualitaet.model.Reading;
import de.globalposeidon.Qualitaet.model.ReadingInfo;

public class ReadingTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveSetReading()
	 * 
	 * @result create new reading. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveSetReading() {

		Meter meter = null;
		MeterReader reader = null;
		ReadingInfo info = null;
		assertEquals("", null, new Reading(meter, reader, info));

	}

	//TODO: new method - getReading(Integer id)
	
//	/**
//	 * testPositiveGetReading()
//	 * 
//	 * @result get reading by id. load from database.
//	 * @author ks
//	 */
//	@Test
//	public void testPositiveGetReading() {
//
//		Integer id = null;
//		assertEquals("", true, new Reading().getReading(id));
//
//	}

}