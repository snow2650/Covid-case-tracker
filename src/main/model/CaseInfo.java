package model;

import com.sun.scenario.effect.impl.sw.sse.SSEEffectPeer;

public class CaseInfo {
    private int venue;
    private int time;
    private String caseID;

    //REQUIRE:
    //MODIFIES:
    //EFFECTS:

    public CaseInfo(int venue, int time, String caseID) {
        this.venue = venue;
        this.time = time;
        this.caseID = caseID;



    }

    // MODIFIES: this
    // EFFECTS: returns a number which represent a place in this AppearInfo
    public int getVenue() {
        return venue;
    }

    // EFFECTS: returns a number which represent left minuets in this AppearInfo
    public int getTime() {
        return time;
    }

    // EFFECTS: returns a number which represent a pokemon in this AppearInfo
    public String getCaseID() {
        return caseID;
    }

}
