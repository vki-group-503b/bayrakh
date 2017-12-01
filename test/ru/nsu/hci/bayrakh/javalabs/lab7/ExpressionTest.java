package ru.nsu.hci.bayrakh.javalabs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
    @Test
    void calculate() {
        final double num1 = -5 * Math.random();
        final NumberExpression num1_e = new NumberExpression(num1);
        assertEquals(
                new AbsoluteExpression(num1_e).calculate(),
                Math.abs(num1)
        );
        assertEquals(
                new NegativeExpression(num1_e).calculate(),
                -num1
        );
        assertEquals(
                new SquareExpression(num1_e).calculate(),
                num1 * num1
        );
        final double num2 = 3 * Math.random();
        final NumberExpression num2_e = new NumberExpression(num2);
        assertEquals(
                new AdditionExpression(num1_e, num2_e).calculate(),
                num1 + num2
        );
        assertEquals(
                new DivisionExpression(num1_e, num2_e).calculate(),
                (num1 - (num1 % num2)) / num2
        );
        assertEquals(
                new MultiplicationExpression(num1_e, num2_e).calculate(),
                num1 * num2
        );
        assertEquals(
                new PowerExpression(num1_e, num2_e).calculate(),
                Math.pow(num1, num2)
        );
        assertEquals(
                new RestExpression(num1_e, num2_e).calculate(),
                num1 % num2
        );
        assertEquals(
                new SubtractionExpression(num1_e, num2_e).calculate(),
                num1 - num2
        );
    }
}