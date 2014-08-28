package de.globalposeidon.Qualitaet.gui;


import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Tenant;
/**
 * renter model.
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable{
      
   
// set Table Top Column Header
   static String[] titleTblTop = new String[]{
      Strings.NAME, Strings.SURNAME, Strings.PHONE, Strings.EMAIL
   };
   
   // set Table Bottom Column Header
   static String[] titleTblBottom = new String[]{
         Strings.METERID, Strings.METERTYPE
   };

      
   // initial JTable Top
   static JTable tblTop = new JTable(TblMdlTop.tblTopModel);
   
   // configure TabelModel Top
   static class TblMdlTop extends AbstractTableModel{
      
      static final int NAME = 0;
      static final int SURNAME = 1;
      static final int PHONE = 2;
      static final int EMAIL = 3;
      
      static final TblMdlTop tblTopModel = new TblMdlTop(Apartment.tenants);
      
    
     public TblMdlTop(ArrayList<Tenant> tenants){
                
     }
     
    public int addElement(Tenant tenant) {
        (Apartment.tenants).add(tenant);
        this.fireTableDataChanged();
        return Apartment.tenants.size()-1;
    }
    public void removeElement(final Apartment Tenant) {
        Apartment.tenants.remove(Tenant);
        this.fireTableDataChanged();
    }
    public void setEntries(final ArrayList<Tenant> dataList) {
        clear();
        for (int row = 0; row < dataList.size(); row++) {
            Apartment.tenants.add(dataList.get(row));
        }
    }
    public String getColumnName(int i) {
       return titleTblTop[i];
       }
    public int getColumnCount() {
       return titleTblTop.length;
       }
    public int getRowCount() {
       return Apartment.tenants.size();
       }
    public Object getRowAt(int row) {
       return Apartment.tenants.get(row);
       }
    public void setRowAt(final Tenant tenant, int row) {
       Apartment.tenants.set(row, tenant);
        this.fireTableRowsUpdated(row, row);
    }
    public Object getValueAt(final int row, final int col) {
        if(col == NAME)
            return ((Tenant)Apartment.tenants.get(row)).getName();
        if(col == SURNAME)
            return ((Tenant)Apartment.tenants.get(row)).getSurname();
        if(col == PHONE)
           return ((Tenant)Apartment.tenants.get(row)).getPhone();
        if(col == EMAIL)
           return ((Tenant)Apartment.tenants.get(row)).getEmail();
        return (Object) null;
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == NAME){ 
           return true;
        } 
        else if(columnIndex == SURNAME) {
           return true;
        }
        else if(columnIndex == PHONE){
           return true;
        }
         else if(columnIndex == EMAIL){
           return true;
        }
           
        return false;
    }
    public void setValueAt(Object currentValue, int rowIndex, int columnIndex) {
        if(columnIndex == NAME)
            ((Tenant)Apartment.tenants.get(rowIndex)).setName((String) currentValue);
        if(columnIndex == SURNAME)
            ((Tenant)Apartment.tenants.get(rowIndex)).setSurname((String) currentValue);
        if(columnIndex == PHONE)
           ((Tenant)Apartment.tenants.get(rowIndex)).setPhone((String) currentValue);
       if(columnIndex == EMAIL)
           ((Tenant)Apartment.tenants.get(rowIndex)).setEmail((String) currentValue);
    }
    public void clear() {
        int rows = getRowCount();
        Apartment.tenants.clear();
        fireTableRowsDeleted(0,rows);
    }
    public String[] getHeaders() {
       return titleTblBottom;
       }
    public ArrayList<Tenant> getRowList() {
       return Apartment.tenants;
       }
    public void setHeaders(final String[] headers) {
       titleTblTop = headers;
       }
    public void setRowList(final ArrayList<Tenant> rowList) {
       Apartment.tenants = rowList;
       }
  }
         
   
   // Initial JTable Bottom
   
   static JTable tblBottom = new JTable(TblMdlBottom.tblBottomModel);
   
   // configure TabelModel Bottom
    static class TblMdlBottom extends AbstractTableModel{
       static final int METERID = 0;
       static final int METERTYPE = 1;
       static final TblMdlBottom tblBottomModel = new TblMdlBottom(Apartment.meters);
       
     
      public TblMdlBottom(ArrayList<Meter> meters){
                 
      }
      
     public int addElement(Meter meter) {
         (Apartment.meters).add(meter);
         this.fireTableDataChanged();
         return Apartment.meters.size()-1;
     }
     public void removeElement(final Apartment Meter) {
         Apartment.meters.remove(Meter);
         this.fireTableDataChanged();
     }
     public void setEntries(final ArrayList<Meter> dataList) {
         clear();
         for (int row = 0; row < dataList.size(); row++) {
             Apartment.meters.add(dataList.get(row));
         }
     }
     public String getColumnName(int i) {
        return titleTblBottom[i];
        }
     public int getColumnCount() {
        return titleTblBottom.length;
        }
     public int getRowCount() {
        return Apartment.meters.size();
        }
     public Object getRowAt(int row) {
        return Apartment.meters.get(row);
        }
     public void setRowAt(final Meter Meter, int row) {
        Apartment.meters.set(row, Meter);
         this.fireTableRowsUpdated(row, row);
     }
     public Object getValueAt(final int row, final int col) {
         if(col == METERID)
             return ((Meter)Apartment.meters.get(row)).getID();
         if(col == METERTYPE)
             return ((Meter)Apartment.meters.get(row)).getType();
         return (Object) null;
     }
     public boolean isCellEditable(int rowIndex, int columnIndex) {
         if(columnIndex == METERID){
            return true;
         }
         else if(columnIndex == METERTYPE){
            return true;
         }
         return false;
     }
     public void setValueAt(Object currentValue, int rowIndex, int columnIndex) {
         if(columnIndex == METERID)
             ((Meter)Apartment.meters.get(rowIndex)).setID((int) currentValue);
         if(columnIndex == METERTYPE)
             ((Meter)Apartment.meters.get(rowIndex)).setCurrentValue((int) currentValue);
     }
     public void clear() {
         int rows = getRowCount();
         Apartment.meters.clear();
         fireTableRowsDeleted(0,rows);
     }
     public String[] getHeaders() {
        return titleTblBottom;
        }
     public ArrayList<Meter> getRowList() {
        return Apartment.meters;
        }
     public void setHeaders(final String[] headers) {
        titleTblBottom = headers;
        }
     public void setRowList(final ArrayList<Meter> rowList) {
        Apartment.meters = rowList;
        }
   }
    
    
 

}