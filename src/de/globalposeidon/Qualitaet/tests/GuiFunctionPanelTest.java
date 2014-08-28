package de.globalposeidon.Qualitaet.tests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

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
    * create two new tenants. one with specific data, one with empty data. insert into database.
    */
   public final void testPositiveCreateTenant() {
      assertNotNull("", new FunctionPanel());
   }

}
