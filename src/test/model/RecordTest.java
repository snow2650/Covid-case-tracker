package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    private Record record1;
    private CaseInfo listA;
    private CaseInfo listB;
    private CaseInfo listC;

    @BeforeEach
    public void setRecord1() {
        record1 = new Record("Jessie's record");
        listA = new CaseInfo(1, 1, 501);
        listB = new CaseInfo(2, 2, 502);
        listC = new CaseInfo(3, 3, 503);
        record1.addCaseInfo(listA);
        record1.addCaseInfo(listB);
        record1.addCaseInfo(listC);
    }

    @Test
    public void TestGetName() {
        assertEquals(record1.getName(),"Jessie's record");
    }

    @Test
    public void TestGetCaseInfo() {
        assertEquals(record1.getCaseInfo().get(0),((new CaseInfo(1, 1, 501))));
        assertEquals(record1.getCaseInfo().get(1),((new CaseInfo(2, 2, 502))));
        assertEquals(record1.getCaseInfo().get(2),((new CaseInfo(3, 3, 503))));

    }

    @Test
    public void testnumCaseInfo() {
        assertEquals(record1.numCaseInfo(),3);
    }
}
