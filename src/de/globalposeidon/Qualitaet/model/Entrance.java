package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A17 - Einfuegen einer Wohnung
 */

public class Entrance {
	
	private ArrayList<Meter> meters; //can be 0
	private ArrayList<Apartment> apartments;
	
//================================================================================
// constructor
//================================================================================
	// empty entrance not allowed, so no Entrance()
	
	public Entrance(Apartment initialApartment) {
		this.apartments = new ArrayList<Apartment>();
		this.addApartment(initialApartment);
	}
	
	public Entrance(Apartment initialApartment, Meter initialMeter) {
		this(initialApartment);
		this.meters = new ArrayList<Meter>();
		this.addMeter(initialMeter);
	}
	
//================================================================================
// access private variables
//================================================================================
	public Meter getMeter(int index) { 
		return meters.get(index);
	}
	
	public void addMeter(Meter var) {
		meters.add(var);
	}
	
	public void removeMeter(int index) { 
		meters.remove(index);
	}
	
	public Apartment getApartment(int index) { 
		return apartments.get(index);
	}
	
	public boolean addApartment(Apartment val) {
		
		this.apartments.add(val);
		return true;
	}
	
	public boolean removeApartment(int index) {
		if(apartments.get(index).apartmentIsEmpty()) {
			this.apartments.remove(index);
			return true;
		}
		return false;
	}
//================================================================================
// other stuff...
//================================================================================
	public ArrayList<Apartment> getEmptyApartments() {
		return this.apartments;
	}
	
	public ArrayList<Apartment> getRentedApartments() {
		return this.apartments;
	}
	
	public boolean entranceIsEmpty() {
		return true;
	}
	
	
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < apartments.size(); i++) {
			output += "Apartment: Nr." + i;
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