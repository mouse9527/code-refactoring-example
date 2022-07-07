package org.coderead.calculator;

import org.coderead.model.Performance;

public class TragedyCalculator extends AbstractPerformanceCalculator {

    private static final int BASIC_AMOUNT = 40000;

    public TragedyCalculator() {
    }

    @Override
    public double getVolumeCredits(Performance performance) {
        return Math.max(performance.getAudience() - 30, 0);
    }

    @Override
    public double getAmount(Performance performance) {
        return BASIC_AMOUNT + 1000 * getExtraAudience(performance);
    }

    private int getExtraAudience(Performance performance) {
        return Math.max(performance.getAudience() - 30, 0);
    }
}