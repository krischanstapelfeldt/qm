package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

/*
 * TODO MUSS
 * WIP - Testdaten f�r alle Z�hler (unterschiedliche Werte, etc...)
 * Suchen von Z�hlern!
 * Ablesefunktion f�r Z�hler ben�tigt Dropdown mit Auswahl f�r Reader und ReadingInfo
 * Neue Ablesewerte und Datum k�nnen nur gr��er sein
 * Verbrauch seit 1.1. anzeigen/berechnen (Testdaten erzeugen!)
 * Verbrauch/Tage seit der letzen Lesung -> Im Model!
 * DONE - L�schen von Mietern
 * Sortieren/Anzeige nach Vermietet und nicht vermietet (im JTable Feld "Vermietet?" und danach abfragen?)
 *
 * TODO KANN
 * Daten sicher (Funktioniert, nur ausgeklammert, f�r Vossi ggfs aktivieren)
 * Titel f�r JTables
 * Meldung �ber erfolgreiche/ nicht erfolgreiche Aktionen. (JFrame Klasse ...)
 * Anzeige im Content nach Start & ohne Auswahl
 * Edit aus Menu entfernen
 * Spaces zwischen Trennstrichen im Contentpane
 * Felder auf Eingaben pr�fen(reine Zahl, etc)
 * Apartment Button "delete" -> "delete tenant" und nur bei auswahl einblenden
 * JTable Felder Gr��e an Inhalt anpassen?*/

/**
 * MainWindow Klasse.
 * @author Timm
 */
public class MainWindow extends JFrame {

   private static final long serialVersionUID = 8601779252949758710L;
   private final Logger logger = LoggerFactory.getLogger(MainWindow.class);
   private DataContainer model;
   private Building currentBuilding;
   private Entrance currentEntrance;
   private Apartment currentApartment;
   private Meter currentMeter;

   private MainTreeModel treeModel;

