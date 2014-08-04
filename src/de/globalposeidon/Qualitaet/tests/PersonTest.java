package de.globalposeidon.Qualitaet.tests;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.globalposeidon.Qualitaet.model.Person;

public class PersonTest extends TestCase {

	Person person;
	Person personEmpty;
	String name;
	String surname;
	String phone;
	String email;

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
	 * testPositiveCreatePerson()
	 * 
	 * @result create two new persons. one with specific data, one with empty
	 *         data. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveCreatePerson() {

		assertEquals("", true, person);
		assertEquals("", true, personEmpty = new Person());

	}

	/**
	 * testPositiveGetName()
	 * 
	 * @result get name from selected persons. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetName() {

		assertEquals("", name, person.getName());

	}

	/**
	 * testPositiveSetName()
	 * 
	 * @result set name for selected person. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveSetName() {
		person.setName(person.getName() + "Addon");
		assertEquals("", name + "Addon", person.getName());

	}

	/**
	 * testPositiveGetSurname()
	 * 
	 * @result get surname from selected persons. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetSurname() {

		assertEquals("", surname, person.getSurname());

	}

	/**
	 * testPositiveSetSurname()
	 * 
	 * @result set surname for selected person. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveSetSurname() {
		person.setSurname(person.getSurname() + "Addon");
		assertEquals("", surname + "Addon", person.getSurname());

	}

	/**
	 * testPositiveGetPhone()
	 * 
	 * @result get phone from selected persons. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetPhone() {

		assertEquals("", phone, person.getPhone());

	}

	/**
	 * testPositiveSetPhone()
	 * 
	 * @result set phone for selected person. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveSetPhone() {
		person.setPhone(person.getPhone() + "000000001");
		assertEquals("", phone + "000000001", person.getPhone());

	}

	/**
	 * testPositiveGetEmail()
	 * 
	 * @result get email from selected persons. load from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetEmail() {

		assertEquals("", email, person.getEmail());

	}

	/**
	 * testPositiveSetEmail()
	 * 
	 * @result set email for selected person. insert into database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveSetEmail() {
		person.setEmail(person.getEmail() + "000000001");
		assertEquals("", email + "000000001", person.getEmail());

	}

	/**
	 * testPositiveGetPerson()
	 * 
	 * @result get person with data from database.
	 * @author Krischan
	 */
	@Test
	public void testPositiveGetPerson() {

		assertEquals("", surname + ", " + name + " " + phone + " " + email,
				person.toString());

	}

}