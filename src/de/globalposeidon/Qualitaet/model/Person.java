package de.globalposeidon.Qualitaet.model;

import java.util.Random;

/**
 * person model.
 * @author Timm Suhl
 */
public class Person implements java.io.Serializable{

   private int id;
   private final Random random = new Random();

   private String name;
   private String surname;
   private String phone;
   private String email;

   // ================================================================================
   // constructor
   // ================================================================================
   public Person() {
      // some standard value for empty person
      this("Barrack", "Obama", "123789223", "oToTheB@usa.de");
      id = random.nextInt();
   }

   public Person(final String name, final String surname, final String phone, final String email) {
      this.name = name;
      this.surname = surname;
      this.phone = phone;
      this.email = email;
   }

   // ================================================================================
   // getter setter
   // ================================================================================
   public final int getID() {
      return id;
   }

   public final String getName() {
      return name;
   }

   public final void setName(final String name) {
      this.name = name;
   }

   public final String getSurname() {
      return surname;
   }

   public final void setSurname(final String surname) {
      this.surname = surname;
   }

   public final String getPhone() {
      return phone;
   }

   public final void setPhone(final String phone) {
      this.phone = phone;
   }

   public final String getEmail() {
      return email;
   }

   public final void setEmail(final String email) {
      this.email = email;
   }

   // ================================================================================
   // other stuff, dont know nice name
   // ================================================================================
   @Override
   public final String toString() {
      return (surname + ", " + name + " " + phone + " " + email);
   }
}
