package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import static org.junit.jupiter.api.Assertions.*;

class JSONNullTest {
    @Test
    void sample_value() {
        final JSONNull value = new JSONNull();
        assertEquals(value.getValue(), null);
        assertEquals(value.toJSON(), "null");
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONNull value = JSONNull.parse(new JSONScanner("null"));
        assertEquals(value.getValue(), null);
        assertEquals(value.toJSON(), "null");
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONNull value = JSONNull.parse(new JSONScanner("false"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}