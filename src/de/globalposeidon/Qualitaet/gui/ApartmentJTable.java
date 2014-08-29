package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;

/**
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable extends JTable {

   private static final long serialVersionUID = 5911359053543293865L;

   public ApartmentJTable(final Apartment apartment) {
      super(new ApartmentTableModelBottom(apartment));
   }
}
