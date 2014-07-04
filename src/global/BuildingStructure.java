package global;

import java.util.ArrayList;

/* abgedeckte Anforderungen
 * A1 - Die Anwendung kann eine Gebäudestruktur darstellen
 * A18 - Löschen von Gebäuden WORK IN PROGRESS
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
// additionl functions
//================================================================================
	public void addBuilding(Building building) {
		buildings.add(building);
	}
	
	public void removeBuilding(int index) { // oder ueber key?
		// TODO Abfrage ob Gebäude "leer" bevor es gelöscht wird
		buildings.remove(index);
	}
	
	public Building getBuilding(int index) { // oder ueber key?
		return buildings.get(index);
	}
	
	public void listBuildings() {
		for (int i = 0; i < buildings.size(); i++) {
			System.out.println("Building: Nr. " + i);
		}
	}
}
