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
 * This class contains the tests for the reading class.
 * @author Krischan Stapelfeldt
 */
public class ReadingTest extends TestCase {
   @Override
   @Before
   /**
    * No ramp up necessary.
    *
    * @throws Might
    *             throw an exception. Unlikely, there is no method body.
    */
   public void setUp() throws Exception {
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create new reading. insert into database.
    */
   @Test
   public final void testPositiveSetReading() {

      final Meter meter = null;
      final MeterReader reader = null;
      final ReadingInfo info = null;
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
