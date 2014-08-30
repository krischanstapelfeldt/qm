package de.globalposeidon.Qualitaet.model;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// // configure TabelModel Bottom
public class MeterTableModelBottom extends AbstractTableModel {

   // use this for modelBotoom (readings)
   static final int METERID = 0;
   static final int READINGID = 1;
   static final int METERREADER = 2;
   static final int READINGINFO = 3;
   static final int READINGDATE = 4;
   static final int READINGVALUE = 5;

   private Meter meter;

   // also use for readings
   private String[] titleTblBottom = new String[] { Strings.METERID, Strings.READING, Strings.READINGPERSON, Strings.READINGINFO,
         Strings.READINGDATE, Strings.READINGVALUE };

   public MeterTableModelBottom(final Meter meter) {
      this.meter = meter;
   }

   @Override
   public int getColumnCount() {
      return titleTblBottom.length;
   }

   @Override
   public int getRowCount() {

      return 1;
   }

   public String getColumnName(final int i) {
      return titleTblBottom[i];
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      if (columnIndex == METERID) {
         return meter.getID();
      }
      if (columnIndex == READINGID) {
         return meter.getType();
      }
      if (columnIndex == METERREADER) {
         return meter.getCurrentValue();
      }
      if (columnIndex == READINGINFO) {
         return meter.getYearValue();
      }
      if (columnIndex == READINGDATE) {
         return meter.getLastRead();
      }
      if (columnIndex == READINGVALUE) {
         return meter.getReadings();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         return true;
      }
      if (columnIndex == READINGID) {
         return true;
      }
      if (columnIndex == METERREADER) {
         return true;
      }
      if (columnIndex == READINGINFO) {
         return true;
      }
      if (columnIndex == READINGDATE) {
         return true;
      }
      if (columnIndex == READINGVALUE) {
         return true;
      }
      return false;
   }

}
