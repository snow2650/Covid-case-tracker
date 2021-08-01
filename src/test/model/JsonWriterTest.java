package model;


import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Record record = new Record("My record");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyRecord() {
        try {
            Record record = new Record("My record");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyRecord.json");
            writer.open();
            writer.write(record);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyRecord.json");
            record = reader.read();
            assertEquals("My record", record.getName());
            assertEquals(0, record.numCaseInfo());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralRecord() {
        try {
            Record record = new Record("My record");
            record.addCaseInfo(new CaseInfo(1, 1 ,501));
            record.addCaseInfo(new CaseInfo(2, 2, 502));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralRecord.json");
            writer.open();
            writer.write(record);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralRecord.json");
            record = reader.read();
            assertEquals("My record", record.getName());
            LinkedList<CaseInfo> caseInfoS = record.getCaseInfo();
            assertEquals(2, caseInfoS.size());
            caseInfoS.get(0).equals(new CaseInfo(1, 1 ,501));
            caseInfoS.get(1).equals(new CaseInfo(2, 2 ,502));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
