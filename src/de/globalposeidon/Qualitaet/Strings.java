package de.globalposeidon.Qualitaet;

/**
 * String class for central string management.
  * @author Sebastian Lauber
 */

public final class Strings {
   /**
    * prevents calls from subclass.
    */
   protected Strings() {
      throw new UnsupportedOperationException();
   }

   // basic terms
   public static final String ABOUT = "about";
   public static final String ADDWSPACE = "add ";
   public static final String ADRESS = "adress";
   public static final String APARTMENT = "apartment";
   public static final String BUILDING = "building";
   public static final String CANCEL = "cancel";
   public static final String CLOSE = "close";
   public static final String CURRENTVALUE = "currentvalue";
   public static final String DELWSPACE = "delete ";
   public static final String DETAILS = "details";
   public static final String EDIT = "Edit";
   public static final String EMAIL = "email";
   public static final String ENTRANCE = "entrance";
   public static final String FAQ = "FAQ";
   public static final String FILE = "File";
   public static final String FIRSTNAME = "first name";
   public static final String GLOBALPOSEIDON = "Global Poseidon";
   public static final String HELP = "Help";
   public static final String HOUSENO = "House no.";
   public static final String LASTREAD = "lastread";
   public static final String MAKEREADING = "make reading";
   public static final String METER = "meter";
   public static final String METERTYPE = "metertype";
   public static final String NAME = "name";
   public static final String OPENWSPACE = "open ";
   public static final String PHONE = "phone";
   public static final String READING = "reading";
   public static final String READINGINFO = "reading info";
   public static final String READINGPERSON = "reading person";
   public static final String RENTED = "rented";
   public static final String RENTER = "renter";
   public static final String OK = "OK";
   public static final String SAVE = "save";
   public static final String SEARCH = "search";
   public static final String SORT = "sort";
   public static final String STREET = "street";
   public static final String SURNAME = "surname";
   public static final String TENANT = "tenant";
   public static final String TOWN = "town";
   public static final String UNRENTED = "unrented";
   public static final String UNSORTED = "unsorted";
   public static final String VALUE = "value";
   public static final String YEARVALUE = "yearvalue";
   public static final String ZIP = "ZIP Code";

   // advanced terms
   public static final String ADDAPARTMENT = ADDWSPACE + APARTMENT;
   public static final String ADDBUILDING = ADDWSPACE + BUILDING;
   public static final String ADDENTRANCE = ADDWSPACE + ENTRANCE;
   public static final String ADDRENTER = ADDWSPACE + RENTER;
   public static final String ADDTENANT = ADDWSPACE + TENANT;
   public static final String ADDMETER = ADDWSPACE + METER;
   public static final String ADRESSDETAILS = ADRESS + " " + DETAILS;
   public static final String APARMENTNAME = APARTMENT + " " + "name";
   public static final String BUILDINGNAME = BUILDING + " name";
   public static final String DELAPARTMENT = DELWSPACE + APARTMENT;
   public static final String DELBUILDING = DELWSPACE + BUILDING;
   public static final String DELENTRANCE = DELWSPACE + ENTRANCE;
   public static final String DELRENTER = DELWSPACE + RENTER;
   public static final String DELTENANT = DELWSPACE + TENANT;
   public static final String METERDETAILS = METER + " " + DETAILS;
   public static final String METERID = METER + " ID";
   public static final String METERREADINGVALUE = METER + " " + READING + " " + VALUE;
   public static final String METERSEARCH = METER + " search";
   public static final String OPENJENKINS = OPENWSPACE + "Jenkins";
   public static final String OPENJUNITJENKINS = OPENWSPACE + "JUnit report on Jenkins";
   public static final String OPENJACOCOJENKINS = OPENWSPACE + "JaCoCo report on Jenkins";
   public static final String OPENMANTIS = OPENWSPACE + "Mantis";
   public static final String OPENTESTLINK = OPENWSPACE + "Testlink";
   public static final String READINGVALUE = READING + " " + VALUE;
   public static final String RENTERDETAILS = RENTER + " " + DETAILS;
   public static final String SORTBYUNRENTED = "sort by " + RENTED + "/" + UNRENTED;
   public static final String TENANTDETAILS = TENANT + " " + DETAILS;

   // int Terms
   public static final int ZERO = 0;
   public static final int ONE = 1;
   public static final int TWO = 2;
   public static final int THREE = 3;
   public static final int FOUR = 4;
   public static final int FIVE = 5;
   public static final int SIX = 6;
   public static final int SEVEN = 7;
   public static final int EIGHT = 8;
   public static final int NINE = 9;
   public static final int TEN = 10;
   public static final int THIRTY = 30;
   public static final int ONE_HUNDRED = 100;
}
