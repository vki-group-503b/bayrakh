package ru.nsu.hci.bayrakh.javalabs.lab13;

import ru.nsu.hci.bayrakh.javalabs.lab9.LinkedList;

import java.util.Iterator;

public class List<T> extends LinkedList<T> {
    public List<T> filter(Predicate<T> predicate) {
        final List<T> result = new List<>();
        for (T element : this) {
            if (predicate.call(element)) {
                result.pushBack(element);
            }
        }
        return result;
    }

    public <R> List<R> map(MapFn<T, R> fn) {
        final List<R> result = new List<>();
        for (T element : this) {
            result.pushBack(fn.call(element));
        }
        return result;
    }

    public <R> R fold(FoldFn<T, R> fn, R init) {
        R result = init;
        for (T element : this) {
            result = fn.call(element, result);
        }
        return result;
    }

    public int count(Predicate<T> predicate) {
        int result = 0;
        for (T element : this) {
            if (predicate.call(element)) {
                result++;
            }
        }
        return result;
    }

    public T first(Predicate<T> predicate) {
        for (T element : this) {
            if (predicate.call(element)) {
                return element;
            }
        }
        return null;
    }

    public T last(Predicate<T> predicate) {
        T result = null;
        for (T element : this) {
            if (predicate.call(element)) {
                result = element;
            }
        }
        return result;
    }

    public T single(Predicate<T> predicate) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.call(element)) {
                while (iterator.hasNext()) {
                    if (predicate.call(iterator.next())) {
                        return null;
                    }
                }
                return element;
            }
        }
        return null;
    }

    public boolean all(Predicate<T> predicate) {
        for (T element : this) {
            if (!predicate.call(element)) {
                return false;
            }
        }
        return true;
    }
}

