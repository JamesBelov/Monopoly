package tiles;

import main.AssetForfeitureHandler;
import util.Token;
import util.InvalidActionException;
import util.RequestedPayoutExceedsTokenLiquidityException;

public abstract class Property extends Tile {

    protected Token owner;
    protected int marketPrice;
    protected boolean mortgaged;
    protected int mortgagePayout;
    protected int unmortgagePrice;

    public abstract void billRent(Token renter, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException;

    public void onLand(Token player, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException{

        if(owner == null){
            AssetForfeitureHandler.handleInitialPropertyLandEvent(player, this);
            return;
        }

        if(owner != player){
            billRent(player, diceRoll);
        }

    }

    public void setOwner(Token player){
        owner = player;
    }

    public void mortage() throws InvalidActionException{ //property class needs to override this for house functionality

        if(mortgaged) throw new InvalidActionException(this.name + " is already mortgaged.");
        
        owner.increaseLiquidity(mortgagePayout);
        mortgaged = true;

    }

    public void unmortgage() throws InvalidActionException, RequestedPayoutExceedsTokenLiquidityException{

        if(!mortgaged) throw new InvalidActionException(this.name + " is not currently mortgaged.");

        if(unmortgagePrice > owner.getLiquidity()) throw new RequestedPayoutExceedsTokenLiquidityException("Not enough money to unmortgage " + this.name);

    }

    public int getMarketPrice(){
        return marketPrice;
    }

}
