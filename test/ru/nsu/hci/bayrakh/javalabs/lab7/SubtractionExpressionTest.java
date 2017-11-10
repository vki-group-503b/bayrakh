package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testBinaryExpression(
                (a, b) -> new SubtractionExpression(a, b),
                (a, b) -> a - b
        );
    }

}