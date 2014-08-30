package de.globalposeidon.Qualitaet.tests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.Launcher;
import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.DataContainer;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class GuiLauncherTest extends TestCase {

   @Override
   @Before
   /**
    * No ramp up necessary.
    * @throws Might
    *             throw an exception. Unlikely, there is no method body.
    */
   public final void setUp() throws Exception {
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

      final Collection<Boolean> collection = new ArrayList<Boolean>();
      assertEquals(0, collection.size());
      try {
         final DataContainer dc = Launcher.createRandomModel();
         new MainWindow(dc);
         collection.add(true);
      } catch (final Exception e) {
         e.printStackTrace();
      }
      assertEquals(1, collection.size());
   }
}
