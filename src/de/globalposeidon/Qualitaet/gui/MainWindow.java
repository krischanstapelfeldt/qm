package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;

public class MainWindow extends JFrame {

   private static final long serialVersionUID = 8601779252949758710L;
   private final Logger logger = LoggerFactory.getLogger(MainWindow.class);
   public DataContainer model;
   private Building currentBuilding;
   private Entrance currentEntrance;
   private Apartment currentApartment;
   private Meter currentMeter;

   private MainTreeModel treeModel;

   // Create the application.
   public MainWindow(final DataContainer model) {
      super(Strings.GLOBALPOSEIDON);
      this.model = model;
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         System.setProperty("apple.laf.useScreenMenuBar", "true");
         System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Global Poseidon");
      } catch (final Exception e) {
         logger.error("Could not set theme");
      }
      initialize();
      logger.info("Main Window - Startup ok");
   }

   // Initialize the contents of the frame

   private void initialize() {
      setSize(Strings.ONE_THOUSAND, Strings.SIX_HUNDRED);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Center frame
      setLocationRelativeTo(null);
      
      // Treemodel with model
      treeModel = new MainTreeModel(model);
      final JTree tree = new JTree(treeModel);
      
      // MenuBar
      setJMenuBar(new MainMenuBar(this, model, treeModel));

      // Initial splitpanes
      final JSplitPane splitPane = new JSplitPane();
      add(splitPane);

      // Initial left panel at leftsplitpane
      final JPanel leftPanel = new JPanel();
      splitPane.setLeftComponent(leftPanel);

      // Initial right panel at rightsplitpane
      final JPanel rightPanel = new JPanel();
      splitPane.setRightComponent(rightPanel);

      // Set new panel at the bottom part of the right splitpane
      final JPanel pnlBottomRight = new JPanel();

      // Set FunktionalPanel
      final JPanel pnlFunction = new JPanel();

      // Set contentPanel
      final JPanel cntPanel = new JPanel();

      // declare BorderLayout at contentPanel
      cntPanel.setLayout(new BorderLayout());

      // declare GroupLayout at leftpanel
      final GroupLayout glLeftPanel = new GroupLayout(leftPanel);

      // declare GroupLayout at rightpanel
      final GroupLayout glBottomRightPanel = new GroupLayout(pnlBottomRight);
      final GroupLayout glTopRightPanel = new GroupLayout(rightPanel);


      // declare buttons
      final JButton btnAddBuilding = new JButton(Strings.ADDBUILDING);
      final JButton btnAddEntrance = new JButton(Strings.ADDENTRANCE);
      final JButton btnAddApartment = new JButton(Strings.ADDAPARTMENT);
      final JButton btnAddMeter = new JButton(Strings.ADDMETER);
      final JButton btnAddTenant = new JButton(Strings.ADDTENANT);
      final JButton btnDelete = new JButton(Strings.DELWSPACE);

      final FunctionPanel panelFunction = new FunctionPanel(this);
      // add radiobuttons to a group
      final ButtonGroup rdGroup = new ButtonGroup();
      rdGroup.add(panelFunction.getRdbtnUnsorted());
      rdGroup.add(panelFunction.getRdbtnRented());
      rdGroup.add(panelFunction.getRdbtnUnrented());

      // set buttons disabled to make them depending on node selection
      btnAddEntrance.setEnabled(false);
      btnAddApartment.setEnabled(false);
      btnAddMeter.setEnabled(false);
      btnAddTenant.setEnabled(false);
      // set texftfields and radiobutton disabled to make them depending on node
      // selection
      panelFunction.getTfReadingVal().setEnabled(false);
      panelFunction.getTfPerson().setEnabled(false);
      panelFunction.getTfReadingInfo().setEnabled(false);
      panelFunction.getRdbtnUnsorted().setEnabled(false);
      panelFunction.getRdbtnRented().setEnabled(false);
      panelFunction.getRdbtnUnrented().setEnabled(false);

      // add FunctionPanel on BottomRightPanel
      pnlFunction.add(panelFunction);

      // order Grouplayout in the leftsplit
      glLeftPanel.setHorizontalGroup(glLeftPanel
            .createParallelGroup(Alignment.LEADING)
            .addGroup(
                  glLeftPanel.createSequentialGroup().addComponent(tree, GroupLayout.DEFAULT_SIZE, Strings.TWO_HUNDRED, Short.MAX_VALUE))
                  .addGroup(
                        glLeftPanel
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                              glLeftPanel.createParallelGroup(Alignment.LEADING).addGroup(
                                    Alignment.TRAILING,
                                    glLeftPanel
                                    .createSequentialGroup()
                                    .addGroup(
                                          glLeftPanel
                                          .createParallelGroup(Alignment.LEADING)
                                          .addComponent(btnAddTenant, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                                .addComponent(btnAddBuilding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                      Short.MAX_VALUE)
                                                      .addComponent(btnAddApartment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                            Short.MAX_VALUE)
                                                            .addComponent(btnAddMeter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                                  Short.MAX_VALUE)
                                                                  .addComponent(btnAddEntrance, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                        .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                                              Short.MAX_VALUE)).addContainerGap()))));

      glLeftPanel.setVerticalGroup(glLeftPanel.createParallelGroup(Alignment.LEADING).addGroup(
            glLeftPanel.createSequentialGroup().addComponent(tree, GroupLayout.DEFAULT_SIZE, Strings.FOUR_HUNDRED, Short.MAX_VALUE)
            .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddBuilding).addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnAddEntrance).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddApartment)
            .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddMeter).addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnAddTenant).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDelete).addContainerGap()));

      leftPanel.setLayout(glLeftPanel);

      // Set Bottom Panel
      glBottomRightPanel.setHorizontalGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING).addComponent(pnlFunction,
            GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

      glBottomRightPanel.setVerticalGroup(glBottomRightPanel.createParallelGroup(Alignment.LEADING).addComponent(pnlFunction,
            GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

      pnlBottomRight.setLayout(glBottomRightPanel);

      // order Layout at the Top part of the right splitpane
      glTopRightPanel.setHorizontalGroup(glTopRightPanel.createParallelGroup(Alignment.LEADING)
            .addComponent(pnlBottomRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cntPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

      glTopRightPanel.setVerticalGroup(glTopRightPanel.createParallelGroup(Alignment.LEADING).addGroup(
            glTopRightPanel.createSequentialGroup()
            .addComponent(cntPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottomRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(Strings.TEN)));

      rightPanel.setLayout(glTopRightPanel);

      // popup-menu for tree
      addPopup(tree, new MainPopupMenu());

      // tree with single selection mode
      tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
      tree.addTreeSelectionListener(new TreeSelectionListener() {
         @Override
         public void valueChanged(final TreeSelectionEvent e) {
            final TreeNode node = (TreeNode) tree.getLastSelectedPathComponent();
            /* if nothing is selected */
            if (node == null) {
               btnAddEntrance.setEnabled(false);
               btnAddApartment.setEnabled(false);
               btnAddMeter.setEnabled(false);
               btnAddTenant.setEnabled(false);
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getTfPerson().setEnabled(false);
               panelFunction.getTfReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);
               return;

            }
            /* React to the node selection. */
            if (node instanceof Building) {
               // System.out.println("selected a building with ID:" +
               // ((Building) node).getID());
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
               cntPanel.removeAll();
               cntPanel.add(new BuildingPanel(selectedBuilding()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getTfPerson().setEnabled(false);
               panelFunction.getTfReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

            } else if (node instanceof Entrance) {
               // System.out.println("selected an entrance with ID:" +
               // ((Entrance) node).getID());
               setCurrentEntrance((Entrance) node);
               // in case of switched building, set rest null
               setCurrentApartment(null);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(false);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new EntrancePanel(selectedEntrance()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getTfPerson().setEnabled(false);
               panelFunction.getTfReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(true);
               panelFunction.getRdbtnRented().setEnabled(true);
               panelFunction.getRdbtnUnrented().setEnabled(true);

            } else if (node instanceof Apartment) {
               // System.out.println("selected an apartment with ID: " +
               // ((Apartment) node).getID());
               setCurrentApartment((Apartment) node);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new ApartmentPanel(selectedApartment()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getTfPerson().setEnabled(false);
               panelFunction.getTfReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

            } else if (node instanceof Meter) {
               // System.out.println("selected an Meter with ID: " + ((Meter)
               // node).getID());
               setCurrentMeter((Meter) node);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new MeterPanel(selectedMeter()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(true);
               panelFunction.getTfPerson().setEnabled(true);
               panelFunction.getTfReadingInfo().setEnabled(true);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

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
            final AddBuildingWindow addBuilding = new AddBuildingWindow(model);
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
            final AddEntranceWindow addEntrance = new AddEntranceWindow(selectedBuilding());
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
            final AddApartmentWindow addApartment = new AddApartmentWindow(selectedEntrance());
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
               addMeter = new AddMeterWindow(model, selectedApartment());
            } else {
               addMeter = new AddMeterWindow(model, selectedEntrance());
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
            final AddTenantWindow addTenant = new AddTenantWindow(selectedApartment());
            addTenant.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosed(final WindowEvent e) {
                  treeModel.reload();
               }
            });
         }
      });

      // TODO: WORK IN PROGRESS - Currently crashing
      // TreePath path = find((DefaultMutableTreeNode) treeModel.getRoot(),
      // "5");
      // tree.setSelectionPath(path);
      // tree.scrollPathToVisible(path);
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

   private void setCurrentMeter(final Meter meter) {

      currentMeter = meter;
   }

   private Meter selectedMeter() {

      return currentMeter;
   }

// should be called from within the function panel
//   public void findMeter(String meterID) {
//	   find(treeModel.def, meterID);
//   }

//   private TreePath find(final DefaultMutableTreeNode root, final String s) {
//      @SuppressWarnings("unchecked")
//      final Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
//      System.out.println("find() - just before while loop");
//      while (e.hasMoreElements()) {
//         final DefaultMutableTreeNode node = e.nextElement();
//         System.out.println("find() - just after next element");
//         if (node.toString().equalsIgnoreCase(s)) {
//            return new TreePath(node.getPath());
//         }
//      }
//      return null;
//   }
   
}
