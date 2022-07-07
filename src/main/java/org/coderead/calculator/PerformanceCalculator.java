package org.coderead.calculator;

import org.coderead.model.Performance;

public interface PerformanceCalculator {
    double getVolumeCredits(Performance performance);

    double getAmount(Performance performance);
}
