package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.model.Building;

public class BuildingPanel extends JPanel {
	
	public BuildingPanel(Building building) {
		
		this.setLayout(new BorderLayout());
		
		// ui components
		JLabel lblHeader = new JLabel("Building " + building.getID());
		this.add(lblHeader, BorderLayout.NORTH);
		
		JLabel lblEntranceCount = new JLabel("Entrances: " + building.getEntrancesCount());
		this.add(lblEntranceCount, BorderLayout.CENTER);
		
	}

}
