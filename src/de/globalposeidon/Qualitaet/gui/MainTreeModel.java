package de.globalposeidon.Qualitaet.gui;

import javax.swing.tree.DefaultTreeModel;

import de.globalposeidon.Qualitaet.model.DataContainer;

public class MainTreeModel extends DefaultTreeModel {
	private static final long serialVersionUID = -5960181543240121987L;

	public MainTreeModel(DataContainer dc) {
		super(dc);
	}
}
