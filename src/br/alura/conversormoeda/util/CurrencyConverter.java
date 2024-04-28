package br.alura.conversormoeda.util;

import br.alura.conversormoeda.model.Conversion;
import br.alura.conversormoeda.api.request.ExchangeRateApi;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static br.alura.conversormoeda.util.Menu.exibirMenu;

public class CurrencyConverter {
    private final static Logger LOGGER = Logger.getLogger(CurrencyConverter.class.getName());
    private String baseCode;
    private String targetCurrency;
    private Map<String, Double> exchangeRates;
    private final List<Conversion> history = new ArrayList<>();

    public void start() throws IOException {
        //LOGGER.info("Iniciando a interação com usuário.");
        UserInput userInput = new UserInput();

        // Mostra o painel de entrada da aplicação,
        exibirMenu();
        // Mostra o painel de entrada da aplicação, mas vai receber outra função em breve por isso o nome CurrencyType
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
        //LOGGER.info("Dados de entrada processados e devolvidos.");
    }

    private void convertAndPrint(UserInput userInput) throws IOException {
        //LOGGER.info("Iniciando a conversão.");
        double amountInBaseCurrency = userInput.getAmount(baseCode);
        double exchangeRate = exchangeRates.get(targetCurrency);
        double convertedAmount = amountInBaseCurrency * exchangeRate;
        String formattedAmount = String.format("%.2f", convertedAmount);
        System.out.println("O valor em " + targetCurrency + " é: " + formattedAmount);

        Conversion conversion = new Conversion(baseCode, targetCurrency, amountInBaseCurrency, convertedAmount, LocalDateTime.now());
        history.add(conversion);
        Historico.addHistorico(conversion);
        //System.out.println(history);
    }
}
