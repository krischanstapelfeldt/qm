package de.globalposeidon.Qualitaet.model;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * TableModel for Meterpanel.
 * @author Hadschii
 */
public class MeterTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = -7166828471266641592L;

   static final int METERID = 0;
   static final int METERTYPE = 1;
   static final int METERVALUE = 2;
   static final int METERYEARVALUE = 3;
   static final int LASTREAD = 4;

   private final Meter meter;

   private final String[] titleTblTop = new String[]{Strings.METERID, Strings.METERTYPE, Strings.CURRENTVALUE, Strings.YEARVALUE,
         Strings.LASTREAD};

   /**
    * Konstruktor.
    * @param meter
    *           meter
    */
   public MeterTableModelTop(final Meter meter) {
      this.meter = meter;
   }

   // ----------- Abstract Table Model Methods
   @Override
   public final int getColumnCount() {
      return titleTblTop.length;
   }

   @Override
   public final int getRowCount() {

      return 1;
   }

   @Override
   public final String getColumnName(final int i) {
      return titleTblTop[i];
   }

   @Override
   public final Object getValueAt(final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         return meter.getID();
      }
      if (columnIndex == METERTYPE) {
         return meter.getType();
      }
      if (columnIndex == METERVALUE) {
         return meter.getCurrentValue();
      }
      if (columnIndex == METERYEARVALUE) {
         return meter.getYearValue();
      }
      if (columnIndex == LASTREAD) {
         return meter.getLastRead();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         return true;
      } else if (columnIndex == METERTYPE) {
         return true;
      } else if (columnIndex == METERVALUE) {
         return true;
      } else if (columnIndex == METERYEARVALUE) {
         return true;
      } else if (columnIndex == LASTREAD) {
         return true;
      }
      return false;
   }

}
