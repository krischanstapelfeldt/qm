package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.globalposeidon.Qualitaet.model.Meter;

public class MeterPanel extends JPanel {

   private static final long serialVersionUID = 5663133647111763942L;

   public MeterPanel(final Meter meter) {

      // set window layout
      final JPanel pnlMain = new JPanel();

      setLayout(new BorderLayout());
      pnlMain.setLayout(new GridLayout(2, 0, 0, 2));

      // ui components
      final JPanel pnlHeader = new JPanel(new FlowLayout());
      final JLabel lblId = new JLabel("Meter " + meter.getID());
      final JLabel lblMeterType = new JLabel("|Metertype: " + meter.getType());
      final JLabel lblCurValue = new JLabel("|Current Value: " + meter.getCurrentValue());
      final JLabel lblYearValue = new JLabel("|Year Value: " + meter.getCurrentValue());
      final JLabel lblLastRead = new JLabel("|Last Read: " + meter.getLastRead());

      pnlHeader.add(lblId);
      pnlHeader.add(lblMeterType);
      pnlHeader.add(lblCurValue);
      pnlHeader.add(lblYearValue);
      pnlHeader.add(lblLastRead);

      // Initial JTable
      final JTable table = new JTable();
      final JTable table2 = new JTable();

      // Initial Scrollpane
      final JScrollPane scrollPane = new JScrollPane();
      scrollPane.getViewport().setBackground(Color.white);
      final JScrollPane scrollPane2 = new JScrollPane();
      scrollPane2.getViewport().setBackground(Color.white);

      scrollPane.setViewportView(table);
      scrollPane2.setViewportView(table2);

      pnlMain.add(scrollPane);
      pnlMain.add(scrollPane2);

      add(pnlHeader, BorderLayout.NORTH);
      add(pnlMain, BorderLayout.CENTER);
   }
}
