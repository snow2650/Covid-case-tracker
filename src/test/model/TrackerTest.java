package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {

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

    @Test
    public void testInputInfoCon() {
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        assertTrue(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        assertTrue(CaseInfoquality(case2, record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        assertTrue(CaseInfoquality(case2, record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , -1, 1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(-1, 1, 1), record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , 1, -1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(1, -1, 1), record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , 1, 1, -1);
        assertFalse(CaseInfoquality(new CaseInfo(1, 1, -1), record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , 100, 1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(100, 1, 1), record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , 1, 10000, 1);
        assertFalse(CaseInfoquality(new CaseInfo(1, 10000, 1), record.getCaseInfo().getLast()));
        Condition.inputInfoCon(record
                , 1, 1, 10000);
        assertFalse(CaseInfoquality(new CaseInfo(1, 1, 10000), record.getCaseInfo().getLast()));
    }

    @Test
    public void testremoveInfoCon() {
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        Condition.inputInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        Condition.removeInfoCon(record
                , case2.getLocation(), 1, 1);
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        assertTrue(CaseInfoquality(case2, record.getCaseInfo().getLast()));
        Condition.removeInfoCon(record
                , -1, 1, 1);
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        Condition.removeInfoCon(record
                , 10000, 1, 1);
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        Condition.removeInfoCon(record
                , 1, 1,-1);
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        Condition.removeInfoCon(record
                , 1,1, 10000);
        assertFalse(CaseInfoquality(case1, record.getCaseInfo().getLast()));
        Condition.removeInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        assertTrue(CaseInfoquality(case1, record.getCaseInfo().getLast()));
    }

    @Test
    public void testsearchCaseIDCon() {
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        Condition.inputInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        assertTrue(Condition.searchIDCon(record
                ,1, 1, case1.getCaseID()));
        assertTrue(Condition.searchIDCon(record
                , 1, 1, case2.getCaseID()));
        assertFalse(Condition.searchIDCon(record
                , 1, 1, case4.getCaseID()));
        assertFalse(Condition.searchIDCon(record
                , 1, 1, -1));
        assertFalse(Condition.searchIDCon(record
                , 1, 1, 10000));
        assertFalse(Condition.searchIDCon(record
                , 1, 1, 200));
        assertTrue(Condition.searchIDCon(record
                , 1, 1, 500));
        assertTrue(Condition.searchIDCon(record
                , 99, 15, 550));
    }

    @Test
    public void testsearchLocationCon() {
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        Condition.inputInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        assertTrue(Condition.searchLocationCon(record
                , case1.getLocation(), 1, 500));
        assertTrue(Condition.searchLocationCon(record
                , case2.getLocation(), 15, 550));
        assertFalse(Condition.searchLocationCon(record
                , case4.getLocation(), 1, 1));
        assertFalse(Condition.searchLocationCon(record
                , -1, 1, 1));
        assertFalse(Condition.searchLocationCon(record
                , 10000, 1, 1));
        assertFalse(Condition.searchLocationCon(record
                , 200, 1, 1));
        assertTrue(Condition.searchLocationCon(record
                , 1, 1, 500));
        assertTrue(Condition.searchLocationCon(record
                , 99, 15, 550));
    }

    @Test
    public void testsearchTimeCon() {
        Condition.inputInfoCon(record
                , case1.getLocation(), case1.getTime(), case1.getCaseID());
        Condition.inputInfoCon(record
                , case2.getLocation(), case2.getTime(), case2.getCaseID());
        assertTrue(Condition.searchTimeCon(record
                , 1, case1.getTime(), 1));
        assertTrue(Condition.searchTimeCon(record
                , 1, case2.getTime(), 1));
        Condition.inputInfoCon(record
                , case3.getLocation(), case3.getTime(), case3.getCaseID());
        Condition.inputInfoCon(record
                , case4.getLocation(), case4.getTime(), case4.getCaseID());
        assertTrue(Condition.searchTimeCon(record
                , 1, case3.getTime(), 1));
        assertTrue(Condition.searchTimeCon(record
                , 1, case4.getTime(), 1));
        assertTrue(Condition.searchTimeCon(record
                , 1, 15, 1));
        assertTrue(Condition.searchTimeCon(record
                , 1, 1, 1));
        assertFalse(Condition.searchTimeCon(record
                , 1, -1, 1));
        assertFalse(Condition.searchTimeCon(record
                , 1, 10000, 1));
    }

    public boolean CaseInfoquality(CaseInfo a, CaseInfo b) {
        return a.getLocation() == b.getLocation()
                && a.getTime() == b.getTime()
                && a.getCaseID() == b.getCaseID();
    }
}