package ru.nsu.hci.bayrakh.javalabs.lab7;

public class SquareExpression extends UnaryExpression {
    SquareExpression(Expression elem) {
        super(elem);
    }

    @Override
    public double calculate() {
        double e = calcElem();
        return e * e;
    }
}
