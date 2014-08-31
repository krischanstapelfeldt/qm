package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Renter;
import de.globalposeidon.Qualitaet.model.Tenant;

/**
 * AddBuildingWindow shows the user a window to either add a building with "OK" or to cancel the request with "Cancel".
 * @author Timm Suhl
 */
public class AddBuildingWindow extends JDialog {

   private static final long serialVersionUID = 4298418116709775705L;
   
   private final JTextField tfBuildingName;
   private final JTextField tfFirstname;
   private final JTextField tfSurname;
   private final JTextField tfTel;
   private final JTextField tfEmail;
   
   public AddBuildingWindow(final DataContainer model) {

      setTitle("add building");

      // ui components
      final JPanel contentPnl = new JPanel(new BorderLayout());
      final JPanel tfPnl = new JPanel(new GridLayout(2, 4, 2, 2));
      final JLabel descriptionLbl = new JLabel("This will add a new building with a random ID and a given Renter to the tree");
      final JLabel lblBuildingName = new JLabel("Building Name"); tfBuildingName = new JTextField("");
      final JLabel lblFirstname = new JLabel("Firstname"); tfFirstname = new JTextField("");
      final JLabel lblSurname = new JLabel("Surname");tfSurname = new JTextField("");
      final JLabel lblTel = new JLabel("Phone");tfTel = new JTextField("");
      final JLabel lblEmail = new JLabel("Mail");tfEmail = new JTextField("");
      tfPnl.add(lblBuildingName); tfPnl.add(tfBuildingName);
      tfPnl.add(lblFirstname); tfPnl.add(tfFirstname);
      tfPnl.add(lblSurname); tfPnl.add(tfSurname);
      tfPnl.add(lblTel); tfPnl.add(tfTel);
      tfPnl.add(lblEmail); tfPnl.add(tfEmail);
      contentPnl.add(descriptionLbl, BorderLayout.NORTH);
      contentPnl.add(tfPnl, BorderLayout.CENTER);

      final JPanel buttonPnl = new JPanel(new FlowLayout());
      final JButton saveBtn = new JButton(Strings.OK);
      saveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            addBuilding(model);
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

   private void addBuilding(final DataContainer container) {
	  
	   if (tfBuildingName.getText().equals("")) {
		   tfBuildingName.requestFocus();
	   } else if (tfFirstname.getText().equals("")) {
		   tfFirstname.requestFocus();
	   } else if (tfSurname.getText().equals("")) {
		   tfSurname.requestFocus();
	   } else if (tfTel.getText().equals("")) {
		   tfTel.requestFocus();
	   } else if (tfEmail.getText().equals("")) {
		   tfEmail.requestFocus();
	   } else { // all fields valid
		   Renter tmpRenter = new Renter(tfFirstname.getText(), tfSurname.getText(), tfTel.getText(), tfEmail.getText());
		   Building tmpBuilding = new Building(container, tfBuildingName.getText());
		   tmpBuilding.setRenter(tmpRenter);
		   container.addBuilding(tmpBuilding);
		   dispose();
	   }
   }
}
