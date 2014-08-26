package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Person;

/**
 * This class contains the tests for the person class.
 * @author Krischan Stapelfeldt
 */
public class PersonTest extends TestCase {

   private Person person;
   private String name;
   private String surname;
   private String phone;
   private String email;

   @Override
   @Before
   /**
    * Ramps the necessary objects up (name, surname, phone, email, person
    * object)
    * @throws Throws an exception, when setup fails
    */
   public final void setUp() throws Exception {

      final Timestamp tstamp = new Timestamp(System.currentTimeMillis());

      name = "Mustermann" + tstamp;
      surname = "Max";
      phone = "01234/5678912";
      email = "max@mustermann.de";
      person = new Person(name, surname, phone, email);
   }

   @Override
   @After
   public void tearDown() throws Exception {
   }

   /**
    * create two new persons. one with specific data, one with empty data. insert into database.
    */
   @Test
   public final void testPositiveCreatePerson() {

      Person personEmpty = new Person();
      assertEquals("", true, person);
      assertEquals("", true, personEmpty);

   }

   /**
    * get name from selected persons. load from database.
    */
   @Test
   public final void testPositiveGetName() {

      assertEquals("", name, person.getName());

   }

   /**
    * set name for selected person. insert into database.
    */
   @Test
   public final void testPositiveSetName() {
      person.setName(person.getName() + "Addon");
      assertEquals("", name + "Addon", person.getName());

   }

   /**
    * get surname from selected persons. load from database.
    */
   @Test
   public final void testPositiveGetSurname() {

      assertEquals("", surname, person.getSurname());

   }

   /**
    * set surname for selected person. insert into database.
    */
   @Test
   public final void testPositiveSetSurname() {
      person.setSurname(person.getSurname() + "Addon");
      assertEquals("", surname + "Addon", person.getSurname());

   }

   /**
    * get phone from selected persons. load from database.
    */
   @Test
   public final void testPositiveGetPhone() {

      assertEquals("", phone, person.getPhone());

   }

   /**
    * set phone for selected person. insert into database.
    */
   @Test
   public final void testPositiveSetPhone() {
      person.setPhone(person.getPhone() + "000000001");
      assertEquals("", phone + "000000001", person.getPhone());

   }

   /**
    * get email from selected persons. load from database.
    */
   @Test
   public final void testPositiveGetEmail() {

      assertEquals("", email, person.getEmail());

   }

   /**
    * set email for selected person. insert into database.
    */
   @Test
   public final void testPositiveSetEmail() {
      person.setEmail(person.getEmail() + "000000001");
      assertEquals("", email + "000000001", person.getEmail());

   }

   /**
    * get person with data from database.
    */
   @Test
   public final void testPositiveGetPerson() {

      assertEquals("", surname + ", " + name + " " + phone + " " + email, person.toString());

   }

}
