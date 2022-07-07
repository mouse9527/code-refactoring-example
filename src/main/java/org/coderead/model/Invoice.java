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

    public String getStatement(Map<String, Play> plays) {
        return getCustomer() + formatPerformances(plays);
    }

    private StringBuilder formatPerformances(Map<String, Play> plays) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            stringBuilder.append(String.format(" %s: %s (%d seats)\n", play.getName(), play.getAmount(performance).formatUSD(), performance.getAudience()));
        }
        return stringBuilder;
    }

    public Amount getTotalAmount(Map<String, Play> plays) {
        int totalAmount = 0;
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            totalAmount += play.getAmount(performance).getAmount();
        }
        return new Amount(totalAmount);
    }

    public int getVolumeCredits(Map<String, Play> plays) {
        int volumeCredits = 0;
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            volumeCredits += AbstractPerformanceCalculator.of(play.getType()).getVolumeCredits(performance);
        }
        return volumeCredits;
    }

}
