package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public interface JSONParser<T> {
    T parse(JSONScanner scanner) throws UnexpectedInputException;
}
