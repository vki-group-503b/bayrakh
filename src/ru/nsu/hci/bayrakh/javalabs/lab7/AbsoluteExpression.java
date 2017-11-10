package ru.nsu.hci.bayrakh.javalabs.lab7;

public class AbsoluteExpression extends UnaryExpression {
    AbsoluteExpression(Expression elem) {
        super(elem);
    }

    @Override
    public double calculate() {
        double e = calcElem();
        if (Double.compare(e, 0) <= 0)
            e = -e;
        return e;
    }
}
