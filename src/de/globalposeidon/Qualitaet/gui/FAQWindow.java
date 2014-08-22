package de.globalposeidon.Qualitaet.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FAQWindow extends JDialog {
	private static final long serialVersionUID = -7412097759123813493L;
	final Logger logger = LoggerFactory.getLogger(FAQWindow.class);
	public FAQWindow (JFrame parent) {
		logger.debug("Add FAQ window opened");
		this.setTitle("faq");
		// add text
		JTextArea textArea = new JTextArea("Hier eine FAQ schreiben...");
		this.getContentPane().add(textArea);
		// layout
		this.pack();
		this.setLocationRelativeTo(parent);
		this.setResizable(false);
		this.setVisible(true);
	}
}


