package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public enum TokenKind {
    StringToken,
    NumberToken,
    ObjectBeginToken,
    ObjectPairDelimiterToken,
    ListDelimiterToken,
    ObjectEndToken,
    ArrayBeginToken,
    ArrayEndToken,
    BooleanToken,
    NullToken,
    EndOfInput;

    public String toString() {
        switch (this) {
            case StringToken: return "String";
            case NumberToken: return "Number";
            case ObjectBeginToken: return "ObjectBegin";
            case ObjectPairDelimiterToken: return "ObjectPairDelimiter";
            case ListDelimiterToken: return "ListDelimiter";
            case ObjectEndToken: return "ObjectEnd";
            case ArrayBeginToken: return "ArrayBegin";
            case ArrayEndToken: return "ArrayEnd";
            case BooleanToken: return "Boolean";
            case NullToken: return "Null";
            case EndOfInput: return "EndOfInput";
            default: return "Unknown";
        }
    }
}
