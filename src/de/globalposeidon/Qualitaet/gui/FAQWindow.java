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

public class FAQWindow extends JDialog {
   private static final long serialVersionUID = -7412097759123813493L;
   private final Logger logger = LoggerFactory.getLogger(FAQWindow.class);

   public FAQWindow(final JFrame parent) {
      logger.debug("Add FAQ window opened");
      setTitle("faq");
      // add text
      final JPanel contentPnl = new JPanel(new BorderLayout());
      final JLabel lblFaq = new JLabel("Hier eine FAQ schreiben...");

      JButton btnOk = new JButton(Strings.OK);
      contentPnl.add(btnOk, BorderLayout.SOUTH);
      contentPnl.add(lblFaq, BorderLayout.NORTH);

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
