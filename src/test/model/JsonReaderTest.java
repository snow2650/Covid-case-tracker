package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Record record = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyRecord() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRecord.json");
        try {
            Record record = reader.read();
            assertEquals("Today's record", record.getName());
            assertEquals(0, record.numCaseInfo());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralRecord() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralRecord.json");
        try {
            Record record = reader.read();
            assertEquals("Today's record", record.getName());
            LinkedList<CaseInfo> caseInfoS = record.getCaseInfo();
            assertEquals(3, caseInfoS.size());
            caseInfoS.get(0).equals(new CaseInfo(1, 1 ,501));
            caseInfoS.get(1).equals(new CaseInfo(2, 2 ,502));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}