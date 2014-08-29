package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

//import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

/**
 * renter model.
 * 
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable {
  // private ApartmentTableModelTop;

   private ApartmentJTable() {
      throw new UnsupportedOperationException();
   }
   
  
   // initial JTable Top
   private static JTable tblTop = new JTable(new ApartmentTableModelTop());
   // Initial JTable Bottom
//   private static JTable tblBottom = new JTable(ApartmentTableModelBottom.getTblMdlBottom());

//   public static JTable getTblBottom() {
//      return tblBottom;
//   }

//   public static void setTblBottom(JTable tblBottom) {
//      ApartmentJTable.tblBottom = tblBottom;
//   }

   public static final JTable getTblTop() {
      return tblTop;
   }

   public void setTblTop(JTable tblTop) {
      ApartmentJTable.tblTop = tblTop;
   }

}
