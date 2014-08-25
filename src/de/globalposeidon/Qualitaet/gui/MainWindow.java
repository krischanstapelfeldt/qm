package de.globalposeidon.Qualitaet.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 8601779252949758710L;
	private final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private final DataContainer model;
	private Building currentBuilding;
	private Entrance currentEntrance;
	private Apartment currentApartment;

	// Create the application.

	public MainWindow(final DataContainer model) {
		super(Strings.GLOBALPOSEIDON);
		this.model = model;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty(
					"com.apple.mrj.application.apple.menu.about.name",
					"Global Poseidon");
		} catch (final Exception e) {
		}
		initialize();
		logger.info("Main Window - Startup ok");
	}

	// Initialize the contents of the frame

	private void initialize() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JSeparator seperatorVertical = new JSeparator();

		// MenuBar
		setJMenuBar(new MainMenuBar(this));

		// Initial splitpanes
		final JSplitPane splitPane = new JSplitPane();
		add(splitPane);

		// Initial left splitpane
		final JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);

		// Treemodel with model
		final MainTreeModel treeModel = new MainTreeModel(model);

		// declare buttons
		final JButton btnAddBuilding = new JButton(Strings.ADDBUILDING);
		final JButton btnAddEntrance = new JButton(Strings.ADDENTRANCE);
		final JButton btnAddApartment = new JButton(Strings.ADDAPARTMENT);
		final JButton btnAddMeter = new JButton(Strings.ADDMETER);
		final JButton btnAddTenant = new JButton(Strings.ADDTENANT);

		// set buttons disabled to make them depending on node selection
		btnAddEntrance.setEnabled(false);
		btnAddApartment.setEnabled(false);
		btnAddMeter.setEnabled(false);
		btnAddTenant.setEnabled(false);
		// TODO: make classes for right side panel
		// tree with single selection mode
		final JTree tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(final TreeSelectionEvent e) {
				final TreeNode node = (TreeNode) tree
						.getLastSelectedPathComponent();
				/* if nothing is selected */
				if (node == null) {
					btnAddEntrance.setEnabled(false);
					btnAddApartment.setEnabled(false);
					btnAddMeter.setEnabled(false);
					btnAddTenant.setEnabled(false);
					return;
				}
				/* React to the node selection. */
				if (node instanceof Building) {
					System.out.println("selected a building with ID:"
							+ ((Building) node).getID());
					setCurrentBuilding((Building) node);
					// in case of switched building, set rest null
					setCurrentEntrance(null);
					setCurrentApartment(null);
					// also set other buttons enabled/disabled
					btnAddEntrance.setEnabled(true);
					btnAddApartment.setEnabled(false);
					btnAddMeter.setEnabled(false);
					btnAddTenant.setEnabled(false);

					// set right panel
					splitPane.setRightComponent(new BuildingPanel(
							selectedBuilding()));
				} else if (node instanceof Entrance) {
					System.out.println("selected an entrance with ID:"
							+ ((Entrance) node).getID());
					setCurrentEntrance((Entrance) node);
					// in case of switched building, set rest null
					setCurrentApartment(null);
					// also set other buttons enabled/disabled
					btnAddEntrance.setEnabled(true);
					btnAddApartment.setEnabled(true);
					btnAddMeter.setEnabled(true);
					btnAddTenant.setEnabled(false);
				} else if (node instanceof Apartment) {
					System.out.println("selected an apartment with ID: "
							+ ((Apartment) node).getID());
					setCurrentApartment((Apartment) node);
					// also set other buttons enabled/disabled
					btnAddEntrance.setEnabled(true);
					btnAddApartment.setEnabled(true);
					btnAddMeter.setEnabled(true);
					btnAddTenant.setEnabled(true);
				} else {
					btnAddEntrance.setEnabled(false);
					btnAddApartment.setEnabled(false);
					btnAddMeter.setEnabled(false);
					btnAddTenant.setEnabled(false);
				}
			}
		});

		// button listener
		btnAddBuilding.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final AddBuildingWindow addBuilding = new AddBuildingWindow(
						model);
				addBuilding.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(final WindowEvent e) {
						treeModel.reload();
					}
				});
			}
		});
		btnAddEntrance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final AddEntranceWindow addEntrance = new AddEntranceWindow(
						selectedBuilding());
				addEntrance.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(final WindowEvent e) {
						treeModel.reload();
					}
				});
			}
		});
		btnAddApartment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final AddApartmentWindow addApartment = new AddApartmentWindow(
						selectedEntrance());
				addApartment.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(final WindowEvent e) {
						treeModel.reload();
					}
				});
			}
		});
		btnAddMeter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				AddMeterWindow addMeter;
				if (selectedApartment() != null) {
					addMeter = new AddMeterWindow(selectedApartment());
				} else {
					addMeter = new AddMeterWindow(selectedEntrance());
				}

				addMeter.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(final WindowEvent e) {
						treeModel.reload();
					}
				});
			}
		});
		btnAddTenant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final AddTenantWindow addTenant = new AddTenantWindow(
						selectedApartment());
				addTenant.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(final WindowEvent e) {
						treeModel.reload();
					}
				});
			}
		});

		// Set Grouplayout in the leftsplit
		final GroupLayout glLeftPanel = new GroupLayout(leftPanel);
		glLeftPanel
				.setHorizontalGroup(glLeftPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								glLeftPanel.createSequentialGroup()
										.addComponent(tree,
												GroupLayout.DEFAULT_SIZE, 200,
												Short.MAX_VALUE))
						.addGroup(
								glLeftPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												glLeftPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																glLeftPanel
																		.createSequentialGroup()
																		.addGroup(
																				glLeftPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								btnAddTenant,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnAddBuilding,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnAddApartment,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnAddMeter,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnAddEntrance,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addContainerGap()))));

		glLeftPanel.setVerticalGroup(glLeftPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				glLeftPanel
						.createSequentialGroup()
						.addComponent(tree, GroupLayout.DEFAULT_SIZE, 400,
								Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddBuilding)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddEntrance)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddApartment)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddMeter)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddTenant).addContainerGap()));

		// popup-menu for tree
		addPopup(tree, new MainPopupMenu());

		leftPanel.setLayout(glLeftPanel);

		// Initial right splitpane
		final JPanel rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);

		// Set new panel at the bottom part of the right splitpane
		final JPanel pnlBottomRight = new JPanel();

		final JLabel lblMeterId = new JLabel(Strings.METERID);

		final JTextField tfMeterId = new JTextField();
		tfMeterId.setPreferredSize(new Dimension(100, 20));

		final JLabel lblMeterSearch = new JLabel(Strings.METERSEARCH);

		final JButton btnSave = new JButton(Strings.SAVE);
		final JButton btnCancel = new JButton(Strings.CANCEL);

		// Initial Radiobuttons
		final JLabel lblSort = new JLabel(Strings.SORTBYUNRENTED);
		final JRadioButton rdRented = new JRadioButton(Strings.RENTED);
		final JRadioButton rdUnrented = new JRadioButton(Strings.UNRENTED);

		// Group Radiobuttons
		final ButtonGroup rdGroup = new ButtonGroup();

		rdGroup.add(rdRented);
		rdGroup.add(rdUnrented);

		// Set Vertical-Seperator
		seperatorVertical.setOrientation(SwingConstants.VERTICAL);

		// Set Components to fill the Meter Details
		final JLabel lblDesReadingVal = new JLabel(Strings.METERREADINGVALUE);
		final JLabel lblReadingVal = new JLabel(Strings.READINGVALUE);
		final JTextField tfReadingVal = new JTextField();
		tfReadingVal.setPreferredSize(new Dimension(100, 20));

		// Set Layout at the bottom part of the right splitpane
		final GroupLayout glBottomRightPanel = new GroupLayout(pnlBottomRight);
		glBottomRightPanel
				.setHorizontalGroup(glBottomRightPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								glBottomRightPanel
										.createSequentialGroup()
										.addGroup(
												glBottomRightPanel
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addGroup(
																glBottomRightPanel
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnSave))
														.addGroup(
																Alignment.LEADING,
																glBottomRightPanel
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				glBottomRightPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblMeterSearch)
																						.addGroup(
																								glBottomRightPanel
																										.createSequentialGroup()
																										.addComponent(
																												lblMeterId)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												tfMeterId,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))))
										.addGap(25)
										.addGroup(
												glBottomRightPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																glBottomRightPanel
																		.createSequentialGroup()
																		.addGroup(
																				glBottomRightPanel
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblDesReadingVal,
																								Alignment.LEADING)
																						.addGroup(
																								glBottomRightPanel
																										.createSequentialGroup()
																										.addComponent(
																												lblReadingVal)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												tfReadingVal,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(20)
																		.addComponent(
																				seperatorVertical,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(25)
																		.addGroup(
																				glBottomRightPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								rdUnrented)
																						.addComponent(
																								rdRented)
																						.addComponent(
																								lblSort)))
														.addComponent(btnCancel))
										.addContainerGap()));

		glBottomRightPanel
				.setVerticalGroup(glBottomRightPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								glBottomRightPanel
										.createSequentialGroup()
										.addContainerGap(25, Short.MAX_VALUE)
										.addGroup(
												glBottomRightPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																seperatorVertical,
																GroupLayout.PREFERRED_SIZE,
																90,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																glBottomRightPanel
																		.createSequentialGroup()
																		.addComponent(
																				lblSort)
																		.addGap(20)
																		.addComponent(
																				rdRented)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				rdUnrented))
														.addGroup(
																glBottomRightPanel
																		.createSequentialGroup()
																		.addGroup(
																				glBottomRightPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblMeterSearch)
																						.addComponent(
																								lblDesReadingVal))
																		.addGap(20)
																		.addGroup(
																				glBottomRightPanel
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblMeterId)
																						.addComponent(
																								tfMeterId,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								tfReadingVal,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblReadingVal))))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glBottomRightPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnSave)
														.addComponent(btnCancel))));

		pnlBottomRight.setLayout(glBottomRightPanel);

		// Initial Scrollpane
		final JScrollPane scrollPane = new JScrollPane();

		// Set Layout at the Top part of the right splitpane
		final GroupLayout glTopRightPanel = new GroupLayout(rightPanel);
		glTopRightPanel.setHorizontalGroup(glTopRightPanel
				.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlBottomRight, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		glTopRightPanel.setVerticalGroup(glTopRightPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				glTopRightPanel
						.createSequentialGroup()

						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

						.addComponent(pnlBottomRight,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGap(20)));

		// Initial JTable
		final JTable table = new JTable();
		scrollPane.setViewportView(table);
		rightPanel.setLayout(glTopRightPanel);

		// Center frame
		setLocationRelativeTo(null);

	}

	// Necessary to open the popup-menu
	private static void addPopup(final Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			@Override
			public void mouseReleased(final MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(final MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void setCurrentBuilding(final Building building) {

		currentBuilding = building;
	}

	private Building selectedBuilding() {

		return currentBuilding;
	}

	private void setCurrentEntrance(final Entrance entrance) {

		currentEntrance = entrance;
	}

	private Entrance selectedEntrance() {

		return currentEntrance;
	}

	private void setCurrentApartment(final Apartment apartment) {

		currentApartment = apartment;
	}

	private Apartment selectedApartment() {

		return currentApartment;
	}
}
