package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Renter;

/**
 * AddRenterWindow shows the user a window to either add a renter to the
 * currently selected building with "OK" or to cancel the request with "Cancel"
 *
 * @author Timm Suhl
 */
public class AddRenterWindow extends JDialog {

   private static final long serialVersionUID = 7393374690213796358L;

   // private JPanel content;
   private final JTextField tfFirstname;
   private final JTextField tfSurname;
   private final JTextField tfTel;
   private final JTextField tfEmail;

   public AddRenterWindow(final Building building) {

      setTitle("add renter");

      // ui components
      final JPanel contentPnl = new JPanel(new FlowLayout());
      final JLabel descriptionLbl = new JLabel("This will add a new renter to the building with ID: " + building.getID());
      tfFirstname = new JTextField("Firstname");
      tfSurname = new JTextField("Surname");
      tfTel = new JTextField("Phone");
      tfEmail = new JTextField("Mail");
      contentPnl.add(descriptionLbl);
      contentPnl.add(tfFirstname);
      contentPnl.add(tfSurname);
      contentPnl.add(tfTel);
      contentPnl.add(tfEmail);

      final JPanel buttonPnl = new JPanel(new FlowLayout());
      final JButton saveBtn = new JButton(Strings.OK);
      saveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            addRenter(building);
         }
      });
      final JButton cancelBtn = new JButton(Strings.CANCEL);
      cancelBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            dispose();
         }
      });
      buttonPnl.add(saveBtn);
      buttonPnl.add(cancelBtn);

      // layout manager
      setLayout(new BorderLayout());

      // add components
      this.add(buttonPnl, BorderLayout.SOUTH);
      this.add(contentPnl, BorderLayout.CENTER);

      // layout window
      pack();
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);
   }

   private void addRenter(final Building building) {
      building.setRenter(new Renter(tfFirstname.getText(), tfSurname.getText(), tfTel.getText(), tfEmail.getText()));
      dispose();
   }
}
