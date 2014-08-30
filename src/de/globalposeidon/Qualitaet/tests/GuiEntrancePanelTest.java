package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.gui.EntrancePanel;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Entrance;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class GuiEntrancePanelTest extends TestCase {

   private Entrance entrance = null;

   @Override
   @Before
   /**
    * No ramp up necessary.
    * @throws Might
    *             throw an exception. Unlikely, there is no method body.
    */
   public final void setUp() throws Exception {
      final Building building = new Building(null);
      entrance = new Entrance(building);
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * bla.
    */
   @Test
   public final void testPositiveCreateTenant() {

      assertNotNull(new EntrancePanel(entrance));
   }

}
