package de.globalposeidon.Qualitaet.tests;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.MeterReader;
import de.globalposeidon.Qualitaet.model.Metertype;
import de.globalposeidon.Qualitaet.model.Reading;
import de.globalposeidon.Qualitaet.model.ReadingInfo;

/**
 * This class contains the tests for the reading class.
 * @author Krischan Stapelfeldt
 */
public class ReadingTest extends TestCase {

	private DataContainer dataContainer;
	private Building building;
	private Entrance entrance;
	private Meter meter;
	private Reading reading;

 
   /**
    * BLA
    *
    * @throws Might
    *             throw an exception. Unlikely, there is no method body.
    */
   @Override
   @Before
	public final void setUp() throws Exception {
	   dataContainer = new DataContainer();
	   building = new Building(dataContainer);
	   entrance =  new Entrance(building);
	   meter = new Meter(001, Metertype.GAS, entrance);
	   meter.setCurrentValue(1);
	   reading = new Reading(meter, MeterReader.ENERGYPROVIDER, ReadingInfo.ESTIMATION);
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }
   
   /**
    * create new reading. insert into database.
    */
   @Test
   public final void testPositiveCreateReading() {

      assertNotNull(reading);

   }
   
   /**
    * create new reading. insert into database.
    */
   @Test
   public final void testPositiveGetMeter() {

	   assertEquals("", meter, reading.getMeter());
   }

   /**
    * bla.
    */
   @Test
   public final void testPositiveGetReader() {

	   assertEquals("", MeterReader.ENERGYPROVIDER, reading.getReader());
   }

   /**
    * bla.
    */
   @Test
   public final void testPositiveGetReadingInfo() {

	   assertEquals("", ReadingInfo.ESTIMATION, reading.getInfo());
   }


   /**
    * bla.
    */
   @Test
   public final void testPositiveGetReadingDate() {

	   assertEquals("", new Date(), reading.getReadingDate());
   }


   /**
    * bla.
    */
   @Test
   public final void testPositiveGetReadingValue() {

	   assertEquals("", 1, reading.getReadingValue());
   }

   /**
    * bla.
    */
   @Test
   public final void testGetID() {
	   assertNotNull(reading.getID());
   }
}
