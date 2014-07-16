package de.globalposeidon.Qualitaet.model;

public class Tenant extends Person {
//================================================================================
// constructor
//================================================================================
	public Tenant() {
		// some standard value for empty person
		super();
	}
	
	public Tenant(String name, String surname, String phone, String email) {
		super(name, surname, phone, email);
	}	

}
