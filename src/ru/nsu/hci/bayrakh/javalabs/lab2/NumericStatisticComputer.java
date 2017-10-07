package ru.nsu.hci.bayrakh.javalabs.lab2;

public class NumericStatisticComputer {
    private double[] numbers;
    private int size = 0;
    double sum = 0;
    double mul = 1;
    NumericStatisticComputer(int capability) {
        numbers = new double[capability];
    }
    public void add(double element) throws Exception {
        if (size == numbers.length)
            throw new Exception("Введено больше значений, чем ожидалось");
        int j = 0;
        for (; j < size; j++) {
            if (element < numbers[j]) break;
        }
        for (int k = size; k > j; k--) {
            numbers[k] = numbers[k - 1];
        }
        numbers[j] = element;
        sum += element;
        mul *= element;
        size++;
    }
    public double getMin() {
        return numbers[0];
    }
    public double getMax() {
        return numbers[size - 1];
    }
    public double getAgv() {
        return sum/size;
    }
    public double getMed() {
        if ((size % 2) == 0) {
            int pos = size / 2;
            return (numbers[pos] + numbers[pos - 1]) / 2;
        } else {
            int pos = (size - 1)/2;
            return numbers[pos];
        }
    }
    public double getGev() {
        return Math.pow(mul, 1/((double) size));
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (size > 0) {
            result.append(numbers[0]);
        }
        for (int i = 0; i < size; i++) {
            result.append(", ");
            result.append(numbers[i]);
        }
        return result.toString();
    }
}
