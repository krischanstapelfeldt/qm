package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Apartment;

public class ApartmentPanel extends JPanel {

   private static final long serialVersionUID = 8794147005620814516L;

   public ApartmentPanel(final Apartment apartment) {

      // set window layout
      final JPanel pnlMain = new JPanel();

      setLayout(new BorderLayout());
      pnlMain.setLayout(new GridLayout(2, 0, 0, 2));

      // ui components
      final JPanel pnlHeader = new JPanel(new FlowLayout());
      final JLabel lblApartment = new JLabel("Apartment " + apartment.getID());
      // final JLabel lblMeter = new JLabel("|Meter: "
      // + apartment.getMeter(0));
      // final JLabel lblTenant = new JLabel("|Tenant: "
      // + apartment.getTenant(0));

      pnlHeader.add(lblApartment);
      // pnlHeader.add(lblMeter);
      // pnlHeader.add(lblTenant);

      // Initial JTable
      final JTable table = new JTable();
      final JTable table2 = new JTable();

      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      final JScrollPane scrollPane2 = new JScrollPane();

      scrollPane.setViewportView(table);
      scrollPane2.setViewportView(table2);

      pnlMain.add(scrollPane);
      pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);
   }
}
