package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A13 - Es koennen bis zu 4 Mieter in einer Wohnung wohnen.
 */

public class Apartment {
	
	private ArrayList<Meter> meters;
	private ArrayList<Tenant> tenants;
	
//================================================================================
// constructor
//================================================================================
	// empty apartment not allowed, so no Building()
	
	public Apartment(Meter initialMeter) {
		meters = new ArrayList<Meter>();
		meters.add(initialMeter);
	}
	
	public Apartment(Meter initialMeter, Tenant initialTenant) {
		this(initialMeter);
		this.tenants = new ArrayList<Tenant>();
		this.tenants.add(initialTenant);
	}
	
//================================================================================
// access private variables
//================================================================================
	public void addMeter(Meter meter) {
		this.meters.add(meter);
	}
	
	public Meter getMeter(int index) {
		return this.meters.get(index);
	}
	
	public boolean addTenant(Tenant tentant) {
		if(this.tenants.size() < 5) {
			this.tenants.add(tentant);
			return true;
		}
		return false;
	}
	
//================================================================================
// other stuff...
//================================================================================
	public boolean apartmentIsEmpty() {

		return false;
	}

	@Override
	public String toString() {
		String output = "Renter: " + "\n";
		for (int i = 0; i < tenants.size(); i++) {
			output += "Tentant: Nr." + i;
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