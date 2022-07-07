package org.coderead.calculator;

import org.coderead.model.Performance;

public class ActionCalculator implements PerformanceCalculator {
    private static final int BASIC_AMOUNT = 40000;
    private static final int AMOUNT_PRE_EXTRA_AUDIENCE = 1000;
    private static final int BASIC_AUDIENCE = 30;

    public ActionCalculator() {
    }

    @Override
    public double getVolumeCredits(Performance performance) {
        return Math.max(performance.getAudience() - BASIC_AUDIENCE, 0);
    }

    @Override
    public double getAmount(Performance performance) {
        return BASIC_AMOUNT + AMOUNT_PRE_EXTRA_AUDIENCE * getExtraAudience(performance);
    }

    private int getExtraAudience(Performance performance) {
        return Math.max(performance.getAudience() - BASIC_AUDIENCE, 0);
    }
}