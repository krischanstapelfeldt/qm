Klassen
=
- BuildingStructure
	- 1..n Building
- Building
	- 1 renter
	- 1...n entrance 
- Entrance
	- 0...n meter
	- 1...n apartment
- Apartment
	- 1...n meter
	- 0...n tentant
- Meter
	- date (date)
	- value (int)
	- valueFirst (int) //Wert am 1.1. jedes Jahres
	- id (int)
	- MeterType (Strom, Gas, Wasser)
	
- Person
	- name (String)
	- surname (String)
	- phone (String)
	- email (String)
	- renter (subclass)
	- tenant (subclass)

Enums
=
- MeterReader (Hauswart, Mieter, Energieversorger)
- ReadingInfo (Ablesung, Schätzung)

Funktionen
=
Enumerationsoperationen
-
- listBuilding()
- listApartment(int buildingID)
- listEntrance(int apartmentID)
- listMeter(int entranceID)

Datenmanipulation
-
*Hinzufügen*

- addBuilding()
- addApartment()
- addEntrance()
- addMeter()

*Löschen*

- deleteBuilding()
- deleteApartment()
- deleteEntrance()
- deleteMeter()


Geschäftslogik
-
- readMeter(int newValue, date readingDate)