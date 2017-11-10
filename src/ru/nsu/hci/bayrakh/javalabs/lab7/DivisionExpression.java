package ru.nsu.hci.bayrakh.javalabs.lab7;

public class DivisionExpression extends BinaryExpression {
    DivisionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        final double l = calcLeft();
        final double r = calcRight();
        return (l - (l % r)) / r;
    }
}
