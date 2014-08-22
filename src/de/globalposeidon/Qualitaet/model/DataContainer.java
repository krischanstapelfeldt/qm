package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.UUID;

import javax.swing.tree.TreeNode;

public class DataContainer implements TreeNode {
	
	private UUID uuid;
	private ArrayList<Building> buildings;

	public DataContainer(){
		buildings = new ArrayList<>(1);
		uuid = UUID.randomUUID();
	}
	
	public void addBuilding(Building building){
		buildings.add(building);
	}
	
	
	public String toString(){
		return uuid.toString();
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return buildings.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return buildings.size();
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
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
	public Enumeration children() {
		return Collections.enumeration(buildings);
	}
}
