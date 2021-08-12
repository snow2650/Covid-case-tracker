package model;

import java.util.LinkedList;

public class CheckBoolean {

    // MODIFIES: this
    // EFFECTS: check if the information follows the rules under each function
    public static boolean checkBoolean(LinkedList<CaseInfo> caseInfos,
                                       String type, int location, int time, int caseID, int i) {
        switch (type) {
            case "i":
            case "r":
                return caseInfos.get(i).getLocation() == location
                        && caseInfos.get(i).getTime() == time
                        && caseInfos.get(i).getCaseID() == caseID;
            case "l":
                return caseInfos.get(i).getLocation() == location;
            case "t":
                return caseInfos.get(i).getTime() == time;//Time is 24 hour format
            case "c":
                return caseInfos.get(i).getCaseID() == caseID;
            default:
                return false;
        }
    }
}
