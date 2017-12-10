package ru.nsu.hci.bayrakh.javalabs.lab12;

public class RecursiveObject<T> {
    public T value;
    public RecursiveObject<T> ref;

    RecursiveObject(T value, RecursiveObject<T> ref) {
        this.value = value;
        this.ref = ref;
    }
}
