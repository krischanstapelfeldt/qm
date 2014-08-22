package de.globalposeidon.Qualitaet.gui;

import javax.swing.tree.DefaultTreeModel;

import de.globalposeidon.Qualitaet.model.DataContainer;

public class MainTreeModel extends DefaultTreeModel {
	public MainTreeModel(DataContainer dc) {
		super(dc);
	}
}
