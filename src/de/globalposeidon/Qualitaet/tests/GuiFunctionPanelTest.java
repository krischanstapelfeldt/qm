package de.globalposeidon.Qualitaet.tests;

import javax.swing.JFrame;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.gui.FunctionPanel;

/**
 * This class contains the tests for the tenant class.
 * @author Krischan Stapelfeldt
 */
public class GuiFunctionPanelTest extends TestCase {

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
    * bla.
    */
   @Test
   public final void testPositiveCreateTenant() {

        assertNotNull(new FunctionPanel(new JFrame()));
   }

}
