package ui;

import model.Condition;
import model.Record;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CaseTracker {
    private static final String JSON_STORE = "./data/record.json";
    private Scanner input;
    private Record record;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs record and runs the CaseTracker application
    public CaseTracker() throws FileNotFoundException {
        input = new Scanner(System.in);
        record = new Record("Area A's record");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes information input
    private void runTracker() {
        boolean keepGoing = true;
        String command;
        //caseInfos = new LinkedList();
        //input = new Scanner(System.in);//if need a non empty list,remove this line

        //init(caseInfos);
        while (keepGoing) {
            displayMenu();
            command = input.next().toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command, record);
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
    public void processCommand(String command, Record record) {
        if (command.equals("i")) {  //input basic information
            inputInfo(record);
        } else if (command.equals("r")) {
            removeInfo(record);
        } else if (command.equals("f")) {  //find basic information
            findWithMethod(record);
        } else if (command.equals("s")) {  //save the record
            saveRecord();
        } else if (command.equals("l")) {  //load the record
            loadRecord();
        } else if (command.equals("a")) {  //print all information
            printAll(record);
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

        System.out.println("\tf -> find basic information");
        //System.out.println("\tl -> search by location");
        //System.out.println("\tt -> search by time");
        //System.out.println("\tc -> search by case ID");
        System.out.println("\ta -> print all information");

        System.out.println("\ts -> save the record");
        System.out.println("\tl -> load the record");
        System.out.println("\tq -> quit");
    }

    public void findWithMethod(Record record) {
        System.out.println("select from:");
        System.out.println("\tl -> search by location");
        System.out.println("\tt -> search by time");
        System.out.println("\tc -> search by case ID");
        String command = input.next().toLowerCase();;
        if (command.equals("l")) {  //search by place
            searchLocation(record);
        } else if (command.equals("t")) {  //search by time
            searchTime(record);
        } else if (command.equals("c")) {  //search id
            searchID(record);
        } else {
            System.out.println("selection not valid...");
        }
    }




    // MODIFIES: this, caseInfos
    // EFFECTS: input case's location from 1-100, time from 0000-2400, and ID
    public void inputInfo(Record record) {
        System.out.print("Enter location (1~100), time (0-24), ID (500~999) for adding:");
        int location = input.nextInt();
        int time = input.nextInt();
        int id = input.nextInt();
        Condition.inputInfoCon(record, location, time, id);//change to a call to caseinfolist
    }

    // MODIFIES: this, caseInfos
    // EFFECTS: delete the info that already exist
    public void removeInfo(Record record) {
        System.out.print("Enter location (1~100), time (0-24), ID (500~999) for removing:");
        int location = input.nextInt();
        int time = input.nextInt();
        int id = input.nextInt();
        Condition.removeInfoCon(record, location, time, id);
        //CaseList.addInfo;
    }

    // MODIFIES: this
    // EFFECTS: search the info by ID
    public void searchID(Record record) {
        System.out.print("Enter ID (500~999):");
        int location = 1;
        int time = 0;
        int id = input.nextInt();
        Condition.searchIDCon(record, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the location
    public void searchLocation(Record record) {
        System.out.print("Enter location (1~100):");
        int location = input.nextInt();
        int time = 0;
        int id = 500;
        Condition.searchLocationCon(record, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: search the info by the time
    public void searchTime(Record record) {
        System.out.print("Enter hour (0~24):");
        int location = 1;
        int time = input.nextInt();
        int id = 500;
        Condition.searchTimeCon(record, location, time, id);
    }

    // MODIFIES: this
    // EFFECTS: print all the info in the list
    public void printAll(Record record) {
        Condition.printList(record.getCaseInfo());
        if (record.numCaseInfo() == 1) {
            System.out.println("----------There is 1 case.------------");
        } else if (record.numCaseInfo() == 0) {
            System.out.println("--------No cases today!----------");
        } else {
            System.out.println("--------There are " + record.numCaseInfo() + " cases.----------");
        }
    }

    // EFFECTS: saves the record to file
    private void saveRecord() {
        try {
            jsonWriter.open();
            jsonWriter.write(record);
            jsonWriter.close();
            System.out.println("Saved " + record.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads record from file
    private void loadRecord() {
        try {
            record = jsonReader.read();
            System.out.println("Loaded " + record.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }




}
