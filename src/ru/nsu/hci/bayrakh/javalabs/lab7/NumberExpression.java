package ru.nsu.hci.bayrakh.javalabs.lab7;

public class NumberExpression implements Expression {
    private double value;

    NumberExpression(double value) {
        this.value = value;
    }

    public double calculate() {
        return value;
    }
}
