package de.globalposeidon.Qualitaet.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.globalposeidon.Qualitaet.Strings;

public class FunctionPanel extends JPanel {

   private static final long serialVersionUID = 5869251984510316018L;
   // declare Labels
   private final JLabel lblMeterId = new JLabel(Strings.METERID);
   private final JLabel lblMeterSearch = new JLabel(Strings.METERSEARCH);
   private final JLabel lblReadVal = new JLabel(Strings.READINGVALUE);
   private final JLabel lblReadPers = new JLabel(Strings.READINGPERSON);
   private final JLabel lblSort = new JLabel(Strings.SORT);
   private final JLabel lblMakeReading = new JLabel(Strings.MAKEREADING);
   private final JLabel lblReadInfo = new JLabel(Strings.READINGINFO);

   // declare TextField
   private final JTextField tfMeterId = new JTextField();
   private final JTextField tfReadingVal = new JTextField();
   private final JTextField tfPerson = new JTextField();
   private final JTextField tfReadingInfo = new JTextField();

   // declare Buttons
   private final JButton btnSave = new JButton(Strings.SAVE);
   private final JButton btnSearch = new JButton(Strings.SEARCH);

   // declare Radiobuttons
   private final JRadioButton rdbtnUnsorted = new JRadioButton(Strings.UNSORTED, true);
   private final JRadioButton rdbtnRented = new JRadioButton(Strings.RENTED, false);
   private final JRadioButton rdbtnUnrented = new JRadioButton(Strings.UNRENTED, false);

   // declare Separator
   private final JSeparator separatorLeft = new JSeparator();
   private final JSeparator separatorRight = new JSeparator();

