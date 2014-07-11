package de.globalposeidon.Qualitaet;

import java.awt.EventQueue;
import de.globalposeidon.Qualitaet.gui.MainWindow;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}

}
