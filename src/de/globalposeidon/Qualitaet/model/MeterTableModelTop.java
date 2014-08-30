 package de.globalposeidon.Qualitaet.model;

 import javax.swing.table.AbstractTableModel;

 //// configure TabelModel Bottom
 public class MeterTableModelTop extends AbstractTableModel {

 private static final long serialVersionUID = -7166828471266641592L;

// use this for modelBotoom (readings)
//static final int METERID = 0;
//static final int READINGID = 1;
//static final int METERREADER = 2;
//static final int READINGINFO = 3;
//static final int READINGDATE = 4;
//static final int READINGVALUE = 5;
 
static final int METERID = 0;
static final int METERTYPE = 1;
static final int METERVALUE = 2;
static final int METERYEARVALUE = 3;
static final int LASTREAD = 4; 
 
private Meter meter;
 
// also use for readings
//private String[] titleTblTop = new String[]{"ID Meter", "ID Reading", "Reader", "ReadingInfo", "Date", "Value"};
private String[] titleTblTop = new String[]{"ID Meter", "Metertype", "Value", "yearValue", "last read"};

 public MeterTableModelTop(final Meter meter) {
	 this.meter = meter;
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
	 if (columnIndex == METERID) {
         return meter.getID();
      }
	 if (columnIndex == METERTYPE) {
         return meter.getType();
      }
	 if (columnIndex == METERVALUE) {
         return meter.getCurrentValue();
      }
	 if (columnIndex == METERYEARVALUE) {
         return meter.getYearValue();
      }
	 if (columnIndex == LASTREAD) {
         return meter.getLastRead();
      }
      return null;
 }
 
 @Override
 public final boolean isCellEditable(final int rowIndex, final int columnIndex) {
	 if (columnIndex == METERID) {
         return true;
      }
	 else if (columnIndex == METERTYPE) {
         return true;
      }
	 else if (columnIndex == METERVALUE) {
         return true;
      }
	 else if (columnIndex == METERYEARVALUE) {
         return true;
      }
	 else if (columnIndex == LASTREAD) {
         return true;
      }
      return false;
 }
 
}
