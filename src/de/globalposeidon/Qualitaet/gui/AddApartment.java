package de.globalposeidon.Qualitaet.gui;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.model.*;

public class AddApartment extends JFrame {

	// private JPanel content;
	private JTextField tfApartment;
	private JTextField tfFirstname;
	private JTextField tfSurname;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfMeter;
	private JTextField tfReadingVal;
	

	// Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddApartment frame = new AddApartment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.

	public AddApartment() {
		super("Add Apartment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 350);

		JPanel tfPanel = new JPanel();
		setContentPane(tfPanel);

		// Initial Textfields and their length
		tfApartment = new JTextField();
		tfApartment.setPreferredSize(new Dimension(150, 20));
		tfFirstname = new JTextField();
		tfFirstname.setPreferredSize(new Dimension(150, 20));
		tfSurname = new JTextField();
		tfSurname.setPreferredSize(new Dimension(150, 20));
		tfTel = new JTextField();
		tfTel.setPreferredSize(new Dimension(150, 20));
		tfEmail = new JTextField();
		tfEmail.setPreferredSize(new Dimension(150, 20));
		tfMeter = new JTextField();
		tfMeter.setPreferredSize(new Dimension(150, 20));
		tfReadingVal = new JTextField();
		tfReadingVal.setPreferredSize(new Dimension(150, 20));


		// Initial Labels
		JLabel lblApartment = new JLabel("Apartment name");
		JLabel lblRenter = new JLabel("Renter details");
		JLabel lblFirstname = new JLabel("Firstname");
		JLabel lblSurname = new JLabel("Surname");
		JLabel lblTel = new JLabel("Tel.");
		JLabel lblEmail = new JLabel("E-Mail");
		JLabel lblMeter = new JLabel("Meter ID");
		JLabel lblReadingVal = new JLabel("Reading Value");
		JLabel lblMeterDet = new JLabel("Meter details");

		Font f = new Font("Arial", Font.ITALIC, 14);
		lblRenter.setFont(f);
		lblMeterDet.setFont(f);

		// Initial Buttons
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");

		// Set Layout at Textfield Panel

		GroupLayout layout = new GroupLayout(tfPanel);

		tfPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		SequentialGroup horizontalGroup = layout.createSequentialGroup();

		SequentialGroup verticalGroup = layout.createSequentialGroup();

		// Set horizontal Groups

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblApartment)
				.addComponent(tfApartment, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGap(30));
		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)

		.addComponent(lblRenter));

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblFirstname)
				.addComponent(tfFirstname, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSurname)
				.addComponent(tfSurname, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblTel)
				.addComponent(tfTel, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblEmail)
				.addComponent(tfEmail, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGap(30));
		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addComponent(lblMeterDet));

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblMeter)
				.addComponent(tfMeter, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblReadingVal)
				.addComponent(tfReadingVal, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));



		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGap(0, 0, Short.MAX_VALUE).addComponent(btnSave)
				.addComponent(btnCancel));

		// Set Parallel Group - Left Label Group

		ParallelGroup lblGroup1 = layout
				.createParallelGroup()
				.addGroup(layout.createSequentialGroup()

				.addComponent(lblApartment))

				.addGroup(layout.createSequentialGroup()

				.addComponent(lblRenter))
				.addGroup(layout.createSequentialGroup()

				.addComponent(lblFirstname))

				.addGroup(layout.createSequentialGroup().addComponent(lblTel))

				.addGroup(
						layout.createSequentialGroup().addComponent(lblMeterDet))

				.addGroup(
						layout.createSequentialGroup().addComponent(lblMeter));



		// Set Parallel Group - Left Textfield Group

		ParallelGroup tfGroup1 = layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup().addComponent(
								tfApartment, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(
								tfFirstname, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(tfTel,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(tfMeter,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))



				.addGroup(layout.createSequentialGroup().addComponent(btnSave));

		// Set Parallel Group - Right Label Group

		ParallelGroup lblGroup2 = layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup().addComponent(lblSurname))

				.addGroup(layout.createSequentialGroup().addComponent(lblEmail))

				.addGroup(
						layout.createSequentialGroup().addComponent(lblMeterDet))

				.addGroup(layout.createSequentialGroup().addComponent(lblReadingVal))



								.addGroup(
										layout.createSequentialGroup()
												.addComponent(btnCancel));

		// Set Parallel Group - Right TextField Group
		ParallelGroup tfGroup2 = layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup().addComponent(tfSurname,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(tfEmail,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(tfReadingVal,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE));

		layout.setVerticalGroup(horizontalGroup);
		layout.setHorizontalGroup(verticalGroup);

		// Connect the groups
		verticalGroup.addGroup(lblGroup1).addGroup(tfGroup1)
				.addGroup(lblGroup2).addGroup(tfGroup2);

		// Set same button size
		layout.linkSize(SwingConstants.HORIZONTAL, btnSave, btnCancel);
	}
}
