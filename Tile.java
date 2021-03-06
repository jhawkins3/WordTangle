/**
 * An encapsulation of a Tile in the game WordTangle.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class Tile {
   private static final int NORTH = 0;

   private static final int SOUTH = 1;

   private static final int EAST  = 2;

   private static final int WEST  = 3;

   private boolean initialized;
   private char letter;
   private Tile[] neighbors;

   /**
    * Explicit Value Constructor.
    * 
    * @param letter The letter associated with the Tile.
    */
   public Tile(char letter) {
      if (Character.toString(letter) != null) {
         this.letter = letter;
      }
   }

   /**
    * Get the letter associated with this Tile.
    * 
    * @return The letter
    */
   public char getLetter() {
      return this.letter;
   }

   /**
    * Initialize this Tile (i.e., assign all of its neighbors).
    * Note: This method must/does only change the attributes
    * of this Tile the first time it is invoked. Subsequent
    * invocations are ignored.
    * 
    * @param north This Tile object's north neighbor
    * @param south This Tile object's south neighbor
    * @param east  This Tile object's east neighbor
    * @param west  This Tile object's west neighbor
    */
   public void initialize(Tile north, Tile south, Tile east, Tile west) {
      if (!initialized) {
         neighbors = new Tile[4];
         neighbors[NORTH] = north;
         neighbors[SOUTH] = south;
         neighbors[EAST] = east;
         neighbors[WEST] = west;
         
         // initialize() method has been called, set variable to true
         initialized = true;
      }
   }

   /**
    * Determine if this Tile has the given Tile as a neighbor.
    * 
    * @param tile The other Tile
    * @return true if this Tile has the other Tile as a neighbor
    */
   public boolean hasNeighbor(Tile tile) {
      // Verify tile is not null
      if (tile != null) { 
         if (tile.equals(neighbors[NORTH]) || tile.equals(neighbors[SOUTH]) 
             || tile.equals(neighbors[EAST]) || tile.equals(neighbors[WEST])) {
            return true;
         }
      }
      return false;
   }

   /**
    * Determine if this Tile object has been initialized.
    * 
    * @return true if it has been initialized; false otherwise
    */
   public boolean wasInitialized() {
      return initialized;
   }
}
