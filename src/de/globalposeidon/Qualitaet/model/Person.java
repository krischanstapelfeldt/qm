package de.globalposeidon.Qualitaet.model;

import java.util.ArrayList;

public class Person {
	
	String name;
	String surname;
	String phone;
	String email;
	
//================================================================================
// constructor
//================================================================================
	public Person() {
		// some standard value for empty person
		this("Barrack", "Obama", "123789223", "oToTheB@usa.de");
	}
	
	public Person(String name, String surname, String phone, String email) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}
//================================================================================
// getter setter
//================================================================================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		return (surname + ", " + name + " " + phone + " " + email);
	}
}
