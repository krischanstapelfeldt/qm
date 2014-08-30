package de.globalposeidon.Qualitaet.gui;

import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.MeterTableModelTop;

public class MeterJTable extends JTable {

   
   /**
    * 
    */
   private static final long serialVersionUID = -7380748698789448791L;

   protected MeterJTable(final Meter meter) {
      super(new MeterTableModelTop(meter));
      // throw new UnsupportedOperationException();
   }
   }