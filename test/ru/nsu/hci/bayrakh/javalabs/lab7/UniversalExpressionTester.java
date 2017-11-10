package ru.nsu.hci.bayrakh.javalabs.lab7;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversalExpressionTester {
    public interface CreateUnaryExpressionClosure<T extends Expression> {
        T call(NumberExpression argument);
    }

    public interface UnaryClosure {
        double call(double arg);
    }

    public static <T extends Expression>
    void testUnaryExpression(
            CreateUnaryExpressionClosure<T> constructing,
            UnaryClosure expecting
    ) {
        double argument = Math.random();
        assertEquals(
                constructing.call(new NumberExpression(argument)).calculate(),
                expecting.call(argument)
        );
    }

    public interface CreateBinaryExpressionClosure<T extends Expression> {
        T call(NumberExpression left, NumberExpression right);
    }

    public interface BinaryClosure {
        double call(double left, double right);
    }

    public static <T extends Expression>
    void testBinaryExpression(
            CreateBinaryExpressionClosure<T> constructing,
            BinaryClosure expecting
    ) {
        double left = Math.random();
        double right = Math.random();
        assertEquals(
                constructing.call(
                        new NumberExpression(left),
                        new NumberExpression(right)
                ).calculate(),
                expecting.call(left, right)
        );
    }
}
