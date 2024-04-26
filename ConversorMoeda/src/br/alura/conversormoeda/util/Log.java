package br.alura.conversormoeda.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static final String FILE_PATH = "log.txt";

    public static void addLog(String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            if (errorMessage != null && !errorMessage.isEmpty()) {
                writer.write("Erro: " + errorMessage);
                writer.newLine();
            }
            writer.write("----------------------------------");
            writer.newLine();
        } catch (IOException e) {
            Log.addLog(e.getMessage());
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}