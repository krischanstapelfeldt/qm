package de.globalposeidon.Qualitaet.model;

public class Tenant extends Person {
	// ================================================================================
	// constructor
	// ================================================================================
	public Tenant() {
		// some standard value for empty person
		super();
	}

	public Tenant(final String name, final String surname, final String phone, final String email) {
		super(name, surname, phone, email);
	}

}
