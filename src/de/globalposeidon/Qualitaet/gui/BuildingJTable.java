package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.BuildingTableModelTop;

/**
 * @author Jens-Rainer Felske
 */
public class BuildingJTable extends JTable {

   /**
    * 
    */
   private static final long serialVersionUID = -3551963231471633148L;

   protected BuildingJTable(Building building) {
      super(new BuildingTableModelTop(building));
     // throw new UnsupportedOperationException();
   }
}
