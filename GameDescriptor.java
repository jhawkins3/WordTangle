/**
 * An encapsulation of all of the information needed to play
 * a game of WordTangle.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class GameDescriptor {
   private CharacterTracker undoTracker;
   private Game game;

   /**
    * Explicit Value Constructor.
    * 
    * @param game The Game
    * @param undoTracker The "undo" tracker to use
    */
   public GameDescriptor(Game game, CharacterTracker undoTracker) {
      this.game = game;
      this.undoTracker = undoTracker;
   }

   /**
    * Get the Game.
    * 
    * @return  The Game
    */
   public Game getGame() {
      return this.game;
   }

   /**
    * Get the "undo" tracker.
    * 
    * @return  The "undo" tracker
    */
   public CharacterTracker getUndoTracker() {
      return this.undoTracker;
   }
}
