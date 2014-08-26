package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.Entrance;

/**
 * AddEntranceWindow shows the user a window to either add a entrance to the
 * currently selected building with "OK" or to cancel the request with "Cancel"
 *
 * @author Timm Suhl
 */
public class AddEntranceWindow extends JDialog {

   private static final long serialVersionUID = 6200962634221693506L;

   public AddEntranceWindow(final Building building) {

      setTitle("add entrance");

      // ui components
      final JPanel contentPnl = new JPanel(new FlowLayout());
      final JLabel descriptionLbl = new JLabel("This will add a new entrance with a random ID to the building with ID: " + building.getID());
      contentPnl.add(descriptionLbl);

      final JPanel buttonPnl = new JPanel(new FlowLayout());
      final JButton saveBtn = new JButton(Strings.OK);
      saveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            addEntrance(building);
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

   private void addEntrance(final Building building) {
      building.addEntrance(new Entrance(building));
      dispose();
   }

}
