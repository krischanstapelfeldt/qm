package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Person;
/**
 * This class contains the tests for the person class
 * @author Krischan Stapelfeldt
 *
 */
public class PersonTest extends TestCase {

	Person person;
	Person personEmpty;
	String name;
	String surname;
	String phone;
	String email;

	/**
	 * Ramps the necessary objects up (name, surname, phone, email, person object)
	 */
	@Before
	public void setUp() throws Exception {

		Timestamp tstamp = new Timestamp(System.currentTimeMillis());

		name = "Mustermann" + tstamp;
		surname = "Max";
		phone = "01234/5678912";
		email = "max@mustermann.de";
		person = new Person(name, surname, phone, email);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * create two new persons. one with specific data, one with empty data. insert into database.
	 */
	@Test
	public void testPositiveCreatePerson() {

		assertEquals("", true, person);
		assertEquals("", true, personEmpty = new Person());

	}

	/**
	 * get name from selected persons. load from database.
	 */
	@Test
	public void testPositiveGetName() {

		assertEquals("", name, person.getName());

	}

	/**
	 * set name for selected person. insert into database.
	 */
	@Test
	public void testPositiveSetName() {
		person.setName(person.getName() + "Addon");
		assertEquals("", name + "Addon", person.getName());

	}

	/**
	 * get surname from selected persons. load from database.
	 */
	@Test
	public void testPositiveGetSurname() {

		assertEquals("", surname, person.getSurname());

	}

	/**
	 * set surname for selected person. insert into database.
	 */
	@Test
	public void testPositiveSetSurname() {
		person.setSurname(person.getSurname() + "Addon");
		assertEquals("", surname + "Addon", person.getSurname());

	}

	/**
	 * get phone from selected persons. load from database.
	 */
	@Test
	public void testPositiveGetPhone() {

		assertEquals("", phone, person.getPhone());

	}

	/**
	 * set phone for selected person. insert into database.
	 */
	@Test
	public void testPositiveSetPhone() {
		person.setPhone(person.getPhone() + "000000001");
		assertEquals("", phone + "000000001", person.getPhone());

	}

	/**
	 * get email from selected persons. load from database.
	 */
	@Test
	public void testPositiveGetEmail() {

		assertEquals("", email, person.getEmail());

	}

	/**
	 * set email for selected person. insert into database.
	 */
	@Test
	public void testPositiveSetEmail() {
		person.setEmail(person.getEmail() + "000000001");
		assertEquals("", email + "000000001", person.getEmail());

	}

	/**
	 * get person with data from database.
	 */
	@Test
	public void testPositiveGetPerson() {

		assertEquals("", surname + ", " + name + " " + phone + " " + email,
				person.toString());

	}

}