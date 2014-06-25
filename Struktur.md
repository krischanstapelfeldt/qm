Klassen
=
- Building
	- 1 renter
	- 1...n entrance 
		- 0...n meter
		- 1...n apartment
			- 1...n meter
			- 0...n tenant
- Entrance
- Apartment
- Meter
	- date (date)
	- value (int)
	- valueFirst (int) //Wert am 1.1. jedes Jahres
	- id (int)
	- MeterType (Strom, Gas, Wasser)
	
- Person
	- name
	- surname
	- phone
	- email
	- renter (Vermieter)
	- tenant (Mieter)

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