package ru.nsu.hci.bayrakh.javalabs.lab13;

public interface FoldFn<T, R> {
    R call(T element, R fold);
}
