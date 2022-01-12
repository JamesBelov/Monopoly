package tiles;
import util.Token;
import util.RequestedPayoutExceedsTokenLiquidityException;

public abstract class Tile {

    protected String name;

    public abstract void onLand(Token player, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException;
    //only implementations of this method that descend from the Ownable implementation can throw the above exception
    
}
