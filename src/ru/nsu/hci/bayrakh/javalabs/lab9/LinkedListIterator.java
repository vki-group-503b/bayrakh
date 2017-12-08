package ru.nsu.hci.bayrakh.javalabs.lab9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private boolean isReverse = false;
    private LinkedListElement<T> next = null;
    LinkedListIterator(LinkedListElement<T> element, boolean isReverse) {
        this.isReverse = isReverse;
        next = element;
    }
    LinkedListIterator(LinkedListElement<T> element) {
        this.isReverse = false;
        next = element;
    }
    public boolean hasNext() {
        return next != null;
    }
    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        final LinkedListElement<T> element = next;
        if (element != null) {
            next = isReverse ? element.getPrev() : element.getNext();
            return element.getValue();
        } else {
            next = null;
            return null;
        }
    }
}
