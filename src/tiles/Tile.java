package tiles;
import util.Token;

public abstract class Tile {

    protected String name;

    public abstract void onLand(Token X, int diceRoll);
    
}
