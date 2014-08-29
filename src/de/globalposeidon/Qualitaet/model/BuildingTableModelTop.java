package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Top
public class BuildingTableModelTop extends AbstractTableModel {

   /**
    * Author Jens-Rainer Felske
    */
   private static final long serialVersionUID = 7275188332461034629L;
   private static final int ENTRANCE = 0;
   private final Building building;
   // set Table Top Column Header
   private String[] titleTblTop = new String[] {Strings.ENTRANCE};

   public BuildingTableModelTop(final Building building) {
      this.building = building;
   }

   public final int addElement(final Entrance entrance) {
      (building.getEntrances()).add(entrance);
      fireTableDataChanged();
      return building.getEntrances().size() - 1;
   }

   public final void removeElement(final Entrance entrances) {
      building.getEntrances().remove(entrances);
      fireTableDataChanged();
   }

   public final void setEntries(final ArrayList<Entrance> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         building.getEntrances().add(dataList.get(row));
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
      return building.getEntrances().size();
   }

   public final Object getRowAt(final int row) {
      return building.getEntrances().get(row);
   }

   public final void setRowAt(final Entrance entrences, final int row) {
      building.getEntrances().set(row, entrences);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == ENTRANCE) {
         return building.getEntrances().get(row).getID();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
      if (columnIndex == ENTRANCE) {
         return true;
      }

      return false;
   }

   @Override
   public final void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == ENTRANCE) {
         building.getEntrances().get(rowIndex).setID((int) currentValue);
      }

   }

   public final void clear() {
      final int rows = getRowCount();
      building.getEntrances().clear();
      fireTableRowsDeleted(0, rows);
   }

   public final String[] getHeaders() {
      return titleTblTop;
   }

   public final ArrayList<Entrance> getRowList() {
      return building.getEntrances();
   }

   public final void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public final void setRowList(final ArrayList<Entrance> rowList) {
      building.setEntrances(rowList);
   }

}