   /**
    * Konstruktor.
    * @param model
    *           model
    */
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
   /**
    * Initialisieren.
    */
   private void initialize() {
      setSize(Strings.ONE_THOUSAND, Strings.SIX_HUNDRED);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Center frame
      setLocationRelativeTo(null);

      // Treemodel with model
      treeModel = new MainTreeModel(model);
      final JTree tree = new JTree(treeModel);
      tree.setRootVisible(false);

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
      btnDelete.setEnabled(false);

      // set texftfields and radiobutton disabled to make them depending on node
      // selection
      panelFunction.getTfReadingVal().setEnabled(false);
      panelFunction.getCbPerson().setEnabled(false);
      panelFunction.getCbReadingInfo().setEnabled(false);
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
      // addPopup(tree, new MainPopupMenu());

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
               btnDelete.setEnabled(false);
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getCbPerson().setEnabled(false);
               panelFunction.getCbReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);
               return;

            }
            /* React to the node selection. */
            if (node instanceof Building) {
               setCurrentBuilding((Building) node);
               // in case of switched building, set rest null
               setCurrentEntrance(null);
               setCurrentApartment(null);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(false);
               btnAddMeter.setEnabled(false);
               btnAddTenant.setEnabled(false);
               btnDelete.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new BuildingPanel(selectedBuilding()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getCbPerson().setEnabled(false);
               panelFunction.getCbReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

            } else if (node instanceof Entrance) {
               setCurrentEntrance((Entrance) node);
               // in case of switched building, set rest null
               setCurrentApartment(null);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(false);
               btnDelete.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new EntrancePanel(selectedEntrance()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getCbPerson().setEnabled(false);
               panelFunction.getCbReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(true);
               panelFunction.getRdbtnRented().setEnabled(true);
               panelFunction.getRdbtnUnrented().setEnabled(true);

            } else if (node instanceof Apartment) {
               setCurrentApartment((Apartment) node);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(true);
               btnDelete.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new ApartmentPanel(selectedApartment()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(false);
               panelFunction.getCbPerson().setEnabled(false);
               panelFunction.getCbReadingInfo().setEnabled(false);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

            } else if (node instanceof Meter) {
               setCurrentMeter((Meter) node);
               // also set other buttons enabled/disabled
               btnAddEntrance.setEnabled(true);
               btnAddApartment.setEnabled(true);
               btnAddMeter.setEnabled(true);
               btnAddTenant.setEnabled(true);
               btnDelete.setEnabled(true);

               // set right panel
               cntPanel.removeAll();
               cntPanel.add(new MeterPanel(selectedMeter()));

               // set textfields and radiobuttons enable/disable
               panelFunction.getTfReadingVal().setEnabled(true);
               panelFunction.getCbPerson().setEnabled(true);
               panelFunction.getCbReadingInfo().setEnabled(true);
               panelFunction.getRdbtnUnsorted().setEnabled(false);
               panelFunction.getRdbtnRented().setEnabled(false);
               panelFunction.getRdbtnUnrented().setEnabled(false);

            } else {
               btnAddEntrance.setEnabled(false);
               btnAddApartment.setEnabled(false);
               btnAddMeter.setEnabled(false);
               btnAddTenant.setEnabled(false);
               btnDelete.setEnabled(false);

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
      btnDelete.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {

            final TreeNode node = (TreeNode) tree.getLastSelectedPathComponent();
            /* React to the node selection. */
            if (node instanceof Building) {
               if (((Building) node).buildingIsEmpty()) {
                  model.removeBuilding(selectedBuilding());
               }
            } else if (node instanceof Entrance) {
               if (((Entrance) node).entranceIsEmpty()) {
                  selectedBuilding().getEntrances().remove(node);
               }
            } else if (node instanceof Apartment) {
               if (((Apartment) node).apartmentIsEmpty()) {
                  selectedEntrance().getApartments().remove(node);
               }
            } else if (node instanceof Meter) {
               if (selectedApartment() != null) {
                  selectedApartment().getMeters().remove(node);
               } else {
                  selectedEntrance().getMeters().remove(node);
               }
            }
            treeModel.reload();
         }
      });

       TreePath path = find((DefaultMutableTreeNode) treeModel.getRoot(),
       "8");
       tree.setSelectionPath(path);
       tree.scrollPathToVisible(path);
   }

   /**
    * Aktuelles Gebaude setzen.
    * @param building
    *           Gebaude
    */
   private void setCurrentBuilding(final Building building) {

      currentBuilding = building;
   }

   /**
    * Aktuelles Gebauede.
    * @return Gebaude
    */
   public final Building selectedBuilding() {

      return currentBuilding;
   }

   /**
    * Aktuellen Eingang setzen.
    * @param entrance
    *           Eingang
    */
   private void setCurrentEntrance(final Entrance entrance) {

      currentEntrance = entrance;
   }

   /**
    * Aktueller Eingang.
    * @return Eingang
    */
   public final Entrance selectedEntrance() {

      return currentEntrance;
   }

   /**
    * Aktuelles Apartment setzen.
    * @param apartment
    *           Apartment
    */
   private void setCurrentApartment(final Apartment apartment) {

      currentApartment = apartment;
   }

   /**
    * Aktuelles Apartment.
    * @return apartment
    */
   public final Apartment selectedApartment() {

      return currentApartment;
   }

   /**
    * Aktuellen Zaehler setzen.
    * @param meter
    *           Zaehler
    */
   private void setCurrentMeter(final Meter meter) {

      currentMeter = meter;
   }

   /**
    * Aktuelle Zaehler.
    * @return Zaehler
    */
   public final Meter selectedMeter() {

      return currentMeter;
   }

   public void findMeter(String meterID) {
      find((DefaultMutableTreeNode) treeModel.getRoot(), meterID);
   }

   private TreePath find(final DefaultMutableTreeNode root, final String s) {

      for (Enumeration<DefaultMutableTreeNode> e = root.preorderEnumeration(); e.hasMoreElements();) {
         DefaultMutableTreeNode node = null;
         try {
            node = e.nextElement();
            if (node.getChildCount() > 0) {
               for (Enumeration<DefaultMutableTreeNode> enumr = node.children(); enumr.hasMoreElements();) {
                  DefaultMutableTreeNode node_r = null;
                  try {
                     node_r = enumr.nextElement();
                     if (node_r.getClass() == Meter.class) {
                        Meter meter = (Meter) node_r;
                        System.out.println(node_r);
                        if (meter.getID() == new Integer(s))
                           return new TreePath(node.getPath());
                     }
                  } catch (Exception exa) {
                       // Ja, das knallt manchmal, aber das kann ignoriert werden
                  }
               }
            }
         } catch (Exception e2) {
            // Ja, das knallt manchmal, aber das kann ignoriert werden
         }
      }

      System.out.println("find() - just before while loop");
      // while (e.hasMoreElements()) {
      //
      // }
      return null;
   }
}
