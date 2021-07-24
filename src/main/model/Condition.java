package model;

import java.util.LinkedList;

public class Condition {
    // REQUIRES: input case's location from 1-100, time from 0-24, and ID from 500-600
    // MODIFIES: this
    // EFFECTS: return the information if add successfully, otherwise return error message
    public static void inputInfoCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {
        if (location < 1 || location > 100) {
            System.out.println("invalid location");
        } else if (time < 0 || time > 24) {
            System.out.println("invalid time");
        } else if (id < 500 || id > 600) {
            System.out.println("invalid ID");
        } else {
            if (casecheck(caseInfos,"i", location, time, id).isEmpty()) {
                printin(casecheck(caseInfos,"i", location, time, id));
                System.out.println("(" + location + ", " + time + ", " + id + ") was added successfully");
            } else {
                System.out.println("Fail! The location in (" + location + ") was occupied");
            }
        }

    }

    // REQUIRES: input a person's venue from 1-100, and number from 500-600
    // MODIFIES: this
    // EFFECTS: delete the info that already exists and return message
    public static void removeInfoCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {
        if (location < 1 || location > 100) {
            System.out.println("invalid location");
        } else if (id < 500 || id > 600) {
            System.out.println("invalid ID");
        } else {
            if (!casecheck(caseInfos,"r", location, time, id).isEmpty()) {
                printin(casecheck(caseInfos,"r", location, time, id));
                System.out.println("was removed successfully");
            } else {
                System.out.println("Data was not found");
            }
        }

    }

    // REQUIRES: person ID is from 500-600
    // MODIFIES: this
    // EFFECTS: search person by number and return its basic information
    public static boolean searchIDCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {
        boolean found = false;
        if (id < 500 || id > 600) {
            System.out.println("invalid ID");

        } else {
            if (!casecheck(caseInfos,"p", location, time, id).isEmpty()) {
                printin(casecheck(caseInfos,"p", location, time, id));
                System.out.println("was found");
                found = true;
            } else {
                System.out.println("Data was not found");
            }
        }
        return found;

    }

    // REQUIRES: location is represented by number 1-100
    // MODIFIES: this
    // EFFECTS: search pokemon by venue and return its basic information
    public static boolean searchLocationCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {
        boolean found = false;
        if (location < 1 || id > 100) {
            System.out.println("invalid location");

        } else {
            if (!casecheck(caseInfos,"l", location, time, id).isEmpty()) {
                printin(casecheck(caseInfos,"l", location, time, id));
                System.out.println("was found");
                found = true;
            } else {
                System.out.println("Data was not found");
            }
        }
        return found;

    }

    // REQUIRES: positive integer which Max is 24 min
    // MODIFIES: this
    // EFFECTS: search pokemon by left time and return its basic information
    public static boolean searchTimeCon(LinkedList<CaseInfo> caseInfos, int location, int time, int id) {
        boolean found = false;
        if (time < 0 || time > 24) {
            System.out.println("invalid time");

        } else {
            if (!casecheck(caseInfos,"t", location, time, id).isEmpty()) {
                printin(casecheck(caseInfos,"t", location, time, id));
                System.out.println("was found");
                found = true;
            } else {
                System.out.println("Data was not found");
            }
        }
        return found;

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

    public static LinkedList<CaseInfo> casecheck(LinkedList<CaseInfo> caseInfos,
                                                 String type, int location, int time, int id) {
        LinkedList<CaseInfo> answer = new LinkedList();
        for (int i = 0; i < caseInfos.size(); i++) {
            if (checkboolean(caseInfos, type, location, time, id, i)) {
                answer.addLast(new CaseInfo(caseInfos.get(i).getLocation(),
                        caseInfos.get(i).getTime(), caseInfos.get(i).getCaseID()));
                if (type.equals("r")) {
                    caseInfos.remove(i);
                }
            }
        }
        if (type.equals("i") && answer.isEmpty()) {
            caseInfos.addLast(new CaseInfo(location, time, id));
        }
        return answer;
    }


    private static boolean checkboolean(LinkedList<CaseInfo> caseInfos,
                                        String type, int location, int time, int id, int i) {
        switch (type) {
            case "i":
                return caseInfos.get(i).getLocation() == location;
            case "r":
                return caseInfos.get(i).getLocation() == location && caseInfos.get(i).getCaseID() == id;
            case "l":
                return caseInfos.get(i).getLocation() == location;
            case "t":
                return caseInfos.get(i).getTime() >= time;
            case "p":
                return caseInfos.get(i).getCaseID() == id;
            default:
                return false; // need exception??
        }
    }


}
