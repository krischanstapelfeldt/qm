package de.globalposeidon.Qualitaet.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AboutWindow extends JDialog {
	private static final long serialVersionUID = 6372879078251123070L;
	final Logger logger = LoggerFactory.getLogger(AboutWindow.class);
	public AboutWindow (JFrame parent) {
		logger.debug("About window opened");
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
