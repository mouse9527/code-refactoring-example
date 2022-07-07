package org.coderead.model;

import org.coderead.calculator.*;

public enum PlayType {
    TRAGEDY(new TragedyCalculator()),
    COMEDY(new ComedyCalculator()),
    ACTION(new ActionCalculator()),
    LOVE(new LoveCalculator());

    private final AbstractPerformanceCalculator calculator;

    PlayType(AbstractPerformanceCalculator calculator) {
        this.calculator = calculator;
    }

    public static PlayType of(String type) {
        return valueOf(type.toUpperCase());
    }

    double getAmount(Performance performance) {
        return getCalculator().getAmount(performance);
    }

    double getVolumeCredits(Performance performance) {
        return getCalculator().getVolumeCredits(performance);
    }

    private AbstractPerformanceCalculator getCalculator() {
        return calculator;
    }
}
