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


public class MainWindow extends JFrame {
	private static final long serialVersionUID = 8601779252949758710L;
	final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private JFrame frame;
	private JTextField tfTest;
	private JTable table;

	
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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator separator = new JSeparator();
	
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
					.addGap(0)
					.addComponent(tree, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(glLeftPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glLeftPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, glLeftPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnAddRenter, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(glLeftPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(glLeftPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAddBuilding, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
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
		
		
		popMenu.add(separator);
		
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
		
		// Set Gridlayout at right splitpane
		rightPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		// Initial scrollpane for the JTable
		JScrollPane scrollPane = new JScrollPane();
		rightPanel.add(scrollPane);
		
		// Initial Table for the datail view
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// Set cardlayout at the top part of the right splitpane
		JPanel clTopRightPanel = new JPanel();
		rightPanel.add(clTopRightPanel);
		clTopRightPanel.setLayout(new CardLayout(0, 0));
		
		// Set new panel at the bottom part of the right splitpane
		JPanel BottomRightPanel = new JPanel();
		clTopRightPanel.add(BottomRightPanel, "name_39926974484125");
		
		JLabel lblTest = new JLabel("Test Lable");
		
		tfTest = new JTextField();
		tfTest.setColumns(10);
		
		JLabel label = new JLabel("New label");
		GroupLayout glBottomRightPanel = new GroupLayout(BottomRightPanel);
		glBottomRightPanel.setHorizontalGroup(
				glBottomRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glBottomRightPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(glBottomRightPanel.createSequentialGroup()
							.addComponent(lblTest)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfTest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addContainerGap(385, Short.MAX_VALUE))
		);
		glBottomRightPanel.setVerticalGroup(
				glBottomRightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glBottomRightPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(glBottomRightPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTest)
						.addComponent(tfTest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(label)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		BottomRightPanel.setLayout(glBottomRightPanel);
		
		

	}
	
	// necessary to open the popup-menu
	
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

	

		
	
