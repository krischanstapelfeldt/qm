package de.globalposeidon.Qualitaet.gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.globalposeidon.Qualitaet.Strings;

// import de.globalposeidon.Qualitaet.model.DBWorker;

/**
 * This class contains the main menu.
 * @author Sebastian Lauber
 */

public class MainMenuBar extends JMenuBar {
   private static final long serialVersionUID = 3409407521701819128L;

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

   public MainMenuBar(final JFrame parent) {

      final JMenu file = new JMenu(Strings.FILE);
      add(file);

      final JMenuItem close = new JMenuItem(Strings.CLOSE);
      close.addActionListener(new ActionListener() {
         // TODO replace force exit
         @Override
         public void actionPerformed(final ActionEvent e) {
            System.exit(0);
         }
      });
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
}
