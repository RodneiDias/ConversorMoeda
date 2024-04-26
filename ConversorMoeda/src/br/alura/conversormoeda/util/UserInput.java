package br.alura.conversormoeda.util;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    String menu= """
                ************************CONVERSOR-DE-MOEDA************************
                
                                          Seja bem vindo                                                                                   
                         
                    Você pode realizar a converção de qualquer moeda utilizando
                    o código de referência.                         
                                             Exemplos:
                    BRL (Real brasileiro), ARS (Peso argentino), BOB (Boliviano)
                    USD (Dólar Americano), AUD (Dólar Australiano), EUR (Euro) 
                                   
                                                                                                          
                                    Digite Enter para iniciar
                                                                  
                ******************************************************************     
        """;

    public String getCurrencyType() {
        System.out.println(menu);

        return scanner.nextLine().toLowerCase();
    }

    public String getBaseCurrency() {
        System.out.println("Digite a moeda base:");
        return scanner.nextLine().toUpperCase();
    }

    public String getTargetCurrency() {
        System.out.println("Digite a moeda de destino:");
        return scanner.nextLine().toUpperCase();
    }

    public double getAmount(String currency) {
        System.out.println("Digite o valor em " + currency + ":");
        return scanner.nextDouble();
    }

    public void closeScanner() {
        scanner.close();
    }
}

