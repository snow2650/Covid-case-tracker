package model;

import exception.WrongIDException;
import exception.WrongLocationException;
import exception.WrongTimeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static model.Condition.*;
import static org.junit.jupiter.api.Assertions.*;


public class ConditionTest {

    private Record record1;
    private LinkedList<CaseInfo> answerEmpty = new LinkedList<>();
    private LinkedList<CaseInfo> answer1 = new LinkedList<>();
    private LinkedList<CaseInfo> answer2 = new LinkedList<>();
    private LinkedList<CaseInfo> answer3 = new LinkedList<>();
    private LinkedList<CaseInfo> answer = new LinkedList<>();

    @BeforeEach
    public void setRecord1() {
        record1 = new Record("James's record");
        record1.addCaseInfo(new CaseInfo(1, 1, 501));
        record1.addCaseInfo(new CaseInfo(2, 2, 502));
        record1.addCaseInfo(new CaseInfo(3, 3, 503));
        answer1.add(new CaseInfo(1, 1, 501));
        answer2.add(new CaseInfo(2, 2, 502));
        answer3.add(new CaseInfo(3, 3, 503));
        answer.add(new CaseInfo(1, 1, 501));
        answer.add(new CaseInfo(2, 2, 502));
        answer.add(new CaseInfo(3, 3, 503));
    }


    @Test
    protected void AllrightTest() {
        try {
            checkParameters(1, 0, 500);
        } catch (WrongLocationException e) {
            fail("WrongLocationException should not be shown");
        } catch (WrongTimeException e2) {
            fail("WrongTimeException should not be shown");
        } catch (WrongIDException e3) {
            fail("WrongIDException should not be shown");
        }
    }

    @Test
    protected void WrongLocationTest1() {
        try {
            checkParameters(0, 0, 500);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            // pass
        } catch (WrongTimeException e2) {
            fail("WrongTimeException should not be shown");
        } catch (WrongIDException e3) {
            fail("WrongIDException should not be shown");
        }
    }

    @Test
    protected void WrongLocationTest2()  {
        try {
            checkParameters(101, 1, 500);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            // pass
        } catch (WrongTimeException e2) {
            fail("WrongTimeException should not be shown");
        } catch (WrongIDException e3) {
            fail("WrongIDException should not be shown");
        }
    }

    @Test
    protected void WrongTimeTest1()  {
        try {
            checkParameters(1, -1, 500);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            fail("WrongLocationException should not be shown");
        } catch (WrongTimeException e2) {
            // pass
        } catch (WrongIDException e3) {
            fail("WrongIDException should not be shown");
        }
    }

    @Test
    protected void WrongTimeTest2()  {
        try {
            checkParameters(1, 25, 500);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            fail("WrongLocationException should not be shown");
        } catch (WrongTimeException e2) {
            // pass
        } catch (WrongIDException e3) {
            fail("WrongIDException should not be shown");
        }
    }

    @Test
    protected void WrongIDTest1()  {
        try {
            checkParameters(1, 0, 499);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            fail("WrongLocationException should not be shown");
        } catch (WrongTimeException e2) {
            fail("WrongTimeException should not be shown");
        } catch (WrongIDException e3) {
            // pass
        }
    }

    @Test
    protected void WrongIDTest2()  {
        try {
            checkParameters(1, 0, 1000);
            fail("WrongException should not be shown");
        } catch (WrongLocationException e) {
            fail("WrongLocationException should not be shown");
        } catch (WrongTimeException e2) {
            fail("WrongTimeException should not be shown");
        } catch (WrongIDException e3) {
            // pass
        }
    }


}

