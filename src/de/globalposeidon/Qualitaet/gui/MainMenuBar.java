package de.globalposeidon.Qualitaet.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.DataContainer;

// import de.globalposeidon.Qualitaet.model.DBWorker;

/**
 * This class contains the main menu.
 * @author Sebastian Lauber
 */

public class MainMenuBar extends JMenuBar {
   private static final long serialVersionUID = 3409407521701819128L;

   private DataContainer model;
   private MainTreeModel treeModel;

   public MainMenuBar(final JFrame parent, final DataContainer model, final MainTreeModel tree) {

      setModel(model);
      setTreeModel(tree);

      final JMenu file = new JMenu(Strings.FILE);
      add(file);

      final JMenuItem close = new JMenuItem(Strings.CLOSE);
      close.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent e) {
            System.exit(0);
         }
      });
      file.add(close);

      final JMenu help = new JMenu(Strings.HELP);
      add(help);

      final JMenuItem about = new JMenuItem(Strings.ABOUT);
      about.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            new AboutWindow(parent);
         }
      });
      help.add(about);

      final JMenuItem faq = new JMenuItem(Strings.FAQ);
      faq.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            new FAQWindow(parent);
         }
      });
      help.add(faq);
   }

   public final MainTreeModel getTreeModel() {
      return treeModel;
   }

   public final void setTreeModel(final MainTreeModel treeModel) {
      this.treeModel = treeModel;
   }

   public final DataContainer getModel() {
      return model;
   }

   public final void setModel(final DataContainer model) {
      this.model = model;
   }
}
