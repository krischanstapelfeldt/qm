package tests;

import global.Meter;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MeterTest extends TestCase {
	Meter meter;

	@Before
	public void setUp() throws Exception {
		meter = new Meter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositiveAddMeter() {
		assertEquals("", true, meter.add());
	}

	@Test
	public void testPositiveDeleteMeter() {
		assertEquals("", true, meter.delete());
	}

	@Test
	public void testPositiveListMeter() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, meter.list(id));
	}

	@Test
	public void testPositiveReadMeter() {
		int newValue = 0;
		Date readingDate = null;
		assertEquals("", true, meter.read(newValue, readingDate));
	}

}