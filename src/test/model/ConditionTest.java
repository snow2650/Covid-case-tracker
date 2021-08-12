package model;

import exception.WrongIDException;
import exception.WrongLocationException;
import exception.WrongTimeException;
import org.junit.jupiter.api.Test;

import static model.Condition.checkParameters;
import static org.junit.jupiter.api.Assertions.fail;

public class ConditionTest {

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

