//package de.globalposeidon.Qualitaet.model;
//
//import java.util.ArrayList;
//
//import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
//
//import de.globalposeidon.Qualitaet.Strings;
//import de.globalposeidon.Qualitaet.gui.ApartmentJTable;
//
//// configure TabelModel Bottom
//public class ApartmentTableModelBottom extends AbstractTableModel {
//
//   private static final long serialVersionUID = 1817731260470629483L;
//   static final int METERID = 0;
//   static final int METERTYPE = 1;
//   // set Table Bottom Column Header
//   private static String[] titleTblBottom = new String[] { Strings.METERID, Strings.METERTYPE };
//
//   private static ApartmentTableModelBottom TblMdlBottom = new ApartmentTableModelBottom(Apartment.getMeters());
//
//   public ApartmentTableModelBottom(final ArrayList<Meter> meters) {
//
//   }
//
//   public int addElement(final Meter meter) {
//      (Apartment.getMeters()).add(meter);
//      fireTableDataChanged();
//      return Apartment.getMeters().size() - 1;
//   }
//
//   public void removeElement(final Apartment meter) {
//      Apartment.getMeters().remove(meter);
//      fireTableDataChanged();
//   }
//
//   public void setEntries(final ArrayList<Meter> dataList) {
//      clear();
//      for (int row = 0; row < dataList.size(); row++) {
//         Apartment.getMeters().add(dataList.get(row));
//      }
//   }
//
//   @Override
//   public String getColumnName(final int i) {
//      return titleTblBottom[i];
//   }
//
//   @Override
//   public int getColumnCount() {
//      return titleTblBottom.length;
//   }
//
//   @Override
//   public int getRowCount() {
//      return Apartment.getMeters().size();
//   }
//
//   public Object getRowAt(final int row) {
//      return Apartment.getMeters().get(row);
//   }
//
//   public void setRowAt(final Meter meter, final int row) {
//      Apartment.getMeters().set(row, meter);
//      fireTableRowsUpdated(row, row);
//   }
//
//   @Override
//   public Object getValueAt(final int row, final int col) {
//      if (col == METERID) {
//         return Apartment.getMeters().get(row).getID();
//      }
//      if (col == METERTYPE) {
//         return Apartment.getMeters().get(row).getType();
//      }
//      return null;
//   }
//
//   @Override
//   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
//      if (columnIndex == METERID) {
//         return true;
//      } else if (columnIndex == METERTYPE) {
//         return true;
//      }
//      return false;
//   }
//
//   @Override
//   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
//      if (columnIndex == METERID) {
//         Apartment.getMeters().get(rowIndex).setID((int) currentValue);
//      }
//      if (columnIndex == METERTYPE) {
//         Apartment.getMeters().get(rowIndex).setCurrentValue((int) currentValue);
//      }
//   }
//
//   public void clear() {
//      final int rows = getRowCount();
//      Apartment.getMeters().clear();
//      fireTableRowsDeleted(0, rows);
//   }
//
//   public String[] getHeaders() {
//      return titleTblBottom;
//   }
//
//   public ArrayList<Meter> getRowList() {
//      return Apartment.getMeters();
//   }
//
//   public void setHeaders(final String[] headers) {
//      titleTblBottom = headers;
//   }
//
//   public void setRowList(final ArrayList<Meter> rowList) {
//      Apartment.setMeters(rowList);
//   }
//
//   public static JTable getTblBottom() {
//      return getTblBottom();
//   }
//
//   public static void setTblBottom(final JTable tblBottom) {
//      ApartmentJTable.setTblBottom(tblBottom);
//   }
//
//   public static ApartmentTableModelBottom getTblMdlBottom() {
//      return TblMdlBottom;
//   }
//
//}
