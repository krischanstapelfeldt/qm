package de.globalposeidon.Qualitaet.model;

/*
 * Class that contains all data for this project
 */

public class DataContainer {
	
	public Building building1; 

	public DataContainer(){
		// lets get this motherfucker some data!
		// create persons
		Renter renter1 = new Renter("Helmerichs", "Hans", "7645252", "abc@web.de");
		Renter renter2 = new Renter("Plattfeld", "Jan", "847545", "sehrPlatt@web.de");
		Tenant tenant1 = new Tenant("Steffens", "Sarah", "982478", "ss@web.de");
		Tenant tenant2 = new Tenant("Steffens", "Sarah", "982478", "ss@web.de");
		Tenant tenant3 = new Tenant("Steffens", "Sarah", "982478", "ss@web.de");
		Tenant tenant4 = new Tenant("Steffens", "Sarah", "982478", "ss@web.de");
		Tenant tenant5 = new Tenant("Steffens", "Sarah", "982478", "ss@web.de");
		
		// create building
		this.building1 = new Building();
		// and add renter
		this.building1.setRenter(renter1);
		
		// create entrances
		Entrance entrance1 = new Entrance();
		Entrance entrance2 = new Entrance();
		// and add them to the building
		this.building1.addEntrance(entrance1);
		this.building1.addEntrance(entrance2);
		
		// create apartments
		Apartment apartment1 = new Apartment();
		Apartment apartment2 = new Apartment();
		Apartment apartment3 = new Apartment();
		// and add them to the entrances
		entrance1.addApartment(apartment1);
		entrance1.addApartment(apartment2);
		entrance2.addApartment(apartment3);
		
		// create Meters
		Meter meter1 = new Meter(001, Metertype.GAS);
		Meter meter1b = new Meter(002, Metertype.POWER);
		Meter meter2 = new Meter(003, Metertype.GAS);
		Meter meter2b = new Meter(004, Metertype.POWER);
		Meter meter2c = new Meter(005, Metertype.WATER);
		Meter meter3 = new Meter(006, Metertype.GAS);
		Meter meter3b = new Meter(007, Metertype.POWER);
		// and add them to the apartments
		apartment1.addMeter(meter1); apartment1.addMeter(meter1b);
		apartment2.addMeter(meter2); apartment2.addMeter(meter2b); apartment2.addMeter(meter2c);
		apartment3.addMeter(meter3); apartment3.addMeter(meter3b);
		
		// ...finally make persons live in the apartments
		apartment1.addTenant(tenant1); apartment1.addTenant(tenant2);
		apartment2.addTenant(tenant3);
		apartment3.addTenant(tenant4); apartment3.addTenant(tenant5);
		
		// and print this motherfucker
		System.out.print(this.building1);
	}
}
