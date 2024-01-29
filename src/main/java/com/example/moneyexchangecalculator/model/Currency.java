package com.example.moneyexchangecalculator.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class Currency {

    private String currencyName;
    private String currencyCode;
    private Float currencyExchangeRate;

    @JsonGetter("exchangeRate")
    public Float getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    @JsonSetter("mid")
    public void setCurrencyExchangeRate(Float currencyExchangeRate){
        this.currencyExchangeRate = currencyExchangeRate;
    }

    @JsonProperty("currencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    @JsonSetter("currency")
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonSetter("code")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
