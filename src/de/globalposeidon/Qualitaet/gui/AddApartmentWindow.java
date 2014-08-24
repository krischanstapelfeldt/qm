package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;

public class AddApartmentWindow extends JDialog {
	
	private static final long serialVersionUID = 5817993189340085967L;

	public AddApartmentWindow(final Entrance entrance) {
	
		this.setTitle("add apartment");
		
		//ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = new JLabel("This will add a new apartment with a random ID to the entrance with ID: " + entrance.getID());
		contentPnl.add(descriptionLbl);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				addApartment(entrance);
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
	
	private void addApartment(Entrance entrance) {
		entrance.addApartment(new Apartment(entrance));
		dispose();
	}
}

