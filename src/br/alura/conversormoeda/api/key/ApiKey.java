package br.alura.conversormoeda.api.key;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ApiKey {
    private final static Logger LOGGER = Logger.getLogger(ApiKey.class.getName());

    public static String readApiKey(String currencyType) {
        String fileName = currencyType.equals("convencional") ? "api_keyExchange.txt" : "api_keyCoin.txt";
        try {
            Logger.getLogger("Iniciou método que busca chave de acesso no arquivo api_keyExchange.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String apiKey = reader.readLine();
            reader.close();
            return apiKey;
        } catch (IOException e) {
            Logger.getLogger("Erro no método que busca chave de acesso no arquivo api_keyExchange.txt", e.getMessage());

            return null;
        }

    }
}
