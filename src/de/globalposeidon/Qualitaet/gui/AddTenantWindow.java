package de.globalposeidon.Qualitaet.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Tenant;
/**
 * AddTenantWindow shows the user a window to either add a tenant to the currently selected apartment with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddTenantWindow extends JDialog {

	private static final long serialVersionUID = 7393374690213796358L;
	
	// private JPanel content;
	private JTextField tfFirstname;
	private JTextField tfSurname;
	private JTextField tfTel;
	private JTextField tfEmail;

	public AddTenantWindow(final Apartment apartment) {
			
		this.setTitle("add tenant");
		
		//ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = new JLabel("This will add a new tenant to the apartment with ID: " + apartment.getID());
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
				addTenant(apartment);
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
		
	private void addTenant(Apartment apartment) {
		apartment.addTenant(new Tenant(this.tfFirstname.getText(), this.tfSurname.getText(), this.tfTel.getText(), this.tfEmail.getText()));
		dispose();
	}
}
