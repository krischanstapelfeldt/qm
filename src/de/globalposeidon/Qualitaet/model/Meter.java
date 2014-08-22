package de.globalposeidon.Qualitaet.model;

import java.util.Date;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A2 - Zaehler unterstuetzen verschieden Typen
 * A3 - Zaehler sind eindeutig zu identifizieren -> meterID
 * A5 - Zaehler haben eine Ablesewert ->currentValue/yearValue
 * A8 - Zaehlerwert und Datum laufen vorwaerts
 */

public class Meter implements TreeNode{
	
	final private Apartment apartment;
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
	public Meter(int meterID, Metertype type, Apartment apartment) {
		this.apartment = apartment;
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
		if(!lastRead.before(this.lastRead)) {
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
	
// TODO: REMOVE OLD TEST STUFF
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
	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}
	@Override
	public int getChildCount() {
		return 0;
	}
	@Override
	public TreeNode getParent() {
		return apartment;
	}
	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean getAllowsChildren() {
		return false;
	}
	@Override
	public boolean isLeaf() {
		return true;
	}
	@Override
	public Enumeration<?> children() {
		return null;
	}

}
