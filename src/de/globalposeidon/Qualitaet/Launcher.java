package de.globalposeidon.Qualitaet;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.MeterReader;
import de.globalposeidon.Qualitaet.model.Metertype;
import de.globalposeidon.Qualitaet.model.ReadingInfo;
import de.globalposeidon.Qualitaet.model.Renter;
import de.globalposeidon.Qualitaet.model.Tenant;

/**
 * This class launches the GUI and datamodel.
 * @author Sebastian Lauber
 */

public class Launcher {
   /**
    * prevents calls from subclass.
    */
   protected Launcher() {
      throw new UnsupportedOperationException();
   }

   /**
    * Mainmethod, fires up everything.
    * @param args
    *           No args specified
    */
   public static final void main(final String[] args) {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
            	DataContainer container;
            	
//            	String workingDir = System.getProperty("user.dir");
//         	   // Remove if load in MainMenuBar is working correctly
//         	   try {
//                   FileInputStream fileIn = new FileInputStream(workingDir+"\\container.ser");
//                   ObjectInputStream in = new ObjectInputStream(fileIn);
//                   container = (DataContainer) in.readObject();
//                   in.close();
//                   fileIn.close();
//                   System.out.println(workingDir+"\\container.ser");
//                }catch(IOException i) {
//             	  System.out.println("Some exception");
//             	  container = createRandomModel();
//                   i.printStackTrace();
//                   return;
//                }catch(ClassNotFoundException c) {
//                   System.out.println("Container class not found");
//                   container = createRandomModel();
//                   c.printStackTrace();
//                   return;
//                }
            	container = createRandomModel();
            	final MainWindow window = new MainWindow(container);
            	window.setVisible(true);
            } catch (final Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Creates a new demomodel for the application.
    * @return Prefilled DataContainer
    */
   public static DataContainer createRandomModel() {
	   
	   Calendar cal = Calendar.getInstance(); // needed to set meters
	   
      // T-MT-001
      final DataContainer dc = new DataContainer();
      final Building b = new Building(dc, "Atlantic Haus");
      dc.addBuilding(b);
      b.setRenter(new Renter());
      final Entrance e = new Entrance(b);
      b.addEntrance(e);
      final Meter me = new Meter(dc.incMeterCnt(), Metertype.POWER, e);
      cal.set(2014, 10,1); me.setCurrentValue(100); me.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 11,1); me.setCurrentValue(9001); me.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      cal.set(2015,0,1); me.setYearValue(12501); me.setCurrentValue(12501); me.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      e.addMeter(me);
      final Meter meb = new Meter(dc.incMeterCnt(), Metertype.GAS, e);
      cal.set(2014,10,2); meb.setCurrentValue(10); meb.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.READING);
      cal.set(2014,10,6); meb.setCurrentValue(14); meb.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      e.addMeter(meb);
// APARTMENT 1
      final Apartment a = new Apartment(e);
      e.addApartment(a);
      final Meter ma = new Meter(dc.incMeterCnt(), Metertype.POWER, a);
      cal.set(2014,10,2); ma.setCurrentValue(99); ma.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      cal.set(2014,11,6); ma.setCurrentValue(300); ma.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.ESTIMATION);
      a.addMeter(ma);
      final Meter mab = new Meter(dc.incMeterCnt(), Metertype.GAS, a);
      cal.set(2014,10,2); mab.setCurrentValue(101); mab.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.READING);
      cal.set(2014,11,6); mab.setCurrentValue(4242); mab.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.ESTIMATION);
      a.addMeter(mab);
      final Meter mac = new Meter(dc.incMeterCnt(), Metertype.WATER, a);
      cal.set(2014, 10,1); mac.setCurrentValue(100); mac.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 11,1); mac.setCurrentValue(3345); mac.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      cal.set(2015,0,1); mac.setYearValue(6000); mac.setCurrentValue(6000); mac.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      a.addMeter(mac);
// APARTMENT 2
      final Apartment ab = new Apartment(e);
      e.addApartment(ab);
      final Meter mb = new Meter(dc.incMeterCnt(), Metertype.POWER, a);
      ab.addMeter(mb);
      final Meter mbb = new Meter(dc.incMeterCnt(), Metertype.GAS, a);
      ab.addMeter(mbb);
      final Meter mbc = new Meter(dc.incMeterCnt(), Metertype.WATER, a);
      cal.set(2014, 10,1); mbc.setCurrentValue(100); mbc.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 10,17); mbc.setCurrentValue(400); mbc.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.READING);
      cal.set(2015,0,1); mbc.setYearValue(980); mbc.setCurrentValue(980); mbc.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      ab.addMeter(mbc);
      ab.addTenant(new Tenant("Steffens", "J�rgen", "5247521", "steffens@mail.de"));
      ab.addTenant(new Tenant("Steffens", "Ursula", "5247521", "steffens@mail.de"));
