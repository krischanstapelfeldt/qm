package de.globalposeidon.Qualitaet.model;

import java.util.Date;

public class Reading {
	
	private int ID;
	
	Meter meter;
	MeterReader reader;
	ReadingInfo info;
	Date readingDate;
	int readingValue;
	
	public Reading(Meter meter, MeterReader reader, ReadingInfo info) {
		readingDate = new Date();
		this.meter = meter;
		this.reader = reader;
		this.info = info;
		readingValue = meter.currentValue;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
