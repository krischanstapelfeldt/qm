package de.globalposeidon.Qualitaet.model;

import java.util.Date;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/**
 * meter model.
 * @author Timm Suhl
 */
public class Meter implements TreeNode {

   private int id;
   private final Entrance entrance; // parent node
   private final Apartment apartment; // parent node

   private final Metertype type;
   private int currentValue;
   private int yearValue; // wert zum 01.01 eines Jahres
   private Date lastRead; // letzter ablesewert

   // ================================================================================
   // constructors
   // ================================================================================
   // empty meter not allowed, so no Meter()

   public Meter(final int meterID, final Metertype type, final Entrance entrance) {
      this.entrance = entrance;
      apartment = null;
      id = meterID;
      this.type = type;
      currentValue = 0;
      yearValue = 0;
      lastRead = new Date();
   }

   public Meter(final int meterID, final Metertype type, final Apartment apartment) {
      this.apartment = apartment;
      entrance = null;
      id = meterID;
      this.type = type;
      currentValue = 0;
      yearValue = 0;
      lastRead = new Date();
   }

   // ================================================================================
   // access private variables
   // ================================================================================
   public final int getID() {
      return id;
   }

   public final int getCurrentValue() {
      return currentValue;
   }

   public final void setCurrentValue(final int currentValue) {
      // only can be set forward
      if (currentValue > this.currentValue) {
         this.currentValue = currentValue;
      }
   }

   public final int getYearValue() {
      return yearValue;
   }

   public final void setYearValue(final int yearValue) {
      // only can be set forward
      if (yearValue > this.yearValue) {
         this.yearValue = yearValue;
      }
   }

   public final Date getLastRead() {
      return lastRead;
   }

   public final void setLastRead(final Date lastRead) {
      // only can be set forward
      if (!lastRead.before(this.lastRead)) {
         this.lastRead = lastRead;
      }
   }

   public final Metertype getType() {
      return type;
   }

   // ================================================================================
   // other stuff, dont know nice name
   // ================================================================================
   public final Reading makeReading() {
      return new Reading(this, MeterReader.JANITOR, ReadingInfo.ESTIMATION);
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
