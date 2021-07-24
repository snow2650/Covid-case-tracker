package model;

import java.util.LinkedList;

public class Condition {
    // REQUIRES: input case's location from 1-100, left time from 1-15, and number from 1-151
    // MODIFIES: this
    // EFFECTS: return the information if add successfully, otherwise return error message
    public static void inputInfoCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {

    }

    // REQUIRES: input pokemon's venue from 1-1000, and number from 1-151
    // MODIFIES: this
    // EFFECTS: delete the info that already exists and return message
    public static void removeInfoCon(LinkedList<CaseInfo> caseInfos, int venue, int time, int id) {

    }

    // REQUIRES: pokemon number is from 1-151
    // MODIFIES: this
    // EFFECTS: search person by number and return its basic information(listofinfo)
    public static boolean searchIDCon(LinkedList<CaseInfo> caseInfos, int venue, int time, int id) {

    }

    // REQUIRES: location is represented by number 1-1000
    // MODIFIES: this
    // EFFECTS: search pokemon by venue and return its basic information
    public static boolean searchLocationCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {

    }

    // REQUIRES: positive integer which Max is 24 min
    // MODIFIES: this
    // EFFECTS: search pokemon by left time and return its basic information
    public static boolean searchTimeCon(LinkedList<CaseInfo> caseInfos, int venue, int time, int id) {

    }

    // MODIFIES: this
    // EFFECTS: print all the informations of the Linkedlist
    public static void printin(LinkedList<CaseInfo> answer) {
        for (int i = 0; i < answer.size(); i++) {
            System.out.println("(" + answer.get(i).getLocation() + ", "
                    + answer.get(i).getTime() + ", "
                    + answer.get(i).getCaseID() + ")");
        }
    }


}
