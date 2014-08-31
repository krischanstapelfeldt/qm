package de.globalposeidon.Qualitaet.model;

import java.util.Random;

/**
 * person model.
 * @author Timm Suhl
 */
public class Person implements java.io.Serializable {

   /**
    *
    */
   private static final long serialVersionUID = 1L;
   private int id;
   private final Random random = new Random();

   private String name;
   private String surname;
   private String phone;
   private String email;

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * Konstruktor.
    */
   public Person() {
      // some standard value for empty person
      this("Barrack", "Obama", "123789223", "oToTheB@usa.de");
      id = random.nextInt();
   }

   /**
    * Konstruktor.
    * @param name
    *           name
    * @param surname
    *           nachname
    * @param phone
    *           telefon
    * @param email
    *           mail
    */
   public Person(final String name, final String surname, final String phone, final String email) {
      this.name = name;
      this.surname = surname;
      this.phone = phone;
      this.email = email;
   }

   // ================================================================================
   // getter setter
   // ================================================================================
   /**
    * ID erhalten.
    * @return ID
    */
   public final int getID() {
      return id;
   }

   /**
    * Namen erhalten.
    * @return Name
    */
   public final String getName() {
      return name;
   }

   /**
    * Name setzen.
    * @param name
    *           name
    */
   public final void setName(final String name) {
      this.name = name;
   }

   /**
    * Nachname erhalten.
    * @return nachname
    */
   public final String getSurname() {
      return surname;
   }

   /**
    * Nachname setzen.
    * @param surname
    *           nachname
    */
   public final void setSurname(final String surname) {
      this.surname = surname;
   }

   /**
    * Telefonnummer erhalten.
    * @return telefonnummer
    */
   public final String getPhone() {
      return phone;
   }

   /**
    * Telefonnummer setzen.
    * @param phone
    *           telefonnummer
    */
   public final void setPhone(final String phone) {
      this.phone = phone;
   }

   /**
    * Email erhalten.
    * @return mail
    */
   public final String getEmail() {
      return email;
   }

   /**
    * Email setzen.
    * @param email
    *           mail
    */
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
