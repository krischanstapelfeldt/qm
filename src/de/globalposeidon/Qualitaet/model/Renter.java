package de.globalposeidon.Qualitaet.model;

/**
 * renter model.
 * @author Timm
 *
 */
public class Renter extends Person {

// ================================================================================
// constructor
// ================================================================================
	public Renter() {
		// some standard value for empty person
		super();
	}

	public Renter(final String name, final String surname, final String phone, final String email) {
		super(name, surname, phone, email);
	}

}
