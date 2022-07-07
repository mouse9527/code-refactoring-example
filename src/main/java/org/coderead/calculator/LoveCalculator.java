package org.coderead.calculator;

import org.coderead.model.Performance;

public class LoveCalculator extends AbstractPerformanceCalculator {

    @Override
    public double getVolumeCredits(Performance performance) {
        return Math.max(performance.getAudience() - 30, 0);
    }

    @Override
    public double getAmount(Performance performance) {
        int thisAmount = 40000;
        int extraAudience = performance.getAudience() - 30;
        if (extraAudience > 0) {
            thisAmount += 1000 * extraAudience;
        }
        return thisAmount;
    }
}