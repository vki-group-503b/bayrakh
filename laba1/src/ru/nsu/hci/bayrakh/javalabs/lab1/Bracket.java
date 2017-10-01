package ru.nsu.hci.bayrakh.javalabs.lab1;

import java.util.HashMap;
import java.util.Map;

class Bracket {
    Map<Character, Character> brackets;

    public Bracket() {
        brackets = new HashMap<Character, Character>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('<', '>');
        brackets.put('{', '}');
    }

    public char getClosingBracket(char opening) {
        if (brackets.containsKey(opening)) {
            return brackets.get(opening);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public boolean isOpening(char symbol) {
        return brackets.containsKey(symbol);
    }
    public boolean isClosing(char symbol) {
        return brackets.containsValue(symbol);
    }
    public boolean isBracket(char symbol) {
        return isClosing(symbol) || isOpening(symbol);
    }
}