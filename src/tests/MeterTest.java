package tests;

import global.Meter;

import java.util.Date;

import junit.framework.TestCase;

public class MeterTest extends TestCase {
	Meter meter;

	@Override
	public void setUp() throws Exception {
		meter = new Meter();
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testPositiveAddMeter() {
		assertEquals("", true, meter.add());
	}

	public void testPositiveDeleteMeter() {
		assertEquals("", true, meter.delete());
	}

	public void testPositiveListMeter() {
		int id = 1;
		int[] i = null;
		assertEquals("", i, meter.list(id));
	}

	public void testPositiveReadMeter() {
		int newValue = 0;
		Date readingDate = null;
		assertEquals("", true, meter.read(newValue, readingDate));
	}

}