package br.alura.conversormoeda.util;

import br.alura.conversormoeda.model.Conversion;
import br.alura.conversormoeda.api.request.ExchangeRateApi;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private String baseCode;
    private String targetCurrency;
    private Map<String, Double> exchangeRates;
    private final List<Conversion> history = new ArrayList<>();

    public void start() throws IOException {
        UserInput userInput = new UserInput();
        // Solicitar ao usuário o tipo de moeda (convencional ou criptomoeda)
        String currencyType = userInput.getCurrencyType();

        // Solicitar ao usuário a moeda base
        baseCode = userInput.getBaseCurrency();

        // Obter as taxas de conversão da API
        ExchangeRateApi exchangeRateAPI = new ExchangeRateApi(currencyType, baseCode);
        exchangeRates = exchangeRateAPI.getExchangeRates();

        // Solicitar ao usuário a moeda de destino
        targetCurrency = userInput.getTargetCurrency();

        // Converter e imprimir o resultado da conversão
        convertAndPrint(userInput);

    }

    private void convertAndPrint(UserInput userInput) throws IOException {
        double amountInBaseCurrency = userInput.getAmount(baseCode);
        double exchangeRate = exchangeRates.get(targetCurrency);
        double convertedAmount = amountInBaseCurrency * exchangeRate;
        String formattedAmount = String.format("%.2f", convertedAmount);
        System.out.println("O valor em " + targetCurrency + " é: " + formattedAmount);

        Conversion conversion = new Conversion(baseCode, targetCurrency, amountInBaseCurrency, convertedAmount, LocalDateTime.now());
        Historico.addHistorico(conversion);
    }
}
