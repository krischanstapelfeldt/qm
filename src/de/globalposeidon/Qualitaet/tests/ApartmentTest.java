package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Tenant;

/**
 * This class contains the tests for the apartment class.
 *
 * @author Krischan Stapelfeldt
 */
public class ApartmentTest extends TestCase {

   private DataContainer dataContainer;
   private Building building;
   private Entrance entrance;
   private Apartment apartment;
   private Meter meter;
   private Tenant tenant;

   @Override
   @Before
   /**
    * Ramps the necessary objects up (dataContainer, building, entrance,
    * apartment).
    * @throws Throws an exception, when it explodes.
    */
   public final void setUp() throws Exception {
      dataContainer = new DataContainer();
      building = new Building(dataContainer);
      entrance = new Entrance(building);
      apartment = new Apartment(entrance);

   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create two new apartments. one with specific data, one with empty data.
    * insert into database.
    */
   @Test
   public final void testPositiveCreateApartment() {

      assertNotNull(apartment);
   }

   /**
    * bla.
    */
   @Test
   public final void testGetID() {

      assertNotNull(apartment.getID());
   }

   /**
    * add meter to selected apartment. insert into database.
    */
   @Test
   public final void testPositiveAddMeter() {
      apartment.addMeter(meter);
      assertEquals("", meter, apartment.getMeter(0));

   }

   /**
    * get meter from selected apartment. load from database.
    */
   @Test
   public final void testPositiveGetMeter() {

      apartment.addMeter(meter);
      assertEquals("", meter, apartment.getMeter(0));
   }

   /**
    * get meter from selected apartment. load from database.
    */
   @Test
   public final void testNegativeGetMeter() {

      assertEquals("", null, apartment.getMeter(0));
   }

   /**
    * bla..
    */
   @Test
   public final void testPositiveRemoveMeter() {

      apartment.addMeter(meter);
      assertEquals("", meter, apartment.removeMeter(0));
   }

   /**
    * remove meter from selected ArrayList. delete from database.
    */
   @Test
   public final void testNegativeRemoveMeter() {

      assertEquals("", null, apartment.removeMeter(0));
   }

   /**
    * bla.
    */
   @Test
   public final void testMeterCount() {

      assertEquals("", 0, apartment.meterCount());
   }

   /**
    * add tenant to selected apartment. insert into database.
    */
   @Test
   public final void testPositiveAddTenant() {

      assertEquals("", true, apartment.addTenant(tenant));
   }

   /**
    * bla.
    */
   @Test
   public final void testNegativeAddTenant() {

      apartment.addTenant(new Tenant());
      apartment.addTenant(new Tenant());
      apartment.addTenant(new Tenant());
      apartment.addTenant(new Tenant());
      assertEquals("", false, apartment.addTenant(tenant));
   }

   /**
    * get tenant from selected apartment. load from database.
    */
   @Test
   public final void testPositiveGetTenant() {

      apartment.addTenant(tenant);
      assertEquals("", tenant, apartment.getTenant(0));
   }

   /**
    * bla.
    */
   @Test
   public final void testNegativeGetTenant() {

      assertEquals("", null, apartment.getTenant(0));
   }

   /**
    * bla.
    */
   @Test
   public final void testPositiveRemoveTenant() {

      apartment.addTenant(tenant);
      assertEquals("", tenant, apartment.removeTenant(0));
   }

   /**
    * bla.
    */
   @Test
   public final void testNegativeRemoveTenant() {

      assertEquals("", null, apartment.removeTenant(0));
   }

   /**
    * bla.
    */
   @Test
   public final void testTenantCount() {

      assertEquals("", 0, apartment.tenantCount());
   }

   /**
    * get boolean if apartment is empty. load from database.
    */
   @Test
   public final void testPositiveApartmentIsEmpty() {

      assertEquals("", true, apartment.apartmentIsEmpty());
   }

   /**
    * get boolean if apartment is empty. load from database.
    */
   @Test
   public final void testNegativeApartmentIsEmpty() {

      apartment.addTenant(tenant);
      assertEquals("", false, apartment.apartmentIsEmpty());
   }

}
