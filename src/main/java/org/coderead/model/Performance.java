package org.coderead.model;

/**
 * 表演
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Performance {

    private String playId;

    private int audience;

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    String formatPerformances(Play play) {
        return String.format(" %s: %s (%d seats)\n", play.getName(), play.getAmount(this).formatUSD(), getAudience());
    }
}
