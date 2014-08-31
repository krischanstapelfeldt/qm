package de.globalposeidon.Qualitaet.model;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * TableModel for Entrancepanel.
 * @author Hadschii
 */
public class EntranceTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   private final Entrance entrance;
   static final int METERID = 0;
   static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private final String[] titleTblTop = new String[]{Strings.METERID, Strings.METERTYPE};

   /**
    * Konstruktor.
    * @param entrance
    *           entrance
    */
   public EntranceTableModelTop(final Entrance entrance) {
      this.entrance = entrance;
   }

   // ----------- Abstract Table Model Methods
   @Override
   public final String getColumnName(final int i) {
      return titleTblTop[i];
   }

   @Override
   public final int getColumnCount() {
      return titleTblTop.length;
   }

   @Override
   public final int getRowCount() {
      return entrance.getMeters().size();
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == METERID) {
         return entrance.getMeters().get(row).getID();
      }
      if (col == METERTYPE) {
         return entrance.getMeters().get(row).getType();
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
         if (currentValue.getClass() == (String.class)) {
            entrance.getMeters().get(rowIndex).setID(new Integer((String) currentValue));
         } else {
            entrance.getMeters().get(rowIndex).setID((int) currentValue);
         }
      }
   }
}
