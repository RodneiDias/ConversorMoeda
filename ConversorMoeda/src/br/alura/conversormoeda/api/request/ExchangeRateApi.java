    package br.alura.conversormoeda.api.request;

    import br.alura.conversormoeda.api.response.ExchangeRatesResponse;
    import br.alura.conversormoeda.api.key.ApiKey;
    import br.alura.conversormoeda.util.Log;
    import java.net.HttpURLConnection;
    import java.io.InputStreamReader;
    import java.io.BufferedReader;
    import com.google.gson.Gson;
    import java.io.IOException;
    import java.net.URL;
    import java.util.Map;



    public class ExchangeRateApi {
        private  String baseCode;
        private  String currencyType;

        public  ExchangeRateApi(String currencyType, String baseCode) {
            this.currencyType = "convencional";
            this.baseCode = baseCode;
        }

            public Map<String, Double> getExchangeRates () throws IOException {
        try{
            String API_KEY = ApiKey.readApiKey(currencyType);
            String apiUrl = currencyType.equals("convencional")
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
        }catch (IOException e) {
            Log.addLog(e.toString());
            throw new RuntimeException("Erro de I/O ao acessar a API: " + e.getMessage(), e);

        }
    }
}