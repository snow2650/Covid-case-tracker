package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class CaseInfo implements Writable {
    private int location;
    private int time;
    private int caseID;

    //REQUIRE:location, time caseID are not empty
    //MODIFIES:this
    //EFFECTS:is a set of basic information
    //        location is a number from 1~100, time is 0~24
    //        Different caseIDs represent different persons from 500-999
    public CaseInfo(int location, int time, int caseID) {
        this.location = location;
        this.time = time;
        this.caseID = caseID;
    }

    // MODIFIES: this
    // EFFECTS: returns a number which represent a place
    public int getLocation() {
        return location;
    }

    // EFFECTS: returns a number which represent the time the case showed up
    public int getTime() {
        return time;
    }

    // EFFECTS: returns an ID which represent a person
    public int getCaseID() {
        return caseID;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("location", location);
        json.put("time", time);
        json.put("caseID", caseID);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CaseInfo caseInfo = (CaseInfo) o;
        return location == caseInfo.location
                && time == caseInfo.time
                && caseID == caseInfo.caseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, time, caseID);
    }

}
