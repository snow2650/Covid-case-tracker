package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static model.CheckBoolean.checkBoolean;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBooleanTest {

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
    public void testcheckBoolean() {
        assertTrue(checkBoolean(answer, "i", 1,1,501,0));
        assertFalse(checkBoolean(answer, "i", 1,1,501,1));
        assertTrue(checkBoolean(answer, "r", 1,1,501,0));
        assertFalse(checkBoolean(answer, "r", 1,1,501,1));
        assertTrue(checkBoolean(answer, "l", 1,1,501,0));
        assertFalse(checkBoolean(answer, "l", 1,1,501,1));
        assertTrue(checkBoolean(answer, "t", 1,1,501,0));
        assertFalse(checkBoolean(answer, "t", 1,10,501,0));
        assertTrue(checkBoolean(answer, "c", 1,1,501,0));
        assertFalse(checkBoolean(answer, "c", 1,1,501,1));
        assertFalse(checkBoolean(answer, "xxx", 1,1,501,0));
    }
}
