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
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;
/**
 * AddMeterWindow shows the user a window to either add a meter to the currently selected entrance OR apartment with "OK" or to cancel the request with "Cancel"
 * @author Hadschii
 *
 */
public class AddMeterWindow extends JDialog {
	
	private static final long serialVersionUID = -4549927043320246284L;

	public AddMeterWindow(final Object obj) {
		
		this.setTitle("add meter");
		
		// get object type
		//TODO: Test if working
		final boolean isEntrance = (obj instanceof Entrance);
		System.out.println(isEntrance);
		//ui components
		JPanel contentPnl = new JPanel(new FlowLayout());
		JLabel descriptionLbl = isEntrance	? new JLabel("This will add a new meter to an entrance")
											: new JLabel("This will add a new meter to an apartment");
		contentPnl.add(descriptionLbl);
		
		JPanel buttonPnl = new JPanel(new FlowLayout());
		JButton saveBtn = new JButton(Strings.ok);
		saveBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isEntrance) {
					addMeter((Entrance) obj);
				} else {
					addMeter((Apartment) obj);
				}
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
	
	private void addMeter(Entrance entrance) {
		System.out.println("try to add meter to entrance...");
//		entrance.addMeter(new Meter(001, Metertype.GAS, entrance));
		dispose();
	}
	
	private void addMeter(Apartment apartment) {
		System.out.println("try to add meter to apartment...");
		apartment.addMeter(new Meter(001, Metertype.GAS, apartment));
		dispose();
	}
}
