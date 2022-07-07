package org.coderead.model;

import java.util.List;
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

    public String getStatement(Plays plays) {
        return getCustomer() + formatPerformances(plays);
    }

    private String formatPerformances(Plays plays) {
        return getPerformances().stream()
                .map(it -> it.formatPerformances(plays.getPlay(it)))
                .collect(Collectors.joining());
    }


    public Amount getTotalAmount(Plays plays) {
        Double totalAmount = getPerformances().stream()
                .map(it -> plays.getAmount(it).getAmount())
                .reduce(0d, Double::sum);
        return new Amount(totalAmount);
    }

    public int getVolumeCredits(Plays plays) {
        Double volumeCredits = getPerformances().stream()
                .map(plays::getVolumeCredits)
                .reduce(0d, Double::sum);
        return volumeCredits.intValue();
    }

}
