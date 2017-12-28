package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import static org.junit.jupiter.api.Assertions.*;

class JSONNumberTest {
    @Test
    void sample_value() {
        JSONNumber value = new JSONNumber(2.5);
        assertEquals(value.getValue().doubleValue(), 2.5);
        assertEquals(value.toJSON(), "2.5");
        value = new JSONNumber(-1.75e-8);
        assertEquals(value.getValue().doubleValue(), -1.75e-8);
        assertEquals(value.toJSON(), "-1.75e-8");
        value = new JSONNumber(2.5e16);
        assertEquals(value.getValue().doubleValue(), 2.5e16);
        assertEquals(value.toJSON(), "2.5e16");
    }

    @Test
    void correctly_parsed_value() throws UnexpectedInputException {
        JSONNumber value = JSONNumber.parse(new JSONScanner("3.75"));
        assertEquals(value.getValue().doubleValue(), 3.75);
        assertEquals(value.toJSON(), "3.75");
        value = JSONNumber.parse(new JSONScanner("2.5e-10"));
        assertEquals(value.getValue().doubleValue(), 2.5e-10);
        assertEquals(value.toJSON(), "2.5e-10");
        value = JSONNumber.parse(new JSONScanner("-5e5"));
        assertEquals(value.getValue().doubleValue(), -5e5);
        assertEquals(value.toJSON(), "-500000");
    }

    @Test
    void incorrectly_parsed_value() throws Exception {
        try {
            JSONNumber value = JSONNumber.parse(new JSONScanner("false"));
            throw new Exception("Достигнут недостижимый участок кода.");
        } catch (UnexpectedInputException e) { }
    }
}