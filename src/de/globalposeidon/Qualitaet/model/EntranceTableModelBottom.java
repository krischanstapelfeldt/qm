package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Bottom
public class EntranceTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   static final int APARTMENT = 0;
   private final Entrance entrance;
   // set Table Bottom Column Header
   private String[] titleTblBottom = new String[] { Strings.APARTMENT };

   public EntranceTableModelBottom(Entrance entrance) {
      this.entrance = entrance;
   }

   public int addElement(final Apartment apartment) {
      (entrance.getApartments()).add(apartment);
      fireTableDataChanged();
      return entrance.getApartments().size() - 1;
   }

   public void removeElement(final Apartment apartment) {
      entrance.getApartments().remove(apartment);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Apartment> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         entrance.getApartments().add(dataList.get(row));
      }
   }

   @Override
   public String getColumnName(final int i) {
      return titleTblBottom[i];
   }

   @Override
   public int getColumnCount() {
      return titleTblBottom.length;
   }

   @Override
   public int getRowCount() {
      return entrance.getApartments().size();
   }

   public Object getRowAt(final int row) {
      return entrance.getApartments().get(row);
   }

   public void setRowAt(final Apartment apartment, final int row) {
      entrance.getApartments().set(row, apartment);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == APARTMENT) {
         return entrance.getApartments().get(row).getID();
      }
      return null;
   }

   @Override
   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == APARTMENT) {
         return true;
      }

      return false;
   }

   @Override
   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == APARTMENT) {
         entrance.getApartments().get(rowIndex).setID((int) currentValue);
      }

   }

   public void clear() {
      final int rows = getRowCount();
      entrance.getApartments().clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblBottom;
   }

   public ArrayList<Apartment> getRowList() {
      return entrance.getApartments();
   }

   public void setHeaders(final String[] headers) {
      titleTblBottom = headers;
   }

   public void setRowList(final ArrayList<Apartment> rowList) {
      entrance.setApartments(rowList);
   }
}
