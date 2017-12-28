package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

public class JSONString extends JSONValue {
    public JSONString(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }

    @Override
    public String toJSON() {
        final String value = (String) getValue();
        final StringBuilder resultBuilder = new StringBuilder(value.length() * 2 + 2);
        resultBuilder.append('"');
        for (char c : value.toCharArray()) {
            final int code = c;
            if (code >= 256) {
                resultBuilder.append("\\u");
                resultBuilder.append(Integer.toHexString(code));
            } else if (c == '"') {
                resultBuilder.append("\\\"");
            } else if (c == '\\') {
                resultBuilder.append("\\\\");
            } else if (c == '\b') {
                resultBuilder.append("\\b");
            } else if (c == '\f') {
                resultBuilder.append("\\f");
            } else if (c == '\n') {
                resultBuilder.append("\\n");
            } else if (c == '\r') {
                resultBuilder.append("\\r");
            } else if (c == '\t') {
                resultBuilder.append("\\t");
            } else {
                resultBuilder.append(c);
            }
        }
        resultBuilder.append('"');
        return resultBuilder.toString();
    }

    public static JSONString parse(JSONScanner scanner) throws UnexpectedInputException {
        return new JSONString(
                (String) scanner.expectNext(TokenKind.StringToken)
        );
    }
}
