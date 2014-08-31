package de.globalposeidon.Qualitaet.model;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * TableModel for Meterpanel.
 * @author Hadschii
 *
 */
public class MeterTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 566486559559380979L;
   
   static final int METERID = 0;
   static final int READINGID = 1;
   static final int METERREADER = 2;
   static final int READINGINFO = 3;
   static final int READINGDATE = 4;
   static final int READINGVALUE = 5;

   private Meter meter;

   private String[] titleTblBottom = new String[] { Strings.METERID, Strings.READING, Strings.READINGPERSON, Strings.READINGINFO,
         Strings.READINGDATE, Strings.READINGVALUE };
   /**
    * Konstruktor.
    * @param meter meter
    */
   public MeterTableModelBottom(final Meter meter) {
      this.meter = meter;
   }

// ----------- Abstract Table Model Methods
   @Override
   public int getColumnCount() {
      return titleTblBottom.length;
   }

   @Override
   public int getRowCount() {

      return meter.getReadings().size();
   }
   @Override
   public String getColumnName(final int i) {
      return titleTblBottom[i];
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      if (columnIndex == METERID) {
         return meter.getID();
      }
      if (columnIndex == READINGID) {
         return meter.getReadings().get(rowIndex).getID();
      }
      if (columnIndex == METERREADER) {
         return meter.getReadings().get(rowIndex).getReader();
      }
      if (columnIndex == READINGINFO) {
         return meter.getReadings().get(rowIndex).getInfo();
      }
      if (columnIndex == READINGDATE) {
         return meter.getReadings().get(rowIndex).getReadingDate();
      }
      if (columnIndex == READINGVALUE) {
         return meter.getReadings().get(rowIndex).getReadingValue();
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
