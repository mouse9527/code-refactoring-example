package org.coderead.model;

import org.coderead.calculator.*;

public enum PlayType {
    tragedy(new TragedyCalculator()),
    comedy(new ComedyCalculator()),
    action(new ActionCalculator()),
    love(new LoveCalculator());

    private final AbstractPerformanceCalculator calculator;

    PlayType(AbstractPerformanceCalculator calculator) {
        this.calculator = calculator;
    }

    AbstractPerformanceCalculator getCalculator() {
        return calculator;
    }

    double getAmount(Performance performance) {
        return getCalculator().getAmount(performance);
    }

    double getVolumeCredits(Performance performance) {
        return getCalculator().getVolumeCredits(performance);
    }
}
