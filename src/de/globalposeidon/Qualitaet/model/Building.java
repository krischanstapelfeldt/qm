package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

public class Building {
	
	private Person renter;
	private ArrayList<Entrance> entrances;
	
//================================================================================
// constructos
//================================================================================
	public Building() {
		// TODO Add standard value for a person, maybe Obama?
		//renter = new Person() // need to implement person constructor
		entrances = new ArrayList<Entrance>();
	}
	
//================================================================================
// access private variables
//================================================================================
	public void addEntrance(Entrance entrance) {
		entrances.add(entrance);
	}
	
	public void removeEntrance(int index) { // oder ueber key?
		// TODO Abfrage ob Entrance "leer" bevor es geloescht wird
		entrances.remove(index);
	}
	
	public Entrance getEntrance(int index) { // oder ueber key?
		return entrances.get(index);
	}
	
//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		// TODO WORK IN PROGRESS need toString() implementation from atomic classes
		String output = "Renter: " + "\n";
		for (int i = 0; i < entrances.size(); i++) {
			output += "Entrance: Nr." + i;
		}
		return output;
	}
//================================================================================
// test functions
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