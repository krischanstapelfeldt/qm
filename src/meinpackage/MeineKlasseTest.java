package meinpackage;

import junit.framework.TestCase;


public class MeineKlasseTest extends TestCase {
	MeineKlasse meineKlasse1;

	@Override
	public void setUp() throws Exception {
		meineKlasse1 = new MeineKlasse();
		assertEquals("Anfangs darf kein Job gesetzt sein.", null,
				meineKlasse1.getJob());
	}

	@Override
	public void tearDown() throws Exception {
		meineKlasse1 = null;
	}

	public void testGetAndSetJob() {
		meineKlasse1.setJob("Quadrat");
		assertEquals("Job muss 'Quadrat' sein.", "Quadrat",
				meineKlasse1.getJob());
	}
	
	public void testDoJobs() throws Exception {
		meineKlasse1.setJob("Quadrat");
		assertTrue("Quadrat von '4' muss '16' sein.",
				16. == meineKlasse1.myMethod(4));

		meineKlasse1.setJob("Wurzel");
		assertTrue("Wurzel von '4' muss '2' sein.",
				2. == meineKlasse1.myMethod(4));

		meineKlasse1.setJob(null);
		try {
			meineKlasse1.myMethod(4);
			fail("Exception muss geworfen werden, da kein korrekter Job gesetzt.");
		} catch (Exception ex) {/* ok */
		}
	}
}