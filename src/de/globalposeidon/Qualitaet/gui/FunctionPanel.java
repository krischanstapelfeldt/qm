package de.globalposeidon.Qualitaet.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.MeterReader;
import de.globalposeidon.Qualitaet.model.ReadingInfo;

public class FunctionPanel extends JPanel {
   private final Logger logger = LoggerFactory.getLogger(FunctionPanel.class);
   private static final long serialVersionUID = 5869251984510316018L;
   // declare Labels
   private final JLabel lblMeterId = new JLabel(Strings.METERID);
   private final JLabel lblMeterSearch = new JLabel(Strings.METERSEARCH);
   private final JLabel lblReadVal = new JLabel(Strings.READINGVALUE);
   private final JLabel lblReadPers = new JLabel(Strings.READINGPERSON);
   private final JLabel lblMakeReading = new JLabel(Strings.MAKEREADING);
   private final JLabel lblReadInfo = new JLabel(Strings.READINGINFO);

   // declare TextField
   private final JTextField tfMeterId = new JTextField();
   private final JTextField tfReadingVal = new JTextField();

   // declare Buttons
   private final JButton btnSave = new JButton(Strings.SAVE);
   private final JButton btnSearch = new JButton(Strings.SEARCH);

   // declare Separator
   private final JSeparator separatorLeft = new JSeparator();

   // set Combobox

   private final JComboBox<?> cbPerson;
   private final JComboBox<?> cbReadInfo;

   /**
    * Konstruktor.
    * @param parent
    *           parent.
    */
   @SuppressWarnings({"unchecked", "rawtypes"})
   public FunctionPanel(final MainWindow parent) {
      final GridBagLayout gridBagLayout = new GridBagLayout();
      setLayout(gridBagLayout);

      cbPerson = new JComboBox(MeterReader.values());
      cbReadInfo = new JComboBox(ReadingInfo.values());

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

      final GridBagConstraints gbcTfReadingVal = new GridBagConstraints();
      gbcTfReadingVal.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfReadingVal.gridx = Strings.SIX;
      gbcTfReadingVal.gridy = Strings.TWO;
      add(getTfReadingVal(), gbcTfReadingVal);
      getTfReadingVal().setColumns(Strings.TEN);

      final GridBagConstraints gbccbPerson = new GridBagConstraints();
      gbccbPerson.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbccbPerson.gridx = Strings.SIX;
      gbccbPerson.gridy = Strings.THREE;
      add(getCbPerson(), gbccbPerson);

      final GridBagConstraints gbcTfReadingInfo = new GridBagConstraints();
      gbcTfReadingInfo.insets = new Insets(Strings.TEN, Strings.ZERO, Strings.FIVE, Strings.FIVE);
      gbcTfReadingInfo.gridx = Strings.SIX;
      gbcTfReadingInfo.gridy = Strings.FOUR;
      add(getCbReadingInfo(), gbcTfReadingInfo);

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
            if (!tfMeterId.getText().equals("")) {
               parent.findMeter(tfMeterId.getText());
            }
         }
      });

      btnSave.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            MeterReader tmpMr = null;
            ReadingInfo tmpP = null;
            if (tfReadingVal.getText().equals("")) {
               tfReadingVal.requestFocus();
            } else {
               if (cbPerson.getSelectedIndex() == 0) {
                  tmpMr = MeterReader.JANITOR;
                  logger.debug("janitor selected");
               } else if (cbPerson.getSelectedIndex() == 1) {
                  tmpMr = MeterReader.RENTER;
                  logger.debug("renter selected");
               } else if (cbPerson.getSelectedIndex() == 2) {
                  tmpMr = MeterReader.ENERGYPROVIDER;
                  logger.debug("energy selected");
               }

               if (cbReadInfo.getSelectedIndex() == 0) {
                  tmpP = ReadingInfo.READING;
               } else if (cbReadInfo.getSelectedIndex() == 1) {
                  tmpP = ReadingInfo.ESTIMATION;
               }

               parent.selectedMeter().setCurrentValue(Integer.parseInt(tfReadingVal.getText()));
               parent.selectedMeter().makeReading(new Date(), tmpMr, tmpP);
               tfReadingVal.setText("");
            }
         }
      });
   }

   public final JComboBox<?> getCbReadingInfo() {
      return cbReadInfo;
   }

   public final JComboBox<?> getCbPerson() {
      return cbPerson;
   }

   public final JTextField getTfReadingVal() {
      return tfReadingVal;
   }
}
