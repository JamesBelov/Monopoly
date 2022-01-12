package main;

import tiles.Ownable;
import util.InvalidActionException;
import util.Token;
import java.util.ArrayList;

public class AssetForfeitureHandler {

    public static void handleInitialOwnableLandEvent(Token intialLander, Ownable ownable){
        //requires implementation
    }

    public static void handleBankruptcy(Token insolvetPlayer, Token playerOwed){
        if(playerOwed != null){
            //requires implementation
        }
        //so does this
    }

    public static void switchOwnables(Token player1, Token player2, ArrayList<Ownable> equity1, ArrayList<Ownable> equity2) throws InvalidActionException{
        if(!player1.getEquity().containsAll(equity1) || !player2.getEquity().containsAll(equity2) ){
            throw new InvalidActionException("Players don't own all requested ownables");
        }
    }

}
