package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.gui.FunctionPanel;
import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.DataContainer;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class GuiFunctionPanelTest extends TestCase {

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

      assertNotNull(new FunctionPanel(new MainWindow(new DataContainer())));
   }

}
