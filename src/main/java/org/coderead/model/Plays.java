package org.coderead.model;

import java.util.Map;

public class Plays {
    private final Map<String, Play> plays;

    public Plays(Map<String, Play> plays) {
        this.plays = plays;
    }

    public Map<String, Play> getPlays() {
        return plays;
    }

    double getVolumeCredits(Performance it) {
        return getPlay(it).getVolumeCredits(it);
    }

    Amount getAmount(Performance it) {
        return getPlay(it).getAmount(it);
    }

    Play getPlay(Performance it) {
        return getPlays().get(it.getPlayId());
    }
}
