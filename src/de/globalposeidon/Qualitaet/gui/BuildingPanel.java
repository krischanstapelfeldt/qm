package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.model.Building;

public class BuildingPanel extends JPanel {

	private static final long serialVersionUID = -6703093984245263776L;

	public BuildingPanel(final Building building) {
		
		// set window layout
		setLayout(new BorderLayout());

		// ui components
		JPanel pnlHeader = new JPanel(new FlowLayout());
		final JLabel lblHeader = new JLabel("Building " 
				+ building.getID());
		final JLabel lblEntranceCount = new JLabel("|Entrances: "
				+ building.entranceCount());
		final JLabel lblRenter = new JLabel("|Renter: "
				+ building.getRenter());
		pnlHeader.add(lblHeader);
		pnlHeader.add(lblEntranceCount);
		pnlHeader.add(lblRenter);
		JPanel pnlContent = new JPanel();
		// add content... like jtable and stuff
		// ...
		// add panels to layout
		add(pnlHeader, BorderLayout.NORTH);
		add(pnlContent, BorderLayout.CENTER);
	}

}
