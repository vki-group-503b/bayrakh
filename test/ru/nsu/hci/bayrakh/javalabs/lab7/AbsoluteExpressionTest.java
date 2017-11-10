package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbsoluteExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testUnaryExpression(
                a -> new AbsoluteExpression(a),
                a -> Math.abs(a)
        );
    }

}