package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Top
public class BuildingTableModelTop extends AbstractTableModel {

   /**
    * 
    */
   private static final long serialVersionUID = 7275188332461034629L;
   private static final int ENTRANCE = 0;
   private final Building building;
   // set Table Top Column Header
   private String[] titleTblTop = new String[] { Strings.ENTRANCE };


   public BuildingTableModelTop(Building building) {
      this.building = building;
   }

   public int addElement(final Entrance entrance) {
      (building.getEntrances()).add(entrance);
      fireTableDataChanged();
      return building.getEntrances().size() - 1;
   }

   public void removeElement(final Entrance entrances) {
      building.getEntrances().remove(entrances);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Entrance> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         building.getEntrances().add(dataList.get(row));
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
      return building.getEntrances().size();
   }

   public Object getRowAt(final int row) {
      return building.getEntrances().get(row);
   }

   public void setRowAt(final Entrance entrences, final int row) {
      building.getEntrances().set(row, entrences);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == ENTRANCE) {
         return building.getEntrances().get(row).getID();
      }
      return null;
   }

   @Override
   public boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == ENTRANCE) {
         return true;
      }

      return false;
   }

   @Override
   public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == ENTRANCE) {
         building.getEntrances().get(rowIndex).setID((int) currentValue);
      }

   }

   public void clear() {
      final int rows = getRowCount();
      building.getEntrances().clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblTop;
   }

   public ArrayList<Entrance> getRowList() {
      return building.getEntrances();
   }

   public void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public void setRowList(final ArrayList<Entrance> rowList) {
      building.setEntrances(rowList);
   }

}
