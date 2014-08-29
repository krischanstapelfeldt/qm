package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;


import de.globalposeidon.Qualitaet.model.Apartment;
//import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

/**
 * renter model.
 * 
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable {
  // private ApartmentTableModelTop;
	private JTable tblTop;
	/**
	 * 
	 */
   public ApartmentJTable(Apartment apartment) {
	   tblTop = new JTable(new ApartmentTableModelTop(apartment));
//      throw new UnsupportedOperationException();
   }
   
  
   // initial JTable Top
   // Initial JTable Bottom
//   private static JTable tblBottom = new JTable(ApartmentTableModelBottom.getTblMdlBottom());

//   public static JTable getTblBottom() {
//      return tblBottom;
//   }

//   public static void setTblBottom(JTable tblBottom) {
//      ApartmentJTable.tblBottom = tblBottom;
//   }

   public final JTable getTblTop() {
      return tblTop;
   }

   public void setTblTop(JTable tblTop) {
      this.tblTop = tblTop;
   }

}
