package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

/**
 * renter model.
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable {
   protected ApartmentJTable() {
      throw new UnsupportedOperationException();
   }

   
   // initial JTable Top
   private static JTable tblTop = new JTable(ApartmentTableModelTop.getTblMdlTop());

   // Initial JTable Bottom
   private static JTable tblBottom = new JTable(ApartmentTableModelBottom.getTblMdlBottom());
   
   
   
   public static JTable getTblBottom() {
      return tblBottom;
   }

   public static void setTblBottom(JTable tblBottom) {
      ApartmentJTable.tblBottom = tblBottom;
   }

   public static JTable getTblTop() {
      return tblTop;
   }

   public static void setTblTop(JTable tblTop) {
      ApartmentJTable.tblTop = tblTop;
   }
   

   



}
