package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.EntranceTableModelBottom;
import de.globalposeidon.Qualitaet.model.EntranceTableModelTop;

/**
 * renter model.
 * 
 * @author Jens-Rainer Felske
 */
public class EntranceJTable {

   protected EntranceJTable() {
      throw new UnsupportedOperationException();
   }

   // initial JTable Top
   private static JTable tblTop = new JTable(EntranceTableModelTop.getTblMdlTop());

   // Initial JTable Bottom
   private static JTable tblBottom = new JTable(EntranceTableModelBottom.getTblMdlBottom());

   public static void setTblTop(JTable tblTop) {
      EntranceJTable.tblTop = tblTop;
   }

   public static JTable getTblTop() {
      return tblTop;
   }

   public static void setTblBottom(JTable tblBottom) {
      EntranceJTable.tblBottom = tblBottom;
   }

   public static JTable getTblBottom() {
      return tblBottom;
   }

}
