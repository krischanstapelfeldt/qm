package de.globalposeidon.Qualitaet.model;

/**
 * renter model.
 * @author Timm Suhl
 */
public class Renter extends Person {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * Konstruktor.
    */
   public Renter() {
      // some standard value for empty person
      super();
   }

   /**
    * Konstruktor.
    * @param name
    *           name
    * @param surname
    *           nachname
    * @param phone
    *           telefon
    * @param email
    *           mail
    */
   public Renter(final String name, final String surname, final String phone, final String email) {
      super(name, surname, phone, email);
   }

}
