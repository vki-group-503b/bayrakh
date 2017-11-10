package ru.nsu.hci.bayrakh.javalabs.lab7;

public class NegativeExpression extends UnaryExpression {
    NegativeExpression(Expression elem) {
        super(elem);
    }

    @Override
    public double calculate() {
        return -calcElem();
    }
}
