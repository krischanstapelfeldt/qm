package de.globalposeidon.Qualitaet.gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import de.globalposeidon.Qualitaet.Strings;

public class MainPopupMenu extends JPopupMenu {
	private static final long serialVersionUID = -6183434525940582452L;

	public MainPopupMenu(){
		JMenuItem AddBuilding = new JMenuItem(Strings.addBuilding);
		add(AddBuilding);
		
		JMenuItem AddEntrance = new JMenuItem(Strings.addEntrance);
		add(AddEntrance);
		
		JMenuItem AddRenter = new JMenuItem(Strings.addRenter);
		add(AddRenter);
		
		JMenuItem AddTenant = new JMenuItem(Strings.addTenant);
		add(AddTenant);
		
		
		add(new JSeparator());
		
		JMenuItem DelAppartment = new JMenuItem(Strings.delAppartment);
		add(DelAppartment);
		
		JMenuItem DelBuilding = new JMenuItem(Strings.delBuilding);
		add(DelBuilding);
		
		JMenuItem DelEntrance = new JMenuItem(Strings.delEntrance);
		add(DelEntrance);
		
		JMenuItem DelRenter = new JMenuItem(Strings.delRenter);
		add(DelRenter);
	}
}
