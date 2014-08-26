package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/**
 * reading model.
 * @author Timm
 *
 */
public class Reading {

	private int ID;

	private Meter meter;
	private MeterReader reader;
	private ReadingInfo info;
	private Date readingDate;
	private int readingValue;

	public Reading(final Meter meter, final MeterReader reader, final ReadingInfo info) {
		readingDate = new Date();
		this.meter = meter;
		this.reader = reader;
		this.info = info;
		readingValue = meter.getCurrentValue();
	}

	public final int getID() {
		return ID;
	}

	public final void setID(final int iD) {
		ID = iD;
	}
}
