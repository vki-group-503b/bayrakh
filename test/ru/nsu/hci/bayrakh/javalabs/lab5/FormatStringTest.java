package ru.nsu.hci.bayrakh.javalabs.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatStringTest {
    @Test
    void format() throws Exception {
        String yourName = "Igor", name = "jarvis", description = "AI from some movie";
        String formatted = FormatString.format("Hello, ${0}. My name is ${1}.\n I am ${1} - ${2}.",
                yourName, name, description);
        assertEquals(formatted, "Hello, Igor. My name is jarvis.\n I am jarvis - AI from some movie.");
    }

}