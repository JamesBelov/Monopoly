package tiles;
import util.Token;

public class Go extends Tile{

    public void onLand(Token lander, int diceRoll)
    {
        lander.increaseLiquidity(200);
    }
}
