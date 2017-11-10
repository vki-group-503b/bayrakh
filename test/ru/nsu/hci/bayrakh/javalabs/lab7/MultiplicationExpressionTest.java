package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testBinaryExpression(
                (a, b) -> new MultiplicationExpression(a, b),
                (a, b) -> a * b
        );
    }

}