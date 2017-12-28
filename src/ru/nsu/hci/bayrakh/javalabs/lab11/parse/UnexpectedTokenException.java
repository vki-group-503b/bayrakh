package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public class UnexpectedTokenException extends UnexpectedInputException {
    UnexpectedTokenException(TokenKind kind, String source, int position) {
        super("Неожиданный токен " + kind.toString(), source, position);
    }
}
