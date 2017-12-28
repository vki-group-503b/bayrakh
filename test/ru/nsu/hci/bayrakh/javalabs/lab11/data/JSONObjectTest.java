package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JSONObjectTest {
    private static final String sampleJSON = "{\"a\":[true,2],\"coordinateX\":[false]}";
    private final TreeMap<JSONValue, JSONValue> sampleMap = new TreeMap<>();
    JSONObjectTest() {
        final ArrayList<JSONValue> listA = new ArrayList<>(2);
        listA.add(new JSONBoolean(true));
        listA.add(new JSONNumber(2.0));
        sampleMap.put(new JSONString("a"), new JSONArray(listA));
        final ArrayList<JSONValue> listX = new ArrayList<>(1);
        listX.add(new JSONBoolean(false));
        sampleMap.put(new JSONString("coordinateX"), new JSONArray(listX));
    }

    static void assertMapsEquals(Map<JSONValue, JSONValue> left, Map<JSONValue, JSONValue> right) {
        Iterator<Map.Entry<JSONValue, JSONValue>> leftIterator = right.entrySet().iterator();
        Iterator<Map.Entry<JSONValue, JSONValue>> rightIterator = right.entrySet().iterator();
        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            final Map.Entry<JSONValue, JSONValue> leftEntry = leftIterator.next();
            final Map.Entry<JSONValue, JSONValue> rightEntry = rightIterator.next();
            assertEquals(leftEntry.getKey(), rightEntry.getKey());
            assertEquals(leftEntry.getValue(), rightEntry.getValue());
        }
        assertEquals(leftIterator.hasNext(), rightIterator.hasNext());
    }

    @Test
    void sample_value() {
        final JSONObject value = new JSONObject(sampleMap);
        assertMapsEquals(value.getValue(), sampleMap);
        assertEquals(value.toJSON(), sampleJSON);
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONObject value = JSONObject.parse(new JSONScanner(sampleJSON));
        assertMapsEquals(value.getValue(), sampleMap);
        assertEquals(value.toJSON(), sampleJSON);
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONObject value = JSONObject.parse(new JSONScanner("false"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}
