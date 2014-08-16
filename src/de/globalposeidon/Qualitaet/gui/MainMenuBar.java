package de.globalposeidon.Qualitaet.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.globalposeidon.Qualitaet.Strings;

public class MainMenuBar extends JMenuBar{
	private static final long serialVersionUID = 3409407521701819128L;

	public MainMenuBar(){		
		JMenu file = new JMenu(Strings.file);
		add(file);
		
		JMenuItem close = new JMenuItem(Strings.close);
		close.addActionListener(new ActionListener() {
			// TODO replace force exit
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
		file.add(close);
		
		JMenu edit = new JMenu(Strings.edit);
		add(edit);
		
		JMenuItem building = new JMenuItem(Strings.addBuilding);
		edit.add(building);
		
		JMenuItem apartment = new JMenuItem(Strings.addAppartment);
		edit.add(apartment);
		
		JMenuItem renter = new JMenuItem(Strings.addRenter);
		edit.add(renter);
			
		JMenu help = new JMenu(Strings.help);
		add(help);
		
		JMenuItem about = new JMenuItem(Strings.about);
		help.add(about);
		
		JMenuItem faq = new JMenuItem(Strings.faq);
		help.add(faq);
	}
}