package ru.nsu.hci.bayrakh.javalabs.lab7;

public class PowerExpression extends BinaryExpression {
    PowerExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return Math.pow(calcLeft(), calcRight());
    }
}
