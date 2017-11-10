package ru.nsu.hci.bayrakh.javalabs.lab7;

public class RestExpression extends BinaryExpression {
    RestExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return calcLeft() % calcRight();
    }
}
