package tiles;
import java.util.Arrays;

import main.Board;
import util.*; 
public class Street extends Property {
    private static int totalHouses = 32;
    private static int totalHotels = 12;

    private int houses;
    private int houseCost;  
    private Color color; 

    private int[] rentPricingLevels;

    public Street(String name, Color color, int marketPrice, int houseCost, int[] rentPricingLevels) {
        this.name = name;
        this.color = color;
        this.marketPrice = marketPrice;
        this.mortgagePayout = marketPrice / 2;
        this.unmortgagePrice = (int) (mortgagePayout * 1.1);
        this.houseCost = houseCost;
        houses = 0;
        this.rentPricingLevels = rentPricingLevels;
    }

    public void billRent(Token renter, int diceRoll)
    {
        //need implementation
    }

    public void buildHouse() throws RequestedPayoutExceedsTokenLiquidityException, InvalidActionException
    {
        if(!Board.doesTokenOwnColorSet(owner, this.color)) throw new InvalidActionException("Need full color set to build houses");
        if(houses == 4){
            //hotel build request
            if(totalHotels <= 0) throw new InvalidActionException("No hotels left");
            this.owner.decreaseLiquidity(houseCost);
            totalHotels--;
            houses++;
        }
        else{
            //house build request
            if(totalHouses <= 0) throw new InvalidActionException("No houses left");
            if(houses > 4) throw new InvalidActionException("No room to build house on " + this.name);
            this.owner.decreaseLiquidity(houseCost);
            totalHouses--;
            houses++;
        }

    }

    public void sellHouse() throws InvalidActionException
    {
        if(houses <= 0) throw new InvalidActionException("No houses to sell on " + this.name);
        houses--;
        this.owner.increaseLiquidity(houseCost / 2);
        if(houses == 5)
        {
            totalHotels++;
        }
        else
        {
            totalHouses++;
        }
    }

    public Color getColor(){
        return color;
    }

    public int[] getRentPricingLevels(){
        return Arrays.copyOf(rentPricingLevels, rentPricingLevels.length);
    }

}
