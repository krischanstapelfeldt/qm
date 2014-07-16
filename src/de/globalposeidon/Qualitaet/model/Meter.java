package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/* abgedeckte Anforderungen
 * A3 - Zaehler sind eindeutig zu identifizieren -> meterID
 * A5 - Zaehler haben eine Ablesewert ->currentValue/yearValue
 * A8 - Zaehlerwert und Datum laufen vorwaerts
 */

public class Meter {
	
	final int meterID;
	Metertype type;
	int currentValue;
	int yearValue; // wert zum 01.01 eines Jahres
	Date lastRead; // letzter ablesewert

//================================================================================
// constructors
//================================================================================
	// empty strucuture not allowed, so no BuildingStructure()

	// structure with initial building
	public Meter(int meterID, Metertype type) {
		this.meterID = meterID;
		this.type = type;
		this.currentValue = 0;
		this.yearValue = 0;
	}
//================================================================================
// access private variables
//================================================================================
	public int getMeterID() {
		return meterID;
	}

	public Metertype getType() {
		return type;
	}
	// TODO: type as final too?
	public void setType(Metertype type) {
		this.type = type;
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
	
//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		return (meterID + " " + type + " " + currentValue + " " + yearValue + " " + lastRead);
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