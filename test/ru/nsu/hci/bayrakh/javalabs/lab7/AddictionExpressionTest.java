package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddictionExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testBinaryExpression(
                (a, b) -> new AddictionExpression(a, b),
                (a, b) -> a + b
        );
    }

}