package de.globalposeidon.Qualitaet.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import de.globalposeidon.Qualitaet.Strings;

public class FunctionPanel extends JPanel {

   private static final long serialVersionUID = 5869251984510316018L;
   // declare Labels
   private JLabel lblMeterId = new JLabel(Strings.METERID);
   private JLabel lblMeterSearch = new JLabel(Strings.METERSEARCH);
   private JLabel lblReadVal = new JLabel(Strings.READINGVALUE);
   private JLabel lblReadPers = new JLabel(Strings.READINGPERSON);
   private JLabel lblSort = new JLabel("Sort");
   private JLabel lblMakeReading = new JLabel(Strings.MAKEREADING);

   // declare TextField

   private final JTextField tfMeterId = new JTextField();
   private final JTextField tfReadingVal = new JTextField();
   private final JTextField tfPerson = new JTextField();

   // declare Buttons
   private final JButton btnSave = new JButton(Strings.SAVE);
   private final JButton btnSearch = new JButton(Strings.SEARCH);

   // declare Radiobuttons
   private final JRadioButton rdbtnUnsorted = new JRadioButton(Strings.UNSORTED);
   private final JRadioButton rdbtnRented = new JRadioButton(Strings.RENTED);
   private final JRadioButton rdbtnUnrented = new JRadioButton(Strings.UNRENTED);

   // declare ButtonGroup
   // TODO
   private final ButtonGroup rdGroup = new ButtonGroup();

   // add radiobuttons to a group
   // rdGroup.add(rdbtnUnsorted);
   // rdGroup.add(rdbtnRented);
   // rdGroup.add(rdbtnUnRented);

   // declare Separator
   private final JSeparator separatorLeft = new JSeparator();
   private final JSeparator separatorRight = new JSeparator();

