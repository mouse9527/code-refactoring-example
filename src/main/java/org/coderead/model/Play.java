package org.coderead.model;

import org.coderead.Amount;

/**
 * 剧目
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Play {

    private String name;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Amount getAmount(Performance performance) {
        return new Amount(PlayType.of(getType()).getAmount(performance));
    }

    double getVolumeCredits(Performance performance) {
        return PlayType.of(getType()).getVolumeCredits(performance);
    }

}
