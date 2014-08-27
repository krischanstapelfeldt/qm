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

import de.globalposeidon.Qualitaet.Ints;
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

   static final JTextField tfMeterId = new JTextField();
  static final JTextField tfReadingVal = new JTextField();
  static final JTextField tfPerson = new JTextField();

   // declare Buttons
   private final JButton btnSave = new JButton(Strings.SAVE);
   private final JButton btnSearch = new JButton(Strings.SEARCH);

   // declare Radiobuttons
   static  final JRadioButton rdbtnUnsorted = new JRadioButton(Strings.UNSORTED, true);
   static final JRadioButton rdbtnRented = new JRadioButton(Strings.RENTED, false);
   static final JRadioButton rdbtnUnrented = new JRadioButton(Strings.UNRENTED, false);


   // declare Separator
   private final JSeparator separatorLeft = new JSeparator();
   private final JSeparator separatorRight = new JSeparator();

   // create Panel
   public FunctionPanel() {
      GridBagLayout gridBagLayout = new GridBagLayout();
      setLayout(gridBagLayout);

      GridBagConstraints gbcLblMeterSearch = new GridBagConstraints();
      gbcLblMeterSearch.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblMeterSearch.gridx = Strings.ONE;
      gbcLblMeterSearch.gridy = Strings.ONE;
      add(lblMeterSearch, gbcLblMeterSearch);

      GridBagConstraints gbcLblMeterId = new GridBagConstraints();
      gbcLblMeterId.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblMeterId.gridx = Strings.ZERO;
      gbcLblMeterId.gridy = Strings.TWO;
      add(lblMeterId, gbcLblMeterId);

      GridBagConstraints gbcLblMakeReading = new GridBagConstraints();
      gbcLblMakeReading.insets = new Insets(Strings.ZERO,Strings.ZERO,Strings.FIVE,Strings.FIVE);
      gbcLblMakeReading.gridx = Strings.SIX;
      gbcLblMakeReading.gridy = Strings.ONE;
      add(lblMakeReading, gbcLblMakeReading);

      GridBagConstraints gbcLblReadVal = new GridBagConstraints();
      gbcLblReadVal.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblReadVal.gridx = Strings.FIVE;
      gbcLblReadVal.gridy = Strings.TWO;
      add(lblReadVal, gbcLblReadVal);

      GridBagConstraints gbcLblReadPers = new GridBagConstraints();
      gbcLblReadPers.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblReadPers.gridx = Strings.FIVE;
      gbcLblReadPers.gridy = Strings.THREE;
      add(lblReadPers, gbcLblReadPers);

      GridBagConstraints gbcTfMeterId = new GridBagConstraints();
      gbcTfMeterId.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfMeterId.gridx = Strings.ONE;
      gbcTfMeterId.gridy = Strings.TWO;
      add(tfMeterId, gbcTfMeterId);
      tfMeterId.setColumns(10);

      separatorLeft.setOrientation(SwingConstants.VERTICAL);
      separatorLeft.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbcSeparatorLeft = new GridBagConstraints();
      gbcSeparatorLeft.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorLeft.gridheight = Strings.SIX;
      gbcSeparatorLeft.insets = new Insets(Strings.ZERO, Strings.THIRTY, Strings.ZERO, Strings.THIRTY);
      gbcSeparatorLeft.gridx = Strings.THREE;
      gbcSeparatorLeft.gridy = Strings.ZERO;
      add(separatorLeft, gbcSeparatorLeft);

      GridBagConstraints gbcLblSort = new GridBagConstraints();
      gbcLblSort.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblSort.gridx = Strings.TEN;
      gbcLblSort.gridy = Strings.ONE;
      add(lblSort, gbcLblSort);

      GridBagConstraints gbcTfReadingVal = new GridBagConstraints();
      gbcTfReadingVal.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfReadingVal.gridx = Strings.SIX;
      gbcTfReadingVal.gridy = Strings.TWO;
      add(tfReadingVal, gbcTfReadingVal);
      tfReadingVal.setColumns(10);

      GridBagConstraints gbcTfPerson = new GridBagConstraints();
      gbcTfPerson.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfPerson.gridx = Strings.SIX;
      gbcTfPerson.gridy = Strings.THREE;
      add(tfPerson, gbcTfPerson);
      tfPerson.setColumns(10);

      separatorRight.setOrientation(SwingConstants.VERTICAL);
      separatorRight.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbcSeparatorRight = new GridBagConstraints();
      gbcSeparatorRight.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorRight.gridheight = Strings.SIX;
      gbcSeparatorRight.insets = new Insets(Strings.ZERO, Strings.THIRTY, Strings.ZERO, Strings.THIRTY);
      gbcSeparatorRight.gridx = Strings.EIGHT;
      gbcSeparatorRight.gridy = Strings.ZERO;
      add(separatorRight, gbcSeparatorRight);

      GridBagConstraints gbcRdbtnUnsorted = new GridBagConstraints();
      gbcRdbtnUnsorted.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnUnsorted.gridx = Strings.TEN;
      gbcRdbtnUnsorted.gridy = Strings.TWO;
      add(rdbtnUnsorted, gbcRdbtnUnsorted);

      GridBagConstraints gbcRdbtnRented = new GridBagConstraints();
      gbcRdbtnRented.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnRented.gridx = Strings.TEN;
      gbcRdbtnRented.gridy = Strings.THREE;
      add(rdbtnRented, gbcRdbtnRented);

      GridBagConstraints gbcRdbtnUnrented = new GridBagConstraints();
      gbcRdbtnUnrented.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnUnrented.gridx = Strings.TEN;
      gbcRdbtnUnrented.gridy = Strings.FOUR;
      add(rdbtnUnrented, gbcRdbtnUnrented);

      GridBagConstraints gbcBtnSave = new GridBagConstraints();
      gbcBtnSave.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.ZERO, Strings.FIVE);
      gbcBtnSave.gridx = Strings.SIX;
      gbcBtnSave.gridy = Strings.FIVE;
      add(btnSave, gbcBtnSave);

      GridBagConstraints gbcBtnSearch = new GridBagConstraints();
      gbcBtnSearch.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.ZERO, Strings.FIVE);
      gbcBtnSearch.gridx = Strings.ONE;
      gbcBtnSearch.gridy = Strings.FIVE;
      add(btnSearch, gbcBtnSearch);

   }

}
