package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import de.globalposeidon.Qualitaet.Strings;
import de.globalposeidon.Qualitaet.model.DataContainer;

// import de.globalposeidon.Qualitaet.model.DBWorker;

/**
 * This class contains the main menu.
 * @author Sebastian Lauber
 */

public class MainMenuBar extends JMenuBar {
   private static final long serialVersionUID = 3409407521701819128L;
   
   DataContainer model;
   MainTreeModel treeModel;

   private void openWebpage(final URI uri) {
      final Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
      if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
         try {
            desktop.browse(uri);
         } catch (final Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void openWebpage(final String urlString) {
      try {
         openWebpage(new URI(urlString));
      } catch (final URISyntaxException e) {
         e.printStackTrace();
      }
   }

   public MainMenuBar(final JFrame parent, DataContainer model, MainTreeModel tree) {
	   
	   this.model = model;
	   this.treeModel = tree;
	   
      final JMenu file = new JMenu(Strings.FILE);
      add(file);
      
      final JMenuItem saveContainer = new JMenuItem(Strings.SAVE);
      saveContainer.addActionListener(new ActionListener() {
         // TODO replace force exit
         @Override
         public void actionPerformed(final ActionEvent e) {
            saveCurrentContainer();
            final JFrame okFrame = new JFrame();
            okFrame.setLayout(new BorderLayout());
            okFrame.add(new JLabel("Daten gespeichert"), BorderLayout.NORTH);
            JButton okBtn = new JButton("OK");
            okBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    okFrame.dispose();
                 }
             });
            okFrame.add(okBtn, BorderLayout.CENTER);
            okFrame.pack();
            okFrame.setLocationRelativeTo(null);
            okFrame.show(true);
         }
      });
      final JMenuItem loadContainer = new JMenuItem("load");
      loadContainer.addActionListener(new ActionListener() {
         // TODO replace force exit
         @Override
         public void actionPerformed(final ActionEvent e) {
            readContainer();
         }
      });
      final JMenuItem close = new JMenuItem(Strings.CLOSE);
      close.addActionListener(new ActionListener() {
         // TODO replace force exit
         @Override
         public void actionPerformed(final ActionEvent e) {
            System.exit(0);
         }
      });
      file.add(saveContainer);
      file.add(loadContainer);
      file.add(close);

      final JMenu edit = new JMenu(Strings.EDIT);
      add(edit);

      final JMenuItem apartment = new JMenuItem(Strings.ADDAPARTMENT);
      edit.add(apartment);

      final JMenuItem building = new JMenuItem(Strings.ADDBUILDING);
      edit.add(building);

      final JMenuItem renter = new JMenuItem(Strings.ADDRENTER);
      edit.add(renter);

      final JMenu dev = new JMenu("Developer");
      add(dev);

      final JMenuItem jenkins = new JMenuItem(Strings.OPENJENKINS);
      jenkins.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            openWebpage("http://stapelfeldt.selfhost.eu:8080");
         }
      });
      dev.add(jenkins);

      final JMenuItem jUnitJenkins = new JMenuItem(Strings.OPENJUNITJENKINS);
      jUnitJenkins.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            openWebpage("http://stapelfeldt.selfhost.eu:8080/" + "job/Global%20Poseidon/ws/reports/junit/index.html");
         }
      });
      dev.add(jUnitJenkins);

      final JMenuItem jaCoCoJenkins = new JMenuItem(Strings.OPENJACOCOJENKINS);
      jaCoCoJenkins.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            openWebpage("http://stapelfeldt.selfhost.eu:8080/" + "job/Global%20Poseidon/ws/reports/jacoco/index.html");
         }
      });
      dev.add(jaCoCoJenkins);

      final JMenuItem mantis = new JMenuItem(Strings.OPENMANTIS);
      mantis.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            openWebpage("http://stapelfeldt.selfhost.eu/mantis/mantisbt-1.2.17/");
         }
      });
      dev.add(mantis);

      final JMenuItem testlink = new JMenuItem(Strings.OPENTESTLINK);
      testlink.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            openWebpage("http://stapelfeldt.selfhost.eu/testlink/testlink-1.9.10/");
         }
      });
      dev.add(testlink);

      final JMenuItem databaseTest = new JMenuItem("start database test");
      databaseTest.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(final ActionEvent e) {
            // new DBWorker("Testtest");
         }
      });
      dev.add(databaseTest);

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
   
   private void saveCurrentContainer() {
	   
	   String workingDir = System.getProperty("user.dir");
	   try {
        FileOutputStream fileOut =
        new FileOutputStream(workingDir+"\\container.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(model);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in" + workingDir+"\\container.ser");
	   }catch(IOException i) {
         i.printStackTrace();
	   }
   }
   // TODO not updating the view...
   private void readContainer() {
	   
	   String workingDir = System.getProperty("user.dir");
	   
	   try {
          FileInputStream fileIn = new FileInputStream(workingDir+"\\container.ser");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          model = (DataContainer) in.readObject();
          in.close();
          fileIn.close();
          treeModel.reload();
          System.out.println(workingDir+"\\container.ser");
       }catch(IOException i) {
    	  System.out.println("Some exception");
          i.printStackTrace();
          return;
       }catch(ClassNotFoundException c) {
          System.out.println("Container class not found");
          c.printStackTrace();
          return;
       }
   }
}
