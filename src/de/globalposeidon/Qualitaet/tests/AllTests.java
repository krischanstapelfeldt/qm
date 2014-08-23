package de.globalposeidon.Qualitaet.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {
	public static Test suite() {
		TestSuite mySuite = new TestSuite("GlobalPoseidonTestSuite");
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.ApartmentTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.BuildingTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.EntranceTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.PersonTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.ReadingTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.RenterTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.TenantTest.class);
		mySuite.addTestSuite(de.globalposeidon.Qualitaet.tests.MeterTest.class);
		return mySuite;
	}
}