   // create Panel
   public FunctionPanel(final JFrame parent) {
      final GridBagLayout gridBagLayout = new GridBagLayout();
      setLayout(gridBagLayout);

      final GridBagConstraints gbcLblMeterSearch = new GridBagConstraints();
      gbcLblMeterSearch.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblMeterSearch.gridx = Strings.ONE;
      gbcLblMeterSearch.gridy = Strings.ONE;
      add(lblMeterSearch, gbcLblMeterSearch);

      final GridBagConstraints gbcLblMeterId = new GridBagConstraints();
      gbcLblMeterId.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblMeterId.gridx = Strings.ZERO;
      gbcLblMeterId.gridy = Strings.TWO;
      add(lblMeterId, gbcLblMeterId);

      final GridBagConstraints gbcLblMakeReading = new GridBagConstraints();
      gbcLblMakeReading.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblMakeReading.gridx = Strings.SIX;
      gbcLblMakeReading.gridy = Strings.ONE;
      add(lblMakeReading, gbcLblMakeReading);

      final GridBagConstraints gbcLblReadVal = new GridBagConstraints();
      gbcLblReadVal.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblReadVal.gridx = Strings.FIVE;
      gbcLblReadVal.gridy = Strings.TWO;
      add(lblReadVal, gbcLblReadVal);

      final GridBagConstraints gbcLblReadPers = new GridBagConstraints();
      gbcLblReadPers.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblReadPers.gridx = Strings.FIVE;
      gbcLblReadPers.gridy = Strings.THREE;
      add(lblReadPers, gbcLblReadPers);

      final GridBagConstraints gbcLblReadInfo = new GridBagConstraints();
      gbcLblReadInfo.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblReadInfo.gridx = Strings.FIVE;
      gbcLblReadInfo.gridy = Strings.FOUR;
      add(lblReadInfo, gbcLblReadInfo);

      final GridBagConstraints gbcTfMeterId = new GridBagConstraints();
      gbcTfMeterId.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfMeterId.gridx = Strings.ONE;
      gbcTfMeterId.gridy = Strings.TWO;
      add(tfMeterId, gbcTfMeterId);
      tfMeterId.setColumns(Strings.TEN);

      separatorLeft.setOrientation(SwingConstants.VERTICAL);
      separatorLeft.setForeground(Color.DARK_GRAY);
      final GridBagConstraints gbcSeparatorLeft = new GridBagConstraints();
      gbcSeparatorLeft.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorLeft.gridheight = Strings.SIX;
      gbcSeparatorLeft.insets = new Insets(Strings.ZERO, Strings.THIRTY, Strings.ZERO, Strings.THIRTY);
      gbcSeparatorLeft.gridx = Strings.THREE;
      gbcSeparatorLeft.gridy = Strings.ZERO;
      add(separatorLeft, gbcSeparatorLeft);

      final GridBagConstraints gbcLblSort = new GridBagConstraints();
      gbcLblSort.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcLblSort.gridx = Strings.TEN;
      gbcLblSort.gridy = Strings.ONE;
      add(lblSort, gbcLblSort);

      final GridBagConstraints gbcTfReadingVal = new GridBagConstraints();
      gbcTfReadingVal.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfReadingVal.gridx = Strings.SIX;
      gbcTfReadingVal.gridy = Strings.TWO;
      add(getTfReadingVal(), gbcTfReadingVal);
      getTfReadingVal().setColumns(Strings.TEN);

      final GridBagConstraints gbcTfPerson = new GridBagConstraints();
      gbcTfPerson.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfPerson.gridx = Strings.SIX;
      gbcTfPerson.gridy = Strings.THREE;
      add(getTfPerson(), gbcTfPerson);
      getTfPerson().setColumns(Strings.TEN);

      final GridBagConstraints gbcTfReadingInfo = new GridBagConstraints();
      gbcTfReadingInfo.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfReadingInfo.gridx = Strings.SIX;
      gbcTfReadingInfo.gridy = Strings.FOUR;
      add(getTfReadingInfo(), gbcTfReadingInfo);
      getTfReadingInfo().setColumns(Strings.TEN);

      separatorRight.setOrientation(SwingConstants.VERTICAL);
      separatorRight.setForeground(Color.DARK_GRAY);
      final GridBagConstraints gbcSeparatorRight = new GridBagConstraints();
      gbcSeparatorRight.fill = GridBagConstraints.VERTICAL;
      gbcSeparatorRight.gridheight = Strings.SIX;
      gbcSeparatorRight.insets = new Insets(Strings.ZERO, Strings.THIRTY, Strings.ZERO, Strings.THIRTY);
      gbcSeparatorRight.gridx = Strings.EIGHT;
      gbcSeparatorRight.gridy = Strings.ZERO;
      add(separatorRight, gbcSeparatorRight);

      final GridBagConstraints gbcRdbtnUnsorted = new GridBagConstraints();
      gbcRdbtnUnsorted.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnUnsorted.gridx = Strings.TEN;
      gbcRdbtnUnsorted.gridy = Strings.TWO;
      add(getRdbtnUnsorted(), gbcRdbtnUnsorted);

      final GridBagConstraints gbcRdbtnRented = new GridBagConstraints();
      gbcRdbtnRented.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnRented.gridx = Strings.TEN;
      gbcRdbtnRented.gridy = Strings.THREE;
      add(getRdbtnRented(), gbcRdbtnRented);

      final GridBagConstraints gbcRdbtnUnrented = new GridBagConstraints();
      gbcRdbtnUnrented.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.ZERO);
      gbcRdbtnUnrented.gridx = Strings.TEN;
      gbcRdbtnUnrented.gridy = Strings.FOUR;
      add(getRdbtnUnrented(), gbcRdbtnUnrented);

      final GridBagConstraints gbcBtnSave = new GridBagConstraints();
      gbcBtnSave.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.ZERO, Strings.FIVE);
      gbcBtnSave.gridx = Strings.SIX;
      gbcBtnSave.gridy = Strings.FIVE;
      add(btnSave, gbcBtnSave);

      final GridBagConstraints gbcBtnSearch = new GridBagConstraints();
      gbcBtnSearch.insets = new Insets(Strings.ZERO, Strings.ZERO, Strings.ZERO, Strings.FIVE);
      gbcBtnSearch.gridx = Strings.ONE;
      gbcBtnSearch.gridy = Strings.FIVE;
      add(btnSearch, gbcBtnSearch);

      btnSearch.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
         }
      });
   }

   public final JRadioButton getRdbtnUnrented() {
      return rdbtnUnrented;
   }

   public final JRadioButton getRdbtnRented() {
      return rdbtnRented;
   }

   public final JRadioButton getRdbtnUnsorted() {
      return rdbtnUnsorted;
   }

   public final JTextField getTfReadingInfo() {
      return tfReadingInfo;
   }

   public final JTextField getTfPerson() {
      return tfPerson;
   }

   public final JTextField getTfReadingVal() {
      return tfReadingVal;
   }
}
