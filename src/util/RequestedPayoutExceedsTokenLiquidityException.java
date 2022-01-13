package util;

public class RequestedPayoutExceedsTokenLiquidityException extends Exception{
     

    public RequestedPayoutExceedsTokenLiquidityException(String detail){
        super(detail);
    }

}
