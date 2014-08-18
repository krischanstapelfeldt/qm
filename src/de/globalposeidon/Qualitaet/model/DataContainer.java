package de.globalposeidon.Qualitaet.model;

/*
 * Class that contains all data for this project
 */

public class DataContainer {
	
	public BuildingStructure buildingStruct; 

	public DataContainer(){
		//lets get this motherfucker some data!
		Tenant tenant1 = new Tenant();
		Meter meter1 = new Meter(001, Metertype.GAS);
		Apartment apartment1 = new Apartment(meter1, tenant1);
		Entrance entrance1 = new Entrance(apartment1);
		Renter renter1 = new Renter();
		Building initialBuilding = new Building(renter1, entrance1);
		this.buildingStruct = new BuildingStructure(initialBuilding);
		
		// and more!
		Tenant tenant2 = new Tenant();
		Tenant tenant2a = new Tenant("Jessi", "j", "541651", "jj@web.de");
		Tenant tenant2b = new Tenant("Hans", "Wurst", "8123651", "88@web.de");
		Tenant tenant2c = new Tenant("Sebastian", "Stapelfeldt", "684157887", "reger8@web.de");
		Tenant tenant2d = new Tenant("Steffen", "Gölle", "64651", "lgiwe@web.de");
		Meter meter2 = new Meter(001, Metertype.GAS);
		Apartment apartment2 = new Apartment(meter2, tenant2);
		apartment2.addTenant(tenant2a); apartment2.addTenant(tenant2b);
		Apartment apartment2a = new Apartment(meter2);
		apartment2a.addTenant(tenant2c); apartment2a.addTenant(tenant2d);
		Entrance entrance2 = new Entrance(apartment2);
		entrance2.addApartment(apartment2a);
		Renter renter2 = new Renter();
		Building building2 = new Building(renter2, entrance2);
		this.buildingStruct.addBuilding(building2);
		
		// and print this motherfucker
		System.out.print(this.buildingStruct);
	}
}
