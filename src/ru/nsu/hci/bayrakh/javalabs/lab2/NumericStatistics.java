package ru.nsu.hci.bayrakh.javalabs.lab2;

import java.util.Scanner;

public class NumericStatistics {

    public static void main(String[] args) throws Exception {
        System.out.print("Введите количество чисел: ");
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        if (count == 0) return;
        NumericStatisticComputer comp = new NumericStatisticComputer(count);
        for (int i = 0; i < count; i++) {
            System.out.printf("Введите число #%d: ", i + 1);
            comp.add(s.nextDouble());
        }
        System.out.printf("Последовательность чисел: %s", comp.toString());
        System.out.printf("%nМинимум: %.1f%n", comp.getMin());
        System.out.printf("Максимум: %.1f%n", comp.getMax());
        System.out.printf("Среднее арифметическое: %.2f%n", comp.getAgv());
        System.out.printf("Медиана: %.2f%n", comp.getMed());
        System.out.printf("Среднее геаметрическое: %.2f%n", comp.getGev());
    }
}
