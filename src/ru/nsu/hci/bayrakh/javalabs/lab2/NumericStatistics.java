package ru.nsu.hci.bayrakh.javalabs.lab2;

import java.util.Scanner;

public class NumericStatistics {

    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        if (count == 0) return;
        double[] numbers = new double[count];
        double sum = 0;
        double mul = 1;
        for (int i = 0; i < count; i++) {
            System.out.printf("Введите число #%d: ", i + 1);
            double t = s.nextDouble();
            sum += t;
            mul *= t;
            int j = 0;
            for (; j < i; j++) {
                if (t < numbers[j]) break;
            }
            for (int k = i; k > j; k--) {
                numbers[k] = numbers[k - 1];
            }
            numbers[j] = t;
        }
        System.out.printf("Последовательность чисел: %n");
        for(int i=0; i<count; i++){
            System.out.printf("%.1f ", numbers[i]);
        }
        System.out.printf("%nМинимум: %.1f%n", numbers[0]);
        System.out.printf("Максимум: %.1f%n", numbers[count-1]);
        System.out.printf("Среднее арифметическое: %.2f%n", sum/((double) count));
        double med;
        if ((count % 2) == 0) {
            int pos = count / 2;
            med = (numbers[pos] + numbers[pos - 1]) / 2;
        } else {
            int pos = (count - 1)/2;
            med = numbers[pos];
        }
        System.out.printf("Медиана: %.2f%n", med);
        System.out.printf("Среднее геаметрическое: %.2f%n", Math.pow(mul, 1/((double) count)));
    }
}
