import java.util.HashMap;
import java.util.Map;

public class Board {
    //The array of tiles that players will move around on
    private Tile[] tileList;

    //Map where Key is player name and Value is player Location
    private Map playerLocations = new HashMap<Token,Integer>(); 

    //Takes in list of players, assigns them all a starting location at 0
    public Board(Token[] players) {
        tileList = new Tile[36];
        for(Token p : players)
        {
            playerLocations.put(p,0);
        }
    }
}
