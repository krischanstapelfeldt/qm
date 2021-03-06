package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.UUID;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * datacontainer model.
 * @author Timm Suhl
 */
public class DataContainer extends DefaultMutableTreeNode {

   private static final long serialVersionUID = -2235030663900376387L;
   private final UUID uuid;
   private final ArrayList<Building> buildings;
   private int meterCounter;

   /**
    * Konstruktor.
    */
   public DataContainer() {
      buildings = new ArrayList<>(1);
      uuid = UUID.randomUUID();
      setMeterCounter(0);
   }

   /**
    * Gebaude hinzufuegen.
    * @param building
    *           Gebauede
    */
   public final void addBuilding(final Building building) {
      buildings.add(building);
   }

   /**
    * Gebaude erhalten.
    * @param index
    *           index
    * @return Gebauede
    */
   public final Building getBuilding(final int index) {
      return buildings.get(index);
   }

   /**
    * Gebaude entfernen.
    * @param building
    *           Gebauede
    * @return Wurde das Gebaude entfernt?
    */
   public final boolean removeBuilding(final Building building) {
      return buildings.remove(building);
   }

   /**
    * Anzahl der Gebaude.
    * @return Anzahl Gebaeude
    */
   public final int getBuildingCount() {
      return buildings.size();
   }

   /**
    * ID vom Gebauede.
    * @param index
    *           index
    * @return ID
    */
   public final int getBuildingID(final int index) {
      return buildings.get(index).getID();
   }

   /**
    * Counter fuer Zaehler erhoehen.
    * @return Anzahl
    */
   public final int incMeterCnt() {
      return meterCounter++;
   }

   @Override
   public final String toString() {
      return uuid.toString();
   }

   // ================================================================================
   // TreeNode Interface
   // ================================================================================
   @Override
   public final TreeNode getChildAt(final int childIndex) {
      return buildings.get(childIndex);
   }

   @Override
   public final int getChildCount() {
      return buildings.size();
   }

   @Override
   public final TreeNode getParent() {
      return null;
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
   public final Enumeration<Building> children() {
      return Collections.enumeration(buildings);
   }

   /**
    * Anzahl der Zaehler.
    * @return Anzahl
    */
   public final int getMeterCounter() {
      return meterCounter;
   }

   /**
    * .
    * @param meterCounter
    *           Counter setzen
    */
   public final void setMeterCounter(final int meterCounter) {
      this.meterCounter = meterCounter;
   }
}
