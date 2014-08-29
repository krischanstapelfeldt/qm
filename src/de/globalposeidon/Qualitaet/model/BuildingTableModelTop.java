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
//// configure TabelModel Top
//public class BuildingTableModelTop extends AbstractTableModel {
//
//   /**
//    * 
//    */
//   private static final long serialVersionUID = 7275188332461034629L;
//   static final int ENTRANCE = 0;
//   // set Table Top Column Header
//   private static String[] titleTblTop = new String[] { Strings.ENTRANCE };
//
//   private static BuildingTableModelTop TblMdlTop = new BuildingTableModelTop(Building.getEntrance());
//
//   public BuildingTableModelTop(final ArrayList<Entrance> entrances) {
//
//   }
//
//   public int addElement(final Entrance entrances) {
//      (Building.getEntrance()).add(entrances);
//      fireTableDataChanged();
//      return Building.getEntrance().size() - 1;
//   }
//
//   public void removeElement(final Building entrances) {
//      Building.getEntrance().remove(entrances);
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
//      return titleTblTop[i];
//   }
//
//   @Override
//   public int getColumnCount() {
//      return titleTblTop.length;
//   }
//
//   @Override
//   public int getRowCount() {
//      return Building.getEntrance().size();
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
//      return titleTblTop;
//   }
//
//   public ArrayList<Entrance> getRowList() {
//      return Building.getEntrance();
//   }
//
//   public void setHeaders(final String[] headers) {
//      titleTblTop = headers;
//   }
//
//   public void setRowList(final ArrayList<Entrance> rowList) {
//      Building.setEntrances(rowList);
//   }
//
//   public static JTable getTblTop() {
//      return getTblTop();
//   }
//
//   public static void setTblTop(final JTable tblTop) {
//      BuildingJTable.setTblTop(tblTop);
//   }
//
//   public static BuildingTableModelTop getTblMdlTop() {
//      return TblMdlTop;
//   }
//
//}
