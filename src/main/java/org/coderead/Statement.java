package org.coderead;

import org.coderead.model.Invoice;
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
        return String.format("%s%s%s",
                String.format("Statement for %s", invoice.getStatement(plays)),
                String.format("Amount owed is %s\n", invoice.getTotalAmount(plays).formatUSD()),
                String.format("You earned %s credits\n", invoice.getVolumeCredits(plays)));
    }

}
