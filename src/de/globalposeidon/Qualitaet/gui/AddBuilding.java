package de.globalposeidon.Qualitaet.gui;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.model.*;

public class AddBuilding extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		// Initial Button Panel
		JPanel btnPanel = new JPanel();
		
		JPanel tfPanel = new JPanel();
		
		// Set Layout at full Pane
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tfPanel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
				.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(tfPanel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		// Initial Textfields and their length
		tfBuildingName = new JTextField();
		tfBuildingName.setColumns(10);
		tfFirstname = new JTextField();
		tfFirstname.setColumns(10);
		tfSurname = new JTextField();
		tfSurname.setColumns(10);
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfStreet = new JTextField();
		tfStreet.setColumns(10);
		tfHNo = new JTextField();
		tfHNo.setColumns(10);
		tfZip = new JTextField();
		tfZip.setColumns(10);
		tfTown = new JTextField();
		tfTown.setColumns(10);
		
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
		
		// Set Layout at Textfield Panel
		
	GroupLayout glTfPanel = new GroupLayout(tfPanel);
	glTfPanel.setHorizontalGroup(
			glTfPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(glTfPanel.createSequentialGroup()
				.addContainerGap()
				.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(glTfPanel.createSequentialGroup()
						.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTenant)
							.addGroup(glTfPanel.createSequentialGroup()
								.addComponent(lblBuilding)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfBuildingName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblBuilding)
							.addGroup(glTfPanel.createSequentialGroup()
								.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(glTfPanel.createSequentialGroup()
										.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblStreet)
											.addComponent(lblZip, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
										.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tfZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(glTfPanel.createSequentialGroup()
										.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblFirstname)
											.addComponent(lblTel))
										.addGap(18)
										.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tfFirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGap(27)
								.addGroup(glTfPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(glTfPanel.createSequentialGroup()
										.addComponent(lblSurname)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(glTfPanel.createSequentialGroup()
										.addComponent(lblEmail)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(glTfPanel.createSequentialGroup()
										.addGroup(glTfPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblTown)
											.addComponent(lblHNo))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tfTown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfHNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(63, Short.MAX_VALUE))
					.addGroup(glTfPanel.createSequentialGroup()
						.addComponent(lblAdress)
						.addContainerGap(380, Short.MAX_VALUE))))
	);
	glTfPanel.setVerticalGroup(
		glTfPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(glTfPanel.createSequentialGroup()
				.addContainerGap()
				.addGroup(glTfPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblBuilding)
					.addComponent(tfBuildingName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(39)
				.addComponent(lblTenant)
				.addGap(18)
				.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(glTfPanel.createSequentialGroup()
						.addGroup(glTfPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSurname)
							.addComponent(tfSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(glTfPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEmail)))
					.addGroup(glTfPanel.createSequentialGroup()
						.addComponent(lblFirstname)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(glTfPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTel)
							.addComponent(tfTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
				.addComponent(lblAdress)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(glTfPanel.createParallelGroup(Alignment.LEADING)
					.addComponent(tfHNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(glTfPanel.createSequentialGroup()
						.addComponent(lblStreet)
						.addGap(18)
						.addComponent(lblZip))
					.addComponent(tfStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(glTfPanel.createSequentialGroup()
						.addComponent(lblHNo)
						.addGap(18)
						.addGroup(glTfPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfTown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTown))))
				.addGap(55))
	);
	
		tfPanel.setLayout(glTfPanel);
		
		// Initial Buttons
		JButton btnSave = new JButton("Save");
		btnPanel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnPanel.add(btnCancel);
		contentPane.setLayout(gl_contentPane);
	}
}
