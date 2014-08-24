package de.globalposeidon.Qualitaet.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Renter;
/**
 * AddRenterWindow shows the user a window to either add a renter to the currently selected building with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddRenterWindow extends JDialog {

	private static final long serialVersionUID = 7393374690213796358L;
	
	// private JPanel content;
	private JTextField tfFirstname;
	private JTextField tfSurname;
	private JTextField tfTel;
	private JTextField tfEmail;

	public AddRenterWindow(final Building building) {
			
		this.setTitle("add renter");
		
		//ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = new JLabel("This will add a new renter to the building with ID: " + building.getID());
		this.tfFirstname = new JTextField("Firstname");
		this.tfSurname = new JTextField("Surname");
		this.tfTel = new JTextField("Phone");
		this.tfEmail = new JTextField("Mail");
		contentPnl.add(descriptionLbl);
		contentPnl.add(this.tfFirstname);
		contentPnl.add(this.tfSurname);
		contentPnl.add(this.tfTel);
		contentPnl.add(this.tfEmail);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				addRenter(building);
			}
		});	
		JButton cancelBtn = new JButton(Strings.cancel);
		cancelBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPnl.add(saveBtn); buttonPnl.add(cancelBtn);
				
		// layout manager
		this.setLayout(new BorderLayout());
		
		// add components
		this.add(buttonPnl, BorderLayout.SOUTH);
		this.add(contentPnl, BorderLayout.CENTER);
		
		// layout window
			this.pack();
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);	
	}
		
	private void addRenter(Building building) {
		building.setRenter(new Renter(this.tfFirstname.getText(), this.tfSurname.getText(), this.tfTel.getText(), this.tfEmail.getText()));
		dispose();
	}
}
