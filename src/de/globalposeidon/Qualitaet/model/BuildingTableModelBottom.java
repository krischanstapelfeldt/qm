//package de.globalposeidon.Qualitaet.model;
//
//import java.util.ArrayList;
//
//import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
//
//import de.globalposeidon.Qualitaet.Strings;
//import de.globalposeidon.Qualitaet.gui.BuildingJTable;
//
//// configure TabelModel Bottom
//public class BuildingTableModelBottom extends AbstractTableModel {
//
//   /**
//    * 
//    */
//   private static final long serialVersionUID = 7275188332461034629L;
//   static final int RENTER = 0;
//   // set Table Bottom Column Header
//   private static String[] titleTblBottom = new String[] { Strings.RENTER };
//
//   private static BuildingTableModelBottom TblMdlBottom = new BuildingTableModelBottom(Building.getRenter());
//
//   public BuildingTableModelBottom(final Renter renter) {
//
//   }

//   public int addElement(final Renter renter) {
//      (Building.getRenter()).add(renter);
//      fireTableDataChanged();
//      return Building.getRenter().size() - 1;
//   }
//
//   public void removeElement(final Building renter) {
//      Building.getRenter().remove(renter);
//      fireTableDataChanged();
//   }
//
//   public void setEntries(final ArrayList<Entrance> dataList) {
//      clear();
//      for (int row = 0; row < dataList.size(); row++) {
//         Building.getEntrance().add(dataList.get(row));
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
//      return Building.getRenter();
//   }
//
//   public Object getRowAt(final int row) {
//      return Building.getEntrance().get(row);
//   }
//
//   public void setRowAt(final Entrance entrences, final int row) {
//      Building.getEntrance().set(row, entrences);
//      fireTableRowsUpdated(row, row);
//   }
//
//   @Override
//   public Object getValueAt(final int row, final int col) {
//      if (col == ENTRANCE) {
//         return Building.getEntrance().get(row).getID();
//      }
//      return null;
//   }
//
//   @Override
//   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
//      if (columnIndex == ENTRANCE) {
//         return true;
//      }
//
//      return false;
//   }
//
//   @Override
//   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
//      if (columnIndex == ENTRANCE) {
//         Building.getEntrance().get(rowIndex).setID((int) currentValue);
//      }
//
//   }
//
//   public void clear() {
//      final int rows = getRowCount();
//      Building.getEntrance().clear();
//      fireTableRowsDeleted(0, rows);
//   }
//
//   public String[] getHeaders() {
//      return titleTblBottom;
//   }
//
//   public ArrayList<Entrance> getRowList() {
//      return Building.getEntrance();
//   }
//
//   public void setHeaders(final String[] headers) {
//      titleTblBottom = headers;
//   }
//
//   public void setRowList(final ArrayList<Entrance> rowList) {
//      Building.setEntrances(rowList);
//   }
//
//   public static JTable getTblBottom() {
//      return getTblBottom();
//   }
//
//   public static void setTblBottom(final JTable tblBottom) {
//      BuildingJTable.setTblBottom(tblBottom);
//   }
//
//   public static BuildingTableModelBottom getTblMdlBottom() {
//      return TblMdlBottom;
//   }
//
//}
