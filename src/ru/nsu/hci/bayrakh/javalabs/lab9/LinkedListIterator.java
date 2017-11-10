package ru.nsu.hci.bayrakh.javalabs.lab9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private boolean isReverce = false;
    private LinkedListElement<T> prev = null;
    private LinkedListElement<T> element = null;
    private LinkedListElement<T> next = null;
    LinkedListIterator(LinkedListElement<T> element, boolean isReverce) {
        this.isReverce = isReverce;
        next = element;
    }
    LinkedListIterator(LinkedListElement<T> element) {
        this.isReverce = false;
        next = element;
    }
    private void setElement(LinkedListElement<T> element) {
        this.element = element;
        if (element != null) {
            prev = isReverce ? element.getNext() : element.getPrev();
            next = isReverce ? element.getPrev() : element.getNext();
        } else {
            prev = null;
            next = null;
        }
    }
    private void move(LinkedListElement<T> element) throws NoSuchElementException {
        if (element == null)
            throw new NoSuchElementException();
        setElement(element);
    }
    public T getValue() {
        return element.getValue();
    }
    public boolean hasPrev() {
        return prev != null;
    }
    public T prev() throws NoSuchElementException {
        move(prev);
        return getValue();
    }
    public boolean hasNext() {
        return next != null;
    }
    public T next() throws NoSuchElementException {
        move(next);
        return getValue();
    }
}
