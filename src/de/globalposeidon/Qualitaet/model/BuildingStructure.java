package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A1 - Die Anwendung kann eine Gebäudestruktur darstellen
 * A18 - Löschen von Gebäuden WORK IN PROGRESS222222
 * ...
 */

public class BuildingStructure {
	
	private ArrayList<Building> buildings;
	
//================================================================================
// constructors
//================================================================================
	// empty strucuture
	public BuildingStructure() {
		buildings = new ArrayList<Building>();
	}
	// structure with initial building
	public BuildingStructure(Building initialBuilding) {
		this();
		buildings.add(initialBuilding);
	}
	
//================================================================================
// access private variables
//================================================================================
	public void addBuilding(Building building) {
		buildings.add(building);
	}
	
	public void removeBuilding(int index) { // oder ueber key?
		// TODO Abfrage ob Gebaueude "leer" bevor es geloescht wird
		buildings.remove(index);
	}
	
	public Building getBuilding(int index) { // oder ueber key?
		return buildings.get(index);
	}
	
//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		// TODO WORK IN PROGRESS need toString() implementation from atomic classes
		String output = "";
		for (int i = 0; i < buildings.size(); i++) {
			output += "Building: Nr." + i + "\n";
		}
		return output;
	}
}
