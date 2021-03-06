/**
 * An encapsulation of a single game of WordTangle.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class Game {
   private int height;
   private int numberOfRounds;
   private int width;
   private Tile[] starts;
   private Tile[] tiles;
   private String[] answers;
   private String[] hints;

   /**
    * Explicit Value Constructor.
    * 
    * Note: The hints, answers, and starts arrays are conformal
    * and have as many elements as there are rounds in the Game.
    * 
    * @param width   The width of the board/grid (in tiles/letters)
    * @param height  The height of the board/grid (in tiles/letters)
    * @param tiles   All of the Tile objects in the board/grid
    * @param hints   The hints for all of the rounds
    * @param answers The answers for all of the rounds
    * @param starts  The starting Tile objects for all of the rounds
    */
   public Game(int width, int height, Tile[] tiles,
       String[] hints, String[] answers, Tile[] starts) {
      this.width = width;
      this.height = height;
      this.tiles = tiles;
      this.hints = hints;
      this.answers = answers;
      this.starts = starts;
      this.numberOfRounds = hints.length;
   }

   /**
    * Get the answer for a particular round.
    * 
    * @param round The round
    * @return The answer (or null if the round is out of range)
    */
   public String getAnswer(int round) {
      // If round isn't 0 and round is less than number of rounds...
      if ((round >= 0) && (round <= numberOfRounds - 1)) {
         return answers[round];
      }
      return null;
   }

   /**
    * Get the height of the board/grid.
    * 
    * @return The height
    */
   public int getHeight() {
      return this.height;
   }

   /**
    * Get the hint for a particular round.
    * 
    * @param round The round
    * @return The hint  (or null if the round is out of range)
    */
   public String getHint(int round) {
      if ((round >= 0) && (round <= numberOfRounds - 1)) {
         return hints[round];
      }
      return null;
   }

   /**
    * Get the number of rounds in this Game.
    * 
    * @return The number of rounds
    */
   public int getNumberOfRounds() {
      return this.numberOfRounds;
   }

   /**
    * Get the starting Tile for a particular round.
    * 
    * @param round The round
    * @return The Tile  (or null if the round is out of range)
    */
   public Tile getStart(int round) {
      if ((round >= 0) && (round <= numberOfRounds - 1)) {
         return starts[round];
      }
      return null;
   }

   /**
    * Get all of the Tile objects in the board/grid.
    * 
    * @return The Tile objects
    */
   public Tile[] getTiles() {
      return this.tiles;
   }

   /**
    * Get the width of the board/grid.
    * 
    * @return The width
    */
   public int getWidth() {
      return this.width;
   }
}
