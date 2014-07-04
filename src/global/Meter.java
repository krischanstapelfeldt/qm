package global;

import java.util.Date;

public class Meter {
	
	int meterID;
	Metertype type;
	int currentValue;
	int yearValue; // wert zum 01.01 eines Jahres
	Date lastRead; // letzter ablesewert
// TODO MeterReader, also wer hats gelesen implementieren.
	public boolean add() {
		return true;
	}

	public boolean delete() {
		return true;
	}

	public int[] list(int id) {
		int[] i = null;
		return i;
	}

	public boolean read(int newValue, Date readingDate) {
		return true;
	}

}