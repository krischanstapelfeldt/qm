// package de.globalposeidon.Qualitaet.model;
//
// import java.util.ArrayList;
//
// import javax.swing.table.AbstractTableModel;
//
// import de.globalposeidon.Qualitaet.Strings;
//
// //// configure TabelModel Bottom
// public class MeterTableModelTop extends AbstractTableModel {
//
// private static final long serialVersionUID = -7166828471266641592L;
// static final int METERID = 0;
// static final int METERTYPE = 1;
// static final int CURRENTVALUE = 2;
// static final int YEARVALUE = 3;
// static final int LASTREAD = 3;
//
// private String[] titleTblTop = new String[] { Strings.METERID, Strings.METERTYPE, Strings.CURRENTVALUE, Strings.YEARVALUE,
// Strings.LASTREAD };
//
// // private int meterid;
// // private Metertype type;
// // private int currentValue;
// // private int yearValue;
// // private Date lastRead;
// // private Meter meter
//
//
// public MeterTableModelTop(final Meter meter) {
// // this.meter = meter;
// // this.meterid = meter.getID();
// // this.type = meter.getType();
// // this.currentValue = meter.getCurrentValue();
// // this.yearValue = meter.getYearValue();
// // this.lastRead = meter.getLastRead();
//
//
//
// // tmpMeterMeter = new Meter[] { meter.getType(), me
// //
// // for(int i=0; i < meter.length; i++){
// // tmpMeter[i] = new String[] {meter[i]};
// // }
// // }
// //
// // public int addElement(final Meter meter) {
// //
// // meter.getType(meter);
// // fireTableDataChanged();
// // return 1;
// // }
// //
// // public void removeElement(final Renter renter) {
// // building.setRenter(null);
// // fireTableDataChanged();
// // }
// //
// // public void setEntries(final Meter dataList) {
// // clear();
// // meter.setMeter(dataList.get(0));
// // }
// //
// @Override
// public String getColumnName(final int i) {
// return titleTblTop[i];
// }
//
// @Override
// public int getColumnCount() {
// return titleTblTop.length;
// }
//
// @Override
// public int getRowCount() {
// return 1;
// }
//
// public Object getRowAt(final int row) {
// return meter.getMeter();
// }
//
// public void setRowAt(final Renter renter, final int row) {
// building.setRenter(renter);
// fireTableRowsUpdated(row, row);
// }
//
// @Override
// public Object getValueAt(final int row, final int col) {
// if (col == NAME) {
// return building.getRenter().getName();
// }
// if (col == SURNAME) {
// return building.getRenter().getSurname();
// }
// if (col == PHONE) {
// return building.getRenter().getPhone();
// }
// if (col == EMAIL) {
// return building.getRenter().getEmail();
// }
// return null;
// }
//
// @Override
// public boolean isCellEditable(final int rowIndex, final int columnIndex) {
// if (columnIndex == NAME) {
// return true;
// } else if (columnIndex == SURNAME) {
// return true;
// } else if (columnIndex == PHONE) {
// return true;
// } else if (columnIndex == EMAIL) {
// return true;
// }
//
// return false;
// }
//
// @Override
// public void setValueAt(final Object currentValue, final int rowIndex, final int columnIndex) {
// if (columnIndex == NAME) {
// building.getRenter().setName((String) currentValue);
// }
// if (columnIndex == SURNAME) {
// building.getRenter().setSurname((String) currentValue);
// }
// if (columnIndex == PHONE) {
// building.getRenter().setPhone((String) currentValue);
// }
// if (columnIndex == EMAIL) {
// building.getRenter().setEmail((String) currentValue);
// }
// }
//
// public void clear() {
// final int rows = getRowCount();
// building.setRenter(null);
// fireTableRowsDeleted(0, rows);
// }
//
// public String[] getHeaders() {
// return titleTblTop;
// }
//
// public ArrayList<Renter> getRowList() {
// ArrayList<Renter> tmpList = new ArrayList<Renter>();
// tmpList.add(building.getRenter());
// return tmpList;
// }
//
// public void setHeaders(final String[] headers) {
// titleTblTop = headers;
// }
// }
