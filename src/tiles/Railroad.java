package tiles;

import util.RequestedPayoutExceedsTokenLiquidityException;
import util.Token;

public class Railroad extends Property{

    public Railroad(String name, int marketPrice){
        this.name = name;
        this.marketPrice = marketPrice;
        this.mortgagePayout = marketPrice / 2;
        this.unmortgagePrice = (int) (mortgagePayout * 1.1);
    }

    public void billRent(Token renter, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException{

        int numRailRoadsOwnedByOwner = 0;

        for(Property property : owner.getEquity()){
            try{
                if(property.getClass() == Class.forName("Railroad") && !property.mortgaged){
                    numRailRoadsOwnedByOwner++;
                }
            }
            catch(ClassNotFoundException e){
                System.out.println("this should presumably never be printed");
            }
        }

        int rent = 0;

        switch(numRailRoadsOwnedByOwner){
            case 1: rent = 25;
            case 2: rent = 50;
            case 3: rent = 100;
            case 4: rent = 200;
        }

        renter.decreaseLiquidity(rent);
        owner.increaseLiquidity(rent);

    }    

}