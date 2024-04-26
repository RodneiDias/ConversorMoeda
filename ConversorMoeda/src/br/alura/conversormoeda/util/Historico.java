package br.alura.conversormoeda.util;

import br.alura.conversormoeda.model.Conversion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Historico {
        private static final String FILE_PATH = "historico.txt";

        public static void addHistorico(Conversion conversion) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(conversion.toString());
                writer.newLine();

            } catch (IOException e) {
                Log.addLog(e.getMessage());
                System.err.println("Erro ao escrever no arquivo de histórico: " + e.getMessage());
            }
        }
    public static void showHistorico(List<Conversion> history) {
        System.out.println("\nHistórico de conversões:");
        for (Conversion conversion : history) {
            System.out.println("Data e Hora: " + conversion.getTimestamp().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            System.out.println("Moeda de Origem: " + conversion.getBaseCurrency());
            System.out.println("Moeda de Destino: " + conversion.getTargetCurrency());
            System.out.println("Valor Original: " + conversion.getOriginalAmount());
            System.out.println("Valor Convertido: " + conversion.getConvertedAmount());
            System.out.println("----------------------------------");
        }
    }
}

