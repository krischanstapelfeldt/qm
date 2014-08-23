package de.globalposeidon.Qualitaet;

import java.awt.EventQueue;

import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.Apartment;
import de.globalposeidon.Qualitaet.model.Building;
import de.globalposeidon.Qualitaet.model.DataContainer;
import de.globalposeidon.Qualitaet.model.Entrance;
import de.globalposeidon.Qualitaet.model.Meter;
import de.globalposeidon.Qualitaet.model.Metertype;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow(createRandomModel());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static DataContainer createRandomModel(){
		DataContainer dc = new DataContainer();
		Building b = new Building(dc);
		dc.addBuilding(b);
		Entrance e = new Entrance(b);
		b.addEntrance(e);
		Apartment a = new Apartment(e);
		e.addApartment(a);
		Meter m = new Meter(1, Metertype.POWER, a);
		a.addMeter(m);

		Building b2 = new Building(dc);
		dc.addBuilding(b2);
		Entrance e2 = new Entrance(b);
		b2.addEntrance(e2);
		Apartment a2 = new Apartment(e);
		e2.addApartment(a2);
		Meter m2 = new Meter(2, Metertype.POWER, a2);
		a2.addMeter(m2);
		return dc;
	}

}
