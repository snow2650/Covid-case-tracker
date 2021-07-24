package ui;

import model.CaseInfo;
import model.Condition;

import java.util.ArrayList;
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
        LinkedList<CaseInfo> caseInfos = new LinkedList();
        input = new Scanner(System.in);
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

   // private void init(LinkedList<CaseInfo> caseInfos) {
        //caseInfos.addLast(new CaseInfo(1,0,500));
        //input = new Scanner(System.in);
    //}

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
        } else if (command.equals("p")) {  //search id
            searchID(caseInfos);
        } else if (command.equals("a")) {  //print all information
            printall(caseInfos);
        } else {
            System.out.println("selection not valid...");
        }
    }


    // MODIFIES: this, caseInfos
    // EFFECTS: input case's location from 1-100, time from 0000-2400, and ID
    public void inputInfo(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100), time (0-24), ID (500-600):");
        int location = input.nextInt();
        int time = input.nextInt();
        int id = input.nextInt();
        Condition.inputInfoCon(caseInfos, location, time, id);
    }

    // MODIFIES: this, caseInfos
    // EFFECTS: delete the info that already exist
    public void removeInfo(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100) and ID. (500~600):");
        int location = input.nextInt();
        int time = 1;
        int id = input.nextInt();
        Condition.removeInfoCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by ID
    public void searchID(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter ID (500~600):");
        int location = 1;
        int time = 1;
        int id = input.nextInt();
        Condition.searchIDCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the location
    public void searchLocation(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter location (1~100):");
        int location = input.nextInt();
        int time = 1;
        int id = 1;
        Condition.searchLocationCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the time
    public void searchTime(LinkedList<CaseInfo> caseInfos) {
        System.out.print("Enter hour (0~24):");
        int location = 1;
        int time = input.nextInt();
        int id = 1;
        Condition.searchTimeCon(caseInfos, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: print all the info
    public void printall(LinkedList<CaseInfo> caseInfos) {
        Condition.printin(caseInfos);
        System.out.println("------------------------------------------------");
    }


    // MODIFIES: this
    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("\nCOVID-19 CASE TRACKER");
        System.out.println("\nPLEASE SELECT THE OPERATION YOU NEED");
        System.out.println("ENTER THE LETTER FROM BELOW:");
        System.out.println("\ti -> input information");
        System.out.println("\tr -> remove information");
        System.out.println("\tl -> search by location");
        System.out.println("\tt -> search by time");
        System.out.println("\tp -> search the person by ID");
        System.out.println("\ta -> print all information");
        System.out.println("\tq -> quit");
    }






}
