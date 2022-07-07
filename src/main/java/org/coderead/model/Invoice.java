package org.coderead.model;

import org.coderead.Amount;
import org.coderead.calculator.AbstractPerformanceCalculator;

import java.util.List;
import java.util.Map;

/**
 * 发票
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Invoice {

    private String customer;

    private List<Performance> performances;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public int getVolumeCredits(Map<String, Play> plays) {
        int volumeCredits = 0;
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            volumeCredits += AbstractPerformanceCalculator.of(play.getType()).getVolumeCredits(performance);
        }
        return volumeCredits;
    }

    public int getTotalAmount(Map<String, Play> plays) {
        int totalAmount = 0;
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            totalAmount += AbstractPerformanceCalculator.of(play.getType()).getAmount(performance);
        }
        return totalAmount;
    }

    public StringBuilder formatPerformances(Map<String, Play> plays) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            stringBuilder.append(String.format(" %s: %s (%d seats)\n", play.getName(), new Amount(AbstractPerformanceCalculator.of(play.getType()).getAmount(performance)).formatUSD(), performance.getAudience()));
        }
        return stringBuilder;
    }

    public String getStatement(Map<String, Play> plays) {
        return getCustomer() + formatPerformances(plays);
    }

    public Amount getTotalAmountV2(Map<String, Play> plays) {
        return new Amount(getTotalAmount(plays));
    }
}
