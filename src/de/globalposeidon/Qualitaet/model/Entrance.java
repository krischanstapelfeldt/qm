package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * entrance model.
 * @author Timm Suhl
 */
public class Entrance extends DefaultMutableTreeNode implements java.io.Serializable{

   private static final long serialVersionUID = -2273564019802782697L;
   private int id;
   private final Random random = new Random();
   private final Building building; // parent node

   private ArrayList<Meter> meters; // can be 0
   private ArrayList<Apartment> apartments;

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * Konstuktor.
    * @param building Gebaude
    */
   public Entrance(final Building building) {
      this.building = building;
      apartments = new ArrayList<Apartment>();
      meters = new ArrayList<Meter>();
      id = random.nextInt();
   }

   // ================================================================================
   // access private variables
   // ================================================================================
  /**
   * ID des Eingangs.
   * @return id
   */
   public final int getID() {
      return id;
   }
   /**
    * ID des Eingangs setzen.
    * @param iD ID
    */
   public final void setID(final int iD) {
      id = iD;
   }
   /**
    * Liste mit Zaehlern.
    * @return liste
    */
   public final ArrayList<Meter> getMeters() {
      return meters;
   }
   /**
    * Setzen der Zaehlerliste.
    * @param meters Zaehlerliste
    */
   public final void setMeters(final ArrayList<Meter> meters) {
      this.meters = meters;
   }
   /**
    * Liste mit Apartments.
    * @return Apartmentliste
    */
   public final ArrayList<Apartment> getApartments() {
      return apartments;
   }
   /**
    * Setzen der Apartmentliste.
    * @param apartments Apartmentliste
    */
   public final void setApartments(final ArrayList<Apartment> apartments) {
      this.apartments = apartments;
   }
   /**
    * Zaehler zu Index.
    * @param index index
    * @return Zaehler
    */
   public final Meter getMeter(final int index) {
      if (index >= 0 && index < getMeters().size()) {
         return getMeters().get(index);
      }
      return null;
   }
   /**
    * Zaehler hinzfuegen.
    * @param var Zaehler
    */
   public final void addMeter(final Meter var) {
      getMeters().add(var);
   }
   /**
    * Zaehler entfernen.
    * @param index index
    * @return Zaehler
    */
   public final Meter removeMeter(final int index) {
      if (index >= 0 && index < getMeters().size()) {
         return getMeters().get(index);
      }
      return null;
   }
   /**
    * Anzahl Zaehler.
    * @return Anzahl
    */
   public final int meterCount() {
      return getMeters().size();
   }
   /**
    * Apartmentliste.
    * @param index index
    * @return liste
    */
   public final Apartment getApartments(final int index) {
      if (index >= 0 && index < apartments.size()) {
         return apartments.get(index);
      }
      return null;
   }
   /**
    * Apartment hinzu.
    * @param val Apartment
    */
   public final void addApartment(final Apartment val) {
      apartments.add(val);
   }
   /**
    * Apartment entfernen.
    * @param index index
    * @return Apartment
    */
   public final Apartment removeApartment(final int index) {
      if (index >= 0 && index < apartments.size()) {
         if (getApartments(index).apartmentIsEmpty()) {
            return apartments.remove(index);
         }
      }
      return null;
   }
   /**
    * Anzahl Apartments.
    * @return Anzahl
    */
   public final int apartmentCount() {
      return apartments.size();
   }

   // ================================================================================
   // other stuff...
   // ================================================================================
   /**
    * Liste mit leeren Apartments.
    * @return Liste
    */
   public final ArrayList<Apartment> getEmptyApartments() {
      final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
      for (int i = 0; i < apartments.size(); ++i) {
         if (getApartments(i).apartmentIsEmpty()) {
            tmpList.add(apartments.get(i));
         }
      }
      return tmpList;
   }
   /**
    * Liste mit vermieteten Apartments.
    * @return liste
    */
   public final ArrayList<Apartment> getRentedApartments() {
      final ArrayList<Apartment> tmpList = new ArrayList<Apartment>();
      for (int i = 0; i < apartments.size(); ++i) {
         if (!getApartments(i).apartmentIsEmpty()) {
            tmpList.add(apartments.get(i));
         }
      }
      return tmpList;
   }
   /**
    * Eingang leer?.
    * @return JA/NEIN
    */
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
      return apartments.size() > childIndex ? apartments.get(childIndex) : getMeters().get(childIndex - apartments.size());
   }

   @Override
   public final int getChildCount() {
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

}
