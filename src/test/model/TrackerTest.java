package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {

    LinkedList<CaseInfo> caseInfos;
    private CaseInfo list1;
    private CaseInfo list2;
    private CaseInfo list3;
    private CaseInfo list4;


    @BeforeEach
    public void setUp() {
        caseInfos = new LinkedList();
        list1 = new CaseInfo(1, 1, 500);
        list2 = new CaseInfo(99, 15, 550);
        list3 = new CaseInfo(99, 8, 578);
        list4 = new CaseInfo(100, 8, 510);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, list1.getLocation());
        assertEquals(15, list2.getTime());
        assertEquals(578, list3.getCaseID());
        assertEquals(510, list4.getCaseID());
        assertTrue(list1.getCaseID() == 500);
        assertTrue(list2.getLocation() == 99);
        assertTrue(list3.getCaseID() == 578);
        assertTrue(list4.getTime() == 8);
    }

    @Test
    public void testInputInfoCon() {
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        assertTrue(CaseInfoquality(list1, caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        assertTrue(CaseInfoquality(list2, caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        assertTrue(CaseInfoquality(list2, caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, -1, 1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(-1, 1, 1), caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, 1, -1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(1, -1, 1), caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, 1, 1, -1);
        assertFalse(CaseInfoquality(new CaseInfo(1, 1, -1), caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, 100, 1, 1);
        assertFalse(CaseInfoquality(new CaseInfo(100, 1, 1), caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, 1, 10000, 1);
        assertFalse(CaseInfoquality(new CaseInfo(1, 10000, 1), caseInfos.getLast()));
        Condition.inputInfoCon(caseInfos, 1, 1, 10000);
        assertFalse(CaseInfoquality(new CaseInfo(1, 1, 10000), caseInfos.getLast()));
    }

    @Test
    public void testremoveInfoCon() {
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        Condition.inputInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        Condition.removeInfoCon(caseInfos, list2.getLocation(), 1, 1);
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        assertTrue(CaseInfoquality(list2, caseInfos.getLast()));
        Condition.removeInfoCon(caseInfos, -1, 1, 1);
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        Condition.removeInfoCon(caseInfos, 10000, 1, 1);
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        Condition.removeInfoCon(caseInfos, 1, 1,-1);
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        Condition.removeInfoCon(caseInfos, 1,1, 10000);
        assertFalse(CaseInfoquality(list1, caseInfos.getLast()));
        Condition.removeInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        assertTrue(CaseInfoquality(list1, caseInfos.getLast()));
    }

    @Test
    public void testsearchCaseIDCon() {
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        Condition.inputInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        assertTrue(Condition.searchIDCon(caseInfos,1, 1, list1.getCaseID()));
        assertTrue(Condition.searchIDCon(caseInfos, 1, 1, list2.getCaseID()));
        assertFalse(Condition.searchIDCon(caseInfos, 1, 1, list4.getCaseID()));
        assertFalse(Condition.searchIDCon(caseInfos, 1, 1, -1));
        assertFalse(Condition.searchIDCon(caseInfos, 1, 1, 10000));
        assertFalse(Condition.searchIDCon(caseInfos, 1, 1, 200));
        assertTrue(Condition.searchIDCon(caseInfos, 1, 1, 500));
        assertTrue(Condition.searchIDCon(caseInfos, 99, 15, 550));
    }

    @Test
    public void testsearchLocationCon() {
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        Condition.inputInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        assertTrue(Condition.searchLocationCon(caseInfos, list1.getLocation(), 1, 500));
        assertTrue(Condition.searchLocationCon(caseInfos, list2.getLocation(), 15, 550));
        assertFalse(Condition.searchLocationCon(caseInfos, list4.getLocation(), 1, 1));
        assertFalse(Condition.searchLocationCon(caseInfos, -1, 1, 1));
        assertFalse(Condition.searchLocationCon(caseInfos, 10000, 1, 1));
        assertFalse(Condition.searchLocationCon(caseInfos, 200, 1, 1));
        assertTrue(Condition.searchLocationCon(caseInfos, 1, 1, 500));
        assertTrue(Condition.searchLocationCon(caseInfos, 99, 15, 550));
    }

    @Test
    public void testsearchTimeCon() {
        Condition.inputInfoCon(caseInfos, list1.getLocation(), list1.getTime(), list1.getCaseID());
        Condition.inputInfoCon(caseInfos, list2.getLocation(), list2.getTime(), list2.getCaseID());
        assertTrue(Condition.searchTimeCon(caseInfos, 1, list1.getTime(), 1));
        assertTrue(Condition.searchTimeCon(caseInfos, 1, list2.getTime(), 1));
        Condition.inputInfoCon(caseInfos, list3.getLocation(), list3.getTime(), list3.getCaseID());
        Condition.inputInfoCon(caseInfos, list4.getLocation(), list4.getTime(), list4.getCaseID());
        assertTrue(Condition.searchTimeCon(caseInfos, 1, list3.getTime(), 1));
        assertTrue(Condition.searchTimeCon(caseInfos, 1, list4.getTime(), 1));
        assertTrue(Condition.searchTimeCon(caseInfos, 1, 15, 1));
        assertTrue(Condition.searchTimeCon(caseInfos, 1, 1, 1));
        assertFalse(Condition.searchTimeCon(caseInfos, 1, -1, 1));
        assertFalse(Condition.searchTimeCon(caseInfos, 1, 10000, 1));
    }

    public boolean CaseInfoquality(CaseInfo a, CaseInfo b) {
        return a.getLocation() == b.getLocation()
                && a.getTime() == b.getTime()
                && a.getCaseID() == b.getCaseID();
    }
}