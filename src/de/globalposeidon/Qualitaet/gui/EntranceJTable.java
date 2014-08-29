package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.EntranceTableModelTop;

/**
 * @author Jens-Rainer Felske
 */
public class EntranceJTable extends JTable {

   private static final long serialVersionUID = 3906787486598015639L;

   public EntranceJTable(final Entrance entrance) {
      super(new EntranceTableModelTop(entrance));
      // throw new UnsupportedOperationException();
   }
}
