package tiles;
import util.*; 
public class Street extends Ownable {
    private static int totalHouses = 32;
    private static int totalHotels = 12;

    private int houses;
    private int hotels;
    private int houseCost;  
    private Color color; 

    private int[] rentPricingLevels;

    public Street() {
        super();
        //TO DO
    }

    public void billRent(Token renter)
    {
        //TO DO
    }

    public void buildHouse() throws RequestedPayoutExceedsTokenLiquidityException, InvalidActionException
    {
        if(totalHouses <= 0) throw new InvalidActionException("No houses left,");
        

    }
    public void buildHotel() throws RequestedPayoutExceedsTokenLiquidityException, InvalidActionException
    {
        //TO DO
    }
    public void sellHouse() throws InvalidActionException
    {
        //TO DO
    }
    public void sellHotel() throws InvalidActionException
    {
        //TO DO
    }
}
