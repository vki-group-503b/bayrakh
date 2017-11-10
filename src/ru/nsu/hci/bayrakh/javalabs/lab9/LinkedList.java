package ru.nsu.hci.bayrakh.javalabs.lab9;

public class LinkedList<T> implements Iterable<T> {
    LinkedListElement<T> begin = null;
    LinkedListElement<T> end = null;

    public LinkedListElement<T> pushFront(T value) {
        LinkedListElement<T> t = new LinkedListElement<>(value);
        t.setNext(begin);
        begin = t;
        if (end == null) {
            end = t;
        }
        return t;
    }

    public LinkedListElement<T> pushBack(T value) {
        LinkedListElement<T> t = new LinkedListElement<>(value);
        t.setPrev(end);
        end = t;
        if (begin == null) {
            begin = t;
        }
        return t;
    }

    public LinkedListElement<T> getFront() {
        return begin;
    }

    public LinkedListElement<T> getBack() {
        return end;
    }

    public T popFront() {
        T result = begin.getValue();
        begin = begin.removeSelfFront();
        return result;
    }

    public T popBack() {
        T result = end.getValue();
        end = end.removeSelfBack();
        return result;
    }

    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<>(begin);
    }

    public LinkedListIterator<T> reverce_iterator() {
        return new LinkedListIterator<>(end, true);
    }
}
