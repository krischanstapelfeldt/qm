package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

//// configure TabelModel Bottom
   public class BuildingTableModelBottom extends AbstractTableModel {

      private static final long serialVersionUID = -7166828471266641592L;
      static final int NAME = 0;
      static final int SURNAME = 1;
      static final int PHONE = 2;
      static final int EMAIL = 3;
      private String[] titleTblTop = new String[] { Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL };
      
      private Building building;

      public BuildingTableModelBottom(Building building) {
    	  this.building = building;
      }

      public int addElement(final Renter renter) {
    	     
          building.setRenter(renter);
          fireTableDataChanged();
          return 1;
       }

       public void removeElement(final Renter renter) {
          building.setRenter(null);
          fireTableDataChanged();
       }

       public void setEntries(final ArrayList<Renter> dataList) {
          clear();
          building.setRenter(dataList.get(0));
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
          return 1;
       }

       public Object getRowAt(final int row) {
          return building.getRenter();
       }

       public void setRowAt(final Renter renter, final int row) {
    	  building.setRenter(renter);
          fireTableRowsUpdated(row, row);
       }

       @Override
       public Object getValueAt(final int row, final int col) {
          if (col == NAME) {
             return building.getRenter().getName();
          }
          if (col == SURNAME) {
             return building.getRenter().getSurname();
          }
          if (col == PHONE) {
             return building.getRenter().getPhone();
          }
          if (col == EMAIL) {
             return building.getRenter().getEmail();
          }
          return null;
       }

       @Override
       public boolean isCellEditable(final int rowIndex, final int columnIndex) {
          if (columnIndex == NAME) {
             return true;
          } else if (columnIndex == SURNAME) {
             return true;
          } else if (columnIndex == PHONE) {
             return true;
          } else if (columnIndex == EMAIL) {
             return true;
          }

          return false;
       }

       @Override
       public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
          if (columnIndex == NAME) {
        	  building.getRenter().setName((String) currentValue);
          }
          if (columnIndex == SURNAME) {
        	  building.getRenter().setSurname((String) currentValue);
          }
          if (columnIndex == PHONE) {
        	  building.getRenter().setPhone((String) currentValue);
          }
          if (columnIndex == EMAIL) {
        	  building.getRenter().setEmail((String) currentValue);
          }
       }

       public void clear() {
          final int rows = getRowCount();
          building.setRenter(null);
          fireTableRowsDeleted(0, rows);
       }

       public String[] getHeaders() {
          return titleTblTop;
       }

       public ArrayList<Renter> getRowList() {
          ArrayList<Renter> tmpList = new ArrayList<Renter>();
          tmpList.add(building.getRenter());
    	  return tmpList;
       }

       public void setHeaders(final String[] headers) {
          titleTblTop = headers;
       }
}
