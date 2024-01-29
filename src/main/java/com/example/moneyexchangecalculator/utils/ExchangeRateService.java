package com.example.moneyexchangecalculator.utils;

import com.example.moneyexchangecalculator.Constans;
import com.example.moneyexchangecalculator.exceptions.CurrencyExchangeServiceNotWorkingException;
import com.example.moneyexchangecalculator.model.ExchangeRateTable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.moneyexchangecalculator.model.Currency;

import java.util.*;

@Component
public class ExchangeRateService {

    private static List<Currency> currencies;

    public static List<Currency> getCurrencies() {
        return currencies;
    }

    public static void setCurrencies(List<Currency> currencies) {
        ExchangeRateService.currencies = currencies;
    }

    public List<Currency> getExchangeRates() throws CurrencyExchangeServiceNotWorkingException {
        RestTemplate restTemplate = new RestTemplate();

        String baseUri = Constans.NBP_EXCHANGE_RATES_URI;
        List<String> tableTypes = new ArrayList<>(Arrays.asList(Constans.TABLE_TYPES));
        List<Currency> currencies = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        for (String tableType : tableTypes) {

            String uri = new StringBuilder(baseUri)
                    .append(tableType)
                    .toString();

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<ExchangeRateTable[]> result =
                    restTemplate.exchange(uri, HttpMethod.GET, entity, ExchangeRateTable[].class);

            if(result.getBody() != null) {
                currencies.addAll(result.getBody()[0].getCurrencies());
            } else {
                throw new CurrencyExchangeServiceNotWorkingException("Communication with currency service is not working!");
            }
        }
        return currencies;
    }

}
