package tiles;

import util.RequestedPayoutExceedsTokenLiquidityException;
import util.Token;

public class Railroad extends Ownable{

    public Railroad(String name){
        this.name = name;
    }

    public void billRent(Token renter) throws RequestedPayoutExceedsTokenLiquidityException{

        int numRailRoadsOwnedByOwner = 0;

        for(Ownable property : owner.getEquity()){
            try{
                if(property.getClass() == Class.forName("Railroad")){
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