package de.globalposeidon.Qualitaet;

import java.awt.EventQueue;

import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

/**
 * This class launches the GUI and datamodel.
 * @author Sebastian Lauber
 */

public class Launcher {
   /**
    * prevents calls from subclass.
    */
   protected Launcher() {
      throw new UnsupportedOperationException();
   }

   /**
    * Mainmethod, fires up everything.
    * @param args
    *           No args specified
    */
   public static final void main(final String[] args) {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               final MainWindow window = new MainWindow(createRandomModel());
               window.setVisible(true);
            } catch (final Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Creates a new demomodel for the application.
    * @return Prefilled DataContainer
    */
   public static DataContainer createRandomModel() {
      final DataContainer dc = new DataContainer();
      final Building b = new Building(dc);
      dc.addBuilding(b);
      final Entrance e = new Entrance(b);
      b.addEntrance(e);
      final Apartment a = new Apartment(e);
      e.addApartment(a);
      final Meter m = new Meter(1, Metertype.POWER, a);
      a.addMeter(m);

      final Building b2 = new Building(dc);
      dc.addBuilding(b2);
      final Entrance e2 = new Entrance(b);
      b2.addEntrance(e2);
      final Apartment a2 = new Apartment(e);
      e2.addApartment(a2);
      final Meter m2 = new Meter(2, Metertype.POWER, a2);
      a2.addMeter(m2);
      return dc;
   }

}
