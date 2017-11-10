package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NegativeExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testUnaryExpression(
                a -> new NegativeExpression(a),
                a -> -a
        );
    }

}