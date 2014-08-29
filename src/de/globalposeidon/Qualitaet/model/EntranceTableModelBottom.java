//package de.globalposeidon.Qualitaet.model;
//
//import java.util.ArrayList;
//
//import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
//
//import de.globalposeidon.Qualitaet.Strings;
//import de.globalposeidon.Qualitaet.gui.EntranceJTable;
//
//// configure TabelModel Bottom
//public class EntranceTableModelBottom extends AbstractTableModel {
//
//   private static final long serialVersionUID = 1817731260470629483L;
//   static final int APARTMENT = 0;
//   // set Table Bottom Column Header
//   private static String[] titleTblBottom = new String[] { Strings.APARTMENT };
//
//   private static EntranceTableModelBottom TblMdlBottom = new EntranceTableModelBottom(Entrance.getApartment());
//
//   public EntranceTableModelBottom(final ArrayList<Apartment> meters) {
//
//   }
//
//   public int addElement(final Apartment apartment) {
//      (Entrance.getApartment()).add(apartment);
//      fireTableDataChanged();
//      return Entrance.getApartment().size() - 1;
//   }
//
//   public void removeElement(final Entrance apartment) {
//      Entrance.getApartment().remove(apartment);
//      fireTableDataChanged();
//   }
//
//   public void setEntries(final ArrayList<Apartment> dataList) {
//      clear();
//      for (int row = 0; row < dataList.size(); row++) {
//         Entrance.getApartment().add(dataList.get(row));
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
//      return Entrance.getApartment().size();
//   }
//
//   public Object getRowAt(final int row) {
//      return Entrance.getApartment().get(row);
//   }
//
//   public void setRowAt(final Apartment apartment, final int row) {
//      Entrance.getApartment().set(row, apartment);
//      fireTableRowsUpdated(row, row);
//   }
//
//   @Override
//   public Object getValueAt(final int row, final int col) {
//      if (col == APARTMENT) {
//         return Entrance.getApartment().get(row).getID();
//      }
//      return null;
//   }
//
//   @Override
//   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
//      if (columnIndex == APARTMENT) {
//         return true;
//      }
//
//      return false;
//   }
//
//   @Override
//   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
//      if (columnIndex == APARTMENT) {
//         Entrance.getApartment().get(rowIndex).setID((int) currentValue);
//      }
//
//   }
//
//   public void clear() {
//      final int rows = getRowCount();
//      Entrance.getApartment().clear();
//      fireTableRowsDeleted(0, rows);
//   }
//
//   public String[] getHeaders() {
//      return titleTblBottom;
//   }
//
//   public ArrayList<Apartment> getRowList() {
//      return Entrance.getApartment();
//   }
//
//   public void setHeaders(final String[] headers) {
//      titleTblBottom = headers;
//   }
//
//   public void setRowList(final ArrayList<Apartment> rowList) {
//      Entrance.setApartments(rowList);
//   }
//
//   public static JTable getTblBottom() {
//      return getTblBottom();
//   }
//
//   public static void setTblBottom(final JTable tblBottom) {
//      EntranceJTable.setTblBottom(tblBottom);
//   }
//
//   public static EntranceTableModelBottom getTblMdlBottom() {
//      return TblMdlBottom;
//   }
//
//}
