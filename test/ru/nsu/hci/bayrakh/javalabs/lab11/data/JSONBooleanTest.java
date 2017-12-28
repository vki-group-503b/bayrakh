package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import static org.junit.jupiter.api.Assertions.*;

class JSONBooleanTest {
    @Test
    void sample_value() {
        JSONBoolean value = new JSONBoolean(true);
        assertEquals(value.getValue(), true);
        assertEquals(value.toJSON(), "true");
        value = new JSONBoolean(false);
        assertEquals(value.getValue(), false);
        assertEquals(value.toJSON(), "false");
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONBoolean value = JSONBoolean.parse(new JSONScanner("true"));
        assertEquals(value.getValue(), true);
        assertEquals(value.toJSON(), "true");
        value = JSONBoolean.parse(new JSONScanner("false"));
        assertEquals(value.getValue(), false);
        assertEquals(value.toJSON(), "false");
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONBoolean value = JSONBoolean.parse(new JSONScanner("null"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}