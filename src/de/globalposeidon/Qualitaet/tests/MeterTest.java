package de.globalposeidon.Qualitaet.tests;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.Ints;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

/**
 * This class contains the tests for the meter class.
 * @author Krischan Stapelfeldt
 */
public class MeterTest extends TestCase {

   private DataContainer dataContainer;
   private Building building;
   private Entrance entrance;
   private Apartment apartment;
   private Meter meter;
   private int meterID;
   private Metertype type;
   private int currentValue;
   private int yearValue;
   private Date lastRead;

   @Override
   @Before
   /**
    * Ramps the necessary objects up (dataContainer, building, meters,
    * entrance, apartment).
    *
    * @throws Exception
    *             thrown, when setup crashes
    */
   public final void setUp() throws Exception {
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

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create new meter with specific data. insert into database.
    */
   @Test
   public final void testPositiveCreateMeter() {

      assertEquals("", (meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead).toString(), meter.toString());

   }

   /**
    * get id from selected meter. load from database.
    */
   @Test
   public final void testPositiveGetMeterID() {

      assertEquals("", meterID, meter.getID());

   }

   /**
    * get type from selected meter. load from database.
    */
   @Test
   public final void testPositiveGetType() {

      assertEquals("", type, meter.getType());
   }

   /**
    * get current value from selected meter. load from database.
    */
   @Test
   public final void testPositiveGetCurrentValue() {

      assertEquals("", currentValue, meter.getCurrentValue());

   }

   /**
    * set current value for selected meter. insert into database.
    */
   @Test
   public final void testPositiveSetCurrentValue() {
      meter.setCurrentValue(meter.getCurrentValue() + Ints.FIVE_HUNDRED_FIFTY_FIVE.value());
      assertEquals("", currentValue + Ints.FIVE_HUNDRED_FIFTY_FIVE.value(), meter.getCurrentValue());

   }

   /**
    * get year value from selected meter. load from database.
    */
   @Test
   public final void testPositiveGetYearValue() {

      assertEquals("", yearValue, meter.getYearValue());

   }

   /**
    * set year value for selected meter. insert into database.
    */
   @Test
   public final void testPositiveSetYearYalue() {
      meter.setYearValue(meter.getYearValue() + Ints.ONE_HUNDRED_ELEVEN.value());
      assertEquals("", yearValue + Ints.ONE_HUNDRED_ELEVEN.value(), meter.getYearValue());

   }

   /**
    * get last reading from selected meter. load from database.
    */
   @Test
   public final void testPositiveGetLastRead() {

      assertEquals("", lastRead, meter.getLastRead());

   }

   /**
    * set last reading for selected meter. insert into database.
    */
   @Test
   public final void testPositiveSetLastRead() {
      final Date newDate = new Date();
      newDate.setTime(meter.getLastRead().getTime() + 1 * Ints.ONE_DAY_IN_SECONDS.value()); // add
      // one
      // day

      meter.setLastRead(newDate);
      assertEquals("", newDate, meter.getLastRead());

   }

   /**
    * TODO BESCHREIBEN!!!
    */
   @Test
   public final void testPositiveMakeReading() {

      assertNotNull(meter.makeReading());
   }

   /**
    * get meter with data from database.
    */
   @Test
   public final void testPositiveGetMeter() {

      assertEquals("", meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead, meter.toString());

   }

}