   // create Panel
   public FunctionPanel() {
      GridBagLayout gridBagLayout = new GridBagLayout();
      setLayout(gridBagLayout);

      GridBagConstraints gbcLblMeterSearch = new GridBagConstraints();
      gbcLblMeterSearch.insets = new Insets(0, 0, 5, 5);
      gbcLblMeterSearch.gridx = 1;
      gbcLblMeterSearch.gridy = 1;
      add(lblMeterSearch, gbcLblMeterSearch);

      GridBagConstraints gbcLblMeterId = new GridBagConstraints();
      gbcLblMeterId.anchor = GridBagConstraints.WEST;
      gbcLblMeterId.insets = new Insets(0, 0, 5, 5);
      gbcLblMeterId.gridx = 0;
      gbcLblMeterId.gridy = 2;
      add(lblMeterId, gbcLblMeterId);

      GridBagConstraints gbcLblMakeReading = new GridBagConstraints();
      gbcLblMakeReading.insets = new Insets(0, 0, 5, 5);
      gbcLblMakeReading.gridx = 6;
      gbcLblMakeReading.gridy = 1;
      add(lblMakeReading, gbcLblMakeReading);

      GridBagConstraints gbcLblReadVal = new GridBagConstraints();
      gbcLblReadVal.insets = new Insets(0, 0, 5, 0);
      gbcLblReadVal.gridx = 5;
      gbcLblReadVal.gridy = 2;
      add(lblReadVal, gbcLblReadVal);

      GridBagConstraints gbcLblReadPers = new GridBagConstraints();
      gbcLblReadPers.insets = new Insets(0, 0, 5, 5);
      gbcLblReadPers.anchor = GridBagConstraints.EAST;
      gbcLblReadPers.gridx = 5;
      gbcLblReadPers.gridy = 3;
      add(lblReadPers, gbcLblReadPers);

      GridBagConstraints gbcTfMeterId = new GridBagConstraints();
      gbcTfMeterId.insets = new Insets(0, 0, 5, 5);
      gbcTfMeterId.anchor = GridBagConstraints.WEST;
      gbcTfMeterId.gridx = 1;
      gbcTfMeterId.gridy = 2;
      add(tfMeterId, gbcTfMeterId);
      tfMeterId.setColumns(10);

      separatorLeft.setOrientation(SwingConstants.VERTICAL);
      separatorLeft.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbcSeparatorLeft = new GridBagConstraints();
      gbcSeparatorLeft.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorLeft.gridheight = 6;
      gbcSeparatorLeft.insets = new Insets(0, 0, 0, 5);
      gbcSeparatorLeft.gridx = 3;
      gbcSeparatorLeft.gridy = 0;
      add(separatorLeft, gbcSeparatorLeft);

      GridBagConstraints gbcLblSort = new GridBagConstraints();
      // gbc_lblSort.anchor = GridBagConstraints.EAST;
      gbcLblSort.insets = new Insets(0, 0, 5, 5);
      gbcLblSort.gridx = 10;
      gbcLblSort.gridy = 1;
      add(lblSort, gbcLblSort);

      GridBagConstraints gbcTfReadingVal = new GridBagConstraints();
      gbcTfReadingVal.insets = new Insets(0, 0, 5, 5);
      gbcTfReadingVal.fill = GridBagConstraints.HORIZONTAL;
      gbcTfReadingVal.gridx = 6;
      gbcTfReadingVal.gridy = 2;
      add(tfReadingVal, gbcTfReadingVal);
      tfReadingVal.setColumns(10);

      GridBagConstraints gbcTfPerson = new GridBagConstraints();
      gbcTfPerson.insets = new Insets(0, 0, 5, 5);
      gbcTfPerson.fill = GridBagConstraints.HORIZONTAL;
      gbcTfPerson.gridx = 6;
      gbcTfPerson.gridy = 3;
      add(tfPerson, gbcTfPerson);
      tfPerson.setColumns(10);

      separatorRight.setOrientation(SwingConstants.VERTICAL);
      separatorRight.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbcSeparatorRight = new GridBagConstraints();
      gbcSeparatorRight.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorRight.gridheight = 6;
      gbcSeparatorRight.insets = new Insets(0, 0, 0, 5);
      gbcSeparatorRight.gridx = 8;
      gbcSeparatorRight.gridy = 0;
      add(separatorRight, gbcSeparatorRight);

      GridBagConstraints gbcRdbtnUnsorted = new GridBagConstraints();
      gbcRdbtnUnsorted.insets = new Insets(0, 0, 5, 0);
      gbcRdbtnUnsorted.gridx = 10;
      gbcRdbtnUnsorted.gridy = 2;
      add(rdbtnUnsorted, gbcRdbtnUnsorted);

      GridBagConstraints gbcRdbtnRented = new GridBagConstraints();
      gbcRdbtnRented.insets = new Insets(0, 0, 5, 0);
      gbcRdbtnRented.gridx = 10;
      gbcRdbtnRented.gridy = 3;
      add(rdbtnRented, gbcRdbtnRented);

      GridBagConstraints gbcRdbtnUnrented = new GridBagConstraints();
      gbcRdbtnUnrented.insets = new Insets(0, 0, 5, 0);
      gbcRdbtnUnrented.gridx = 10;
      gbcRdbtnUnrented.gridy = 4;
      add(rdbtnUnrented, gbcRdbtnUnrented);

      GridBagConstraints gbcBtnSave = new GridBagConstraints();
      gbcBtnSave.insets = new Insets(0, 0, 0, 5);
      gbcBtnSave.gridx = 6;
      gbcBtnSave.gridy = 5;
      add(btnSave, gbcBtnSave);

      GridBagConstraints gbcBtnSearch = new GridBagConstraints();
      gbcBtnSearch.insets = new Insets(0, 0, 0, 5);
      gbcBtnSearch.gridx = 1;
      gbcBtnSearch.gridy = 5;
      add(btnSearch, gbcBtnSearch);

   }

}
