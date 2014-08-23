package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
/**
 * AddBuildingWindow shows the user a window to either add a building with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddBuildingWindow extends JDialog {

	private static final long serialVersionUID = 4298418116709775705L;

	public AddBuildingWindow(final DataContainer model) {
		
		this.setTitle("add building");
		
		// ui components
		JPanel contentPnl = new JPanel();
		JLabel descriptionLbl = new JLabel("This will add a new building with a random ID to the tree");
		contentPnl.add(descriptionLbl);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				addBuilding(model);
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
	
	private void addBuilding(DataContainer container) {
		
		container.addBuilding(new Building(container));
		dispose();
	}
}
