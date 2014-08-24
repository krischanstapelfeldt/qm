package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Entrance;
/**
 * AddEntranceWindow shows the user a window to either add a entrance to the currently selected building with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddEntranceWindow extends JDialog {
	
	private static final long serialVersionUID = 6200962634221693506L;

	public AddEntranceWindow(final Building building) {
		
		this.setTitle("add entrance");
		
		// ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = new JLabel("This will add a new entrance with a random ID to the building with ID: " + building.getID());
		contentPnl.add(descriptionLbl);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				addEntrance(building);
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
	
	private void addEntrance(Building building) {
		building.addEntrance(new Entrance(building));
		dispose();
	}

}
