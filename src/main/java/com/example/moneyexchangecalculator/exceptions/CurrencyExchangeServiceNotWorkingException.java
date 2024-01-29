package com.example.moneyexchangecalculator.exceptions;

public class CurrencyExchangeServiceNotWorkingException extends Exception{

    public CurrencyExchangeServiceNotWorkingException(String errorMessage) {
        super(errorMessage);
    }

}
