package ru.nsu.hci.bayrakh.javalabs.lab14;

import ru.nsu.hci.bayrakh.javalabs.lab9.LinkedList;
import ru.nsu.hci.bayrakh.javalabs.lab9.LinkedListElement;

import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private LinkedList<T> list = new LinkedList<>();
    private ReentrantLock mutex = new ReentrantLock();

    public void push(T value) {
        mutex.lock();
        list.pushBack(value);
        mutex.unlock();
    }

    public boolean isEmpty() {
        mutex.lock();
        boolean result = list.getFront() == null;
        mutex.unlock();
        return result;
    }

    public T pop() {
        while (true) {
            mutex.lock();
            if (list.getFront() == null) {
                mutex.unlock();
                Thread.yield();
            } else {
                final T value = list.popFront();
                mutex.unlock();
                return value;
            }
        }
    }
}
