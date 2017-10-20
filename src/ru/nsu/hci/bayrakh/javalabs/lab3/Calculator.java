package ru.nsu.hci.bayrakh.javalabs.lab3;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static boolean isDigit(char s) {
        return s >= '0' && s <= '9';
    }

    public static double getDigitValue(char s) throws IllegalArgumentException {
        if (!isDigit(s))
            throw new IllegalArgumentException();
        return s - '0';
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

    private String expression;
    private int i;
    private Stack<Character> operations;
    private Stack<Double> numbers;
    private StringBuilder resultBuilder;
    private char symbol;
    private double result;

    Calculator(String _expression) throws Exception {
        expression = _expression;
        operations = new Stack<>();
        numbers = new Stack<>();
        resultBuilder = new StringBuilder();
        for (i = 0; i < expression.length(); i++) {
            parseSymbol();
        }
        getFromStackAndPutIntoResult(true);
        if (numbers.empty())
            throw new Exception("Некорректное выражение");
        result = numbers.pop();
        if (!numbers.empty())
            throw new Exception("Некорректное выражение");
    }

    private void parseSymbol() throws Exception {
        symbol = expression.charAt(i);
        if (isDigit((symbol))) {
            parseNumber();
        }
        if (isOpeningBracket(symbol)) {
            operations.push(symbol);
        } else if (isOperation(symbol)) {
            if ((!operations.empty()) && (isOperationPriorOver(symbol, operations.peek()))) {
                char lastOp = operations.pop();
                resultBuilder.append(lastOp);
                resultBuilder.append(' ');
                executeOperation(lastOp);
            }
            operations.push(symbol);
        } else if (isClosingBracket(symbol)) {
            getFromStackAndPutIntoResult(false);
        } else if (isWhitespace(symbol)) {
        } else {
            throw new Exception("Некорректное выражение");
        }
    }

    private void parseNumber() {
        double value = getDigitValue(symbol);
        StringBuilder stringValueBuilder = new StringBuilder();
        stringValueBuilder.append(symbol);
        while (i < (expression.length() - 1)) {
            i++;
            symbol = expression.charAt(i);
            if (!isDigit(symbol)) break;
            stringValueBuilder.append(symbol);
            value *= 10;
            value += getDigitValue(symbol);
        }
        if (isPointDelimiter(symbol)) {
            stringValueBuilder.append(symbol);
            double c = 1;
            while (i < (expression.length() - 1)) {
                i++;
                symbol = expression.charAt(i);
                if (!isDigit(symbol)) break;
                stringValueBuilder.append(symbol);
                c /= 10;
                value += c * getDigitValue(symbol);
            }
        }
        resultBuilder.append(stringValueBuilder.toString());
        resultBuilder.append(' ');
        numbers.push(value);
        if (i == (expression.length() - 1))
            symbol = ' ';
    }

    private void executeOperation(char s) throws EmptyStackException {
        if (isOperation(s)) {
            double r = numbers.pop();
            double l = numbers.pop();
            if (isAddOperation(s)) {
                numbers.push(l + r);
            } else if (isSubOperation(s)) {
                numbers.push(l - r);
            } else if (isMulOperation(s)) {
                numbers.push(l * r);
            } else {
                numbers.push(l / r);
            }
        }
    }

    private void getFromStackAndPutIntoResult(boolean ignoreBrackets) {
        char lastOp;
        while (!operations.empty()) {
            lastOp = operations.pop();
            if ((!ignoreBrackets) && isOpeningBracket(lastOp)) break;
            resultBuilder.append(lastOp);
            resultBuilder.append(' ');
            executeOperation(lastOp);
        }
    }

    public double getResult() {
        return result;
    }

    public String getResultExpr() {
        return resultBuilder.toString();
    }
}
