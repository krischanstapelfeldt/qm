package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.gui.EntranceJTable;

// configure TabelModel Bottom
public class EntranceTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = 1817731260470629483L;
   static final int METERID = 0;
   static final int METERTYPE = 1;
   // set Table Bottom Column Header
   private static String[] titleTblTop = new String[] { Strings.METERID, Strings.METERTYPE };

   private static EntranceTableModelTop TblMdlTop = new EntranceTableModelTop(Apartment.getMeters());

   public EntranceTableModelTop(final ArrayList<Meter> meters) {

   }

   public int addElement(final Meter meter) {
      (Entrance.getMeters()).add(meter);
      fireTableDataChanged();
      return Entrance.getMeters().size() - 1;
   }

   public void removeElement(final Entrance meter) {
      Entrance.getMeters().remove(meter);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Meter> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         Entrance.getMeters().add(dataList.get(row));
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
      return Entrance.getMeters().size();
   }

   public Object getRowAt(final int row) {
      return Entrance.getMeters().get(row);
   }

   public void setRowAt(final Meter meter, final int row) {
      Entrance.getMeters().set(row, meter);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == METERID) {
         return Entrance.getMeters().get(row).getID();
      }
      if (col == METERTYPE) {
         return Entrance.getMeters().get(row).getType();
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
         Entrance.getMeters().get(rowIndex).setID((int) currentValue);
      }
      if (columnIndex == METERTYPE) {
         Entrance.getMeters().get(rowIndex).setCurrentValue((int) currentValue);
      }
   }

   public void clear() {
      final int rows = getRowCount();
      Entrance.getMeters().clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblTop;
   }

   public ArrayList<Meter> getRowList() {
      return Entrance.getMeters();
   }

   public void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public void setRowList(final ArrayList<Meter> rowList) {
      Entrance.setMeters(rowList);
   }

   public static JTable getTblTop() {
      return getTblTop();
   }

   public static void setTblTop(final JTable tblTop) {
      EntranceJTable.setTblTop(tblTop);
   }

   public static EntranceTableModelTop getTblMdlTop() {
      return TblMdlTop;
   }

}
