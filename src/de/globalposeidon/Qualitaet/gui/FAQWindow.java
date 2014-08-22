package de.globalposeidon.Qualitaet.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FAQWindow extends JDialog {
	
	public FAQWindow (JFrame parent) {
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


