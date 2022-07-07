package org.coderead.calculator;

import org.coderead.model.Performance;

public class ActionCalculator extends AbstractPerformanceCalculator {

    private static final int BASIC_AMOUNT = 40000;

    public ActionCalculator() {
    }

    @Override
    public double getVolumeCredits(Performance performance) {
        return Math.max(performance.getAudience() - 30, 0);
    }

    @Override
    public double getAmount(Performance performance) {
        int extraAudience = performance.getAudience() - 30;
        if (extraAudience > 0) {
            return BASIC_AMOUNT + 1000 * extraAudience;
        }

        return BASIC_AMOUNT;
    }
}