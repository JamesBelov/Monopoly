package tiles;

import util.RequestedPayoutExceedsTokenLiquidityException;
import util.Token;

public class Utility extends Property{

    public Utility(String name, int marketPrice){
        this.name = name;
        this.marketPrice = marketPrice;
        this.mortgagePayout = marketPrice / 2;
        this.unmortgagePrice = (int) (mortgagePayout * 1.1);
    }

    public void billRent(Token renter, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException{

        int numUtilitiesOwnedByOwner = 0;

        for(Property property : owner.getEquity()){
            try{
                if(property.getClass() == Class.forName("Utility") && !property.mortgaged){
                    numUtilitiesOwnedByOwner++;
                }
            }
            catch(ClassNotFoundException e){
                System.out.println("this should presumably never be printed");
            }
        }

        int multiplier = -1; 
        if(numUtilitiesOwnedByOwner == 1) multiplier = 4;
        if(numUtilitiesOwnedByOwner == 2) multiplier = 10;

        int rent = diceRoll * multiplier;

        renter.decreaseLiquidity(rent);
        owner.increaseLiquidity(rent);

    }
    
}
