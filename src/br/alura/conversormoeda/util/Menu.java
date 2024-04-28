package br.alura.conversormoeda.util;

public class Menu {
    public static void exibirMenu() {
        String menu = """
 
 
 ***************************Seja*bem*vindo**************************

     Você pode realizar a conversão de qualquer moeda utilizando
     o código de referência.
     Exemplos:                   
     BRL (Real brasileiro), ARS (Peso argentino), BOB (Boliviano)                   
     USD (Dólar Americano), AUD (Dólar Australiano), EUR (Euro)                   

     Tecle 'enter' para iniciar                   
     Digite 'sair' a qualquer momento para encerrar                                       

 ********************************************************************                   
      
              """;
        System.out.println(menu);
    }
}
