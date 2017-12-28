package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public class UnexpectedEndOfInputException extends UnexpectedInputException {
    UnexpectedEndOfInputException(String source, int position) {
        super("Неожиданный конец ввода", source, position);
    }
}
