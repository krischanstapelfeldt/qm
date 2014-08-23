package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
/**
 * AddEntrance shows the user a window to either add a entrance to the currently selected building with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddEntranceWindow extends JDialog {
	
	private static final long serialVersionUID = 6200962634221693506L;

	public AddEntranceWindow(final DataContainer model) {
		
		this.setTitle("add building");
		
		// ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = new JLabel("This will add a new entrance with a random ID to the building");
		final JComboBox<Integer> entranceBox = new JComboBox<Integer>();
		for(int i = 0; i < model.getBuildingCount(); ++i) {
			entranceBox.addItem(model.getBuildingID(i));
		}
		contentPnl.add(descriptionLbl);
		contentPnl.add(entranceBox);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				addEntrance(model, entranceBox.getSelectedIndex());
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
	
	private void addEntrance(DataContainer container, int buildingIndex) {
		
		Building building = container.getBuilding(buildingIndex);
		building.addEntrance(new Entrance(building));
		dispose();
	}

}
