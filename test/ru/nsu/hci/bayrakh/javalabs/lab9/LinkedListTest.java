package ru.nsu.hci.bayrakh.javalabs.lab9;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void useCaseTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(2);
        list.pushFront(5);
        list.pushBack(4);
        Vector<Integer> expect = new Vector<>();
        expect.add(5);
        expect.add(2);
        expect.add(4);
        assertIterableEquals(list, expect);

        assertEquals(list.popBack().intValue(), 4);
        expect = new Vector<>();
        expect.add(5);
        expect.add(2);
        assertIterableEquals(list, expect);

        assertEquals(list.popFront().intValue(), 5);
        expect = new Vector<>();
        expect.add(2);
        assertIterableEquals(list, expect);
    }
}
