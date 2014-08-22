package de.globalposeidon.Qualitaet.tests;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

public class MeterTest extends TestCase {
	
	DataContainer dataContainer;
	Building building;
	Entrance entrance;
	Apartment apartment;
	Meter meter;
	int meterID;
	Metertype type;
	int currentValue;
	int yearValue;
	Date lastRead;

	@Before
	public void setUp() throws Exception {
		dataContainer = new DataContainer();
		building = new Building(dataContainer);
		entrance = new Entrance(building);
		apartment = new Apartment(entrance);
		meterID = (int) new Date().getTime();
		type = Metertype.GAS;
		currentValue = 0;
		yearValue = 0;
		lastRead = new Date();
		meter = new Meter(meterID, type, apartment);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * testPositiveCreateMeter()
	 * 
	 * @result create new meter with specific data. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveCreateMeter() {

		assertEquals("", (meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead).toString(), meter.toString());

	}

	/**
	 * testPositiveGetMeterID()
	 * 
	 * @result get ID from selected meter. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetMeterID() {

		assertEquals("", meterID, meter.getID());

	}

	/**
	 * testPositiveGetType()
	 * 
	 * @result get type from selected meter. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetType() {
//		assertEquals("", type, meter.getType());

	}

	/**
	 * testPositiveGetCurrentValue()
	 * 
	 * @result get current value from selected meter. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetCurrentValue() {

		assertEquals("", currentValue, meter.getCurrentValue());

	}

	/**
	 * testPositiveSetCurrentValue()
	 * 
	 * @result set current value for selected meter. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveSetCurrentValue() {
		meter.setCurrentValue(meter.getCurrentValue() + 555);
		assertEquals("", currentValue + 555, meter.getCurrentValue());

	}

	/**
	 * testPositiveGetYearValue()
	 * 
	 * @result get year value from selected meter. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetYearValue() {

		assertEquals("", yearValue, meter.getYearValue());

	}

	/**
	 * testPositiveSetYearYalue()
	 * 
	 * @result set year value for selected meter. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveSetYearYalue() {
		meter.setYearValue(meter.getYearValue() + 111);
		assertEquals("", yearValue + 111, meter.getYearValue());

	}

	/**
	 * testPositiveGetLastRead()
	 * 
	 * @result get last reading from selected meter. load from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetLastRead() {

		assertEquals("", lastRead, meter.getLastRead());

	}

	/**
	 * testPositiveSetLastRead()
	 * 
	 * @result set last reading for selected meter. insert into database.
	 * @author ks
	 */
	@Test
	public void testPositiveSetLastRead() {
		Date newDate = new Date();
		newDate.setTime(meter.getLastRead().getTime() + 1 * 24 * 60 * 60 * 1000); //add one day
		
		meter.setLastRead(newDate);
		assertEquals("", newDate, meter.getLastRead());

	}

	/**
	 * testPositiveMakeReading()
	 * 
	 * @result 
	 * @author ks
	 */
	@Test
	public void testPositiveMakeReading() {

		// TODO: implement testPositiveMakeReading()
		
	}

	/**
	 * testPositiveGetMeter()
	 * 
	 * @result get meter with data from database.
	 * @author ks
	 */
	@Test
	public void testPositiveGetMeter() {

		assertEquals("", meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead,
				meter.toString());

	}

}
