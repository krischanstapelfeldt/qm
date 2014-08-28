package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Building;

public class BuildingPanel extends JPanel {

   private static final long serialVersionUID = -6703093984245263776L;

   public BuildingPanel(final Building building) {

      // set window layout
      final JPanel pnlMain = new JPanel();

      setLayout(new BorderLayout());
      pnlMain.setLayout(new GridLayout(2, 0, 0, 2));

      // ui components
      final JPanel pnlHeader = new JPanel(new FlowLayout());
      final JLabel lblBuilding = new JLabel("Building " + building.getID());
      final JLabel lblEntranceCount = new JLabel("|Entrances: " + building.entranceCount());
      final JLabel lblRenter = new JLabel("|Renter: " + building.getRenter());
      pnlHeader.add(lblBuilding);
      pnlHeader.add(lblEntranceCount);
      pnlHeader.add(lblRenter);

      // Initial JTable
      final JTable table = new JTable();
      final JTable table2 = new JTable();

      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      final JScrollPane scrollPane2 = new JScrollPane();

      scrollPane.setViewportView(BuildingJTable.getTblTop());
      scrollPane2.setViewportView(table2);

      pnlMain.add(scrollPane);
   //   pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);

   }

}
