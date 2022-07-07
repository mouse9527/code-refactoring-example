package org.coderead.calculator;

import org.coderead.model.Performance;

public class ComedyCalculator extends AbstractPerformanceCalculator {

    private static final int BASIC_AMOUNT_PRE_AUDIENCE = 300;
    private static final int BASIC_AMOUNT = 30000;
    private static final int BASIC_EXTRA_AMOUNT = 10000;
    private static final int AMOUNT_PRE_EXTRA_AUDIENCE = 500;

    public ComedyCalculator() {
    }

    @Override
    public double getVolumeCredits(Performance performance) {
        int max = Math.max(performance.getAudience() - 30, 0);
        double floor = Math.floor(performance.getAudience() / 5d);
        return max + floor;
    }

    @Override
    public double getAmount(Performance performance) {
        int result = BASIC_AMOUNT;
        int extraAudience = performance.getAudience() - 20;
        if (extraAudience > 0) {
            result = result + (BASIC_EXTRA_AMOUNT + AMOUNT_PRE_EXTRA_AUDIENCE * extraAudience);
        }
        return result + BASIC_AMOUNT_PRE_AUDIENCE * performance.getAudience();
    }
}