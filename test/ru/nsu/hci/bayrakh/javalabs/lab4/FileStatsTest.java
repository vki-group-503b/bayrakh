package ru.nsu.hci.bayrakh.javalabs.lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileStatsTest {

    final String input = "Hi, user!\nMy name is BRO-BOT and I'm here to help you\nwith your bad.";

    @Test
    void useCaseTest() throws Exception {
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        FileStats stats = new FileStats(stream);
        assertEquals(stats.getLines(), 3);
        assertEquals(stats.getWords(), 15);
        assertEquals(stats.getLetters(), 49);
        HashMap<Character, Integer> counts = stats.getLetterCounts();
        assertEquals(counts.get('A').intValue(), 3);
        assertEquals(counts.get('B').intValue(), 3);
        assertEquals(counts.get('D').intValue(), 2);
        assertEquals(counts.get('E').intValue(), 5);
        assertEquals(counts.get('H').intValue(), 4);
        assertEquals(counts.get('I').intValue(), 4);
        assertEquals(counts.get('L').intValue(), 1);
        assertEquals(counts.get('M').intValue(), 3);
        assertEquals(counts.get('N').intValue(), 2);
        assertEquals(counts.get('O').intValue(), 5);
        assertEquals(counts.get('P').intValue(), 1);
        assertEquals(counts.get('R').intValue(), 4);
        assertEquals(counts.get('S').intValue(), 2);
        assertEquals(counts.get('T').intValue(), 3);
        assertEquals(counts.get('U').intValue(), 3);
        assertEquals(counts.get('W').intValue(), 1);
        assertEquals(counts.get('Y').intValue(), 3);
        assertEquals(counts.size(), 17);
    }

}