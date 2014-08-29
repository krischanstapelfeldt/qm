package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.EntranceTableModelBottom;
import de.globalposeidon.Qualitaet.model.EntranceTableModelTop;

public class EntrancePanel extends JPanel {

   private static final long serialVersionUID = -93700516008712524L;

   public EntrancePanel(final Entrance entrance) {

      // set window layout
      final JPanel pnlMain = new JPanel();

      setLayout(new BorderLayout());
      pnlMain.setLayout(new GridLayout(2, 0, 0, 2));

      // ui components
      final JPanel pnlHeader = new JPanel(new FlowLayout());
      final JLabel lblId = new JLabel("Entrance " + entrance.getID());

      pnlHeader.add(lblId);

      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      final JScrollPane scrollPane2 = new JScrollPane();

      scrollPane.getViewport().setBackground(Color.white);
      scrollPane2.getViewport().setBackground(Color.white);

      scrollPane.setViewportView(new JTable(new EntranceTableModelTop(entrance)));
      scrollPane2.setViewportView(new JTable(new EntranceTableModelBottom(entrance)));

      pnlMain.add(scrollPane);
      pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);
   }

}
