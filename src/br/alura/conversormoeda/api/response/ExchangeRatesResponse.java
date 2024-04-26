package br.alura.conversormoeda.api.response;

import br.alura.conversormoeda.api.key.ApiKey;

import java.util.Map;
import java.util.logging.Logger;

public class ExchangeRatesResponse {
    private final static Logger LOGGER = Logger.getLogger(ApiKey.class.getName());

    private Map<String, Double> conversion_rates;

    public Map<String, Double> getRates() {
        Logger.getLogger("Iniciou método que mapeia as informações");
        return conversion_rates;
    }

}