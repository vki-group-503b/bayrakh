package ru.nsu.hci.bayrakh.javalabs.lab7;

public abstract class UnaryExpression implements Expression {
    private Expression elem;

    UnaryExpression(Expression elem) {
        this.elem = elem;
    }

    public Expression getElem() {
        return elem;
    }

    public double calcElem() {
        return elem.calculate();
    }

    public abstract double calculate();
}
