package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public class UnexpectedInputException extends Exception {
    private static String constructMessage(String message, String source, int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        int beginIndex = position - 5;
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        int endIndex = position + 5;
        if (endIndex >= source.length()) {
            endIndex = source.length() - 1;
        }
        String substring = source.substring(beginIndex, endIndex);
        return String.format(
                "%s: %s на позиции %d",
                message,
                substring,
                position
        );
    }
    UnexpectedInputException(String message, String source, int position) {
        super(constructMessage(message, source, position));
    }
    UnexpectedInputException(String source, int position) {
        this("Неожиданный ввод", source, position);
    }
}
