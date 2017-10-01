package ru.nsu.hci.bayrakh.javalabs.lab1;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (((i % 5) == 0) && ((i % 3) == 0))
                System.out.printf("FizzBuzz ");
            else if ((i % 5) == 0)
                System.out.printf("Buzz ");
            else if ((i % 3) == 0)
                System.out.printf("Fizz ");
            else
                System.out.printf("%d ", i);

        }
    }
}
