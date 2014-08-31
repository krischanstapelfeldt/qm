package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelBottom;
import de.globalposeidon.Qualitaet.model.ApartmentTableModelTop;

public class ApartmentPanel extends JPanel {

   private static final long serialVersionUID = 8794147005620814516L;
   private ApartmentTableModelTop topModel;
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
      final JButton btnDelete = new JButton(Strings.DELWSPACE + Strings.TENANT);

      pnlHeader.add(lblApartment);
      pnlHeader.add(btnDelete);
      
      btnDelete.setEnabled(false);
      topModel = new ApartmentTableModelTop(apartment);
      final JTable tableTop = new JTable(topModel);
      tableTop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tableTop.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
    	  public void valueChanged(ListSelectionEvent e) {
    		  if (tableTop.getSelectedRow() >= 0) {
    			  btnDelete.setEnabled(true);
    		  } else {
    			  btnDelete.setEnabled(false);
    		  }
    	  }
      });      
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
   
      btnDelete.addActionListener(new ActionListener(){
    	  @Override
    	  public void actionPerformed(final ActionEvent e){
    		  topModel.deleteSelectedApartment(tableTop.getSelectedRow());
    		  tableTop.revalidate();
    		  new InfoDialog("INFO", "Mieter geloescht!");
    	  }
      });
}  

}