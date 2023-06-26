package com.SellBuyCar.exception;

public class DealerNotFoundException extends RuntimeException{
    public DealerNotFoundException() {
        super("Dealer Not Found For This Id");
    }

    public DealerNotFoundException(String message){
        super(message);
    }
}
