package de.globalposeidon.Qualitaet;

/**
 * Int class for central int management.
 * 
 * @author Jens-Rainer Felske
 */
public enum Ints {
   ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), THIRTY(30);

   Ints(int value) {
      this.value = value;
   }

   public final int value;

   public int value() {
      return value;
   }
}
