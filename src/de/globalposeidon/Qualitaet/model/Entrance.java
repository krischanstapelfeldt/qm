package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.tree.TreeNode;

/**
 * entrance model.
 * 
 * @author Timm Suhl
 */
public class Entrance implements TreeNode {

   private int id;
   private final Random random = new Random();
   private final Building building; // parent node

   private ArrayList<Meter> meters; // can be 0
   private ArrayList<Apartment> apartments;

   // ================================================================================
   // constructor
   // ================================================================================

   public Entrance(final Building building) {
      this.building = building;
      apartments = new ArrayList<Apartment>();
      meters = new ArrayList<Meter>();
      id = random.nextInt();
   }

   // ================================================================================
   // access private variables
   // ================================================================================
   public final int getID() {
      return id;
   }

   public final void setID(final int iD) {
	      id = iD;
	   }
   
   public final Meter getMeter(final int index) {
      if (index >= 0 && index < getMeters().size()) {
         return getMeters().get(index);
      }
      return null;
   }

   public final void addMeter(final Meter var) {
      getMeters().add(var);
   }

   public final Meter removeMeter(final int index) {
      if (index >= 0 && index < getMeters().size()) {
         return getMeters().get(index);
      }
      return null;
   }

   public final int meterCount() {
      return getMeters().size();
   }

   public final Apartment getApartment(final int index) {
      if (index >= 0 && index < apartments.size()) {
         return apartments.get(index);
      }
      return null;
   }

   public final void addApartment(final Apartment val) {
      apartments.add(val);
   }

   public final Apartment removeApartment(final int index) {
      if (index >= 0 && index < apartments.size()) {
         if (getApartment(index).apartmentIsEmpty()) {
            return apartments.remove(index);
         }
      }
      return null;
   }

   public final int apartmentCount() {
      return apartments.size();
   }

   // ================================================================================
   // other stuff...
   // ================================================================================
   public final ArrayList<Apartment> getEmptyApartments() {
      final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
      for (int i = 0; i < apartments.size(); ++i) {
         if (getApartment(i).apartmentIsEmpty()) {
            tmpList.add(apartments.get(i));
         }
      }
      return tmpList;
   }

   public final ArrayList<Apartment> getRentedApartments() {
      final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
      for (int i = 0; i < apartments.size(); ++i) {
         if (!getApartment(i).apartmentIsEmpty()) {
            tmpList.add(apartments.get(i));
         }
      }
      return tmpList;
   }

   public final boolean entranceIsEmpty() {
      return apartments.size() == 0;
   }

   @Override
   public final String toString() {
      final String output = "Entrance " + getID();
      // for (int i = 0; i < apartments.size(); i++) {
      // output += "\n\t\tApartment " + i + " " + getApartment(i);
      // }
      return output;
   }

   // ================================================================================
   // TreeNode Interface
   // ================================================================================
   @Override
   public final TreeNode getChildAt(final int childIndex) {
      System.out.println("get child at");
      return apartments.size() > childIndex ? apartments.get(childIndex) : getMeters().get(childIndex - apartments.size());
   }

   @Override
   public final int getChildCount() {
      System.out.println("get count");
      return apartments.size() + getMeters().size();
   }

   @Override
   public final TreeNode getParent() {
      return building;
   }

   @Override
   public final int getIndex(final TreeNode node) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public final boolean getAllowsChildren() {
      return true;
   }

   @Override
   public final boolean isLeaf() {
      return false;
   }

   @Override
   public final Enumeration<TreeNode> children() {
      final ArrayList<TreeNode> children = new ArrayList<TreeNode>();
      children.addAll(apartments);
      children.addAll(getMeters());
      return Collections.enumeration(children);
   }

   public ArrayList<Meter> getMeters() {
      return meters;
   }

   public void setMeters(final ArrayList<Meter> meters) {
      this.meters = meters;
   }

   public ArrayList<Apartment> getApartment() {
      return apartments;
   }

   public void setApartments(final ArrayList<Apartment> apartments) {
      this.apartments = apartments;
   }
}
