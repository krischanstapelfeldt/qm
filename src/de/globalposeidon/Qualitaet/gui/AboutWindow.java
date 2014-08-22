package de.globalposeidon.Qualitaet.gui;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class AboutWindow extends JDialog {
	
	public AboutWindow (JFrame parent) {
		
		this.setTitle("about");
		// add text
		JTextArea textArea = new JTextArea("Gebäudeverwaltung\n"
				+ "von Felske, Lauber, Stapelfeld, Suhl\n"
				+ "für Grundlagen QM | Sommersemester 14");
		this.getContentPane().add(textArea);
		// layout
		this.pack();
		this.setLocationRelativeTo(parent);
		this.setResizable(false);
		this.setVisible(true);
	}

}
