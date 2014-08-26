package de.globalposeidon.Qualitaet.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FAQWindow extends JDialog {
   private static final long serialVersionUID = -7412097759123813493L;
   private final Logger logger = LoggerFactory.getLogger(FAQWindow.class);

   public FAQWindow(final JFrame parent) {
      logger.debug("Add FAQ window opened");
      setTitle("faq");
      // add text
      final JTextArea textArea = new JTextArea("Hier eine FAQ schreiben...");
      getContentPane().add(textArea);
      // layout
      pack();
      setLocationRelativeTo(parent);
      setResizable(false);
      setVisible(true);
   }
}
