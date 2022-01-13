package util;
import tiles.*;
import java.util.ArrayList;

public enum Token {

    BATTLESHIP, 
    BOOT,
    CANNON,
    THIMBLE,
    HAT,
    IRON,
    RACECAR,
    DOG,
    CAT,
    DUCK,
    TREX,
    PENGUIN;

    private int liquidity = 1500;
    private int numberOfGetOutOfJailFreeCards = 0;
    private ArrayList<Property> equity;
    private boolean inJail = false;

    private boolean isInJail() //why is this private? - james
    {
        return inJail;
    }

    public void setInJail(boolean poop)
    {
        inJail = poop;
    }

    public void increaseLiquidity(int increase){
        liquidity += increase;
    }

    public void decreaseLiquidity(int decrease) throws RequestedPayoutExceedsTokenLiquidityException{
        if(decrease > liquidity){
            throw new RequestedPayoutExceedsTokenLiquidityException("");
        }
        else{
            liquidity -= decrease;
        }
    }

    public void useGetOutOfJailFreeCard() throws InvalidActionException{
        if(numberOfGetOutOfJailFreeCards == 0){
            throw new InvalidActionException("No get out of jail free card.");
        }

        numberOfGetOutOfJailFreeCards--;
        //reference jail handler?
    }

    public int getLiquidity(){
        return liquidity;
    }

    public ArrayList<Property> getEquity(){
        return equity;
    }



}
