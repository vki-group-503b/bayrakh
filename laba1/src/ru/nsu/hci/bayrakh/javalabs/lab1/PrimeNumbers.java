package ru.nsu.hci.bayrakh.javalabs.lab1;

import java.util.Scanner;

public class PrimeNumbers {

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int readFromKeyboard = s.nextInt();

        if (isPrime(readFromKeyboard)) {
            System.out.println("Число простое");
        } else {
            System.out.println("Число составное");
        }
    }
}
