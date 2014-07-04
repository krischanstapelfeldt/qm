package global;

import java.util.Date;

public class Meter {
	
	int meterID;
	Metertype type;
	int currentValue;
	int yearValue; // wert zum 01.01 eines Jahres
	Date lastRead; // letzter ablesewert
// TODO MeterReader ENUM, also wer hats gelesen implementieren.
	
//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		return (meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead);
	}
	
//================================================================================
// test functions
//================================================================================
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