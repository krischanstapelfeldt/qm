package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * Tablemodel for Apartmentpanel.
 * @author Hadschii
 *
 */
public class ApartmentTableModelTop extends AbstractTableModel {

   private static final long serialVersionUID = -7166828471266641592L;

   private static final int NAME = 0;
   private static final int SURNAME = 1;
   private static final int PHONE = 2;
   private static final int EMAIL = 3;
   
   private final Apartment apartment;
   private String[] titleTblTop = new String[]{Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL};
   /**
    * Konstruktor.
    * @param apartment apartment
    */
   public ApartmentTableModelTop(final Apartment apartment) {
      this.apartment = apartment;
   }
   /**
    * Method to delete a given row.
    * @param row row
    */
   public void deleteSelectedApartment(int row) {
	   apartment.removeTenant(row);
   }

// ----------- Abstract Table Model Methods
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
      return apartment.getTenants().size();
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
}
