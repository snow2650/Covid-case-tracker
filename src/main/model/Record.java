package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.LinkedList;

public class Record implements Writable {
    private String name;
    private LinkedList<CaseInfo> casesinfoS;

    // EFFECTS: constructs record with a name and empty list of thingies
    public Record(String name) {
        this.name = name;
        casesinfoS = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds thingy to this record
    public void addCaseInfo(CaseInfo caseinfo) {
        casesinfoS.add(caseinfo);
    }

    // EFFECTS: returns an unmodifiable list of thingies in this record
    public LinkedList<CaseInfo> getCaseInfo() {
        return casesinfoS;
    }

    // EFFECTS: returns number of thingies in this record
    public int numCaseInfo() {
        return casesinfoS.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("casesInfoS", caseinfoToJson());
        return json;
    }

    // EFFECTS: returns things in this record as a JSON array

    private JSONArray caseinfoToJson() {
        JSONArray jsonArray = new JSONArray();
        for (CaseInfo a : casesinfoS) {
            jsonArray.put(a.toJson());
        }
        return jsonArray;
    }


}
