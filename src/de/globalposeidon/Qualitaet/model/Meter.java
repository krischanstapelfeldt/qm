package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/* abgedeckte Anforderungen
 * A2 - Zaehler unterstuetzen verschieden Typen
 * A3 - Zaehler sind eindeutig zu identifizieren -> meterID
 * A5 - Zaehler haben eine Ablesewert ->currentValue/yearValue
 * A8 - Zaehlerwert und Datum laufen vorwaerts
 */

public class Meter {
	
	private int ID;
	final Metertype type;
	int currentValue;
	int yearValue; // wert zum 01.01 eines Jahres
	Date lastRead; // letzter ablesewert

//================================================================================
// constructors
//================================================================================
	// empty meter not allowed, so no Meter()

	// structure with initial building
	public Meter(int meterID, Metertype type) {
		this.ID = meterID;
		this.type = type;
		this.currentValue = 0;
		this.yearValue = 0;
		this.lastRead = new Date();
	}
//================================================================================
// access private variables
//================================================================================
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		// only can be set forward
		if (currentValue > this.currentValue) {
			this.currentValue = currentValue; 
		}
	}

	public int getYearValue() {
		return yearValue;
	}

	public void setYearValue(int yearValue) {
		// only can be set forward
		if (yearValue > this.yearValue) {
			this.yearValue = yearValue;
		}
	}

	public Date getLastRead() {
		return lastRead;
	}

	public void setLastRead(Date lastRead) {
		// only can be set forward
		if(lastRead.before(this.lastRead)) {
			this.lastRead = lastRead;
		}
	}
	
	public Metertype getType() {
		return this.type;
	}
//================================================================================
// other stuff, dont know nice name
//================================================================================
	public Reading makeReading() {
		return new Reading(this, MeterReader.JANITOR, ReadingInfo.ESTIMATION);
	}
	
	@Override
	public String toString() {
		return (ID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead);
	}
	
//================================================================================
// TODO: REMOVE OLD TEST STUFF
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