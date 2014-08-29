package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/*
 * abgedeckte Anforderungen A13 - Es koennen bis zu 4 Mieter in einer Wohnung
 * wohnen.
 */
/**
 * apartment model.
 * @author Timm Suhl
 */
public class Apartment extends DefaultMutableTreeNode {

   private int id;
   private final Entrance entrance; // parent node
   private final Random random = new Random();

   private ArrayList<Meter> meters;
   private ArrayList<Tenant> tenants;

   private static final int MAXTENANTS = 4;

   // ================================================================================
   // constructor
   // ================================================================================

   public Apartment(final Entrance entrance) {
      this.entrance = entrance;
      meters = new ArrayList<Meter>();
      tenants = new ArrayList<Tenant>();
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

   public final void addMeter(final Meter meter) {
      meters.add(meter);
   }

   public final Meter getMeter(final int index) {
      if (index >= 0 && index < meters.size()) {
         return meters.get(index);
      }
      return null;
   }

   public final Meter removeMeter(final int index) {
      if (index >= 0 && index < meters.size()) {
         return meters.remove(index);
      }
      return null;
   }

   public final int meterCount() {
      return meters.size();
   }

   public final boolean addTenant(final Tenant tentant) {
      if (tenants.size() < MAXTENANTS) { // max 4 tenants for each
                                         // apartment
         tenants.add(tentant);
         return true;
      }
      return false;
   }

   public final Tenant getTenant(final int index) {
      if (index >= 0 && index < tenants.size()) {
         return tenants.get(index);
      }
      return null;
   }

   public final Tenant removeTenant(final int index) {
      if (index >= 0 && index < tenants.size()) {
         return tenants.remove(index);
      }
      return null;
   }

   public final int tenantCount() {
      return tenants.size();
   }

   // ================================================================================
   // other stuff...
   // ================================================================================
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

   public final ArrayList<Meter> getMeters() {
      return meters;
   }

   public final void setMeters(final ArrayList<Meter> meters) {
      this.meters = meters;
   }

   public final ArrayList<Tenant> getTenants() {
      return tenants;
   }

   public final void setTenants(final ArrayList<Tenant> tenants) {
      this.tenants = tenants;
   }

}
