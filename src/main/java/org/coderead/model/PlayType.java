package org.coderead.model;

import org.coderead.calculator.AbstractPerformanceCalculator;

public enum PlayType {
    tragedy("tragedy"),
    comedy("comedy"),
    action("action"),
    love("love");

    private final String type;

    PlayType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    AbstractPerformanceCalculator getCalculator() {
        return AbstractPerformanceCalculator.of(getType());
    }

    double getAmount(Performance performance) {
        return getCalculator().getAmount(performance);
    }

    double getVolumeCredits(Performance performance) {
        return getCalculator().getVolumeCredits(performance);
    }
}
