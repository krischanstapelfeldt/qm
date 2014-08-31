package de.globalposeidon.Qualitaet.model;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * Tablemodel for Apartmentpanel.
 * @author Hadschii
 */
public class ApartmentTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   private final Apartment apartment;
   private static final int METERID = 0;
   private static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private final String[] titleTblBottom = new String[]{Strings.METERID, Strings.METERTYPE};

   /**
    * Konstruktor.
    * @param apartment
    *           apartment
    */
   public ApartmentTableModelBottom(final Apartment apartment) {
      this.apartment = apartment;
   }

   // ----------- Abstract Table Model Methods
   @Override
   public final String getColumnName(final int i) {
      return titleTblBottom[i];
   }

   @Override
   public final int getColumnCount() {
      return titleTblBottom.length;
   }

   @Override
   public final int getRowCount() {
      return apartment.getMeters().size();
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == METERID) {
         return apartment.getMeters().get(row).getID();
      }
      if (col == METERTYPE) {
         return apartment.getMeters().get(row).getType();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         return false;
      } else if (columnIndex == METERTYPE) {
         return false;
      }
      return false;
   }

   @Override
   public final void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         apartment.getMeters().get(rowIndex).setID((int) currentValue);
      }
      if (columnIndex == METERTYPE) {
         apartment.getMeters().get(rowIndex).setCurrentValue((int) currentValue);
      }
   }
}
