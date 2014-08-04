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
	
	public void addApartment(Apartment val) {
		this.apartments.add(val);
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
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		for (int i = 0; i < this.apartments.size(); ++i) {
			if (!this.apartments.get(i).apartmentIsEmpty())
				tmpList.add(this.apartments.get(i));
		}
		return tmpList;
	}
	
	public ArrayList<Apartment> getRentedApartments() {
		ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
		for (int i = 0; i < this.apartments.size(); ++i) {
			if (this.apartments.get(i).apartmentIsEmpty())
				tmpList.add(this.apartments.get(i));
		}
		return tmpList;
	}
	
	public boolean entranceIsEmpty() {
		return this.apartments.size() != 0 ? true : false;
	}
	
	
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < apartments.size(); i++) {
			output += "\n\t\tApartment " + i + " " + getApartment(i);
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