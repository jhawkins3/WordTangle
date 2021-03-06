import java.util.Arrays;

/**
 * An encapsulation of a Guess in a Game of WordTangle.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class Guess {
   public static final int INCORRECT  = -1;

   public static final int INCOMPLETE =  0;

   public static final int CORRECT    =  1;

   private int    last;
   private String answer;
   private Tile[] tiles;

   /**
    * Explicit Value Constructor.
    * 
    * @param answer  The correct answer
    */
   public Guess(String answer) {
      this.answer = answer;
     
      tiles = new Tile[answer.length()];

   }

   /**
    * Add a Tile to the end of the Guess.
    * 
    * Note that this method must/does not add the Tile if it is 
    * already contained in the Guess or if it is not a neighbor
    * of the last tile.
    * 
    * @param tile  The Tile to add
    * @return Either  INCOMPLETE, INCORRECT, or CORRECT 
    */
   public int addTile(Tile tile) {
      int result = INCOMPLETE;
      boolean toAdd = true;
      int numValues = 0;
      
      // Dont add tile if it is already an element of the tiles array.
      for (int i = 0; i < tiles.length; i++) {
         if (tiles[i] == tile) {
            toAdd = false;
            result = INCORRECT;
         }
      }
        
      // Don't add tile if the tiles array is full.
      for (int i = 0; i < tiles.length; i++) {
         if (tiles[i] != null) {
            numValues++;
         }
      }
      if (numValues >= answer.length()) {
         toAdd = false;
      }
         
      // Don't add tile if Tile to be added is not a neighbor of the last
      // non-empty element of the tiles array.
      if (last != 0) {
         if (!(tile.hasNeighbor(tiles[last - 1]))) {
            toAdd = false;
            result = INCORRECT;
         }
      }
        
      // If toAdd is true, requirements are met to add tile
      if (toAdd) { 
         // Add title to last value (titles array index)
         tiles[last] = tile;
         last++;
      }

      // Return INCOMPLETE if Tiles length is less than answer length
      if (this.toString().equals(answer)) {
         result = CORRECT;
      } else if (numValues == answer.length() - 1) { 
         result = INCORRECT;
      }
      
      return result;
   }

   /**
    * Append a Tile (always), without checking the capacity.
    * 
    * @param tile  The Tile to append
    * @return
    */
   private void appendTile(Tile tile) {
      tiles[last] = tile;
      last++;
   }

   /**
    * Check to see if this Guess contains the given Tile.
    * 
    * @param tile  The Tile to look for
    * @return true if this Guess contains the Tile; false otherwise
    */
   public boolean contains(Tile tile) {
      return Arrays.asList(tiles).contains(tile);
   }

   /**
    * Get the last non-null Tile in the Guess.
    * 
    * @return The last non-null Tile
    */
   public Tile getLastTile() {
      if (last == 0) {
         return null;
      }
      return tiles[last - 1];
   }

   /**
    * Get all of the Tile objects (null and no-null) in this Guess.
    * 
    * @return All of the Tile objects
    */
   public Tile[] getTiles() {
      return tiles;
   }

   /**
    * Remove the last non-null Tile from this Guess.
    */
   public void removeTile() {
      
      // Verify that tiles is instantiated (not null)
      last--;
      tiles[last] = null;    
   }

   /**
    * Construct a String representation of this Guess.
    * non-null elements are represented by their character.
    * null elements are represented by an underscore ('_').
    * 
    * @return The String representation
    */
   @Override
   public String toString() {
      // Initialize empty string
      String guess = "";
      
      // Iterate through tiles array
      for (int i = 0; i < tiles.length; i++) { 
         if (tiles[i] == null) {
            guess += '_';
         } else {
            guess += tiles[i].getLetter();
         }
      }
      
      return guess;
         
   }
}
