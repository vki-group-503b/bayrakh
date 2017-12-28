package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

import org.junit.jupiter.api.Test;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.Token;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import static org.junit.jupiter.api.Assertions.*;

class JSONScannerTest {
    void assertToken(Token a, Token b) {
        assertEquals(a.getKind(), b.getKind());
        assertEquals(a.getValue(), b.getValue());
    }
    @Test
    void scanner_scans_simple_object() throws UnexpectedInputException {
        JSONScanner scanner = new JSONScanner("{\"a\":-2.5}");
        assertEquals(
                scanner.next().getKind(),
                TokenKind.ObjectBeginToken
        );
        assertToken(
                scanner.next(),
                new Token(TokenKind.StringToken, "a")
        );
        assertEquals(
                scanner.next().getKind(),
                TokenKind.ObjectPairDelimiterToken
        );
        assertToken(
                scanner.next(),
                new Token(TokenKind.NumberToken, -2.5)
        );
        assertEquals(
                scanner.next().getKind(),
                TokenKind.ObjectEndToken
        );
        assertEquals(
                scanner.next().getKind(),
                TokenKind.EndOfInput
        );
    }
}