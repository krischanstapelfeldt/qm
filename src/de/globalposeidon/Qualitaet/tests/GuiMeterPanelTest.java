package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.gui.MeterPanel;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class GuiMeterPanelTest extends TestCase {

   private Meter meter = null;
   @Before
   /**
    * No ramp up necessary.
    * @throws Might
    *             throw an exception. Unlikely, there is no method body.
    */
   public final void setUp() throws Exception {
       Building building = new Building(null);
       Entrance entrance = new Entrance(building);
       meter = new Meter(0001, Metertype.POWER, entrance);
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

       assertNotNull(new MeterPanel(meter));
   }
}
