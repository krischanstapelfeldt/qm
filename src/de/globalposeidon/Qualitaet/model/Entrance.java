package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/* abgedeckte Anforderungen
 * A17 - Einfuegen einer Wohnung
 */

public class Entrance implements TreeNode{
	
	private int ID;
	final private Building building; // parent node
	
	private ArrayList<Meter> meters; //can be 0
	private ArrayList<Apartment> apartments;
	
//================================================================================
// constructor
//================================================================================

	public Entrance(Building building) {
		this.building = building;
		this.apartments = new ArrayList<Apartment>();
		this.meters = new ArrayList<Meter>();
		ID = ((int) (Math.random()*10000));
	}
	
	public Entrance(Apartment initialApartment, Building building) {
		this(building);
		this.addApartment(initialApartment);
	}
	
	public Entrance(Apartment initialApartment, Meter initialMeter, Building building) {
		this(initialApartment, building);
		this.addMeter(initialMeter);
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
	
	public Meter getMeter(int index) { 
		return meters.get(index);
	}
	
	public void addMeter(Meter var) {
		this.meters.add(var);
	}
	
	public void removeMeter(int index) { 
		this.meters.remove(index);
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
		String output = "Entrance " + getID();
//		for (int i = 0; i < apartments.size(); i++) {
//			output += "\n\t\tApartment " + i + " " + getApartment(i);
//		}
		return output;
	}

//================================================================================
// TreeNode Interface
//================================================================================		
	@Override
	public TreeNode getChildAt(int childIndex) {
		return apartments.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return apartments.size();
	}

	@Override
	public TreeNode getParent() {
		return building;
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
	public Enumeration<TreeNode> children() {
		ArrayList<TreeNode> children = new ArrayList<TreeNode>();
		children.addAll(apartments);
		children.addAll(meters);
		return Collections.enumeration(children);
	}
	
}