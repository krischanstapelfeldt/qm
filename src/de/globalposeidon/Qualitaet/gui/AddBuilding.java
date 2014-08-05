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

public class AddBuilding extends JFrame {

	// private JPanel content;
	private JTextField tfBuildingName;
	private JTextField tfFirstname;
	private JTextField tfSurname;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfStreet;
	private JTextField tfHNo;
	private JTextField tfZip;
	private JTextField tfTown;

	// Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBuilding frame = new AddBuilding();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.

	public AddBuilding() {
		super("Add Building");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 400);

		JPanel tfPanel = new JPanel();
		setContentPane(tfPanel);

		// Initial Textfields and their length
		tfBuildingName = new JTextField();
		tfBuildingName.setPreferredSize(new Dimension(150, 20));
		tfFirstname = new JTextField();
		tfFirstname.setPreferredSize(new Dimension(150, 20));
		tfSurname = new JTextField();
		tfSurname.setPreferredSize(new Dimension(150, 20));
		tfTel = new JTextField();
		tfTel.setPreferredSize(new Dimension(150, 20));
		tfEmail = new JTextField();
		tfEmail.setPreferredSize(new Dimension(150, 20));
		tfStreet = new JTextField();
		tfStreet.setPreferredSize(new Dimension(150, 20));
		tfHNo = new JTextField();
		tfHNo.setPreferredSize(new Dimension(150, 20));
		tfZip = new JTextField();
		tfZip.setPreferredSize(new Dimension(150, 20));
		tfTown = new JTextField();
		tfTown.setPreferredSize(new Dimension(150, 20));

		// Initial Labels
		JLabel lblBuilding = new JLabel("Building name");
		JLabel lblTenant = new JLabel("Tenant details");
		JLabel lblFirstname = new JLabel("Firstname");
		JLabel lblSurname = new JLabel("Surname");
		JLabel lblTel = new JLabel("Tel.");
		JLabel lblEmail = new JLabel("E-Mail");
		JLabel lblStreet = new JLabel("Street");
		JLabel lblHNo = new JLabel("House No.");
		JLabel lblZip = new JLabel("Zip");
		JLabel lblTown = new JLabel("Town");
		JLabel lblAdress = new JLabel("Adress details");

		Font f = new Font("Arial", Font.ITALIC, 14);
		lblTenant.setFont(f);
		lblAdress.setFont(f);

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
				.addComponent(lblBuilding)
				.addComponent(tfBuildingName, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGap(30));
		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)

		.addComponent(lblTenant));

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
				.addComponent(lblAdress));

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblStreet)
				.addComponent(tfStreet, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblHNo)
				.addComponent(tfHNo, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		horizontalGroup.addGroup(layout
				.createParallelGroup(Alignment.CENTER)
				.addComponent(lblZip)
				.addComponent(tfZip, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblTown)
				.addComponent(tfTown, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		horizontalGroup.addGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGap(0, 0, Short.MAX_VALUE).addComponent(btnSave)
				.addComponent(btnCancel));

		// Set Parallel Group - Left Label Group

		ParallelGroup lblGroup1 = layout
				.createParallelGroup()
				.addGroup(layout.createSequentialGroup()

				.addComponent(lblBuilding))

				.addGroup(layout.createSequentialGroup()

				.addComponent(lblTenant))
				.addGroup(layout.createSequentialGroup()

				.addComponent(lblFirstname))

				.addGroup(layout.createSequentialGroup().addComponent(lblTel))

				.addGroup(
						layout.createSequentialGroup().addComponent(lblAdress))

				.addGroup(
						layout.createSequentialGroup().addComponent(lblStreet))

				.addGroup(layout.createSequentialGroup().addComponent(lblZip));

		// Set Parallel Group - Left Textfield Group

		ParallelGroup tfGroup1 = layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup().addComponent(
								tfBuildingName, GroupLayout.DEFAULT_SIZE,
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
						layout.createSequentialGroup().addComponent(tfStreet,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup()

						.addComponent(tfZip, GroupLayout.DEFAULT_SIZE,
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
						layout.createSequentialGroup().addComponent(lblAdress))

				.addGroup(layout.createSequentialGroup().addComponent(lblHNo))

				.addGroup(
						layout.createSequentialGroup()
								.addComponent(lblTown)

								.addGroup(
										layout.createSequentialGroup()
												.addComponent(btnCancel)));

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
						layout.createSequentialGroup().addComponent(tfHNo,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))

				.addGroup(
						layout.createSequentialGroup().addComponent(tfTown,
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
