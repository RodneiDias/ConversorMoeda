package br.alura.conversormoeda.api.key;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ApiKey {
    public static String readApiKey(String currencyType) {
        String fileName = currencyType.equals("convencional") ? "api_keyExchange.txt" : "api_keyCoin.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String apiKey = reader.readLine();
            reader.close();
            return apiKey;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
