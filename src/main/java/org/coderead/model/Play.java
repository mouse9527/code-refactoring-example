package org.coderead.model;

/**
 * 剧目
 *
 * @author kendoziyu
 * @since 2020/10/11 0011
 */
public class Play {

    private String name;

    private PlayType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.name().toLowerCase();
    }

    public void setType(String type) {
        this.type = PlayType.of(type);
    }

    Amount getAmount(Performance performance) {
        return new Amount(type.getAmount(performance));
    }

    double getVolumeCredits(Performance performance) {
        return type.getVolumeCredits(performance);
    }

}
