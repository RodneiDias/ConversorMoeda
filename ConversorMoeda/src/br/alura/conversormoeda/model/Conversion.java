package br.alura.conversormoeda.model;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Conversion {
    private final String baseCurrency;
    private final String targetCurrency;
    private final double originalAmount;
    private final double convertedAmount;
    private final LocalDateTime timestamp;

    public Conversion(String baseCurrency, String targetCurrency, double originalAmount, double convertedAmount, LocalDateTime timestamp) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.timestamp = timestamp;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Conversão realizada em " + timestamp +
                ": " + df.format(originalAmount) + " " + baseCurrency +
                " convertido para " + df.format(convertedAmount) + " " + targetCurrency;
    }
}