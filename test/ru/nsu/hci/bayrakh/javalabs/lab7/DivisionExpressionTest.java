package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testBinaryExpression(
                (a, b) -> new DivisionExpression(a, b),
                (a, b) -> (a - (a % b)) / b
        );
    }

}