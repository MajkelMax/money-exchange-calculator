package com.example.moneyexchangecalculator.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ConvertCurrencyBody {

    @NotNull
    private String baseCurrencyCode;
    @NotNull
    private String targetCurrencyCode;
    @NotNull
    private Float amount;

}
