package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.globalposeidon.Qualitaet.model.Apartment;


public class ApartmentPanel extends JPanel {

   private static final long serialVersionUID = 8794147005620814516L;
   /**
    * 
    * @param apartment
    */
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

      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      scrollPane.getViewport().setBackground(Color.white);
      final JScrollPane scrollPane2 = new JScrollPane();
      scrollPane2.getViewport().setBackground(Color.white);
      
      ApartmentJTable jtable = new ApartmentJTable(apartment);
      scrollPane.setViewportView(jtable.getTblTop());
//      scrollPane2.setViewportView(ApartmentJTable.getTblBottom());

      pnlMain.add(scrollPane);
      pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);
   }
}
