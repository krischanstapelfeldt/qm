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

	public Apartment() {
		this.meters = new ArrayList<Meter>();
		this.tenants = new ArrayList<Tenant>();
	}
	
	public Apartment(Meter initialMeter) {
		this();
		meters.add(initialMeter);
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

}