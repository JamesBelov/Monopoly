package main;

import tiles.Property;
import util.InvalidActionException;
import util.Token;
import java.util.ArrayList;

public class AssetForfeitureHandler {

    public static void handleInitialPropertyLandEvent(Token intialLander, Property Property){
        //requires implementation
    }

    public static void handleBankruptcy(Token insolvetPlayer, Token playerOwed){
        if(playerOwed != null){
            //requires implementation
        }
        //so does this
    }

    public static void switchPropertys(Token player1, Token player2, ArrayList<Property> equity1, ArrayList<Property> equity2) throws InvalidActionException{
        if(!player1.getEquity().containsAll(equity1) || !player2.getEquity().containsAll(equity2) ){
            throw new InvalidActionException("Players don't own all requested Propertys");
        }
    }//this method is the intended primary trade handler but it cant deal with get out of jail free cards at the moment

}
