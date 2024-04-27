package br.alura.conversormoeda.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private final static Logger LOGGER = Logger.getLogger(Log.class.getName());
    private static final String FILE_PATH = "conversorlog.txt";
    static {
        try {
            FileHandler fileHandler = new FileHandler(FILE_PATH, true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao configurar o handler de arquivo", e);
        }
    }
}


//public class Log {
//    private static final String FILE_PATH = "log.txt";
//
//    public static void addLog(String errorMessage) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
//            if (errorMessage != null && !errorMessage.isEmpty()) {
//                writer.write("Erro: " + errorMessage);
//                writer.newLine();
//            }
//            writer.write("----------------------------------");
//            writer.newLine();
//        } catch (IOException e) {
//            Log.addLog(e.getMessage());
//            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
//        }
//    }
//}