package org.coderead.model;

/**
 * 剧目
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Play {

    private String name;

    private String type;
    private PlayType playType;

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
        this.playType = PlayType.of(type);
    }

    Amount getAmount(Performance performance) {
        return new Amount(playType.getAmount(performance));
    }

    double getVolumeCredits(Performance performance) {
        return playType.getVolumeCredits(performance);
    }

}
