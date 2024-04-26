package br.alura.conversormoeda.principal;

import br.alura.conversormoeda.util.CurrencyConverter;
import br.alura.conversormoeda.util.Log;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Instanciamos a classe CurrencyConverter e iniciamos o processo de conversão
            CurrencyConverter converter = new CurrencyConverter();
            converter.start();

        } catch (IOException e) {
            Log.addLog(e.getMessage());
            System.out.println("Erro ao iniciar o conversor de moedas: " + e.getMessage());
        }
    }
}
