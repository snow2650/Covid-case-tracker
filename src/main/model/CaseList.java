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

    // EFFECTS: returns the answer
    public static LinkedList<CaseInfo> getanswer() {
        return answer;
    }
}





