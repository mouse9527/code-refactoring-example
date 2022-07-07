package org.coderead.model;

import org.coderead.calculator.AbstractPerformanceCalculator;

public class PlayType {
    private final String type;

    public PlayType(String type) {
        this.type = type;
    }

    static PlayType valueOf(String type) {
        return new PlayType(type);
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
