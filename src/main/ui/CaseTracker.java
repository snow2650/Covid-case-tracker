package ui;

import model.CaseInfo;

import model.CaseList;
import model.Condition;
import java.util.LinkedList;
import java.util.Scanner;

public class CaseTracker {
    private LinkedList<CaseInfo> caseInfos;
    private Scanner input;

    public CaseTracker() {
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes information input
    private void runTracker() {
        boolean keepGoing = true;
        String command;
        caseInfos = new LinkedList();
        input = new Scanner(System.in);//if need a non empty list,remove this line
        //init(caseInfos);
        while (keepGoing) {
            displayMenu();
            command = input.next().toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command, caseInfos);
            }
        }
        System.out.println("\nGood Bye! Wish you healthy!");
    }
/*

    private void init(LinkedList<CaseInfo> caseInfos) {
        caseInfos.addLast(new CaseInfo(1,0,500));
        caseInfos.addLast(new CaseInfo(1,1,645));
        caseInfos.addLast(new CaseInfo(22,1,645));
        caseInfos.addLast(new CaseInfo(33,1,645));
        caseInfos.addLast(new CaseInfo(44,12,500));
        caseInfos.addLast(new CaseInfo(44,12,700));
        caseInfos.addLast(new CaseInfo(55,20,800));
        caseInfos.addLast(new CaseInfo(99,24,999));
        caseInfos.addLast(new CaseInfo(100,24,999));

        input = new Scanner(System.in);
    }
 //*/

    // MODIFIES: this
    // EFFECTS: processes user command
    public void processCommand(String command, LinkedList<CaseInfo> caseInfos) {
        if (command.equals("i")) {  //input basic information
            inputInfo(caseInfos);
        } else if (command.equals("r")) {
            removeInfo(caseInfos);
        } else if (command.equals("t")) {  //search by time
            searchTime(caseInfos);
        } else if (command.equals("l")) {  //search by place
            searchLocation(caseInfos);
        } else if (command.equals("c")) {  //search id
            searchID(caseInfos);
        } else if (command.equals("a")) {  //print all information
            printAll(caseInfos);
        } else {
            System.out.println("selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("\nCOVID-19 CASE TRACKER");
        System.out.println("\nPLEASE SELECT ONE FUNCTION ");
        System.out.println("ENTER THE LETTER FROM BELOW:");
        System.out.println("\ti -> input information");
        System.out.println("\tr -> remove information");
        System.out.println("\tl -> search by location");
        System.out.println("\tt -> search by time");
        System.out.println("\tc -> search by case ID");
        System.out.println("\ta -> print all information");
        System.out.println("\tq -> quit");
    }


    // MODIFIES: this, caseInfos
    // EFFECTS: input case's location from 1-100, time from 0000-2400, and ID
    public void inputInfo(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100), time (0-24), ID (500~999) for adding:");
        int location = input.nextInt();
        int time = input.nextInt();
        int id = input.nextInt();
        Condition.inputInfoCon(caseInfos, location, time, id);//change to a call to caseinfolist
    }

    // MODIFIES: this, caseInfos
    // EFFECTS: delete the info that already exist
    public void removeInfo(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100), time (0-24), ID (500~999) for removing:");
        int location = input.nextInt();
        int time = input.nextInt();
        int id = input.nextInt();
        Condition.removeInfoCon(caseInfos, location, time, id);
        //CaseList.addInfo;
    }

    // MODIFIES: this
    // EFFECTS: search the info by ID
    public void searchID(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter ID (500~999):");
        int location = 1;
        int time = 0;
        int id = input.nextInt();
        Condition.searchIDCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the location
    public void searchLocation(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100):");
        int location = input.nextInt();
        int time = 0;
        int id = 500;
        Condition.searchLocationCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the time
    public void searchTime(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter hour (0~24):");
        int location = 1;
        int time = input.nextInt();
        int id = 500;
        Condition.searchTimeCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: print all the info in the list
    public void printAll(LinkedList<CaseInfo> caseInfos) {
        Condition.printList(caseInfos);
        if (caseInfos.size() == 1) {
            System.out.println("----------There is 1 case.------------");
        } else if (caseInfos.size() == 0) {
            System.out.println("--------No cases today!----------");
        } else {
            System.out.println("--------There are " + caseInfos.size() + " cases.----------");
        }
    }




}
