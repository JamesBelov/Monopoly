package tiles;
import util.Token;

public abstract class Ownable extends Tile {

    private boolean owned;
    private Token owner;
    private int marketPrice;
    private int mortagePayout;
    private int unmortagePrice;

    public abstract void billRent(Token player);

}
