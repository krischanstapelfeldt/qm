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
import de.globalposeidon.Qualitaet.model.DataContainer;

/**
 * AddBuildingWindow shows the user a window to either add a building with "OK"
 * or to cancel the request with "Cancel"
 * 
 * @author Timm Suhl
 *
 */
public class AddBuildingWindow extends JDialog {

	private static final long serialVersionUID = 4298418116709775705L;

	public AddBuildingWindow(final DataContainer model) {

		setTitle("add building");

		// ui components
		final JPanel contentPnl = new JPanel();
		final JLabel descriptionLbl = new JLabel(
				"This will add a new building with a random ID to the tree");
		contentPnl.add(descriptionLbl);

		final JPanel buttonPnl = new JPanel(new FlowLayout());
		final JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				addBuilding(model);
			}
		});
		final JButton cancelBtn = new JButton(Strings.cancel);
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

		container.addBuilding(new Building(container));
		dispose();
	}
}
