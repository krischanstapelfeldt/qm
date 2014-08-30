package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

// configure TabelModel Top
public class ApartmentTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = -7166828471266641592L;

   private static final int NAME = 0;
   private static final int SURNAME = 1;
   private static final int PHONE = 2;
   private static final int EMAIL = 3;

   private final Apartment apartment;
   // set Table Top Column Header
   private String[] titleTblTop = new String[]{Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL};

   public ApartmentTableModelTop(final Apartment apartment) {
      this.apartment = apartment;
   
   }
   public final int addElement(final Tenant tenant) {
      apartment.addTenant(tenant);
      fireTableDataChanged();
      return apartment.tenantCount() - 1;
   }

   public final void removeElement(final Tenant tenant) {
      apartment.getTenants().remove(tenant);
      fireTableDataChanged();
   }

   public final void setEntries(final ArrayList<Tenant> dataList) {
      clear();
      for (int row = 0; row < dataList.size(); row++) {
         apartment.getTenants().add(dataList.get(row));
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

   public final int getRowCount() {
      return apartment.getTenants().size();
   }

   public final Object getRowAt(final int row) {
      return apartment.getTenants().get(row);
   }

   public final void setRowAt(final Tenant tenant, final int row) {
      apartment.getTenants().set(row, tenant);
      fireTableRowsUpdated(row, row);
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
      if (col == NAME) {
         return apartment.getTenants().get(row).getName();
      }
      if (col == SURNAME) {
         return apartment.getTenants().get(row).getSurname();
      }
      if (col == PHONE) {
         return apartment.getTenants().get(row).getPhone();
      }
      if (col == EMAIL) {
         return apartment.getTenants().get(row).getEmail();
      }
      return null;
   }

   @Override
   public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
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
   public final void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
      if (columnIndex == NAME) {
         apartment.getTenants().get(rowIndex).setName((String) currentValue);
      }
      if (columnIndex == SURNAME) {
         apartment.getTenants().get(rowIndex).setSurname((String) currentValue);
      }
      if (columnIndex == PHONE) {
         apartment.getTenants().get(rowIndex).setPhone((String) currentValue);
      }
      if (columnIndex == EMAIL) {
         apartment.getTenants().get(rowIndex).setEmail((String) currentValue);
      }
   }

   public final void clear() {
      final int rows = getRowCount();
      apartment.getTenants().clear();
      fireTableRowsDeleted(0, rows);
   }

   public final String[] getHeaders() {
      return titleTblTop;
   }

   public final ArrayList<Tenant> getRowList() {
      return apartment.getTenants();
   }

   public final void setHeaders(final String[] headers) {
      titleTblTop = headers;
   }

   
}
