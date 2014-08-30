package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Bottom
public class ApartmentTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   private final Apartment apartment;
   private static final int METERID = 0;
   private static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private String[] titleTblBottom = new String[]{Strings.METERID, Strings.METERTYPE};

   public ApartmentTableModelBottom(final Apartment apartment) {
      this.apartment = apartment;
   }

   public final int addElement(final Meter meter) {
      apartment.addMeter(meter);
      fireTableDataChanged();
      return apartment.meterCount() - 1;
   }

   public final void removeElement(final Meter meter) {
      apartment.getMeters().remove(meter);
      fireTableDataChanged();
   }

   public final void setEntries(final ArrayList<Meter> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         apartment.getMeters().add(dataList.get(row));
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
      return apartment.getMeters().size();
   }

   public final Object getRowAt(final int row) {
      return apartment.getMeters().get(row);
   }

   public final void setRowAt(final Meter meter, final int row) {
      apartment.getMeters().set(row, meter);
      fireTableRowsUpdated(row, row);
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
         return true;
      } else if (columnIndex == METERTYPE) {
         return true;
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

   public final void clear() {
      final int rows = getRowCount();
      apartment.getMeters().clear();
      fireTableRowsDeleted(0, rows);
   }

   public final String[] getHeaders() {
      return titleTblBottom;
   }

   public final ArrayList<Meter> getRowList() {
      return apartment.getMeters();
   }

   public final void setHeaders(final String[] headers) {
      titleTblBottom = headers;
   }

   public final void setRowList(final ArrayList<Meter> rowList) {
      apartment.setMeters(rowList);
   }
}
