package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseTrackerTest {

    Record record;
    private CaseInfo case1;
    private CaseInfo case2;
    private CaseInfo case3;
    private CaseInfo case4;


    @BeforeEach
    public void setUp() {
        record = new Record("Today's record");
        case1 = new CaseInfo(1, 1, 500);
        case2 = new CaseInfo(99, 15, 550);
        case3 = new CaseInfo(99, 8, 578);
        case4 = new CaseInfo(100, 8, 510);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, case1.getLocation());
        assertEquals(15, case2.getTime());
        assertEquals(578, case3.getCaseID());
        assertEquals(510, case4.getCaseID());
        assertTrue(case1.getCaseID() == 500);
        assertTrue(case2.getLocation() == 99);
        assertTrue(case3.getCaseID() == 578);
        assertTrue(case4.getTime() == 8);
    }
}