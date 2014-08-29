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
   
  // private final int index;
  // private final Apartment apartment;
   public static final ApartmentTableModelTop tblMdlTop = new ApartmentTableModelTop();
   private final ArrayList<Tenant> tenants;
   private final Apartment apartment;
   
   // set Table Top Column Header
   private String[] titleTblTop = new String[] { Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL };
   
  
   public ApartmentTableModelTop() {
     // this.apartment = apartment;
      tenants = new ArrayList<Tenant>();
   }
   
   public int addElement(final Tenant tenant) {
     
      apartment.addTenant(tenant);
      fireTableDataChanged();
      return apartment.tenantCount() - 1;
   }

   public void removeElement(final Tenant tenant) {
      tenants.remove(tenant);
      fireTableDataChanged();
   }

   public void setEntries(final ArrayList<Tenant> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         tenants.add(dataList.get(row));
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
      return tenants.size();
   }

   public Object getRowAt(final int row) {
      return tenants.get(row);
   }

   public void setRowAt(final Tenant tenant, final int row) {
      tenants.set(row, tenant);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public Object getValueAt(final int row, final int col) {
      if (col == NAME) {
         return tenants.get(row).getName();
      }
      if (col == SURNAME) {
         return tenants.get(row).getSurname();
      }
      if (col == PHONE) {
         return tenants.get(row).getPhone();
      }
      if (col == EMAIL) {
         return tenants.get(row).getEmail();
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
         tenants.get(rowIndex).setName((String) currentValue);
      }
      if (columnIndex == SURNAME) {
         tenants.get(rowIndex).setSurname((String) currentValue);
      }
      if (columnIndex == PHONE) {
         tenants.get(rowIndex).setPhone((String) currentValue);
      }
      if (columnIndex == EMAIL) {
         tenants.get(rowIndex).setEmail((String) currentValue);
      }
   }

   public void clear() {
      final int rows = getRowCount();
      tenants.clear();
      fireTableRowsDeleted(0, rows);
   }

   public String[] getHeaders() {
      return titleTblTop;
   }

   public ArrayList<Tenant> getRowList() {
      return tenants;
   }

   public void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

//   public void setRowList(final ArrayList<Tenant> rowList) {
//      tenants(rowList);
//   }

//   public ApartmentTableModelTop getTblMdlTop() {
//      return tblMdlTop;
//   }

}
