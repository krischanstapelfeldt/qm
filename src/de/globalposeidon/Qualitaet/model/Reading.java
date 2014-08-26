package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/**
 * reading model.
 * 
 * @author Timm
 */
public class Reading {

   private int ID;

   private final Meter meter;
   private final MeterReader reader;
   private final ReadingInfo info;
   private final Date readingDate;
   private final int readingValue;

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
