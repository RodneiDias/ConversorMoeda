package br.alura.conversormoeda.api.request;

import br.alura.conversormoeda.api.key.ApiKey;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExchangeRateApi {
    private final static Logger LOGGER = Logger.getLogger(ExchangeRateApi.class.getName());
    private  String baseCode;
    private  String currencyType;

    public  ExchangeRateApi(String currencyType, String baseCode) {
        this.currencyType = "convencional"; //
        this.baseCode = baseCode;
    }

    public Map<String, Double> getExchangeRates () throws IOException {
        try {
            //LOGGER.info("Iniciando a conexão com a Api ExchangeRate");

            String API_KEY = ApiKey.readApiKey(currencyType);
            String apiUrl = currencyType.equals("convencional")
            //**** Finalizar a implementação da api coingecko
                    ? "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCode
                    : "https://api.coingecko.com/api/v3/simple/price?ids=" + baseCode + "&vs_currencies=" + currencyType + "&apiKey=" + API_KEY;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Convertendo a resposta JSON para um mapa de taxas de câmbio

            Gson gson = new Gson();
            ExchangeRatesResponse exchangeRatesResponse = gson.fromJson(response.toString(), ExchangeRatesResponse.class);
            return exchangeRatesResponse.getRates();

        } catch (IOException e) {
            LOGGER.log(Level.ALL,"Erro com a conexão da API: ", e.getMessage());
            throw new RuntimeException("Erro com a conexão da API: " + e.getMessage(), e);

        }
    }
}