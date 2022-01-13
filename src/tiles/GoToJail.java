package tiles;
import util.RequestedPayoutExceedsTokenLiquidityException;
import util.Token;
import main.Board;

public class GoToJail extends Tile{

    private int jailIndex = 11;

    public void onLand(Token lander, int diceRoll) throws RequestedPayoutExceedsTokenLiquidityException
    {
        lander.setInJail(true);
        Board.movePlayer(lander, 69420 ,Board.tileList[jailIndex]);
    }
}
