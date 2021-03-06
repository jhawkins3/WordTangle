/**
 * The main class for the WordTangle game.
 * 
 * @author Ben Hawkins
 * @version 1.0
 */
public class WordTangle {

   /**
    * The entry point of the application.
    * 
    * The command line arguments are a segmented/packed array. Each
    * record consists of the name of the file containing the Game
    * and a String representation of the number of undos allowed for
    * each letter (not Tile). -1 indicates that there are an infinite number
    * of undos. 
    * 
    * @param args The command line arguments (see above)
    */
   public static void main(String[] args) {
      // Example command "java WordTangle net.txt 3 cs.txt -1"
      //                  ---------------   [0]  [1]  [2]  [3]
      
      // Verify an even and non-zero number of arguments (args)
      if ((args.length >= 2) && (args.length % 2 == 0)) {

         GameDescriptor[] games = new GameDescriptor[args.length / 2];
         // For loop for every 2 arguments (total args divided by 2): 
         for (int i = 0; i < args.length / 2; i++)  {
         
            // The Game must be constructed using a GameFileReader that reads
            // "element 0" (string/filename)
            GameFileReader reader;
            reader = new GameFileReader(args[0 + (i * 2)]); 
            
            Game game = new Game(reader.getWidth(), reader.getHeight(), 
                                 reader.getTiles(), reader.getHints(), 
                                 reader.getAnswers(), reader.getStarts());
            
            // The CharacterTracker must have all of its elements
            // initialized to "element 1" (integer)
            CharacterTracker tracker;
            tracker = new CharacterTracker();
            
            tracker.setAll(Integer.parseInt(args[1 + (i * 2)])); 
            
            // Add GameDescriptor value to array of total games
            games[i] = new GameDescriptor(game, tracker);
         }
         
         // After constructing the array of GameDescriptor objects, 
         // here call runGames() in the GameRunner class
         GameRunner gr = new GameRunner();
         gr.runGames(games);
      }
   }
}
