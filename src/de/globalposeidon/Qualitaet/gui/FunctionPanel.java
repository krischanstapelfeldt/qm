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

   /**
	 * 
	 */
   private static final long serialVersionUID = 5869251984510316018L;
   // declare Labels
   JLabel lblMeterId = new JLabel(Strings.METERID);
   JLabel lblMeterSearch = new JLabel(Strings.METERSEARCH);
   JLabel lblReadVal = new JLabel(Strings.READINGVALUE);
   JLabel lblReadPers = new JLabel(Strings.READINGPERSON);
   JLabel lblSort = new JLabel("Sort");
   JLabel lblMakeReading = new JLabel(Strings.MAKEREADING);

   // declare TextField

   final JTextField tfMeterId = new JTextField();
   final JTextField tfReadingVal = new JTextField();
   final JTextField tfPerson = new JTextField();

   // declare Buttons
   final JButton btnSave = new JButton(Strings.SAVE);
   final JButton btnSearch = new JButton(Strings.SEARCH);

   // declare Radiobuttons
   final JRadioButton rdbtnUnsorted = new JRadioButton(Strings.UNSORTED);
   final JRadioButton rdbtnRented = new JRadioButton(Strings.RENTED);
   final JRadioButton rdbtnUnrented = new JRadioButton(Strings.UNRENTED);

   // declare ButtonGroup
   final ButtonGroup rdGroup = new ButtonGroup();

   // add radiobuttons to a group
   // rdGroup.add(rdbtnUnsorted);
   // rdGroup.add(rdbtnRented);
   // rdGroup.add(rdbtnUnRented);

   // declare Separator
   final JSeparator separatorLeft = new JSeparator();
   final JSeparator separatorRight = new JSeparator();

   // create Panel
   public FunctionPanel() {
      GridBagLayout gridBagLayout = new GridBagLayout();
      setLayout(gridBagLayout);

      GridBagConstraints gbc_lblMeterSearch = new GridBagConstraints();
      gbc_lblMeterSearch.insets = new Insets(0, 0, 5, 5);
      gbc_lblMeterSearch.gridx = 1;
      gbc_lblMeterSearch.gridy = 1;
      add(lblMeterSearch, gbc_lblMeterSearch);

      GridBagConstraints gbc_lblMeterId = new GridBagConstraints();
      gbc_lblMeterId.anchor = GridBagConstraints.WEST;
      gbc_lblMeterId.insets = new Insets(0, 0, 5, 5);
      gbc_lblMeterId.gridx = 0;
      gbc_lblMeterId.gridy = 2;
      add(lblMeterId, gbc_lblMeterId);

      GridBagConstraints gbc_lblMakeReading = new GridBagConstraints();
      gbc_lblMakeReading.insets = new Insets(0, 0, 5, 5);
      gbc_lblMakeReading.gridx = 6;
      gbc_lblMakeReading.gridy = 1;
      add(lblMakeReading, gbc_lblMakeReading);

      GridBagConstraints gbc_lblReadVal = new GridBagConstraints();
      gbc_lblReadVal.insets = new Insets(0, 0, 5, 0);
      gbc_lblReadVal.gridx = 5;
      gbc_lblReadVal.gridy = 2;
      add(lblReadVal, gbc_lblReadVal);

      GridBagConstraints gbc_lblReadPers = new GridBagConstraints();
      gbc_lblReadPers.insets = new Insets(0, 0, 5, 5);
      gbc_lblReadPers.anchor = GridBagConstraints.EAST;
      gbc_lblReadPers.gridx = 5;
      gbc_lblReadPers.gridy = 3;
      add(lblReadPers, gbc_lblReadPers);

      GridBagConstraints gbc_tfMeterId = new GridBagConstraints();
      gbc_tfMeterId.insets = new Insets(0, 0, 5, 5);
      gbc_tfMeterId.anchor = GridBagConstraints.WEST;
      gbc_tfMeterId.gridx = 1;
      gbc_tfMeterId.gridy = 2;
      add(tfMeterId, gbc_tfMeterId);
      tfMeterId.setColumns(10);

      separatorLeft.setOrientation(SwingConstants.VERTICAL);
      separatorLeft.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbc_separatorLeft = new GridBagConstraints();
      gbc_separatorLeft.fill = GridBagConstraints.VERTICAL;
      gbc_separatorLeft.gridheight = 6;
      gbc_separatorLeft.insets = new Insets(0, 0, 0, 5);
      gbc_separatorLeft.gridx = 3;
      gbc_separatorLeft.gridy = 0;
      add(separatorLeft, gbc_separatorLeft);

      GridBagConstraints gbc_lblSort = new GridBagConstraints();
      // gbc_lblSort.anchor = GridBagConstraints.EAST;
      gbc_lblSort.insets = new Insets(0, 0, 5, 5);
      gbc_lblSort.gridx = 10;
      gbc_lblSort.gridy = 1;
      add(lblSort, gbc_lblSort);

      GridBagConstraints gbc_tfReadingVal = new GridBagConstraints();
      gbc_tfReadingVal.insets = new Insets(0, 0, 5, 5);
      gbc_tfReadingVal.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfReadingVal.gridx = 6;
      gbc_tfReadingVal.gridy = 2;
      add(tfReadingVal, gbc_tfReadingVal);
      tfReadingVal.setColumns(10);

      GridBagConstraints gbc_tfPerson = new GridBagConstraints();
      gbc_tfPerson.insets = new Insets(0, 0, 5, 5);
      gbc_tfPerson.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfPerson.gridx = 6;
      gbc_tfPerson.gridy = 3;
      add(tfPerson, gbc_tfPerson);
      tfPerson.setColumns(10);

      separatorRight.setOrientation(SwingConstants.VERTICAL);
      separatorRight.setForeground(Color.DARK_GRAY);
      GridBagConstraints gbc_separatorRight = new GridBagConstraints();
      gbc_separatorRight.fill = GridBagConstraints.VERTICAL;
      gbc_separatorRight.gridheight = 6;
      gbc_separatorRight.insets = new Insets(0, 0, 0, 5);
      gbc_separatorRight.gridx = 8;
      gbc_separatorRight.gridy = 0;
      add(separatorRight, gbc_separatorRight);

      GridBagConstraints gbc_rdbtnUnsorted = new GridBagConstraints();
      gbc_rdbtnUnsorted.insets = new Insets(0, 0, 5, 0);
      gbc_rdbtnUnsorted.gridx = 10;
      gbc_rdbtnUnsorted.gridy = 2;
      add(rdbtnUnsorted, gbc_rdbtnUnsorted);

      GridBagConstraints gbc_rdbtnRented = new GridBagConstraints();
      gbc_rdbtnRented.insets = new Insets(0, 0, 5, 0);
      gbc_rdbtnRented.gridx = 10;
      gbc_rdbtnRented.gridy = 3;
      add(rdbtnRented, gbc_rdbtnRented);

      GridBagConstraints gbc_rdbtnUnrented = new GridBagConstraints();
      gbc_rdbtnUnrented.insets = new Insets(0, 0, 5, 0);
      gbc_rdbtnUnrented.gridx = 10;
      gbc_rdbtnUnrented.gridy = 4;
      add(rdbtnUnrented, gbc_rdbtnUnrented);

      GridBagConstraints gbc_btnSave = new GridBagConstraints();
      gbc_btnSave.insets = new Insets(0, 0, 0, 5);
      gbc_btnSave.gridx = 6;
      gbc_btnSave.gridy = 5;
      add(btnSave, gbc_btnSave);

      GridBagConstraints gbc_btnSearch = new GridBagConstraints();
      gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
      gbc_btnSearch.gridx = 1;
      gbc_btnSearch.gridy = 5;
      add(btnSearch, gbc_btnSearch);

   }

}
