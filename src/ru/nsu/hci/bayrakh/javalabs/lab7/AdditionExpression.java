package ru.nsu.hci.bayrakh.javalabs.lab7;

public class AdditionExpression extends BinaryExpression {
    AdditionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return calcLeft() + calcRight();
    }
}
