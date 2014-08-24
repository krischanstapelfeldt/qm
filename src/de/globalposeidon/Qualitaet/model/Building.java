package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A16 - Einfuegen eines Einganges
 */

public class Building implements TreeNode{
	
	final private int ID;
	final private DataContainer dc; // parent node
	
	private Renter renter;
	private ArrayList<Entrance> entrances;
	
//================================================================================
// constructor
//================================================================================

	public Building(DataContainer dc) {
		entrances = new ArrayList<Entrance>(); 
		ID = ((int) (Math.random()*10000));
		this.dc = dc;
	}
	
	public Building(Renter renter, Entrance initialEntrance, DataContainer dc) {
		this(dc);
		this.addEntrance(initialEntrance);
		this.renter = renter; 
	}
	
//================================================================================
// access private variables
//================================================================================
	public int getID() {
		return ID;
	}
	
	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
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
	
	public int getEntrancesCount(){
		return entrances.size();
	}

	
//================================================================================
// other stuff...
//================================================================================
	public boolean buildingIsEmpty() {
		return this.entrances.size() != 0 ? true : false;
	}
	
	@Override
	public String toString() {
		return "Building "+getID();
	}

//================================================================================
// TreeNode Interface
//================================================================================	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return entrances.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return entrances.size();
	}

	@Override
	public TreeNode getParent() {
		return dc;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public Enumeration<Entrance> children() {
		return Collections.enumeration(entrances);
	}
	
}