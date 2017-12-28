package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

public class WrongStructureException extends Exception {
    WrongStructureException() {
        super("Структура полученного класса не соответствует структуре JSON");
    }
}
