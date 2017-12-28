package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

public class JSONBoolean extends JSONValue {
    public JSONBoolean(boolean value) {
        super(value);
    }

    @Override
    public Boolean getValue() {
        return (Boolean) super.getValue();
    }

    @Override
    public String toJSON() {
        if (getValue()) {
            return "true";
        } else {
            return "false";
        }
    }

    public static JSONBoolean parse(JSONScanner scanner) throws UnexpectedInputException {
        return new JSONBoolean(
                (Boolean) scanner.expectNext(TokenKind.BooleanToken)
        );
    }
}
