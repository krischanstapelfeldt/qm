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
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Entrance;

/**
 * AddApartmentWindow shows the user a window to either add a apartment to the
 * currently selected entrance with "OK" or to cancel the request with "Cancel"
 * 
 * @author Timm Suhl
 *
 */
public class AddApartmentWindow extends JDialog {

	private static final long serialVersionUID = 5817993189340085967L;

	public AddApartmentWindow(final Entrance entrance) {

		setTitle("add apartment");

		// ui components
		final JPanel contentPnl = new JPanel(new FlowLayout());
		final JLabel descriptionLbl = new JLabel(
				"This will add a new apartment with a random ID to the entrance with ID: "
						+ entrance.getID());
		contentPnl.add(descriptionLbl);

		final JPanel buttonPnl = new JPanel(new FlowLayout());
		final JButton saveBtn = new JButton(Strings.OK);
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				addApartment(entrance);
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

	private void addApartment(final Entrance entrance) {
		entrance.addApartment(new Apartment(entrance));
		dispose();
	}
}
