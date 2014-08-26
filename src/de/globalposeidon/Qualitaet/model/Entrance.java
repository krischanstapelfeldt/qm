package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A17 - Einfuegen einer Wohnung
 */

public class Entrance implements TreeNode {

	private int ID;
	private final Building building; // parent node

	private final ArrayList<Meter> meters; // can be 0
	private final ArrayList<Apartment> apartments;

	// ================================================================================
	// constructor
	// ================================================================================

	public Entrance(final Building building) {
		this.building = building;
		apartments = new ArrayList<Apartment>();
		meters = new ArrayList<Meter>();
		ID = ((int) (Math.random() * 10000));
	}

//	public Entrance(final Apartment initialApartment, final Building building) {
//		this(building);
//		addApartment(initialApartment);
//	}
//
//	public Entrance(final Apartment initialApartment, final Meter initialMeter,
//			final Building building) {
//		this(initialApartment, building);
//		addMeter(initialMeter);
//	}

	// ================================================================================
	// access private variables
	// ================================================================================
	public final int getID() {
		return ID;
	}

	public final void setID(final int iD) {
		ID = iD;
	}

	public final Meter getMeter(final int index) {
		if(index >= 0 && index < meters.size()) {
			return meters.get(index);
		}
		return null;
	}

	public final void addMeter(final Meter var) {
		meters.add(var);
	}

	public final Meter removeMeter(final int index) {
		return meters.remove(index);
	}

	public final Apartment getApartment(final int index) {
		if(index >= 0 && index < apartments.size()) {
			return apartments.get(index);
		}
		return null;
	}

	public final void addApartment(final Apartment val) {
		apartments.add(val);
	}

	public final Apartment removeApartment(final int index) {
		if (getApartment(index).apartmentIsEmpty()) {
			return apartments.remove(index);
		}
		return null;
	}

	// ================================================================================
	// other stuff...
	// ================================================================================
	public final ArrayList<Apartment> getEmptyApartments() {
		final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		for (int i = 0; i < apartments.size(); ++i) {
			if (!apartments.get(i).apartmentIsEmpty()) {
				tmpList.add(apartments.get(i));
			}
		}
		return tmpList;
	}

	public final ArrayList<Apartment> getRentedApartments() {
		final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		for (int i = 0; i < apartments.size(); ++i) {
			if (apartments.get(i).apartmentIsEmpty()) {
				tmpList.add(apartments.get(i));
			}
		}
		return tmpList;
	}

	public final boolean entranceIsEmpty() {
		return apartments.size() == 0 ? true : false;
	}

	@Override
	public final String toString() {
		final String output = "Entrance " + getID();
		// for (int i = 0; i < apartments.size(); i++) {
		// output += "\n\t\tApartment " + i + " " + getApartment(i);
		// }
		return output;
	}

	// ================================================================================
	// TreeNode Interface
	// ================================================================================
	@Override
	public final TreeNode getChildAt(final int childIndex) {
		System.out.println("get child at");
		return apartments.size() > childIndex ? apartments.get(childIndex)
				: meters.get(childIndex - apartments.size());
	}

	@Override
	public final int getChildCount() {
		System.out.println("get count");
		return apartments.size() + meters.size();
	}

	@Override
	public final TreeNode getParent() {
		return building;
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
	public final Enumeration<TreeNode> children() {
		final ArrayList<TreeNode> children = new ArrayList<TreeNode>();
		children.addAll(apartments);
		children.addAll(meters);
		return Collections.enumeration(children);
	}

}