package br.alura.conversormoeda.principal;

import br.alura.conversormoeda.util.CurrencyConverter;
import br.alura.conversormoeda.util.Log;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            LOGGER.info("Iniciando a aplicação e o processo de conversão.");
            CurrencyConverter converter = new CurrencyConverter();
            converter.start();
        } catch (IOException e) {
            LOGGER.log(Level.ALL, "Erro ao iniciar o conversor de moedas: " + e.getMessage());
        }
           LOGGER.info("Finalizando a aplicação");
    }
}
