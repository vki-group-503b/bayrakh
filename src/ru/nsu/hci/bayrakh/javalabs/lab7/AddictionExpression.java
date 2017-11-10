package ru.nsu.hci.bayrakh.javalabs.lab7;

public class AddictionExpression extends BinaryExpression {
    AddictionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return calcLeft() + calcRight();
    }
}
