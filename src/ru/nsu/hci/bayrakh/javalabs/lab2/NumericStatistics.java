package ru.nsu.hci.bayrakh.javalabs.lab2;

import java.util.Scanner;

public class NumericStatistics {

    public static void main(String[] args) throws Exception {
        System.out.print("Введите количество чисел: ");
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.printf("Введите число #%d: ", i + 1);
            numbers[i] = s.nextDouble();
        }
        NumericStorage store = new NumericStorage(numbers);
        System.out.printf("Последовательность чисел: %s", store.toString());
        System.out.printf("%nМинимум: %.1f%n", store.getMin());
        System.out.printf("Максимум: %.1f%n", store.getMax());
        System.out.printf("Среднее арифметическое: %.2f%n", store.getAgv());
        System.out.printf("Медиана: %.2f%n", store.getMed());
        System.out.printf("Среднее геаметрическое: %.2f%n", store.getGev());
    }
}
