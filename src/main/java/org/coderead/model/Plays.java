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
        return getPlays().get(it.getPlayId()).getVolumeCredits(it);
    }
}
