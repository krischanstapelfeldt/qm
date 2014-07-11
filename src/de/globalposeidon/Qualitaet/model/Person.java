package de.globalposeidon.Qualitaet.model;

public class Person {
	
	String name;
	String surname;
	String phone;
	String email;
	
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
		return (surname + ", " + name + "\n" + phone + " " + email);
	}
}
