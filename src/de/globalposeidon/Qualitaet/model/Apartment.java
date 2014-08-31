package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * apartment model.
 * @author Timm Suhl
 */
public class Apartment extends DefaultMutableTreeNode implements java.io.Serializable {

   private static final long serialVersionUID = -5046711217211082032L;
   private int id;
   private final Entrance entrance; // parent node
   private final Random random = new Random();

   private ArrayList<Meter> meters;
   private ArrayList<Tenant> tenants;

   private static final int MAXTENANTS = 4;

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * Konstruktor.
    * @param entrance
    *           Zugehoeriger Eingang
    */
   public Apartment(final Entrance entrance) {
      this.entrance = entrance;
      meters = new ArrayList<Meter>();
      tenants = new ArrayList<Tenant>();
      id = random.nextInt();
   }

   // ================================================================================
   // access private variables
   // ================================================================================
   /**
    * Gibt ID zurueck.
    * @return ID ID
    */
   public final int getID() {
      return id;
   }

   /**
    * ID setzen.
    * @param iD
    *           ID
    */
   public final void setID(final int iD) {
      id = iD;
   }

   /**
    * Zaehler zu einem Apartment hinzufuegen.
    * @param meter
    *           meter
    */
   public final void addMeter(final Meter meter) {
      meters.add(meter);
   }

   /**
    * Zaehler von einem Apartment erhalten.
    * @param index
    *           index
    * @return meter
    */
   public final Meter getMeter(final int index) {
      if (index >= 0 && index < meters.size()) {
         return meters.get(index);
      }
      return null;
   }

   /**
    * Zaehler von einem Apartment entfernen.
    * @param index
    *           index
    * @return Zaehler zaehler
    */
   public final Meter removeMeter(final int index) {
      if (index >= 0 && index < meters.size()) {
         return meters.remove(index);
      }
      return null;
   }

   /**
    * Anzahl der Zaehler.
    * @return Anzahl Anzahl
    */
   public final int meterCount() {
      return meters.size();
   }

   /**
    * Mieter hinzufuegen.
    * @param tenant
    *           Mieter
    * @return Hinzugefuegt?
    */
   public final boolean addTenant(final Tenant tenant) {
      if (tenants.size() < MAXTENANTS) { // max 4 tenants for each
         // apartment
         tenants.add(tenant);
         return true;
      }
      return false;
   }

   /**
    * Mieter erhalten.
    * @param index
    *           index
    * @return tenant Mieter
    */
   public final Tenant getTenant(final int index) {
      if (index >= 0 && index < tenants.size()) {
         return tenants.get(index);
      }
      return null;
   }

   /**
    * Mieter entfernen.
    * @param index
    *           index
    * @return Entfernten Mieter
    */
   public final Tenant removeTenant(final int index) {
      if (index >= 0 && index < tenants.size()) {
         return tenants.remove(index);
      }
      return null;
   }

   /**
    * Anzahl Mieter.
    * @return Anzahl
    */
   public final int tenantCount() {
      return tenants.size();
   }

   // ================================================================================
   // other stuff...
   // ================================================================================
   /**
    * Ist das Apartment leer?
    * @return JA/NEIN
    */
   public final boolean apartmentIsEmpty() {
      return tenants.size() == 0;
   }

   @Override
   public final String toString() {
      final String output = "Apartment " + getID();
      // for (int i = 0; i < tenants.size(); i++) {
      // output += "\n\t\t\t with Tenant: " + getTenant(i);
      // }
      return output;
   }

   // ================================================================================
   // TreeNode Interface
   // ================================================================================
   @Override
   public final TreeNode getChildAt(final int childIndex) {
      return meters.get(childIndex);
   }

   @Override
   public final int getChildCount() {
      return meters.size();
   }

   @Override
   public final TreeNode getParent() {
      return entrance;
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
   public final Enumeration<Meter> children() {
      return Collections.enumeration(meters);
   }

   /**
    * Liste mit Zaehler.
    * @return Liste
    */
   public final ArrayList<Meter> getMeters() {
      return meters;
   }

   /**
    * Liste mit Zaehlern setzen.
    * @param meters
    *           meterliste
    */
   public final void setMeters(final ArrayList<Meter> meters) {
      this.meters = meters;
   }

   /**
    * Liste mit Mietern.
    * @return liste
    */
   public final ArrayList<Tenant> getTenants() {
      return tenants;
   }

   /**
    * Liste mit Mietern setzen.
    * @param tenants
    *           mieterliste
    */
   public final void setTenants(final ArrayList<Tenant> tenants) {
      this.tenants = tenants;
   }

}
