package com.example.moneyexchangecalculator.utils;

import com.example.moneyexchangecalculator.model.Currency;

import java.util.List;
import java.util.Optional;

public class CurrencyConverterUtils {

    public static float calculateTargetCurrencyAmount
            (float baseCurrencyExchangeRatio, float targetCurrencyExchangeRatio, float amountOfBaseCurrency) {
        float exchangeRatio = baseCurrencyExchangeRatio / targetCurrencyExchangeRatio;
        return exchangeRatio * amountOfBaseCurrency;
    }

    public static void ErrorMessageCheck(Optional<Currency> optBaseCurrency,
                                         Optional<Currency> optTargetCurrency,
                                         StringBuilder responseErrorMessage) {

        if (!optBaseCurrency.isPresent() && !optTargetCurrency.isPresent()) {
            responseErrorMessage.append("Base and Target currency codes not found!");
        } else if (!optBaseCurrency.isPresent()) {
            responseErrorMessage.append("Base currency code not found!");
        } else if (!optTargetCurrency.isPresent()) {
            responseErrorMessage.append("Target currency code not found!");
        }
    }

    public static Optional<Currency> getCurrency(List<Currency> currencies, String targetCurrencyCode) {

        return currencies.stream()
                .filter(f -> f.getCurrencyCode().equalsIgnoreCase(targetCurrencyCode))
                .findFirst();

    }










}
