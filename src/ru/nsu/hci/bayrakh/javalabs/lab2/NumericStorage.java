package ru.nsu.hci.bayrakh.javalabs.lab2;

import java.util.Arrays;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;

public class NumericStorage {
    private double[] numbers;
    NumericStorage(double[] nums) {
        numbers = new double[nums.length];
        System.arraycopy(nums, 0, numbers, 0, nums.length);
        Arrays.sort(numbers);
    }
    public double getMin() {
        if (numbers.length > 0)
            return numbers[0];
        return POSITIVE_INFINITY;
    }
    public double getMax() {
        if (numbers.length > 0)
            return numbers[numbers.length - 1];
        return NEGATIVE_INFINITY;
    }
    public double getAgv() {
        double sum = 0;
        for (double e : numbers) {
            sum += e;
        }
        return sum/numbers.length;
    }
    public double getMed() {
        if (numbers.length == 0)
            return NaN;
        if ((numbers.length % 2) == 0) {
            int pos = numbers.length / 2;
            return (numbers[pos] + numbers[pos - 1]) / 2;
        } else {
            int pos = (numbers.length - 1)/2;
            return numbers[pos];
        }
    }
    public double getGev() {
        double mul = 1;
        for (double e : numbers) {
            mul *= e;
        }
        return Math.pow(mul, 1/((double) numbers.length));
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (numbers.length > 0) {
            result.append(numbers[0]);
        }
        for (int i = 1; i < numbers.length; i++) {
            result.append(", ");
            result.append(numbers[i]);
        }
        return result.toString();
    }
}
