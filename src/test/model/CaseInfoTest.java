package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CaseInfoTest {
    @Test
    public void testCaseinfoEquals() {
        CaseInfo caseinfo1 = new CaseInfo(1,1,501);
        CaseInfo caseinfo2 = new CaseInfo(1,1,501);
        CaseInfo caseinfo3 = new CaseInfo(1,1,502);
        assertEquals(caseinfo1, caseinfo2);
        assertNotEquals(caseinfo1, caseinfo3);


        CaseInfo caseinfo4 = new CaseInfo(99,0,999);
        CaseInfo caseinfo5 = new CaseInfo(9,0,999);
        CaseInfo caseinfo6 = new CaseInfo(99,0,999);
        assertEquals(caseinfo4, caseinfo6);
        assertNotEquals(caseinfo5, caseinfo6);



        CaseInfo caseinfo7 = new CaseInfo(50,24,678);
        CaseInfo caseinfo8 = new CaseInfo(50,0,678);
        CaseInfo caseinfo9 = new CaseInfo(50,12,678);
        assertNotEquals(caseinfo7, caseinfo8);
        assertNotEquals(caseinfo8, caseinfo9);


    }



}