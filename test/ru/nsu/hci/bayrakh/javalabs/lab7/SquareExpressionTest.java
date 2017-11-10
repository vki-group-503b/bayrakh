package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testUnaryExpression(
                a -> new SquareExpression(a),
                a -> a * a
        );
    }

}