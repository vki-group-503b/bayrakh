package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JSONArray extends JSONValue {
    public JSONArray(Collection<JSONValue> value) {
        super(value);
    }

    @Override
    public Collection<JSONValue> getValue() {
        return (Collection<JSONValue>) super.getValue();
    }

    @Override
    public String toJSON() {
        final Collection<JSONValue> value = getValue();
        final StringBuilder resultBuilder = new StringBuilder(value.size() * 2 + 2);
        resultBuilder.append('[');
        final Iterator<JSONValue> iterator = value.iterator();
        if (iterator.hasNext()) {
            resultBuilder.append(iterator.next().toJSON());
        }
        while (iterator.hasNext()) {
            resultBuilder.append(',');
            resultBuilder.append(iterator.next().toJSON());
        }
        resultBuilder.append(']');
        return resultBuilder.toString();
    }

    public static JSONArray parse(JSONScanner scanner) throws UnexpectedInputException {
        ArrayList<JSONValue> list = new ArrayList<>();
        scanner.expectNext(TokenKind.ArrayBeginToken);
        while (true) {
            if (scanner.tryParse(s -> {
                list.add(JSONValue.parse(s));
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
        scanner.expectNext(TokenKind.ArrayEndToken);
        return new JSONArray(list);
    }

    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof JSONArray)) {
            return false;
        }
        final Collection<JSONValue> left = getValue();
        final Collection<JSONValue> right = ((JSONArray) rhs).getValue();
        if (left.size() != right.size()) {
            return false;
        }
        final Iterator<JSONValue> rightIterator = right.iterator();
        for (JSONValue leftValue : left) {
            if ((!rightIterator.hasNext()) || (!JSONValue.equals(leftValue, rightIterator.next()))) {
                return false;
            }
        }
        return true;
    }

    public JSONValue get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        for (JSONValue element : getValue()) {
            if ((i++) == index) {
                return element;
            }
        }
        return null;
    }
}
