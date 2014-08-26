package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/**
 * reading model.
 * @author Timm Suhl
 */
public class Reading {

   private int id;

   public final Meter getMeter() {
      return meter;
   }

   public final MeterReader getReader() {
      return reader;
   }

   public final ReadingInfo getInfo() {
      return info;
   }

   public final Date getReadingDate() {
      return readingDate;
   }

   public final int getReadingValue() {
      return readingValue;
   }

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
      return id;
   }

   public final void setID(final int iD) {
      id = iD;
   }
}
