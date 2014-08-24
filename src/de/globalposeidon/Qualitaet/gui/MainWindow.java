package de.globalposeidon.Qualitaet.gui;

import javax.swing.*;

import java.awt.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.TreeSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.*;


public class MainWindow extends JFrame{
	private static final long serialVersionUID = 8601779252949758710L;
	final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	final DataContainer model;
	
	 // Create the application.
	
	public MainWindow(DataContainer model) {
		super(Strings.globalposeidon);
		this.model = model;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Global Poseidon");
		} catch (final Exception e) {
		}
		initialize();
		logger.info("Main Window - Startup ok");
	}

	
	 // Initialize the contents of the frame.
	
	private void initialize() {
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator seperatorVertical = new JSeparator();
	
		// MenuBar
		setJMenuBar(new MainMenuBar(this));
		
		// Initial splitpanes
		JSplitPane splitPane = new JSplitPane();
		add(splitPane);
		
		// Initial left splitpane
		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		
		// Treemodel with model
		final MainTreeModel treeModel = new MainTreeModel(model);
		
		// tree with single selction mode
		JTree tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		// buttons			
		JButton btnAddBuilding = new JButton(Strings.addBuilding);
		btnAddBuilding.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBuildingWindow addBuilding = new AddBuildingWindow(model);
				addBuilding.addWindowListener(new WindowAdapter() {
				    @Override
				    public void windowClosed(WindowEvent e) {
				    	treeModel.reload();
				    }
				});
			}
		});	
// TODO: add entrance button to main window	
// TODO: add selectedBuilding method
		JButton btnAddEntrance = new JButton(Strings.addEntrance);
		btnAddEntrance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				AddEntranceWindow addEntrance = new AddEntranceWindow(selectedBuilding());
//				addEntrance.addWindowListener(new WindowAdapter() {
//				    @Override
//				    public void windowClosed(WindowEvent e) {
//				    	treeModel.reload();
//				    }
//				});
			}
		});	
// TODO: adapt apartment window just like AddEntranceWindow
// TODO: add selectedEntrance method
		JButton btnAddApartment = new JButton(Strings.addApartment);
		btnAddApartment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				AddEntranceWindow addEntrance = new AddEntranceWindow(selectedEntrance());
//				addEntrance.addWindowListener(new WindowAdapter() {
//				    @Override
//				    public void windowClosed(WindowEvent e) {
//				    	treeModel.reload();
//				    }
//				});
			}
		});	
// TODO: add meter button to main window
// TODO: add selectedApartment method		
		JButton addMeterBtn = new JButton(Strings.addRenter);
		addMeterBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				AddMeterWindow addMeter = new AddMeterWindow(selectedApartment()());
//				addMeter.addWindowListener(new WindowAdapter() {
//			    	@Override
//			    	public void windowClosed(WindowEvent e) {
//			    		treeModel.reload();
//			   		}
//				});
		}
	});	
// TODO: write AddRenterWindow with dropdown for apartments			
		JButton btnAddRenter = new JButton(Strings.addRenter);
		btnAddRenter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				AddRenterWindow addRenter = new AddRenterWindow(selectedApartment());
//				addRenter.addWindowListener(new WindowAdapter() {
//				    @Override
//				    public void windowClosed(WindowEvent e) {
//				    	treeModel.reload();
//				    }
//				});
			}
		});	
		
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
		
		// popup-menu for tree
		addPopup(tree, new MainPopupMenu());
	
		leftPanel.setLayout(glLeftPanel);		
		
		// Initial right splitpane
		JPanel rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);
		
		// Set new panel at the bottom part of the right splitpane
		JPanel BottomRightPanel = new JPanel();
				
		JLabel lblMeterId = new JLabel(Strings.meterID);
		
		JTextField tfMeterId = new JTextField();
		tfMeterId.setPreferredSize(new Dimension(100,20));
		
		JLabel lblMeterSearch = new JLabel(Strings.meterSearch);
		
		JButton btnSave = new JButton(Strings.save);
		JButton btnCancel = new JButton(Strings.cancel);
		
		//Initial Radiobuttons
		JLabel lblSort = new JLabel(Strings.sortByRentedUnrented);
		JRadioButton rdRented = new JRadioButton(Strings.rended);
		JRadioButton rdUnrented = new JRadioButton(Strings.unrented);
				
		//Group Radiobuttons
		ButtonGroup rdGroup = new ButtonGroup();
				
		rdGroup.add(rdRented);
		rdGroup.add(rdUnrented);
		
		// Set Vertical-Seperator
		seperatorVertical.setOrientation(SwingConstants.VERTICAL);
		
		// Set Components to fill the Meter Details
		JLabel lblDesReadingVal = new JLabel(Strings.meterReadingValue);
		JLabel lblReadingVal = new JLabel(Strings.readingValue);
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
							.addComponent(seperatorVertical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(seperatorVertical, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
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
		
		// Center frame
		setLocationRelativeTo(null);

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