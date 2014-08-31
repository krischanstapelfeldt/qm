package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

/**
 * AddMeterWindow shows the user a window to either add a meter to the currently selected entrance OR apartment with "OK" or to cancel the
 * request with "Cancel".
 * @author Timm Suhl
 */
public class AddMeterWindow extends JDialog {

   private static final long serialVersionUID = -4549927043320246284L;
   private final Logger logger = LoggerFactory.getLogger(AddMeterWindow.class);

   public AddMeterWindow(final DataContainer container, final Object obj) {

      setTitle("add meter");

      // get object type
      final boolean isEntrance = (obj instanceof Entrance);
      // ui components
      final JPanel contentPnl = new JPanel(new FlowLayout());
      final JLabel descriptionLbl = isEntrance ? new JLabel("This will add a new meter to an entrance") : new JLabel(
            "This will add a new meter to an apartment");
      contentPnl.add(descriptionLbl);

      final JPanel buttonPnl = new JPanel(new FlowLayout());
      final JButton saveBtn = new JButton(Strings.OK);
      saveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            if (isEntrance) {
               addMeter(container.incMeterCnt(), (Entrance) obj);
            } else {
               addMeter(container.incMeterCnt(), (Apartment) obj);
            }
         }
      });
      final JButton cancelBtn = new JButton(Strings.CANCEL);
      cancelBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            dispose();
         }
      });
      buttonPnl.add(saveBtn);
      buttonPnl.add(cancelBtn);

      // layout manager
      setLayout(new BorderLayout());

      // add components
      this.add(buttonPnl, BorderLayout.SOUTH);
      this.add(contentPnl, BorderLayout.CENTER);

      // layout window
      pack();
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);
   }

   private void addMeter(final int id, final Entrance entrance) {
      logger.debug("try to add meter to entrance...");
      entrance.addMeter(new Meter(id, Metertype.GAS, entrance));
      dispose();
   }

   private void addMeter(final int id, final Apartment apartment) {
      logger.debug("try to add meter to apartment...");
      apartment.addMeter(new Meter(id, Metertype.GAS, apartment));
      dispose();
   }
}
