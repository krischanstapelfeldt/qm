package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * building model.
 * @author Timm Suhl
 */
public class Building extends DefaultMutableTreeNode implements java.io.Serializable{

   /**
    * .
    */
   private static final long serialVersionUID = 2774534346650927893L;
   private final int id;
   private final DataContainer dc; // parent node
   private final Random random = new Random();

   private Renter renter;
   private ArrayList<Entrance> entrances;

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * .
    * @param dc
    */
   public Building(final DataContainer dc) {
      entrances = new ArrayList<Entrance>();
      id = random.nextInt();
      this.dc = dc;
   }

   // ================================================================================
   // access private variables
   // ================================================================================
   /**
    * .
    * @return
    */
   public final int getID() {
      return id;
   }
   /**
    * .
    * @return
    */
   public final Renter getRenter() {
      return renter;
   }
   /**
    * .
    * @param renter
    */
   public final void setRenter(final Renter renter) {
      this.renter = renter;

   }
   /**
    * .
    * @param entrance
    */
   public final void addEntrance(final Entrance entrance) {
      entrances.add(entrance);
   }
   /**
    * .
    * @param index
    * @return
    */
   public final Entrance removeEntrance(final int index) {
      if (index >= 0 && index < entrances.size()) {
         if (getEntrance(index).entranceIsEmpty()) {
            return entrances.remove(index);
         }
      }
      return null;
   }
   /**
    * .
    * @param index
    * @return
    */
   public final Entrance getEntrance(final int index) {
      if (index >= 0 && index < entrances.size()) {
         return entrances.get(index);
      }
      return null;
   }
   /**
    * .
    * @return
    */
   public final int entranceCount() {
      return entrances.size();
   }

   // ================================================================================
   // other stuff...
   // ================================================================================
   /**
    * .
    * @return
    */
   public final boolean buildingIsEmpty() {
      return entrances.size() == 0;
   }

   @Override
   public final String toString() {
      return "Building " + getID();
   }

   // ================================================================================
   // TreeNode Interface
   // ================================================================================
   @Override
   public final TreeNode getChildAt(final int childIndex) {
      return entrances.get(childIndex);
   }

   @Override
   public final int getChildCount() {
      return entrances.size();
   }

   @Override
   public final TreeNode getParent() {
      return dc;
   }

   @Override
   public final int getIndex(final TreeNode node) {
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
   public final Enumeration<Entrance> children() {
      return Collections.enumeration(entrances);
   }
   /**
    * .
    * @return
    */
   public final ArrayList<Entrance> getEntrances() {
      return entrances;
   }
   /**
    * .
    * @param entrances
    */
   public final void setEntrances(final ArrayList<Entrance> entrances) {
      this.entrances = entrances;
   }
}
