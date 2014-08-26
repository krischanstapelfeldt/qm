package de.globalposeidon.Qualitaet.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AboutWindow extends JDialog {
   private static final long serialVersionUID = 6372879078251123070L;
   private final Logger logger = LoggerFactory.getLogger(AboutWindow.class);

   public AboutWindow(JFrame parent) {
      logger.debug("About window opened");
      setTitle("about");
      // add text
      final JTextArea textArea = new JTextArea("Gebäudeverwaltung\n" + "von Felske, Lauber, Stapelfeldt, Suhl\n"
            + "für Grundlagen QM | Sommersemester 14");
      getContentPane().add(textArea);
      // layout
      pack();
      setLocationRelativeTo(parent);
      setResizable(false);
      setVisible(true);
   }

}
