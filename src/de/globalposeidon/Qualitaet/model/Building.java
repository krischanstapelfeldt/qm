package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A16 - Einfuegen eines Einganges
 */

public class Building implements TreeNode {

	private final int ID;
	private final DataContainer dc; // parent node

	private Renter renter;
	private final ArrayList<Entrance> entrances;

	// ================================================================================
	// constructor
	// ================================================================================

	public Building(final DataContainer dc) {
		entrances = new ArrayList<Entrance>();
		ID = ((int) (Math.random() * 10000));
		this.dc = dc;
	}

	public Building(final Renter renter, final Entrance initialEntrance, final DataContainer dc) {
		this(dc);
		addEntrance(initialEntrance);
		this.renter = renter;
	}

	// ================================================================================
	// access private variables
	// ================================================================================
	public final int getID() {
		return ID;
	}

	public final Renter getRenter() {
		return renter;
	}

	public final void setRenter(final Renter renter) {
		this.renter = renter;
	}

	public final void addEntrance(final Entrance entrance) {
		entrances.add(entrance);
	}

	public final boolean removeEntrance(final int index) {
		// entrance has to be empty
		if (entrances.get(index).entranceIsEmpty()) {
			entrances.remove(index);
			return true;
		}
		return false;
	}

	public final Entrance getEntrance(final int index) {
		return entrances.get(index);
	}

	public final int getEntrancesCount() {
		return entrances.size();
	}

	// ================================================================================
	// other stuff...
	// ================================================================================
	public final boolean buildingIsEmpty() {
		return entrances.size() != 0 ? true : false;
	}

	@Override
	public final String toString() {
		return "Building " + getID();
	}

	// ================================================================================
	// TreeNode Interface
	// ================================================================================
	@Override
	public final TreeNode getChildAt(final int childIndex) {
		return entrances.get(childIndex);
	}

	@Override
	public final int getChildCount() {
		return entrances.size();
	}

	@Override
	public final TreeNode getParent() {
		return dc;
	}

	@Override
	public final int getIndex(final TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final boolean getAllowsChildren() {
		return true;
	}

	@Override
	public final boolean isLeaf() {
		return false;
	}

	@Override
	public final Enumeration<Entrance> children() {
		return Collections.enumeration(entrances);
	}

}