package org.coderead.model;

import org.coderead.Amount;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private String formatPerformances(Map<String, Play> plays) {
        return getPerformances().stream()
                .map(it -> it.formatPerformances(plays.get(it.getPlayId())))
                .collect(Collectors.joining());
    }


    public Amount getTotalAmount(Map<String, Play> plays) {
        Double totalAmount = getPerformances().stream()
                .map(it -> plays.get(it.getPlayId()).getAmount(it).getAmount())
                .reduce(0d, Double::sum);
        return new Amount(totalAmount);
    }

    public int getVolumeCredits(Map<String, Play> plays) {
        int volumeCredits = 0;
        for (Performance performance : getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            volumeCredits += play.getVolumeCredits(performance);
        }
        return volumeCredits;
    }

}
