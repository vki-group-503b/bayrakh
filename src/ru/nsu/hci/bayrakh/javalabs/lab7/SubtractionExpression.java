package ru.nsu.hci.bayrakh.javalabs.lab7;

public class SubtractionExpression extends BinaryExpression {
    SubtractionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return calcLeft() - calcRight();
    }
}
