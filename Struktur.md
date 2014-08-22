#Allgemein


#Klassen

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
- Reading
	- id (int)
	- meterId (int)
	- date (Date)
	- value (int)
	- ReadingInfo (enum)
	- MeterReader (enum)
- Person
	- name (String)
	- surname (String)
	- phone (String)
	- email (String)
- renter (person subclass)
- tenant (person subclass)

#Enums

- MeterReader (Hauswart, Mieter, Energieversorger)
- ReadingInfo (Ablesung, Schätzung)
- MeterType (Strom, Gas, Wasser)
 
#Funktionen

siehe Klassendiagramm


##Geschäftslogik

- readMeter(int newValue, date readingDate)