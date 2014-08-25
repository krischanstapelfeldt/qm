package de.globalposeidon.Qualitaet.gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import de.globalposeidon.Qualitaet.Strings;

/**
 * This class contains the popup menu
 * @author Sebastian Lauber
 *
 */

public class MainPopupMenu extends JPopupMenu {
	private static final long serialVersionUID = -6183434525940582452L;

	public MainPopupMenu() {
		final JMenuItem addBuilding = new JMenuItem(Strings.addBuilding);
		add(addBuilding);

		final JMenuItem addEntrance = new JMenuItem(Strings.addEntrance);
		add(addEntrance);

		final JMenuItem addRenter = new JMenuItem(Strings.addRenter);
		add(addRenter);

		final JMenuItem addTenant = new JMenuItem(Strings.addTenant);
		add(addTenant);

		add(new JSeparator());

		final JMenuItem delAppartment = new JMenuItem(Strings.delAppartment);
		add(delAppartment);

		final JMenuItem delBuilding = new JMenuItem(Strings.delBuilding);
		add(delBuilding);

		final JMenuItem delEntrance = new JMenuItem(Strings.delEntrance);
		add(delEntrance);

		final JMenuItem delRenter = new JMenuItem(Strings.delRenter);
		add(delRenter);
	}
}
