package com.example.moneyexchangecalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExchangeRateTable {

    @JsonProperty("table")
    private String tableType;
    @JsonProperty("no")
    private String tableNumber;
    @JsonProperty("effectiveDate")
    private String ratesPublicationDate;
    @JsonProperty("rates")
    private List<Currency> currencies;

}
