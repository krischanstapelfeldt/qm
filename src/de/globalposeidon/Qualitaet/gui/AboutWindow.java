package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;

public class AboutWindow extends JDialog {
   private static final long serialVersionUID = 6372879078251123070L;
   private final Logger logger = LoggerFactory.getLogger(AboutWindow.class);

   public AboutWindow(final JFrame parent) {
      logger.debug("About window opened");
      setTitle("about");

      final JPanel contentPnl = new JPanel(new BorderLayout());
      // add text

      final JLabel lblAbout = new JLabel("Gebäudeverwaltung\n" + "von Felske, Lauber, Stapelfeldt, Suhl\n"
            + "für Grundlagen QM | Sommersemester 14");

      final JButton btnOk = new JButton(Strings.OK);
      contentPnl.add(lblAbout, BorderLayout.NORTH);
      contentPnl.add(btnOk, BorderLayout.SOUTH);

      this.add(contentPnl);
      // layout
      pack();
      setLocationRelativeTo(parent);
      setResizable(false);
      setVisible(true);

      btnOk.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            dispose();
         }
      });
   }
}
