package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

public class ApartmentPanel extends JPanel {

   private static final long serialVersionUID = 8794147005620814516L;

   /**
    * @param apartment
    *           Apartment to view in ApartmentPanel.
    */
  
   public ApartmentPanel(final Apartment apartment) {
     
      
      // set window layout
      final JPanel pnlMain = new JPanel();

      setLayout(new BorderLayout());
      pnlMain.setLayout(new GridLayout(2, 0, 0, 2));

      // ui components
      final JPanel pnlHeader = new JPanel(new FlowLayout());
      final JLabel lblApartment = new JLabel("Apartment " + apartment.getID());
      final JButton btnDelete = new JButton(Strings.DELWSPACE);
      
      // final JLabel lblMeter = new JLabel("|Meter: "
      // + apartment.getMeter(0));
      // final JLabel lblTenant = new JLabel("|Tenant: "
      // + apartment.getTenant(0));

      pnlHeader.add(lblApartment);
      pnlHeader.add(btnDelete);
      // pnlHeader.add(lblMeter);
      // pnlHeader.add(lblTenant);
      JTable tableTop = new JTable(new ApartmentTableModelTop(apartment));
      
      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      scrollPane.getViewport().setBackground(Color.white);
      final JScrollPane scrollPane2 = new JScrollPane();
      scrollPane2.getViewport().setBackground(Color.white);
      scrollPane.setViewportView(tableTop);
      scrollPane2.setViewportView(new JTable(new ApartmentTableModelBottom(apartment)));
      tableTop.setRowSelectionAllowed( true );
      
      pnlMain.add(scrollPane);
      pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);
  
   }
//   btnDelete.addActionListener(new ActionListener(){
//      @Override
//      public void actionPerformed(final ActionEvent e){
//         ApartmentTableModelTop.removeElement(tenant);
//      }
//
// 
//   });
      

}