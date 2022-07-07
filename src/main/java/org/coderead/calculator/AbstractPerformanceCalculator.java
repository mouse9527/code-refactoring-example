package org.coderead.calculator;

import org.coderead.model.Performance;

public abstract class AbstractPerformanceCalculator {
    public abstract double getVolumeCredits(Performance performance);

    public abstract double getAmount(Performance performance);
}
