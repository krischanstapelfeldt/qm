package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * TableModel for Entrancepanel.
 * @author Hadschii
 *
 */
public class EntranceTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   static final int APARTMENT = 0;
   static final int ISRENTED = 1;
   
   private final Entrance entrance;
   private String[] titleTblBottom = new String[]{Strings.APARTMENT, "Rented?"};
   
   /**
    * Konstruktor.
    * @param entrance entrance
    */
   public EntranceTableModelBottom(final Entrance entrance) {
      this.entrance = entrance;
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
      return entrance.getApartments().size();
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == APARTMENT) {
         return entrance.getApartments().get(row).getID();
      }
      if (col == ISRENTED) {
          return !entrance.getApartments().get(row).apartmentIsEmpty();
       }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == APARTMENT) {
         return false;
      }
      if (columnIndex == ISRENTED) {
          return false;
       }
      return false;
   }

}
