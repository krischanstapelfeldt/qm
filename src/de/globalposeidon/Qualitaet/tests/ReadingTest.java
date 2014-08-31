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

   @Override
   @Before
   /**
    * Ramps the necessary objects up (dataContainer, building, meters,
    * entrance, apartment)
    *
    * @throws Throws
    *             an exception, when catching fire
    */
   public final void setUp() throws Exception {
      dataContainer = new DataContainer();
      building = new Building(dataContainer);
      entrance = new Entrance(building);
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
    * get the reader from the selected reading.
    */
   @Test
   public final void testPositiveGetReader() {

      assertEquals("", MeterReader.ENERGYPROVIDER, reading.getReader());
   }

   /**
    * get the reading info from selected reading.
    */
   @Test
   public final void testPositiveGetReadingInfo() {

      assertEquals("", ReadingInfo.ESTIMATION, reading.getInfo());
   }

   /**
    * get date from selected reading.
    */
   @Test
   public final void testPositiveGetReadingDate() {

      assertEquals("", new Date(), reading.getReadingDate());
   }

   /**
    * get the reading value from selected reading.
    */
   @Test
   public final void testPositiveGetReadingValue() {

      assertEquals("", 1, reading.getReadingValue());
   }

   /**
    * get the id from the reading.
    */
   @Test
   public final void testGetID() {
      assertNotNull(reading.getID());
   }
}
