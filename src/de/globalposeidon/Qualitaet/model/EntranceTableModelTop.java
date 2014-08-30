package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * Author Jens-Rainer Felske
 */
// configure TabelModel Bottom
public class EntranceTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   private final Entrance entrance;
   static final int METERID = 0;
   static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private String[] titleTblTop = new String[]{Strings.METERID, Strings.METERTYPE};

   public EntranceTableModelTop(final Entrance entrance) {
      this.entrance = entrance;
   }

   public final int addElement(final Meter meter) {
      entrance.addMeter(meter);
      fireTableDataChanged();
      return entrance.meterCount() - 1;
   }

   public final void removeElement(final Meter meter) {
      entrance.getMeters().remove(meter);
      fireTableDataChanged();
   }

   public final void setEntries(final ArrayList<Meter> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         entrance.getMeters().add(dataList.get(row));
      }
   }

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

   public final Object getRowAt(final int row) {
      return entrance.getMeters().get(row);
   }

   public final void setRowAt(final Meter meter, final int row) {
      entrance.getMeters().set(row, meter);
      fireTableRowsUpdated(row, row);
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
      if (columnIndex == METERTYPE) {
      }
   }

   public final void clear() {
      final int rows = getRowCount();
      entrance.getMeters().clear();
      fireTableRowsDeleted(0, rows);
   }

   public final String[] getHeaders() {
      return titleTblTop;
   }

   public final ArrayList<Meter> getRowList() {
      return entrance.getMeters();
   }

   public final void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public final void setRowList(final ArrayList<Meter> rowList) {
      entrance.setMeters(rowList);
   }
}
