package de.globalposeidon.Qualitaet.gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;


import javax.swing.table.TableModel;

import de.globalposeidon.Qualitaet.model.Apartment;
//import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

/**
 * renter model.
 * 
 * @author Jens-Rainer Felske
 */
public class ApartmentJTable extends JTable{

	private static final long serialVersionUID = 5911359053543293865L;

	/**
	 * 
	 */
   public ApartmentJTable(Apartment apartment) {
	   super(new ApartmentTableModelTop(apartment));
   }

}
