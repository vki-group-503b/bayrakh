package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerExpressionTest {
    @Test
    void calculate() {
        UniversalExpressionTester.testBinaryExpression(
                (a, b) -> new PowerExpression(a, b),
                (a, b) -> Math.pow(a, b)
        );
    }

}