package ru.nsu.hci.bayrakh.javalabs.lab3;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static boolean isDigit(char s) {
        switch (s) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
    public static double getDigitValue(char s) throws IllegalArgumentException {
        switch (s) {
            case '9': return 9;
            case '8': return 8;
            case '7': return 7;
            case '6': return 6;
            case '5': return 5;
            case '4': return 4;
            case '3': return 3;
            case '2': return 2;
            case '1': return 1;
            case '0': return 0;
            default: throw new IllegalArgumentException();
        }
    }
    public static boolean isPointDelimiter(char s) {
        return ((s == '.') || (s == ','));
    }
    public static boolean isOperation(char s) {
        return ((s == '+') || (s == '-') || (s == '*') || (s == '/'));
    }
    public static boolean isAddOperation(char s) {
        return s == '+';
    }
    public static boolean isSubOperation(char s) {
        return s == '-';
    }
    public static boolean isMulOperation(char s) {
        return s == '*';
    }
    public static boolean isDivOperation(char s) {
        return s == '/';
    }
    public static boolean isOperationPriorOver(char l, char r) {
        return (
            (isAddOperation(l) || isSubOperation(l)) &&
            (isMulOperation(r) || isDivOperation(r))
        );
    }
    public static boolean isBracket(char s) {
        return ((s == '(') || (s == ')'));
    }
    public static boolean isOpeningBracket(char s) {
        return s == '(';
    }
    public static boolean isClosingBracket(char s) {
        return s == ')';
    }
    public static boolean isWhitespace(char s) {
        return (
            (s == ' ') ||
            (s == '\n') ||
            (s == '\t') ||
            (s == '\r')
        );
    }
    public static void executeOperation(char s, Stack<Double> numbers) throws EmptyStackException {
        if (isAddOperation(s)) {
            numbers.push(numbers.pop() + numbers.pop());
        } else if (isSubOperation(s)) {
            numbers.push(numbers.pop() - numbers.pop());
        } else if (isMulOperation(s)) {
            numbers.push(numbers.pop() * numbers.pop());
        } else if (isDivOperation(s)) {
            numbers.push(numbers.pop() / numbers.pop());
        }
    }
    public static String getFromStackAndPutIntoResult(String result,Stack<Character> operations, Stack<Double> numbers, boolean ignoreBrackets) {
        char lastOp;
        while (!operations.empty()) {
            lastOp = operations.pop();
            if ((!ignoreBrackets) && isOpeningBracket(lastOp)) break;
            result += lastOp + " ";
            executeOperation(lastOp, numbers);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> operations = new Stack<>();
        Stack<Double> numbers = new Stack<>();
        String result = "";
        System.out.print("Введите выражение: ");
        String expression = input.nextLine();
        try {
            for (int i = 0; i < expression.length(); i++) {
                char symbol = expression.charAt(i);
                if (isDigit((symbol))) {
                    double value = getDigitValue(symbol);
                    String stringValue = "";
                    stringValue += symbol;
                    while (i < (expression.length() - 1)) {
                        i++;
                        symbol = expression.charAt(i);
                        if (!isDigit(symbol)) break;
                        stringValue += symbol;
                        value *= 10;
                        value += getDigitValue(symbol);
                    }
                    if (isPointDelimiter(symbol)) {
                        stringValue += symbol;
                        double c = 1;
                        while (i < (expression.length() - 1)) {
                            i++;
                            symbol = expression.charAt(i);
                            if (!isDigit(symbol)) break;
                            stringValue += symbol;
                            c /= 10;
                            value += c * getDigitValue(symbol);
                        }
                    }
                    result += stringValue + " ";
                    numbers.push(value);
                    if (i == (expression.length() - 1))
                        symbol = ' ';
                }
                if (isOpeningBracket(symbol)) {
                    operations.push(symbol);
                } else if (isOperation(symbol)) {
                    if ((!operations.empty()) && (isOperationPriorOver(symbol, operations.peek()))) {
                        char lastOp = operations.pop();
                        result += lastOp + " ";
                        executeOperation(lastOp, numbers);
                    }
                    operations.push(symbol);
                } else if (isClosingBracket(symbol)) {
                    result = getFromStackAndPutIntoResult(result, operations, numbers, false);
                } else if (isWhitespace(symbol)) {
                } else {
                    throw new Exception("Некорректное выражение");
                }
            }
            result = getFromStackAndPutIntoResult(result, operations, numbers, true);
            double res = numbers.pop();
            if (!numbers.empty())
                throw new Exception("Некорректное выражение");
            System.out.printf("Результат: %.3f%n", res);
            System.out.printf("Постфиксная форма: %s%n", result);
        } catch (EmptyStackException e) {
            System.out.println("Некорректное выражение");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
