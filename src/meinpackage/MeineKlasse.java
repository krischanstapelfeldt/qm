package meinpackage;

public class MeineKlasse {
	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double myMethod(double x) throws Exception {
		if ("Quadrat".equalsIgnoreCase(job))
			return x * x;
		if ("Wurzel".equalsIgnoreCase(job))
			return Math.sqrt(x);
		throw new Exception("Fehler: Aufgabe nicht korrekt definiert.");
	}
}