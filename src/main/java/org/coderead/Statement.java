package org.coderead;

import org.coderead.calculator.AbstractPerformanceCalculator;
import org.coderead.model.Invoice;
import org.coderead.model.Performance;
import org.coderead.model.Play;

import java.util.Map;

/**
 * 客户服务类
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Statement {

    private Invoice invoice;
    private Map<String, Play> plays;

    public Statement(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Statement for %s", invoice.getCustomer())).append(formatPerformances());
        stringBuilder.append(String.format("Amount owed is %s\n", new Amount(invoice.getTotalAmount(plays)).formatUSD()));
        stringBuilder.append(String.format("You earned %s credits\n", invoice.getVolumeCredits(plays)));
        return stringBuilder.toString();
    }

    private StringBuilder formatPerformances() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Performance performance : invoice.getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            stringBuilder.append(formatPerformance(performance, play));
        }
        return stringBuilder;
    }

    private String formatPerformance(Performance performance, Play play) {
        return String.format(" %s: %s (%d seats)\n", play.getName(), new Amount(AbstractPerformanceCalculator.of(play.getType()).getAmount(performance)).formatUSD(), performance.getAudience());
    }

}
