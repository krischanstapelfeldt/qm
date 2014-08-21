package de.globalposeidon.Qualitaet.gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.DBWorker;

public class MainMenuBar extends JMenuBar{
	private static final long serialVersionUID = 3409407521701819128L;

	private void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private void openWebpage(String urlString){
		try {
			openWebpage(new URI(urlString));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
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
		
		JMenuItem apartment = new JMenuItem(Strings.addAppartment);
		edit.add(apartment);
		
		JMenuItem building = new JMenuItem(Strings.addBuilding);
		edit.add(building);
		
		JMenuItem renter = new JMenuItem(Strings.addRenter);
		edit.add(renter);
		
		JMenu dev = new JMenu("Developer");
		add(dev);
		
		JMenuItem jenkins = new JMenuItem(Strings.openJenkins);
		jenkins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openWebpage("http://stapelfeldt.selfhost.eu:8080");
			}
		});
		dev.add(jenkins);
		
		JMenuItem jUnitJenkins = new JMenuItem(Strings.openJUnitJenkins);
		jUnitJenkins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openWebpage("http://stapelfeldt.selfhost.eu:8080/job/Global%20Poseidon/ws/junit/index.html");
			}
		});
		dev.add(jUnitJenkins);
		
		JMenuItem mantis = new JMenuItem(Strings.openMantis);
		mantis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openWebpage("http://stapelfeldt.selfhost.eu/mantis/mantisbt-1.2.17/");
			}
		});
		dev.add(mantis);
		
		JMenuItem testlink = new JMenuItem(Strings.openTestlink);
		testlink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openWebpage("http://stapelfeldt.selfhost.eu/testlink/testlink-1.9.10/");
			}
		});
		dev.add(testlink);
		
		JMenuItem databaseTest = new JMenuItem("start database test");
		databaseTest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DBWorker("Testtest");
			}
		});
		dev.add(databaseTest);
			
		JMenu help = new JMenu(Strings.help);
		add(help);
		
		JMenuItem about = new JMenuItem(Strings.about);
		help.add(about);
		
		JMenuItem faq = new JMenuItem(Strings.faq);
		help.add(faq);
	}
}