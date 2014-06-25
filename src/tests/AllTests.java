package tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	public static Test suite() {
		TestSuite mySuite = new TestSuite("Meine Test-Suite");
		mySuite.addTestSuite(tests.BuildingTest.class);
		// ... weitere Testklassen hinzufügen
		return mySuite;
	}
}