package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JSONArrayTest {
    private static final String sampleJSON = "[null,true,false,2.5]";
    private final ArrayList<JSONValue> sampleList = new ArrayList<>();
    JSONArrayTest() {
        sampleList.add(new JSONNull());
        sampleList.add(new JSONBoolean(true));
        sampleList.add(new JSONBoolean(false));
        sampleList.add(new JSONNumber(2.5));
    }

    @Test
    void sample_value() {
        final JSONArray value = new JSONArray(sampleList);
        assertIterableEquals(value.getValue(), sampleList);
        assertEquals(value.toJSON(), sampleJSON);
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONArray value = JSONArray.parse(new JSONScanner(sampleJSON));
        assertIterableEquals(value.getValue(), sampleList);
        assertEquals(value.toJSON(), sampleJSON);
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONArray value = JSONArray.parse(new JSONScanner("[null,true,false,2.5!]"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}
