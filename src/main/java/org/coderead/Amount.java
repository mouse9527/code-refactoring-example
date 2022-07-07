package org.coderead;

import java.text.NumberFormat;
import java.util.Locale;

public class Amount {
    private final double amount;

    public Amount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    String formatUSD() {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(getAmount() / 100);
    }
}
