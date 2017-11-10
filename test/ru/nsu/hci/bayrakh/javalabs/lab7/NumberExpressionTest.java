package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExpressionTest {
    @Test
    void calculate() {
        double argument = Math.random();
        NumberExpression expression = new NumberExpression(argument);
        assertEquals(expression.calculate(), argument);
    }

}