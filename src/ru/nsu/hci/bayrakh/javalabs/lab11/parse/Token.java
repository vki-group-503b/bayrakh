package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public class Token {
    private TokenKind kind;
    private Object value;

    public Token(TokenKind kind, Object value) {
        this.kind = kind;
        this.value = value;
    }

    Token(TokenKind kind) {
        this(kind, null);
    }

    public TokenKind getKind() {
        return kind;
    }

    public Object getValue() {
        return value;
    }
}
