package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

public class JSONNull extends JSONValue {
    public JSONNull() {
        super(null);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String toJSON() {
        return "null";
    }

    public static JSONNull parse(JSONScanner scanner) throws UnexpectedInputException {
        scanner.expectNext(TokenKind.NullToken);
        return new JSONNull();
    }
}
