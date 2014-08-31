package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * meter model.
 * @author Timm Suhl
 */
public class Meter extends DefaultMutableTreeNode implements java.io.Serializable{

   private static final long serialVersionUID = 415757316236669188L;
   private int id;
   private final Entrance entrance; // parent node
   private final Apartment apartment; // parent node

   private final Metertype type;
   private int currentValue;
   private int yearValue; // wert zum 01.01 eines Jahres
   private Date lastRead; // letzter ablesewert
   private ArrayList<Reading> readings;
   private int readerCounter = 0;

   // ================================================================================
   // constructors
   // ================================================================================
   // empty meter not allowed, so no Meter()
   /**
    * Konstruktor.
    * @param meterID ID
    * @param type Typ
    * @param entrance Eingang
    */
   public Meter(final int meterID, final Metertype type, final Entrance entrance) {
       readings = new ArrayList<Reading>();
      this.entrance = entrance;
      apartment = null;
      id = meterID;
      this.type = type;
      currentValue = 0;
      yearValue = 0;
      lastRead = new Date();
   }
   /**
    * Konstruktor.
    * @param meterID ID
    * @param type Typ
    * @param apartment Apartment
    */
   public Meter(final int meterID, final Metertype type, final Apartment apartment) {
       readings = new ArrayList<Reading>();
      this.apartment = apartment;
      entrance = null;
      id = meterID;
      this.type = type;
      currentValue = 0;
      yearValue = 0;
      lastRead = new Date();
   }
   /**
    * ID setzen.
    * @param iD ID
    */
   public final void setID(final int iD) {
      id = iD;
   }
   /**
    * ID erhalte.
    * @return ID
    */
   public final int getID() {
      return id;
   }
   /**
    * Aktueller Wert.
    * @return Wert
    */
   public final int getCurrentValue() {
      return currentValue;
   }
   /**
    * Aktuellen Wert setzen.
    * @param currentValue Wert
    */
   public final void setCurrentValue(final int currentValue) {
      // only can be set forward
      if (currentValue > this.currentValue) {
         this.currentValue = currentValue;
      }
   }
   /**
    * Wert zum 1.1. des Jahres
    * @return Wert
    */
   public final int getYearValue() {
      return yearValue;
   }
   /**
    * Jahreswert setzen.
    * @param yearValue Wert
    */
   public final void setYearValue(final int yearValue) {
      // only can be set forward
      if (yearValue > this.yearValue) {
         this.yearValue = yearValue;
      }
   }
   /**
    * Zuletzt gelesen am.
    * @return Datum.
    */
   public final Date getLastRead() {
      return (Date) lastRead.clone();
   }
   /**
    * Zuletzt gelesen am setzen.
    * @param lastRead Datum
    */
   public final void setLastRead(final Date lastRead) {
      // only can be set forward
      if (!lastRead.before(this.lastRead)) {
         this.lastRead = lastRead;
      }
   }
   /**
    * Typ des Zaehlers.
    * @return Typ
    */
   public final Metertype getType() {
      return type;
   }
   /**
    * Liste mit allen Zaehlungen.
    * @return Liste
    */
   public final ArrayList<Reading> getReadings(){
       return readings;
   }
   /**
    * Liste der Zaehlungen setzen.
    * @param readings Liste
    */
   public final void setReadings(final ArrayList<Reading> readings) {
       this.readings = readings;
   }
   // ================================================================================
   // other stuff, dont know nice name
   // ================================================================================
   /**
    * Zaehlung machen.
    * @param reader reader
    * @param info info
    * @return Zaehlung
    */
   public final Reading makeReading(Date date, final MeterReader reader, final ReadingInfo info) {
	   Reading reading = new Reading(this, reader, info, date);
       readings.add(reading);
       setLastRead(date); // Set last Read to today
      return reading;
   }
   /**
    * returns and then increases the reading counter
    * @return counter
    */
   public int incReadingCounter() {
	   return readerCounter++;
   }
   
   @Override
   public final String toString() {
      return (id + " " + type + " " + currentValue + " " + yearValue + " " + lastRead);
   }

   // ================================================================================
   // TreeNode Interface
   // ================================================================================
   @Override
   public final TreeNode getChildAt(final int childIndex) {
      return null;
   }

   @Override
   public final int getChildCount() {
      return 0;
   }

   @Override
   public final TreeNode getParent() {
      return entrance != null ? entrance : apartment;
   }

   @Override
   public final int getIndex(final TreeNode node) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public final boolean getAllowsChildren() {
      return false;
   }

   @Override
   public final boolean isLeaf() {
      return true;
   }

   @Override
   public final Enumeration<?> children() {
      return null;
   }

}
