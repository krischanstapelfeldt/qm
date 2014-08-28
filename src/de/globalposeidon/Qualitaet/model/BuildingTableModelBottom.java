//package de.globalposeidon.Qualitaet.model;
//
//import java.util.ArrayList;
//
//import javax.swing.table.AbstractTableModel;
//
//import de.globalposeidon.Qualitaet.Strings;
//
////// configure TabelModel Bottom
//   public class BuildingTableModelBottom extends AbstractTableModel {
//
//   /**
//    * 
//    */
//      private static final long serialVersionUID = -7166828471266641592L;
//      static final int NAME = 0;
//      static final int SURNAME = 1;
//      static final int PHONE = 2;
//      static final int EMAIL = 3;
//
//      // set Table Bottom Column Header
//      private static String[] titleTblBottom = new String[] { Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL };
//
//      private static final BuildingTableModelBottom TblMdlBottom = new BuildingTableModelBottom(Building.getRenter());
//
//      public BuildingTableModelBottom(Renter renter) {
//
//      }
//
//      public Renter addElement(final Renter[] tmpArrayRenter) {
//         Building.getRenter();
//         fireTableDataChanged();
//         return Building.getRenter();
//      }
//
//      public void removeElement(final Building renter) {
//         Building.getRenter();
//         fireTableDataChanged();
//      }
//
////      public void setEntries(final Renter dataList) {
////         clear();
////         for (int row = 0; row < dataList; row++) {
////            Building.getRenter().add(dataList.get(row));
////         }
////      }
//
//      @Override
//      public String getColumnName(final int i) {
//         return titleTblBottom[i];
//      }
//
//      @Override
//      public int getColumnCount() {
//         return titleTblBottom.length;
//      }
//
//      @Override
//      public int getRowCount() {
//         return Building.getRenter().size();
//      }
//
//      public Object getRowAt(final int row) {
//         return Building.getRenter().get(row);
//      }
//
//      public void setRowAt(final Renter renter, final int row) {
//         Building.getRenter().set(row, renter);
//         fireTableRowsUpdated(row, row);
//      }
//
//      @Override
//      public Object getValueAt(final int row, final int col) {
//         if (col == NAME) {
//            return Building.getRenter().get(row).getName();
//         }
//         if (col == SURNAME) {
//            return Building.getRenter().get(row).getSurname();
//         }
//         if (col == PHONE) {
//            return Building.getRenter().get(row).getPhone();
//         }
//         if (col == EMAIL) {
//            return Building.getRenter().get(row).getEmail();
//         }
//         return null;
//      }
//
//      @Override
//      public boolean isCellEditable(final int rowIndex, final int columnIndex) {
//         if (columnIndex == NAME) {
//            return true;
//         } else if (columnIndex == SURNAME) {
//            return true;
//         } else if (columnIndex == PHONE) {
//            return true;
//         } else if (columnIndex == EMAIL) {
//            return true;
//         }
//
//         return false;
//      }
//
//      @Override
//      public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
//         if (columnIndex == NAME) {
//            Building.getRenter().get(rowIndex).setName((String) currentValue);
//         }
//         if (columnIndex == SURNAME) {
//            Building.getRenter().get(rowIndex).setSurname((String) currentValue);
//         }
//         if (columnIndex == PHONE) {
//            Building.getRenter().get(rowIndex).setPhone((String) currentValue);
//         }
//         if (columnIndex == EMAIL) {
//            Building.getRenter().get(rowIndex).setEmail((String) currentValue);
//         }
//      }
//
//      public void clear() {
//         final int rows = getRowCount();
//         Building.getRenter().clear();
//         fireTableRowsDeleted(0, rows);
//      }
//
//      public String[] getHeaders() {
//         return titleTblBottom;
//      }
//
//      public ArrayList<Tenant> getRowList() {
//         return Building.getRenter();
//      }
//
//      public void setHeaders(final String[] headers) {
//         titleTblBottom = headers;
//      }
//
//      public void setRowList(final ArrayList<Tenant> rowList) {
//         Building.setRenter(rowList);
//      }
//
//      public static BuildingTableModelBottom getTblMdlBottom() {
//         return TblMdlBottom;
//      }
//
//}
