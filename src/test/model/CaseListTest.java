package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static model.CaseList.caseCheck;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CaseListTest {
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
    public void testcaseCheck() {
        assertEquals(caseCheck(record1, "i", 1,1,501), answer1);
        assertEquals(caseCheck(record1, "i", 2,2,502), answer2);
        assertEquals(caseCheck(record1, "r", 1,1,501), answer1);
        assertNotEquals(caseCheck(record1, "r", 2,3,502), answer2);
        assertNotEquals(caseCheck(record1, "l", 1,1,501), answer1);
        assertEquals(caseCheck(record1, "l", 2,2,502), answer2);
        assertEquals(caseCheck(record1, "t", 1,1,501), answerEmpty);
        assertNotEquals(caseCheck(record1, "t", 1,1,502), answer2);
        assertNotEquals(caseCheck(record1, "c", 1,1,501), answer1);
        assertEquals(caseCheck(record1, "c", 1,1,502), answer2);
        assertEquals(caseCheck(record1, "xxx", 1,1,501),answerEmpty);
    }
}


