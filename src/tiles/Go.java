package tiles;
import util.Token;

public class Go extends Tile{

    //Need to make sure we call the onLand even if we pass it?
    //This is pretty dynamic cause of chance cards sometimes u don't pay
    public void onLand(Token lander, int diceRoll)
    {
        lander.increaseLiquidity(200);
    }
}
