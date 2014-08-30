package de.globalposeidon.Qualitaet.model;

/**
 * tenant model.
 * @author Timm Suhl
 */
public class Tenant extends Person {

   // ================================================================================
   // constructor
   // ================================================================================
   /**
    * Konstruktor.
    */
    public Tenant() {
      // some standard value for empty person
      super();
   }
    /**
     * Konstruktor.
     * @param name name
     * @param surname nachname
     * @param phone telefon
     * @param email mail
     */
   public Tenant(final String name, final String surname, final String phone, final String email) {
      super(name, surname, phone, email);
   }

}
