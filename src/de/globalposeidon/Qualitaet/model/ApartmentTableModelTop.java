package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Top
public class ApartmentTableModelTop extends AbstractTableModel {

   /**
       *
       */
   private static final long serialVersionUID = -7166828471266641592L;
   static final int NAME = 0;
   static final int SURNAME = 1;
   static final int PHONE = 2;
   static final int EMAIL = 3;

   // set Table Top Column Header
   private static String[] titleTblTop = new String[] { Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL };

   private static final ApartmentTableModelTop TblMdlTop = new ApartmentTableModelTop(Apartment.getTenants());

   public ApartmentTableModelTop(final ArrayList<Tenant> tenants) {

   }

   public int addElement(final Tenant tenant) {
      (Apartment.getTenants()).add(tenant);
      fireTableDataChanged();
      return Apartment.getTenants().size() - 1;
   }

   public void removeElement(final Apartment tenant) {
      Apartment.getTenants().remove(tenant);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Tenant> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         Apartment.getTenants().add(dataList.get(row));
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
      return Apartment.getTenants().size();
   }

   public Object getRowAt(final int row) {
      return Apartment.getTenants().get(row);
   }

   public void setRowAt(final Tenant tenant, final int row) {
      Apartment.getTenants().set(row, tenant);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == NAME) {
         return Apartment.getTenants().get(row).getName();
      }
      if (col == SURNAME) {
         return Apartment.getTenants().get(row).getSurname();
      }
      if (col == PHONE) {
         return Apartment.getTenants().get(row).getPhone();
      }
      if (col == EMAIL) {
         return Apartment.getTenants().get(row).getEmail();
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
         Apartment.getTenants().get(rowIndex).setName((String) currentValue);
      }
      if (columnIndex == SURNAME) {
         Apartment.getTenants().get(rowIndex).setSurname((String) currentValue);
      }
      if (columnIndex == PHONE) {
         Apartment.getTenants().get(rowIndex).setPhone((String) currentValue);
      }
      if (columnIndex == EMAIL) {
         Apartment.getTenants().get(rowIndex).setEmail((String) currentValue);
      }
   }

   public void clear() {
      final int rows = getRowCount();
      Apartment.getTenants().clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblTop;
   }

   public ArrayList<Tenant> getRowList() {
      return Apartment.getTenants();
   }

   public void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   public void setRowList(final ArrayList<Tenant> rowList) {
      Apartment.setTenants(rowList);
   }

   public static ApartmentTableModelTop getTblMdlTop() {
      return TblMdlTop;
   }


}
