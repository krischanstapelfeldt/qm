package de.globalposeidon.Qualitaet.model;

import java.util.Date;

/**
 * reading model.
 * @author Timm Suhl
 */
public class Reading {

   private int id;

   private final Meter meter;
   private final MeterReader reader;
   private final ReadingInfo info;
   private final Date readingDate;
   private final int readingValue;
   /**
    * Meter erhalten.
    * @return meter
    */
   public final Meter getMeter() {
      return meter;
   }
   /**
    * Zaehlung erhalten.
    * @return Zaehlung
    */
   public final MeterReader getReader() {
      return reader;
   }
   /**
    * Ableseinformation erhalten.
    * @return Ableseinfo
    */
   public final ReadingInfo getInfo() {
      return info;
   }
   /**
    * Ablesedatum erhalten.
    * @return Datum
    */
   public final Date getReadingDate() {
      return (Date) readingDate.clone();
   }
   /**
    * Ablesewert erhalten.
    * @return Ablesewert
    */
   public final int getReadingValue() {
      return readingValue;
   }
   /**
    * Konstruktor.
    * @param meter Zaehler
    * @param reader Ablesemensch
    * @param info Info
    */
   public Reading(final Meter meter, final MeterReader reader, final ReadingInfo info) {
      readingDate = new Date();
      this.meter = meter;
      this.reader = reader;
      this.info = info;
      readingValue = meter.getCurrentValue();
   }
   /**
    * ID erhalten.
    * @return id
    */
   public final int getID() {
      return id;
   }

}
