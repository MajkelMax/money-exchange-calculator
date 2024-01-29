package com.example.moneyexchangecalculator.scheduledTasks;

import com.example.moneyexchangecalculator.exceptions.CurrencyExchangeServiceNotWorkingException;
import com.example.moneyexchangecalculator.utils.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExchangeRatesRefresher {

    private final ApplicationContext context;

    public ExchangeRatesRefresher(ApplicationContext context) {
        log.info("Exchange Rates Refresher created!");
        this.context = context;
    }

    @Scheduled(fixedRate = 24 * 60 * 1000, initialDelay = 0)
    public void refreshExchangeRates() {

        try {
            ExchangeRateService exchangeRateService = context.getBean(ExchangeRateService.class);
            ExchangeRateService.setCurrencies(exchangeRateService.getExchangeRates());
            log.info("Currencies exchange rates refreshed properly!");

        } catch (CurrencyExchangeServiceNotWorkingException ex) {
            log.debug("Communication with exchange ended with exception:", ex);
        }





    }


}
