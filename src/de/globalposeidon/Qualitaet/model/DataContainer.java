package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.UUID;

import javax.swing.tree.TreeNode;
/**
 * datacontainer model.
 * @author Timm
 *
 */
public class DataContainer implements TreeNode {

	private final UUID uuid;
	private final ArrayList<Building> buildings;

	public DataContainer() {
		buildings = new ArrayList<>(1);
		uuid = UUID.randomUUID();
	}

	public final void addBuilding(final Building building) {
		buildings.add(building);
	}

	public final Building getBuilding(final int index) {
		return buildings.get(index);
	}

	public final int getBuildingCount() {
		return buildings.size();
	}

	public final int getBuildingID(final int index) {
		return buildings.get(index).getID();
	}

	@Override
	public final String toString() {
		return uuid.toString();
	}

	// ================================================================================
	// TreeNode Interface
	// ================================================================================
	@Override
	public final TreeNode getChildAt(final int childIndex) {
		return buildings.get(childIndex);
	}

	@Override
	public final int getChildCount() {
		return buildings.size();
	}

	@Override
	public final TreeNode getParent() {
		return null;
	}

	@Override
	public final int getIndex(final TreeNode node) {
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
	public final Enumeration<Building> children() {
		return Collections.enumeration(buildings);
	}
}
