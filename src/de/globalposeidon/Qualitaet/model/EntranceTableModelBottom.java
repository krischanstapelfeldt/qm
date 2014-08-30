package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * Author Jens-Rainer Felske
 */
// configure TabelModel Bottom
public class EntranceTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   static final int APARTMENT = 0;
   private final Entrance entrance;
   // set Table Bottom Column Header
   private String[] titleTblBottom = new String[]{Strings.APARTMENT};

   public EntranceTableModelBottom(final Entrance entrance) {
      this.entrance = entrance;
   }

   public final int addElement(final Apartment apartment) {
      (entrance.getApartments()).add(apartment);
      fireTableDataChanged();
      return entrance.getApartments().size() - 1;
   }

   public final void removeElement(final Apartment apartment) {
      entrance.getApartments().remove(apartment);
      fireTableDataChanged();
   }

   public final void setEntries(final ArrayList<Apartment> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         entrance.getApartments().add(dataList.get(row));
      }
   }

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

   public final Object getRowAt(final int row) {
      return entrance.getApartments().get(row);
   }

   public final void setRowAt(final Apartment apartment, final int row) {
      entrance.getApartments().set(row, apartment);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == APARTMENT) {
         return entrance.getApartments().get(row).getID();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == APARTMENT) {
         return true;
      }

      return false;
   }

   @Override
   public final void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == APARTMENT && currentValue.getClass() == String.class) {
         entrance.getApartments().get(rowIndex).setID(new Integer((String) currentValue));
      }

   }

   public final void clear() {
      final int rows = getRowCount();
      entrance.getApartments().clear();
      fireTableRowsDeleted(0, rows);
   }

   public final String[] getHeaders() {
      return titleTblBottom;
   }

   public final ArrayList<Apartment> getRowList() {
      return entrance.getApartments();
   }

   public final void setHeaders(final String[] headers) {
      titleTblBottom = headers;
   }

   public final void setRowList(final ArrayList<Apartment> rowList) {
      entrance.setApartments(rowList);
   }
}
