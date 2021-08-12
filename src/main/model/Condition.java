package model;

import exception.WrongIDException;
import exception.WrongLocationException;
import exception.WrongTimeException;
import ui.CaseFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static model.CaseList.caseCheck;

public class Condition extends CaseFrame {

    private static final int locationMin = 1;
    private static final int locationMax = 100;
    private static final int timeMin = 0;
    private static final int timeMax = 24;
    private static final int idMin = 500;
    private static final int idMax = 999;

    public static JLabel textlabel;

    public static void textlabelInit() {
        textlabel = new JLabel();
        textlabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
        textpanel.removeAll();
        textpanel.revalidate();
        textpanel.repaint();
    }

    // REQUIRES: x
    // MODIFIES: this
    // EFFECTS: return the information if add successfully, otherwise return error message
    public static void inputInfoCon(Record record, int location, int time, int caseID) {
        textlabelInit();
        catchExceptions(location, time, caseID);
        if (caseCheck(record, "i", location, time, caseID).isEmpty()) {
            printList(caseCheck(record, "i", location, time, caseID));
            System.out.println(" was added successfully");
            textlabel.setText("(" + location + ", " + time + ", " + caseID + ") was added successfully");
        } else {
            System.out.println("Fail! The data has existed.");
            textlabel.setText("Fail! The data has existed.");
        }
        textpanel.add(textlabel);
    }

    // REQUIRES: x
    // MODIFIES: this
    // EFFECTS: delete the info that already exists and return message
    public static void removeInfoCon(Record record, int location, int time, int caseID) {
        textlabelInit();
        catchExceptions(location, time, caseID);
        if (!caseCheck(record, "r", location, time, caseID).isEmpty()) {
            printList(caseCheck(record, "r", location, time, caseID));
            System.out.println(" was removed successfully");
            textlabel.setText("(" + location + ", " + time + ", " + caseID + ") was removed successfully");
        } else {
            System.out.println("Data was not found");
            textlabel.setText("Data was not found");
        }
        textpanel.add(textlabel);
    }

    // REQUIRES: x
    // MODIFIES: this
    // EFFECTS: search person by number and return its basic information
    public static boolean searchIDCon(Record record, int location, int time, int caseID) {
        textlabelInit();
        boolean found = false;
        catchExceptions(location, time, caseID);
        if (!caseCheck(record, "c", location, time, caseID).isEmpty()) {
            printList(caseCheck(record, "c", location, time, caseID));
            System.out.println("was found");
            found = true;
        } else {
            System.out.println("Data was not found");
            textlabel.setText("Data was not found");
        }
        return found;
    }

    // REQUIRES: x
    // MODIFIES: this
    // EFFECTS: search person by location and return its basic information
    public static boolean searchLocationCon(Record record, int location, int time, int caseID) {
        textlabelInit();
        boolean found = false;
        catchExceptions(location, time, caseID);
        if (!caseCheck(record, "l", location, time, caseID).isEmpty()) {
            printList(caseCheck(record, "l", location, time, caseID));
            System.out.println("was found");
            found = true;
        } else {
            System.out.println("Data was not found");
            textlabel.setText("Data was not found");
        }
        return found;
    }

    // REQUIRES: x
    // MODIFIES: this
    // EFFECTS: search a case by time and return its basic information
    public static boolean searchTimeCon(Record record, int location, int time, int caseID) {
        textlabelInit();
        boolean found = false;
        catchExceptions(location, time, caseID);
        if (!caseCheck(record, "t", location, time, caseID).isEmpty()) {
            printList(caseCheck(record, "t", location, time, caseID));
            System.out.println("was found");
            found = true;
        } else {
            System.out.println("Data was not found");
            textlabel.setText("Data was not found");
        }
        return found;
    }

    // MODIFIES: this
    // EFFECTS: print all the information in the list
    public static void printList(LinkedList<CaseInfo> answer) {
        for (int i = 0; i < answer.size(); i++) {
            System.out.println("(" + answer.get(i).getLocation() + ", "
                    + answer.get(i).getTime() + ", "
                    + answer.get(i).getCaseID() + ")");
        }
    }

    // MODIFIES: this
    // EFFECTS: check whether the parameters are valid
    public static void checkParameters(int location, int time, int caseID)
            throws WrongLocationException, WrongTimeException, WrongIDException {
        if (location < locationMin || location > locationMax) {
            throw new WrongLocationException();
        }
        if (time < timeMin || time > timeMax) {
            throw new WrongTimeException();
        }
        if (caseID < idMin || caseID > idMax) {
            throw new WrongIDException();
        }
    }

    // MODIFIES: this
    // EFFECTS: try and catch the exceptions of parameters
    public static void catchExceptions(int location, int time, int caseID) {
        try {
            checkParameters(location, time, caseID);
        } catch (WrongLocationException e) {
            System.out.println("invalid location");
        } catch (WrongTimeException e2) {
            System.out.println("invalid time");
        } catch (WrongIDException e3) {
            System.out.println("invalid caseID");
        }
    }
}
