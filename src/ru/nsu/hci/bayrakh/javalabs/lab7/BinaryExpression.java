package ru.nsu.hci.bayrakh.javalabs.lab7;

public abstract class BinaryExpression implements Expression {
    private Expression left;
    private Expression right;

    BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public double calcLeft() {
        return left.calculate();
    }

    public Expression getRight() {
        return right;
    }

    public double calcRight() {
        return right.calculate();
    }

    public abstract double calculate();
}
