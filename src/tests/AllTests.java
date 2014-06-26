package tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	public static Test suite() {
		TestSuite mySuite = new TestSuite("Global Poseidon TestSuite");
		mySuite.addTestSuite(tests.ApartmentTest.class);
		mySuite.addTestSuite(tests.BuildingTest.class);
		mySuite.addTestSuite(tests.EntranceTest.class);
		mySuite.addTestSuite(tests.MeterTest.class);
		return mySuite;
	}
}