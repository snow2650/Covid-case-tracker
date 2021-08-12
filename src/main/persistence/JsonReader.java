package persistence;

import model.CaseInfo;
import model.Record;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads record from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Record read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseRecord(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses record from JSON object and returns it
    private Record parseRecord(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Record record = new Record(name);
        addCaseInfoS(record, jsonObject);
        return record;
    }

    // MODIFIES: this, record
    // EFFECTS: parses casesInfoS from JSON object and adds them to record
    private void addCaseInfoS(Record record, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("casesInfoS");
        for (Object json : jsonArray) {
            JSONObject nextCaseInfo = (JSONObject) json;
            addCaseInfo(record, nextCaseInfo);
        }
    }

    // MODIFIES: this, record
    // EFFECTS: parses caseInfo from JSON object and adds it to record
    private void addCaseInfo(Record record, JSONObject jsonObject) {
        int location = jsonObject.getInt("location");
        int time = jsonObject.getInt("time");
        int caseID = jsonObject.getInt("caseID");
        CaseInfo caseinfo = new CaseInfo(location, time, caseID);
        record.addCaseInfo(caseinfo);
    }
}
