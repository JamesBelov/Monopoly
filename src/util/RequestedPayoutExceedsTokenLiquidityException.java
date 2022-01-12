package util;

public class RequestedPayoutExceedsTokenLiquidityException extends InvalidActionException{
    
    public RequestedPayoutExceedsTokenLiquidityException(String detail){
        super(detail);
    }

}
