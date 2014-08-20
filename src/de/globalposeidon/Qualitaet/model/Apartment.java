package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A13 - Es koennen bis zu 4 Mieter in einer Wohnung wohnen.
 */

public class Apartment {
	
	private int ID;

	private ArrayList<Meter> meters;
	private ArrayList<Tenant> tenants;
	
//================================================================================
// constructor
//================================================================================
	// empty apartment not allowed, so no Building()
	
	public Apartment(Meter initialMeter) {
		meters = new ArrayList<Meter>();
		meters.add(initialMeter);
		this.tenants = new ArrayList<Tenant>();
	}
	
	public Apartment(Meter initialMeter, Tenant initialTenant) {
		this(initialMeter);
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
	
	
	
//================================================================================
// TODO: REMOVE OLD TEST STUFF
//================================================================================
	public boolean add() {
		return true;
	}

	public boolean delete() {
		return true;
	}

	public int[] list(int id) {
		int[] i = null;
		return i;
	}

}