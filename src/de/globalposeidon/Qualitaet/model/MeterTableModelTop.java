 package de.globalposeidon.Qualitaet.model;

 import javax.swing.table.AbstractTableModel;

import de.globalposeidon.Qualitaet.Strings;

 //// configure TabelModel Bottom
 public class MeterTableModelTop extends AbstractTableModel {

 private static final long serialVersionUID = -7166828471266641592L;


// static final int METERID = 0;
// static final int METERTYPE = 1;
// static final int CURRENTVALUE = 2;
// static final int YEARVALUE = 3;
// static final int LASTREAD = 3;
//
 

//  private int meterid;
//  private Metertype type;
//  private int currentValue;
//  private int yearValue;
//  private Date lastRead;
//  private Meter meter;
  
private Object[] objects;
private Class[] classes;
private String[] titleTblTop;
      
 public MeterTableModelTop(final Meter meter) {
// this.meter = meter;
//  this.meterid = meter.getID();
//  this.type = meter.getType();
//  this.currentValue = meter.getCurrentValue();
//  this.yearValue = meter.getYearValue();
//  this.lastRead = meter.getLastRead();
    
    objects = new Object[]{meter.getID(), meter.getType(), meter.getCurrentValue(), meter.getYearValue(), meter.getLastRead()};
    classes = new Class[]{Integer.class, String.class, Integer.class, Integer.class, Integer.class};
    titleTblTop = new String[] { Strings.METERID, Strings.METERTYPE, Strings.CURRENTVALUE, Strings.YEARVALUE,
          Strings.LASTREAD };
 }
    
    
 @Override
 public int getColumnCount() {
   return titleTblTop.length;
 }

 @Override
 public int getRowCount() {
   
    return 1;
 }

 public String getColumnName(final int i){
    return titleTblTop[i];
 }
 
 @Override
 public Object getValueAt(int rowIndex, int columnIndex) {
   
    return objects[columnIndex];
 }
 
 public Class getColumnClass(int columnIndex){
    return classes[columnIndex];
 }
 }
