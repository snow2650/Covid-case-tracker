package model;

import java.util.LinkedList;

import static model.CheckBoolean.checkBoolean;

public class CaseList {

    static LinkedList<CaseInfo> answer;


    // MODIFIES: this
    // EFFECTS: check if there are the same information in the list
    public static LinkedList<CaseInfo> caseCheck(Record record, String type, int location, int time, int caseID) {
        answer = new LinkedList();
        for (int i = 0; i < record.numCaseInfo(); i++) {
            if (checkBoolean(record.getCaseInfo(), type, location, time, caseID, i)) {
                answer.addLast(new CaseInfo(record.getCaseInfo().get(i).getLocation(),
                        record.getCaseInfo().get(i).getTime(), record.getCaseInfo().get(i).getCaseID()));
                if (type.equals("r")) {
                    record.getCaseInfo().remove(i);
                }
            }
        }
        if (type.equals("i") && answer.isEmpty()) {
            record.getCaseInfo().addLast(new CaseInfo(location, time, caseID));
        }
        return answer;
    }

/*
    // MODIFIES: this
    // EFFECTS: check if the information follows the rules under each function
    private static boolean checkBoolean(LinkedList<CaseInfo> caseInfos,
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
        }*/
}





