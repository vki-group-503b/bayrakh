package ru.nsu.hci.bayrakh.javalabs.lab1;

import java.util.Scanner;
import java.util.Stack;

public class BracketsSequence {
    public static boolean isCorrect(String text) {
        Bracket bracket = new Bracket();
        if (text == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<Character>();

        for (char symbol : text.toCharArray()) {
            if (!bracket.isBracket(symbol)) continue;

            if (bracket.isOpening(symbol)) {
                stack.push(symbol);
            } else if (bracket.getClosingBracket(stack.peek()) == symbol) {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();

        if (BracketsSequence.isCorrect(text)) {
            System.out.println("Sequence is correct");
        } else {
            System.out.println("Sequence is incorrect");
        }
    }
}