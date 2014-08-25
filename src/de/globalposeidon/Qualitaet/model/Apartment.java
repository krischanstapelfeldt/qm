package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A13 - Es koennen bis zu 4 Mieter in einer Wohnung wohnen.
 */

public class Apartment implements TreeNode {

	private int ID;
	private final Entrance entrance; // parent node

	private final ArrayList<Meter> meters;
	private final ArrayList<Tenant> tenants;

	// ================================================================================
	// constructor
	// ================================================================================

	public Apartment(final Entrance entrance) {
		this.entrance = entrance;
		meters = new ArrayList<Meter>();
		tenants = new ArrayList<Tenant>();
		ID = ((int) (Math.random() * 10000));
	}

	public Apartment(final Meter initialMeter, final Entrance entrance) {
		this(entrance);
		meters.add(initialMeter);
	}

	public Apartment(final Meter initialMeter, final Tenant initialTenant, final Entrance entrance) {
		this(initialMeter, entrance);
		tenants.add(initialTenant);
	}

	// ================================================================================
	// access private variables
	// ================================================================================
	public int getID() {
		return ID;
	}

	public final void setID(int iD) {
		ID = iD;
	}

	public final void addMeter(final Meter meter) {
		meters.add(meter);
	}

	public final Meter getMeter(final int index) {
		return meters.get(index);
	}

	public final void removeMeter(final int index) {
		meters.remove(index);
	}

	public final boolean addTenant(final Tenant tentant) {
		if (tenants.size() < 5) { // max 4 tenants for each apartment
			tenants.add(tentant);
			return true;
		}
		return false;
	}

	public final Tenant getTenant(final int index) {
		return tenants.get(index);
	}

	public final void removeTenant(final int index) {
		tenants.remove(index);
	}

	// ================================================================================
	// other stuff...
	// ================================================================================
	public final boolean apartmentIsEmpty() {
		return meters.size() != 0 ? true : false;
	}

	@Override
	public final String toString() {
		final String output = "Apartment " + getID();
		// for (int i = 0; i < tenants.size(); i++) {
		// output += "\n\t\t\t with Tenant: " + getTenant(i);
		// }
		return output;
	}

	// ================================================================================
	// TreeNode Interface
	// ================================================================================
	@Override
	public final TreeNode getChildAt(final int childIndex) {
		return meters.get(childIndex);
	}

	@Override
	public final int getChildCount() {
		return meters.size();
	}

	@Override
	public final TreeNode getParent() {
		return entrance;
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
	public final Enumeration<Meter> children() {
		return Collections.enumeration(meters);
	}

}