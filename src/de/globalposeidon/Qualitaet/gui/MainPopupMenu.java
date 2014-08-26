package de.globalposeidon.Qualitaet.gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import de.globalposeidon.Qualitaet.Strings;

/**
 * This class contains the popup menu
 * 
 * @author Sebastian Lauber
 */

public class MainPopupMenu extends JPopupMenu {
   private static final long serialVersionUID = -6183434525940582452L;

   public MainPopupMenu() {
      final JMenuItem addBuilding = new JMenuItem(Strings.ADDBUILDING);
      add(addBuilding);

      final JMenuItem addEntrance = new JMenuItem(Strings.ADDENTRANCE);
      add(addEntrance);

      final JMenuItem addRenter = new JMenuItem(Strings.ADDRENTER);
      add(addRenter);

      final JMenuItem addTenant = new JMenuItem(Strings.ADDTENANT);
      add(addTenant);

      add(new JSeparator());

      final JMenuItem delAppartment = new JMenuItem(Strings.DELAPARTMENT);
      add(delAppartment);

      final JMenuItem delBuilding = new JMenuItem(Strings.DELBUILDING);
      add(delBuilding);

      final JMenuItem delEntrance = new JMenuItem(Strings.DELENTRANCE);
      add(delEntrance);

      final JMenuItem delRenter = new JMenuItem(Strings.DELRENTER);
      add(delRenter);
   }
}
