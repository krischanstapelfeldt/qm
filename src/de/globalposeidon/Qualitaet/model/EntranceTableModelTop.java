package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Bottom
public class EntranceTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   private Entrance entrance;
   static final int METERID = 0;
   static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private String[] titleTblTop = new String[] { Strings.METERID, Strings.METERTYPE };

   public EntranceTableModelTop(Entrance entrance) {
      this.entrance = entrance;
   }

   public int addElement(final Meter meter) {
      entrance.addMeter(meter);
      fireTableDataChanged();
      return entrance.meterCount() - 1;
   }

   public void removeElement(final Entrance meter) {
      entrance.getMeters().remove(meter);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Meter> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         entrance.getMeters().add(dataList.get(row));
      }
   }

   @Override
   public String getColumnName(final int i) {
      return titleTblTop[i];
   }

   @Override
   public int getColumnCount() {
      return titleTblTop.length;
   }

   @Override
   public int getRowCount() {
      return entrance.getMeters().size();
   }

   public Object getRowAt(final int row) {
      return entrance.getMeters().get(row);
   }

   public void setRowAt(final Meter meter, final int row) {
      entrance.getMeters().set(row, meter);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == METERID) {
         return entrance.getMeters().get(row).getID();
      }
      if (col == METERTYPE) {
         return entrance.getMeters().get(row).getType();
      }
      return null;
   }

   @Override
   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         return true;
      } else if (columnIndex == METERTYPE) {
         return true;
      }
      return false;
   }

   @Override
   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == METERID) {
         entrance.getMeters().get(rowIndex).setID((int) currentValue);
      }
      if (columnIndex == METERTYPE) {
         entrance.getMeters().get(rowIndex).setCurrentValue((int) currentValue);
      }
   }

   public void clear() {
      final int rows = getRowCount();
      entrance.getMeters().clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblTop;
   }

   public ArrayList<Meter> getRowList() {
      return entrance.getMeters();
   }

   public void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public void setRowList(final ArrayList<Meter> rowList) {
      entrance.setMeters(rowList);
   }
}
