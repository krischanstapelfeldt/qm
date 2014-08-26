package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import de.globalposeidon.Qualitaet.model.Tenant;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class TenantTest extends TestCase {

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
    * create two new tenants. one with specific data, one with empty data. insert into database.
    */
   public final void testPositiveCreateTenant() {

      final Timestamp tstamp = new Timestamp(System.currentTimeMillis());

      final String name = "Mustermann" + tstamp;
      final String surname = "Max";
      final String phone = "01234/5678912";
      final String email = "max@mustermann.de";
      assertEquals("", null, new Tenant(name, surname, phone, email));

      assertEquals("", null, new Tenant());
   }

}
