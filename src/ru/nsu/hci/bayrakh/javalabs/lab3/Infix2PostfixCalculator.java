package ru.nsu.hci.bayrakh.javalabs.lab3;

import java.util.Scanner;

public class Infix2PostfixCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = input.nextLine();
        try {
            Calculator calc = new Calculator(expression);
            System.out.printf("Результат: %.3f%n", calc.getResult());
            System.out.printf("Постфиксная форма: %s%n", calc.getResultExpr());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
