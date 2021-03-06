package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;

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
import de.globalposeidon.Qualitaet.model.Tenant;

/**
 * This class contains the tests for the entrance class.
 * @author Krischan Stapelfeldt
 */
public class EntranceTest extends TestCase {

   private DataContainer dataContainer;
   private Building building;
   private Entrance entrance;
   private Apartment apartment;
   private Apartment apartmentFull;
   private ArrayList<Apartment> emptyApartments;
   private ArrayList<Apartment> fullApartments;
   private Meter meter;

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
      building = new Building(dataContainer, "Testname");
      entrance = new Entrance(building);
      apartment = new Apartment(entrance);
      apartmentFull = new Apartment(entrance);
      apartmentFull.addTenant(new Tenant());
      emptyApartments = new ArrayList<Apartment>();
      fullApartments = new ArrayList<Apartment>();
      emptyApartments.add(apartment);
      fullApartments.add(apartmentFull);
      meter = new Meter(001, Metertype.GAS, entrance);
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create two new entrances. one with specific data, one with empty data. insert into database.
    */
   @Test
   public final void testPositiveCreateEntrance() {

      assertNotNull(entrance);
   }

   /**
    * get id from selected entrance. load from database.
    */
   @Test
   public final void testGetID() {

      assertNotNull(entrance.getID());
   }

   /**
    * add meter to selected ArrayList. insert into database.
    */
   @Test
   public final void testPositiveAddMeter() {

      entrance.addMeter(meter);
      assertEquals("", meter, entrance.getMeter(0));
   }

   /**
    * get meter from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveGetMeter() {

      entrance.addMeter(meter);
      assertEquals("", meter, entrance.getMeter(0));

   }

   /**
    * add meter to selected ArrayList. insert into database.
    */
   @Test
   public final void testNegativeGetMeter() {

      assertEquals("", null, entrance.getMeter(0));
   }

   /**
    * remove meter from selected ArrayList. delete from database.
    */
   @Test
   public final void testPositiveRemoveMeter() {

      entrance.addMeter(meter);
      assertEquals("", meter, entrance.removeMeter(0));
   }

   /**
    * remove meter from selected ArrayList. delete from database.
    */
   @Test
   public final void testNegativeRemoveMeter() {

      assertEquals("", null, entrance.removeMeter(0));
   }

   /**
    * get meter count.
    */
   @Test
   public final void testMeterCount() {

      assertEquals("", 0, entrance.meterCount());
   }

   /**
    * add apartment to selected ArrayList. insert into database.
    */
   @Test
   public final void testPositiveAddApartment() {

      entrance.addApartment(apartment);
      assertEquals("", apartment, entrance.getApartments(0));

   }

   /**
    * get apartment from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveGetApartment() {

      entrance.addApartment(apartment);
      assertEquals("", apartment, entrance.getApartments(0));
   }

   /**
    * try to get a apartment which does not exist.
    */
   @Test
   public final void testNegativeGetApartment() {

      assertEquals("", null, entrance.getApartments(0));
   }

   /**
    * remove apartment from selected ArrayList. delete from database.
    */
   @Test
   public final void testPositiveRemoveApartment() {

      entrance.addApartment(apartment);
      assertNotNull(entrance.removeApartment(0));
   }

   /**
    * try to remove a apartment which does not exist.
    */
   @Test
   public final void testNegativeRemoveApartment() {

      assertEquals("", null, entrance.removeApartment(0));
   }

   /**
    * get apartment count.
    */
   @Test
   public final void testApartmentCount() {

      assertEquals("", 0, entrance.apartmentCount());
   }

   /**
    * get empty apartments from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveGetEmptyApartments() {

      entrance.addApartment(apartment);
      assertEquals("", emptyApartments, entrance.getEmptyApartments());
   }

   /**
    * get rented apartments from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveGetRentedApartments() {

      entrance.addApartment(apartmentFull);
      assertEquals("", fullApartments, entrance.getRentedApartments());
   }

   /**
    * get boolean if entrance is empty. load from database.
    */
   @Test
   public final void testPositiveEntranceIsEmpty() {

      assertEquals("", true, entrance.entranceIsEmpty());
   }

   /**
    * get boolean if entrance is empty. load from database.
    */
   @Test
   public final void testNegativeEntranceIsEmpty() {

      entrance.addApartment(apartment);
      assertEquals("", false, entrance.entranceIsEmpty());
   }

   /**
    * set a list of meters.
    */
   @Test
   public final void testSetMeters() {

      final ArrayList<Meter> tmpList = new ArrayList<Meter>();
      tmpList.add(meter);
      entrance.setMeters(tmpList);
      assertEquals("", 1, entrance.getMeters().size());
   }

   /**
    * get a list of meters.
    */
   @Test
   public final void testGetMeters() {

      entrance.addMeter(meter);
      assertEquals("", 1, entrance.getMeters().size());
   }

   /**
    * set a list of apartments.
    */
   @Test
   public final void testSetApartments() {

      final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
      tmpList.add(apartment);
      entrance.setApartments(tmpList);
      assertEquals("", 1, entrance.getApartments().size());
   }

   /**
    * get a list of apartments.
    */
   @Test
   public final void testGetApartments() {

      entrance.addApartment(apartment);
      assertEquals("", 1, entrance.getApartments().size());
   }

   /**
    * test toString.
    */
   @Test
   public final void testToString() {

      assertNotNull(entrance.toString());
   }
}
