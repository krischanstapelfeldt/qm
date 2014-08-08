package de.globalposeidon.Qualitaet.gui;

import javax.swing.*;

import java.awt.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.model.*;


public class MainWindow extends JFrame{
	private static final long serialVersionUID = 8601779252949758710L;
	final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private JFrame frame;

	
	 // Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 // Create the application.
	
	public MainWindow() {
		super("Global Poseidon");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Global Poseidon");
		} catch (final Exception e) {
		}
		initialize();
		logger.info("Startup ok");
	}

	
	 // Initialize the contents of the frame.
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator separatorPopup = new JSeparator();
		JSeparator seperatorVerical = new JSeparator();
	
		// MenuBar in the top
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem close = new JMenuItem("close");
		file.add(close);
		
		JMenu edit = new JMenu("edit");
		menuBar.add(edit);
		
		JMenuItem building = new JMenuItem("Add building");
		edit.add(building);
		
		JMenuItem apartment = new JMenuItem("Add apartment");
		edit.add(apartment);
		
		JMenuItem renter = new JMenuItem("Add renter");
		edit.add(renter);
		
			
		JMenu help = new JMenu("help");
		menuBar.add(help);
		
		JMenuItem about = new JMenuItem("about");
		help.add(about);
		
		JMenuItem faq = new JMenuItem("faq");
		help.add(faq);
		
		// Set Layout in the frame
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		// Initial splitpanes
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane);
		
		// Initial left splitpane
		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		
		// Initial Tree
		JTree tree = new JTree();
		
		// Initial Buttons
				
		JButton btnAddRenter = new JButton("Add renter");
		JButton btnAddApartment = new JButton("Add apartment");
		JButton btnAddBuilding = new JButton("Add building");
		
		// Set Grouplayout in the leftsplit
		GroupLayout glLeftPanel = new GroupLayout(leftPanel);
		glLeftPanel.setHorizontalGroup(
				glLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glLeftPanel.createSequentialGroup()
					.addComponent(tree, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
				.addGroup(glLeftPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glLeftPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, glLeftPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnAddRenter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(glLeftPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(glLeftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAddBuilding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddApartment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())))
		);
		glLeftPanel.setVerticalGroup(
				glLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glLeftPanel.createSequentialGroup()
					.addComponent(tree, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addComponent(btnAddBuilding)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddApartment)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddRenter)
					.addContainerGap())
		);
		
		// Initial popup-menu
		JPopupMenu popMenu = new JPopupMenu();
		addPopup(tree, popMenu);
		
		JMenuItem AddBuilding = new JMenuItem("Add Tenant");
		popMenu.add(AddBuilding);
		
		JMenuItem AddRenter = new JMenuItem("Add Tenant");
		popMenu.add(AddRenter);
		
		JMenuItem AddTenant = new JMenuItem("Add Tenant");
		popMenu.add(AddTenant);
		
		
		popMenu.add(separatorPopup);
		
		JMenuItem DelBuilding = new JMenuItem("Delete Building");
		popMenu.add(DelBuilding);
		
		JMenuItem DelFlat = new JMenuItem("Delete Flat");
		popMenu.add(DelFlat);
		
		JMenuItem DelEntrance = new JMenuItem("Delete Entrance");
		popMenu.add(DelEntrance);
		
		JMenuItem DelRenter = new JMenuItem("Delete Renter");
		popMenu.add(DelRenter);
		leftPanel.setLayout(glLeftPanel);
		
		
		
		// Initial right splitpane
		JPanel rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);
		
		// Set new panel at the bottom part of the right splitpane
		
		JPanel BottomRightPanel = new JPanel();
		
		
		JLabel lblMeterId = new JLabel("Meter ID");
		
		JTextField tfMeterId = new JTextField();
		tfMeterId.setPreferredSize(new Dimension(100,20));
		
		JLabel lblMeterSearch = new JLabel("Meter search:");
		
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");
		
		
		
		//Initial Radiobuttons
		JLabel lblSort = new JLabel("Sort by rented/unrented:");
		JRadioButton rdRented = new JRadioButton("Rented");
		JRadioButton rdUnrented = new JRadioButton("Unrented");
				
		//Group Radiobuttons
		ButtonGroup rdGroup = new ButtonGroup();
				
		rdGroup.add(rdRented);
		rdGroup.add(rdUnrented);
		
		// Set Vertical-Seperator
		seperatorVerical.setOrientation(SwingConstants.VERTICAL);
		
		// Set Components to fill the Meter Details
		JLabel lblDesReadingVal = new JLabel("Meter reading value:");
		JLabel lblReadingVal = new JLabel("Reading Value");
		JTextField tfReadingVal = new JTextField();
		tfReadingVal.setPreferredSize(new Dimension(100,20));
		
	
		// Set Layout at the bottom part of the right splitpane
		GroupLayout glBottomRightPanel = new GroupLayout(BottomRightPanel);
		glBottomRightPanel.setHorizontalGroup(
			glBottomRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glBottomRightPanel.createSequentialGroup()
					.addGroup(glBottomRightPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(glBottomRightPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSave))
						.addGroup(Alignment.LEADING, glBottomRightPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMeterSearch)
								.addGroup(glBottomRightPanel.createSequentialGroup()
									.addComponent(lblMeterId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfMeterId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(25)
					.addGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(glBottomRightPanel.createSequentialGroup()
							.addGroup(glBottomRightPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDesReadingVal, Alignment.LEADING)
								.addGroup(glBottomRightPanel.createSequentialGroup()
									.addComponent(lblReadingVal)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfReadingVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(20)
							.addComponent(seperatorVerical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdUnrented)
								.addComponent(rdRented)
								.addComponent(lblSort)))
						.addComponent(btnCancel))
						.addContainerGap())
		);
		
			
		glBottomRightPanel.setVerticalGroup(
				glBottomRightPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(glBottomRightPanel.createSequentialGroup()
						.addContainerGap(25, Short.MAX_VALUE)
						.addGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(seperatorVerical, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGroup(glBottomRightPanel.createSequentialGroup()
								.addComponent(lblSort)
								.addGap(20)
								.addComponent(rdRented)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(rdUnrented))
							.addGroup(glBottomRightPanel.createSequentialGroup()
								.addGroup(glBottomRightPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMeterSearch)
									.addComponent(lblDesReadingVal))
								.addGap(20)
								.addGroup(glBottomRightPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMeterId)
									.addComponent(tfMeterId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfReadingVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblReadingVal))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(glBottomRightPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSave)
							.addComponent(btnCancel)))
			);
		
		BottomRightPanel.setLayout(glBottomRightPanel);
		
		
		
		// Initial Scrollpane
		JScrollPane scrollPane = new JScrollPane();
		
		// Set Layout at the Top part of the right splitpane
		
		GroupLayout glTopRightPanel = new GroupLayout(rightPanel);
		glTopRightPanel.setHorizontalGroup(
			glTopRightPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(BottomRightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		glTopRightPanel.setVerticalGroup(
			glTopRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glTopRightPanel.createSequentialGroup()
				
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
					.addComponent(BottomRightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		// Initial JTable
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		rightPanel.setLayout(glTopRightPanel);
		
		

	}
	
	// Necessary to open the popup-menu
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}



	
