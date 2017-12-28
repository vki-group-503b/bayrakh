package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class JSONObject extends JSONValue {
    public JSONObject(Map<JSONValue, JSONValue> value) {
        super(value);
    }

    @Override
    public Map<JSONValue, JSONValue> getValue() {
        return (Map<JSONValue, JSONValue>) super.getValue();
    }

    @Override
    public String toJSON() {
        final Map<JSONValue, JSONValue> value = new TreeMap<>(getValue());
        final StringBuilder resultBuilder = new StringBuilder(value.size() * 4 + 2);
        resultBuilder.append('{');
        final Iterator<Map.Entry<JSONValue, JSONValue>> iterator = value.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<JSONValue, JSONValue> item = iterator.next();
            resultBuilder.append(item.getKey().toJSON());
            resultBuilder.append(':');
            resultBuilder.append(item.getValue().toJSON());
        }
        while (iterator.hasNext()) {
            resultBuilder.append(',');
            Map.Entry<JSONValue, JSONValue> item = iterator.next();
            resultBuilder.append(item.getKey().toJSON());
            resultBuilder.append(':');
            resultBuilder.append(item.getValue().toJSON());
        }
        resultBuilder.append('}');
        return resultBuilder.toString();
    }

    public static JSONObject parse(JSONScanner scanner) throws UnexpectedInputException {
        scanner.expectNext(TokenKind.ObjectBeginToken);
        final TreeMap<JSONValue, JSONValue> map = new TreeMap<>();
        while (true) {
            if (scanner.tryParse(s -> {
                final JSONValue key = JSONValue.parse(s);
                s.expectNext(TokenKind.ObjectPairDelimiterToken);
                final JSONValue value = JSONValue.parse(s);
                map.put(key, value);
                return true;
            }) == null) {
                break;
            }
            if (scanner.tryParse(s -> {
                s.expectNext(TokenKind.ListDelimiterToken);
                return true;
            }) == null) {
                break;
            }
        }
        scanner.expectNext(TokenKind.ObjectEndToken);
        return new JSONObject(map);
    }
}
