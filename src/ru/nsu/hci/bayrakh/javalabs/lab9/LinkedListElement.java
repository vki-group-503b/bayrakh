package ru.nsu.hci.bayrakh.javalabs.lab9;

public class LinkedListElement<T> {
    private LinkedListElement<T> prev = null;
    private T value;
    private LinkedListElement<T> next = null;

    LinkedListElement(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListElement<T> getNext() {
        return next;
    }

    public void setNext(LinkedListElement<T> next) {
        this.next = next;
        if (next != null) {
            next.prev = this;
        }
    }

    public LinkedListElement<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedListElement<T> prev) {
        this.prev = prev;
        if (prev != null) {
            prev.next = this;
        }
    }

    public void removeSelf() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    public LinkedListElement<T> removeSelfFront() {
        LinkedListElement<T> result = next;
        removeSelf();
        return result;
    }

    public LinkedListElement<T> removeSelfBack() {
        LinkedListElement<T> result = prev;
        removeSelf();
        return result;
    }

}
