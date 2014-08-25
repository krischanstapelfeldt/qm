package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.model.Building;

public class BuildingPanel extends JPanel {

	private static final long serialVersionUID = -6703093984245263776L;

	public BuildingPanel(final Building building) {

		setLayout(new BorderLayout());

		// ui components
		final JLabel lblHeader = new JLabel("Building " + building.getID());
		this.add(lblHeader, BorderLayout.NORTH);

		final JLabel lblEntranceCount = new JLabel("Entrances: "
				+ building.getEntrancesCount());
		this.add(lblEntranceCount, BorderLayout.CENTER);

	}

}
