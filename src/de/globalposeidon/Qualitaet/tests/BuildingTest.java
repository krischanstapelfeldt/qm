package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Renter;

/**
 * This class contains the tests for the building class.
 * @author Krischan Stapelfeldt
 */
public class BuildingTest extends TestCase {

   private DataContainer dataContainer;
   private Renter renter;
   private Entrance entrance;
   // private ArrayList<Entrance> entrances;
   private Building building;

   @Override
   @Before
   /**
    * Ramps the necessary objects up (dataContainer, renter, building,
    * entrance).
    * @throws Throws an exception, when catching fire.
    */
   public final void setUp() throws Exception {
      dataContainer = new DataContainer();
      renter = new Renter();
      building = new Building(dataContainer);
      entrance = new Entrance(building);
      // entrances = new ArrayList<Entrance>();
      // entrances.add(initialEntrance);
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create a new building with specific data. insert into database.
    */
   @Test
   public final void testPositiveCreateBuilding() {

      assertNotNull(building);
   }

   /**
    * get id from selected building. load from database.
    */
   @Test
   public final void testGetID() {

      assertNotNull(building.getID());
   }

   /**
    * set renter to building.
    */
   @Test
   public final void testPositiveSetRenter() {

      building.setRenter(renter);
      assertEquals("", renter, building.getRenter());

   }

   /**
    * get renter from selected building. load from database.
    */
   @Test
   public final void testPositiveGetRenter() {

      building.setRenter(renter);
      assertEquals("", renter, building.getRenter());

   }

   /**
    * replace renter with a new renter. insert into database.
    */
   @Test
   public final void testPositiveReplaceRenter() {

      final Renter newRenter = new Renter();
      building.setRenter(newRenter);
      assertEquals("", newRenter, building.getRenter());

   }

   /**
    * add entrance to selected building. insert into database.
    */
   @Test
   public final void testPositiveAddEntrance() {

      building.addEntrance(entrance);
      assertEquals("", entrance, building.getEntrance(0));

   }

   /**
    * get entrance from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveGetEntrance() {

      building.addEntrance(entrance);
      assertEquals("", entrance, building.getEntrance(0));

   }

   /**
    * get entrance from selected ArrayList. load from database.
    */
   @Test
   public final void testNegativeGetEntrance() {

      assertEquals("", null, building.getEntrance(0));

   }

   /**
    * remove entrance from selected ArrayList. delete from database.
    */
   @Test
   public final void testPositiveRemoveEntrance() {

      building.addEntrance(entrance);
      assertEquals("", entrance, building.removeEntrance(0));

   }

   /**
    * remove entrance from selected ArrayList. delete from database.
    */
   @Test
   public final void testNegativeRemoveEntrance() {

      assertEquals("", null, building.removeEntrance(0));

   }

   /**
    * get empty buildings from selected ArrayList. load from database.
    */
   @Test
   public final void testPositiveBuildingIsEmpty() {

      assertEquals("", true, building.buildingIsEmpty());
   }

   /**
    * bla.
    */
   @Test
   public final void testNegativeBuildingIsEmpty() {

      building.addEntrance(entrance);
      assertEquals("", false, building.buildingIsEmpty());
   }

   /**
    * bla.
    */
   @Test
   public final void testEntranceCount() {

      assertEquals("", 0, building.entranceCount());
   }

   /**
    * bla.
    */
   @Test
   public final void testToString() {

      assertNotNull(building.toString());
   }
   // <----- TREENODE TESTS ----->

   // TODO: Write this tests?
}
