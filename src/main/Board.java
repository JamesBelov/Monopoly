package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import tiles.*;
import util.RequestedPayoutExceedsTokenLiquidityException;
import util.Token;
import util.Color;

public class Board {
    //The array of tiles that players will move around on
    private  static Tile[] tileList;

    //Map where Key is player name and Value is player Location
    private static Map<Token,Integer> playerLocations = new HashMap<Token,Integer>(); 

    //Takes in list of players, assigns them all a starting location at 0
    public static void init(Token[] players) {
        tileList = new Tile[36];
        for(Token p : players)
        {
            playerLocations.put(p,0);
        }
    }

    public static void movePlayer(Token player, int diceRoll, Tile tile) throws RequestedPayoutExceedsTokenLiquidityException{

        if(tile == null){
            tile = tileList[(int) playerLocations.get(player) + diceRoll];
        }

        playerLocations.put(player, Arrays.binarySearch(tileList, tile));
        tile.onLand(player, diceRoll);

    }

    public static boolean doesTokenOwnColorSet(Token player, Color color){ //requires them to be unmortgaged
        //needs implementation
        return false;
    }
}
