package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A1 - Die Anwendung kann eine Gebaeudestruktur darstellen
 * A15 - Hinzufuegen von Gebaueden
 * A18 - Loeschen von Gebaeuden
 * ...
 */

public class BuildingStructure {
	
	private int ID;
	
	private ArrayList<Building> buildings;
	
//================================================================================
// constructors
//================================================================================
	public BuildingStructure() {
		buildings = new ArrayList<Building>();
	}

	// structure with initial building
	public BuildingStructure(Building initialBuilding) {
		buildings = new ArrayList<Building>();
		this.addBuilding(initialBuilding);
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
	
	public boolean addBuilding(Building building) {
		buildings.add(building);
		return true;
	}
	
	public boolean removeBuilding(int index) { // oder ueber key?
		if (buildings.get(index).buildingIsEmpty()) {
			buildings.remove(index);
			return true;
		}
		return false;
	}
	
	public Building getBuilding(int index) { // oder ueber key?
		return buildings.get(index);
	}
	
//================================================================================
// other stuff...
//================================================================================
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < buildings.size(); i++) {
			output += "Bulding " + i  + " " + getBuilding(i) + "\n";
		}
		return output;
	}
}
