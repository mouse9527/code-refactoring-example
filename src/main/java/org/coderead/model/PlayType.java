package org.coderead.model;

import org.coderead.calculator.*;

public enum PlayType {
    TRAGEDY(new TragedyCalculator()),
    COMEDY(new ComedyCalculator()),
    ACTION(new ActionCalculator()),
    LOVE(new LoveCalculator());

    private final PerformanceCalculator calculator;

    PlayType(PerformanceCalculator calculator) {
        this.calculator = calculator;
    }

    public static PlayType of(String type) {
        try {
            return valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type: " + type + ".");
        }
    }

    double getAmount(Performance performance) {
        return getCalculator().getAmount(performance);
    }

    double getVolumeCredits(Performance performance) {
        return getCalculator().getVolumeCredits(performance);
    }

    private PerformanceCalculator getCalculator() {
        return calculator;
    }
}
