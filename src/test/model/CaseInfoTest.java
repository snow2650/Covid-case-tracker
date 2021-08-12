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
    }
}