// APARTMENT 3
      final Apartment ac = new Apartment(e);
      e.addApartment(ac);
      final Meter mc = new Meter(dc.incMeterCnt(), Metertype.POWER, a);
      ac.addMeter(mc);
      final Meter mcb = new Meter(dc.incMeterCnt(), Metertype.GAS, a);
      ac.addMeter(mcb);
      final Meter mcc = new Meter(dc.incMeterCnt(), Metertype.WATER, a);
      cal.set(2014, 10,1); mcc.setCurrentValue(100); mcc.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 11,20); mcc.setCurrentValue(3345); mcc.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      cal.set(2015,0,1); mcc.setYearValue(6000); mcc.setCurrentValue(6000); mcc.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      cal.set(2015,1,6); mcc.setCurrentValue(8101); mcc.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      ac.addMeter(mcc);
      ac.addTenant(new Tenant("Bayer", "Krischan", "8784245", "nurSchnulzenGucken@mail.de"));
      ac.addTenant(new Tenant("Bayer", "Martina", "8784245", "nurSchnulzenGucken@mail.de"));
      ac.addTenant(new Tenant("Bayer", "Lisa", "8784245", "nurSchnulzenGucken@mail.de"));
      ac.addTenant(new Tenant("Bayer", "Otto", "8784245", "nurSchnulzenGucken@mail.de"));

      final Building b2 = new Building(dc, "Studentenwohnheim 311");
      dc.addBuilding(b2);
      b2.setRenter(new Renter());
      final Entrance e2 = new Entrance(b2);
      b2.addEntrance(e2);
      final Meter me2 = new Meter(dc.incMeterCnt(), Metertype.POWER, e2);
      e2.addMeter(me2);
      final Meter meb2 = new Meter(dc.incMeterCnt(), Metertype.GAS, e2);
      e2.addMeter(meb2);
// APARTMENT 1
      final Apartment a2 = new Apartment(e2);
      e2.addApartment(a2);
      final Meter ma2 = new Meter(dc.incMeterCnt(), Metertype.POWER, a2);
      a2.addMeter(ma2);
      final Meter mab2 = new Meter(dc.incMeterCnt(), Metertype.GAS, a2);
      a2.addMeter(mab2);
      final Meter mac2 = new Meter(dc.incMeterCnt(), Metertype.WATER, a2);
      a2.addMeter(mac2);
      a2.addTenant(new Tenant("Berg", "Kevin", "476358", "lassDieChantalAusmSchrankKaevin@mail.de"));
      a2.addTenant(new Tenant("Berg", "Chantal", "476358", "lassDieChantalAusmSchrankKaevin@mail.de"));
      a2.addTenant(new Tenant("Berg", "Jan-Hendrik-Olaf", "476358", "lassDieChantalAusmSchrankKaevin@mail.de"));
// APARTMENT 2
      final Apartment ab2 = new Apartment(e2);
      e2.addApartment(ab2);
      final Meter mb2 = new Meter(dc.incMeterCnt(), Metertype.POWER, a2);
      cal.set(2014, 10,1); mb2.setCurrentValue(4009); mb2.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 11,20); mb2.setCurrentValue(9001); mb2.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      cal.set(2015,0,1); mb2.setYearValue(11000); mb2.setCurrentValue(11000); mcc.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      cal.set(2015,1,6); mb2.setCurrentValue(12010); mb2.makeReading(cal.getTime(), MeterReader.JANITOR, ReadingInfo.ESTIMATION);
      ab2.addMeter(mb2);
      final Meter mbb2 = new Meter(dc.incMeterCnt(), Metertype.GAS, a2);
      ab2.addMeter(mbb2);
      final Meter mbc2 = new Meter(dc.incMeterCnt(), Metertype.WATER, a2);
      ab2.addMeter(mbc2);
      ab2.addTenant(new Tenant("Alimibi", "Max", "6978721", "v@mail.de"));
// APARTMENT 3
      final Apartment ac2 = new Apartment(e2);
      e2.addApartment(ac2);
      final Meter mc2 = new Meter(dc.incMeterCnt(), Metertype.POWER, a2);
      ac2.addMeter(mc2);
      final Meter mcb2 = new Meter(dc.incMeterCnt(), Metertype.GAS, a2);
      ac2.addMeter(mcb2);
      final Meter mcc2 = new Meter(dc.incMeterCnt(), Metertype.WATER, a2);
      cal.set(2014, 10,1); mcc2.setCurrentValue(42); mcc2.makeReading(cal.getTime(), MeterReader.ENERGYPROVIDER, ReadingInfo.READING);
      cal.set(2014, 11,20); mcc2.setCurrentValue(9001); mcc2.makeReading(cal.getTime(), MeterReader.RENTER, ReadingInfo.ESTIMATION);
      ac2.addMeter(mcc2);

      return dc;
   }

}
