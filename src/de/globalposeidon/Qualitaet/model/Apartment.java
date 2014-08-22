package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A13 - Es koennen bis zu 4 Mieter in einer Wohnung wohnen.
 */

public class Apartment implements TreeNode{
	
	private int ID;

	final private Entrance entrance;
	
	private ArrayList<Meter> meters;
	private ArrayList<Tenant> tenants;
	
//================================================================================
// constructor
//================================================================================

	public Apartment(Entrance entrance){
		this.entrance = entrance;
		this.meters = new ArrayList<Meter>();
		this.tenants = new ArrayList<Tenant>();
	}
	
	public Apartment(Meter initialMeter, Entrance entrance) {
		this(entrance);
		meters.add(initialMeter);
	}
	
	public Apartment(Meter initialMeter, Tenant initialTenant,Entrance entrance) {
		this(initialMeter,entrance);
		this.tenants.add(initialTenant);
	}
	
//================================================================================
// access private variables
//================================================================================
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public void addMeter(Meter meter) {
		this.meters.add(meter);
	}
	
	public Meter getMeter(int index) {
		return this.meters.get(index);
	}
	public void removeMeter(int index) {
		this.meters.remove(index);
	}

	public boolean addTenant(Tenant tentant) {
		if(this.tenants.size() < 5) { //max 4 tenants for each apartment
			this.tenants.add(tentant);
			return true;
		}
		return false;
	}
	
	public Tenant getTenant(int index) {
		return this.tenants.get(index);
	}
	
	public void removeTenant(int index) {
		this.tenants.remove(index);
	}
//================================================================================
// other stuff...
//================================================================================
	public boolean apartmentIsEmpty() {
		return this.meters.size() != 0 ? true : false;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < tenants.size(); i++) {
			output += "\n\t\t\t with Tenant: " + getTenant(i);
		}
		return output;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return meters.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return meters.size();
	}

	@Override
	public TreeNode getParent() {
		return entrance;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public Enumeration<Meter> children() {
		return Collections.enumeration(meters);
	}

}