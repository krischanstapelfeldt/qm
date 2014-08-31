package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * TableModel for BuildingPanel
 * @author Hadschii
 *
 */
public class BuildingTableModelBottom extends AbstractTableModel {

   private static final long serialVersionUID = -7166828471266641592L;
   static final int NAME = 0;
   static final int SURNAME = 1;
   static final int PHONE = 2;
   static final int EMAIL = 3;
   private String[] titleTblTop = new String[]{Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL};
   private final Building building;
   /**
    * Konstruktor.
    * @param building building
    */
   public BuildingTableModelBottom(final Building building) {
      this.building = building;
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
      return 1;
   }

   @Override
   public final Object getValueAt(final int row, final int col) {
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
}
