package de.globalposeidon.Qualitaet;

import java.awt.EventQueue;

import de.globalposeidon.Qualitaet.gui.MainWindow;
import de.globalposeidon.Qualitaet.model.DataContainer;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setVisible(true);
					DataContainer test = new DataContainer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
