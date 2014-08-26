package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Renter;

/**
 * This class contains the tests for the renter class
 *
 * @author Krischan Stapelfeldt
 */
public class RenterTest extends TestCase {
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
    * create two new renter. one with specific data, one with empty data. insert
    * into database.
    */
   @Test
   public final void testPositiveCreateRenter() {

      final Timestamp tstamp = new Timestamp(System.currentTimeMillis());

      final String name = "Mustermann" + tstamp;
      final String surname = "Max";
      final String phone = "01234/5678912";
      final String email = "max@mustermann.de";
      assertEquals("", null, new Renter(name, surname, phone, email));

      assertEquals("", null, new Renter());
   }

}
