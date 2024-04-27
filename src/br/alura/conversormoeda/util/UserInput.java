package br.alura.conversormoeda.util;

import br.alura.conversormoeda.principal.Main;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInput {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    private final Scanner scanner;
    private final String[] currencyCodes;

    public UserInput() {
        this.scanner = new Scanner(System.in);
        // Array contendo os códigos de moeda fornecidos
        this.currencyCodes = new String[]{
                "USD", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
                "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD",
                "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC",
                "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR",
                "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ",
                "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD",
                "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF",
                "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD",
                "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN",
                "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN",
                "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
                "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL", "SOS", "SRD", "SSP",
                "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD",
                "TWD", "TZS", "UAH", "UGX", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF",
                "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"};
    }

    String menu = """
                    ************************Seja bem vindo************************                                             

                        Você pode realizar a converção de qualquer moeda utilizando
                        o código de referência.
                                                 Exemplos:
                        BRL (Real brasileiro), ARS (Peso argentino), BOB (Boliviano)
                        USD (Dólar Americano), AUD (Dólar Australiano), EUR (Euro)


                                        Tecle 'enter' para iniciar
                                Digite 'sair' a qualquer momento para encerrar
                    
                    ******************************************************************
            """;

    public String getCurrencyType() {
        System.out.println(menu);
        return scanner.nextLine().toLowerCase();
    }

    public String getBaseCurrency() {
        while (true) {
            System.out.println("Digite a moeda base (digite 'sair' para encerrar):");
            String currency = scanner.nextLine().trim().toUpperCase();
            if (currency.equalsIgnoreCase("sair")) {
                closeScanner();
                System.exit(0);
            }
            if (isValidCurrency(currency)) {
                return currency;
            } else {
                System.out.println("Moeda inválida. Por favor, digite uma moeda válida.");
            }
        }
    }

    public String getTargetCurrency() {
        while (true) {
            System.out.println("Digite a moeda de destino (digite 'sair' para encerrar):");
            String currency = scanner.nextLine().trim().toUpperCase();
            if (currency.equalsIgnoreCase("sair")) {
                closeScanner();
                System.exit(0);
            }
            if (isValidCurrency(currency)) {
                return currency;
            } else {
                System.out.println("Moeda inválida. Por favor, digite uma moeda válida.");
            }
        }
    }

    public double getAmount(String currency) {
        while (true) {
            System.out.println("Digite o valor em " + currency + " (digite 'sair' para encerrar):");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("sair")) {
                closeScanner();
                System.exit(0);
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Por favor, digite um número válido.");
                LOGGER.log(Level.ALL, "Valor digitado inválido: " + e.getMessage());
            }
        }
    }

    private boolean isValidCurrency(String currency) {
        for (String code : currencyCodes) {
            if (code.equals(currency)) {
                return true;
            }
        }
        return false;
    }

    private void closeScanner() {
        scanner.close();
    }
}

