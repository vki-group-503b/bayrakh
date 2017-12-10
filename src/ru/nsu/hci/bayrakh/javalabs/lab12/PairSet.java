package ru.nsu.hci.bayrakh.javalabs.lab12;

import javafx.util.Pair;

import java.util.ArrayList;

public class PairSet {
    private ArrayList<Pair<Object, Object>> Pairs = new ArrayList<>();

    public boolean has(Object left, Object right) {
        for (Pair<Object, Object> pair : Pairs) {
            Object leftValue = pair.getKey();
            Object rightValue = pair.getValue();
            if (((left.equals(leftValue)) && (right.equals(rightValue))) ||
                    ((left.equals(rightValue)) && (right.equals(leftValue)))) {
                return true;
            }
        }
        return false;
    }

    public void add(Object left, Object right) {
        if (!has(left, right)) {
            Pairs.add(new Pair<>(left, right));
        }
    }
}
