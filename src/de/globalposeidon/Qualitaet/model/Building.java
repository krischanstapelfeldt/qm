package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A16 - Einfuegen eines Einganges
 */

public class Building {
	
	private int ID;
	
	private Renter renter;
	private ArrayList<Entrance> entrances;
	
//================================================================================
// constructor
//================================================================================
	// empty building not allowed, so no Building()
	
	public Building(Renter renter, Entrance initialEntrance) {
		entrances = new ArrayList<Entrance>();
		this.addEntrance(initialEntrance);
		this.renter = renter; 
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
	
	public Renter getRenter() {
		return renter;
	}

	public void replaceRenter(Renter renter) {
		this.renter = renter;
	}
	
	public void addEntrance(Entrance entrance) {
		entrances.add(entrance);
	}

	public boolean removeEntrance(int index) { 
		//entrance has to be empty
		if (entrances.get(index).entranceIsEmpty()) {
			entrances.remove(index);
			return true;
		}
		return false;
	}
	
	public Entrance getEntrance(int index) {
		return entrances.get(index);
	}
	
//================================================================================
// other stuff...
//================================================================================
	public boolean buildingIsEmpty() {
		return this.entrances.size() != 0 ? true : false;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < entrances.size(); i++) {
			output += " Rented by " + this.renter;
			output += "\n\tEntrance " + i + " " + getEntrance(i);
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

	public int[] list() {
		int[] i = null;
		return i;
	}

}