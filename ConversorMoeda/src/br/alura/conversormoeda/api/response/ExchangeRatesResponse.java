package br.alura.conversormoeda.api.response;

import java.util.Map;

public class ExchangeRatesResponse {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getRates() {
        return conversion_rates;
    }
}