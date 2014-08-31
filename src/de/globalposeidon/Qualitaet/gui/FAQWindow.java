package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
      final JPanel contentPnl = new JPanel(new BorderLayout());
      final JTextArea textArea = new JTextArea("Hier eine FAQ schreiben...");
      
      JButton btnOk = new JButton("Ok");
      contentPnl.add(btnOk, BorderLayout.SOUTH);
      contentPnl.add(textArea, BorderLayout.NORTH);
      
      this.add(contentPnl);
      // layout
      pack();
      setLocationRelativeTo(parent);
      setResizable(false);
      setVisible(true);
      
 

   }
}
