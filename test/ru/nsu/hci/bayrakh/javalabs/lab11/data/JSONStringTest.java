package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import static org.junit.jupiter.api.Assertions.*;

class JSONStringTest {
    @Test
    void sample_value() {
        final JSONString value = new JSONString("Hello, world!");
        assertEquals(value.getValue(), "Hello, world!");
        assertEquals(value.toJSON(), "\"Hello, world!\"");
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONString value = JSONString.parse(new JSONScanner("\"Hello, world!\""));
        assertEquals(value.getValue(), "Hello, world!");
        assertEquals(value.toJSON(), "\"Hello, world!\"");
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONString value = JSONString.parse(new JSONScanner("\"Hello, world!"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}
