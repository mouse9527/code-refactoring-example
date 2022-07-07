package org.coderead.calculator;

import org.coderead.model.Performance;

public class ComedyCalculator extends AbstractPerformanceCalculator {
    public ComedyCalculator() {
    }

    @Override
    public double getVolumeCredits(Performance performance) {
        int max = Math.max(performance.getAudience() - 30, 0);
        double floor = Math.floor(performance.getAudience() / 5);
        return max + floor;
    }

    @Override
    public double getAmount(Performance performance) {
        int thisAmount = 30000;
        if (performance.getAudience() > 20) {
            thisAmount = thisAmount + (10000 + 500 * (performance.getAudience() - 20));
        }
        return thisAmount + 300 * performance.getAudience();
    }
}