/**
 * A CharacterTracker object can be used to keep track of the
 * number of "uses" of each upper-case letter in the English
 * alphabet.
 * 
 * It behaves like an accumulator array and a lookup array.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class CharacterTracker {

   private int[] count;

   /**
    * Default Constructor.
    */
   public CharacterTracker() {
      this.count = new int[26];
   }

   /**
    * Get the current number of "uses" for a particular character.
    * 
    * @param c  The char of interest
    * @return The number of uses
    */
   public int getCount(char c) {
      return count[toIndex(c)];
   }

   /**
    * Increase (by one) the current number of "uses" for a particular 
    * character.
    * 
    * @param c  The char of interest
    */
   public void increase(char c) {
      count[toIndex(c)]++;
   }

   /**
    * Decrease (by one) the current number of "uses" for a particular 
    * character.
    * 
    * @param c  The char of interest
    */
   public void reduce(char c) {
      count[toIndex(c)]--;
   }

   /**
    * Set the current number of "uses" for every character.
    * 
    * @param value  The number of "uses"
    */
   public void setAll(int value) {
      for (int i = 0; i < count.length; i++) { 
         count[i] = value;
      }
   }

   /**
    * Get the index (in a 0-based array) for a particular character.
    * 
    * @param c  The char of interest
    * @return The index (in the interval [0, 25])
    */
   public static int toIndex(char c) {
      String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      return uppers.indexOf(c);
   }
}
